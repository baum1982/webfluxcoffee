<template>


    <div class="row">

       <!-- <div class="col-xl-8 col-lg-7"> -->
      <div class="col-12">
        <admin-goods-form @saveItem="saveItem">
        </admin-goods-form>
      </div>

      <div class="col-12">
        <div slot="raw-content" class="table-responsive">
          <admin-goods-table 
              :data="data" 
              :columns="table1.columns" 
              :colNames="table1.colNames"
              @removeValue="removeValue">
          </admin-goods-table>
        </div>
      </div>
    </div>
</template>
<script>
import AdminGoodsTable  from "./AdminGoodsTable";
import AdminGoodsForm from "./AdminGoodsForm";


var uri = 'https://raw.githubusercontent.com/joshua1988/doit-vuejs/master/data//demo.json';

const tableColumns = [
  // "id", 
  "name", 
  "price"
];
const tableColNames = [
  // "상품코드", 
  "상품명", 
  "가격"
];

var tableData = [
  {
    id: 1,
    name: "카페라떼",
    price: "3500"
  },
  {
    id: 2,
    name: "카페모카",
    price: "3500"
  }
  // ,
  // {
  //   id: 3,
  //   name: "카페라떼",
  //   price: "3500"
  // },
  // {
  //   id: 4,
  //   name: "카페라떼",
  //   price: "3500"
  // }
];
export default {

  data() {
    return {
      table1: {
        columns: [...tableColumns],
        colNames: [...tableColNames]
      },
      data: []
    };
  },

  components: {
    AdminGoodsTable,
    AdminGoodsForm
  },

 

  created(){
      console.log('create');
      this.getList();
   },

  methods:{
    saveItem(newGood){
      console.log(newGood);
      // DB에 넣고 다시 가져와라...
      // http://localhost:8080/good/
      var self = this;

       this.$http.post('http://192.168.0.24:8080/good',newGood)
          .then(function(res){
            console.log(res.data);
              self.data = res.data;
          });
    },
    getList: function(){
      console.log('axiosGET');
      var self = this;
      this.$http.get('http://192.168.0.24:8080/good/list')
        .then(function(res){
            self.data = res.data;
        });
    },
    removeValue(item){
      console.log(item);
      var self = this;
      this.$http.delete('http://192.168.0.24:8080/good/' + item.id)
        .then(function(res){
            self.data = res.data;
      });
    }
  }
};
</script>
<style>
</style>