<template>
<div>
  <table class="table" :class="tableClass">
    <thead>
    <slot name="columns">
      <th v-for="column in colNames" :key="column" >{{column}}</th>
      <th>처리</th>
    </slot>
    </thead>
    <transition-group name='list' tag='tbody' >
    <!-- <tbody> -->
    <tr v-for="(item, index) in data" :key="item.id" @dblclick="editValue(item)"  class="shadow">
      <slot :row="item">
        <td v-for="(column, index) in columns"
            :key="index"
            v-if="hasValue(item, column)">
          {{itemValue(item, column)}}
        </td>
        <td style="">
          <!-- <button  @click="removeValue(item)">삭제</button> -->
           <span class="removeBtn" type="button" @click="removeValue(item)">
           <i class="fa fa-trash-o" aria-hidden="true"></i>
         </span>
        
        </td>
      </slot>
    </tr>
    <!-- </tbody> -->
    </transition-group>
  </table>
   <EditModal v-if="showModal" 
        @closeModal="showModal=false" 
        @updateGood="updateGood"
        :item="item" >
    </EditModal>
</div>
</template>



<script>

import EditModal from './AdminGoodsEditModal';


export default {
  data() {
    return {
      showModal: false,
      item: {
        name: '',
        price:''
      }
    };
  },
  name: 'admin-goods-table',
  props: {
    columns: Array,
    colNames: Array,    
    data: Array,
    type: {
      type: String, // striped | hover
      default: "striped"
    },
    title: {
      type: String,
      default: ""
    },
    subTitle: {
      type: String,
      default: ""
    }
  },
  computed: {
    tableClass() {
      return `table-${this.type}`;
    }
  },
  methods: {
    hasValue(item, column) {
      return item[column.toLowerCase()] !== "undefined";
    },
    itemValue(item, column) {
      return item[column.toLowerCase()];
    },
    removeValue(item){
      this.$emit('removeValue', item);
    },
    editValue(item){
      console.log('editValue', item);
      this.item = item;
      this.showModal = !this.showModal;
    },
    updateGood(item){
      console.log('updateGood', item);
      this.$emit('insertNewGood', item);
      this.showModal = !this.showModal;
    }
    
  },
  components: {
    EditModal: EditModal
  },

  
};
</script>
<style>
/* transition */
.list-item {
  display: inline-block;
  margin-right: 10px;
}
.list-move {
  transition: transform 1s;
}
.list-enter-active, .list-leave-active {
  transition: all 1s;
}
.list-enter, .list-leave-to {
  opacity: 0;
  transform: translateY(30px);
}
</style>
