<template>
  <card class="card" title="">
    <div>
      <form @submit.prevent>
      
        <div class="row">
          <div class="col-md-5">
            <fg-input type="text"
                      label=""
                      placeholder="상품명"
                      v-model="newGood.name"
                      @keyup.enter.native.prevent="saveItem">
            </fg-input>
          </div>
          <div class="col-md-5">
            <fg-input type="number"  min="1000"
                      label=""
                      value="1000"
                      step="500"
                      placeholder="가격"
                      v-model="newGood.price"
                       @keyup.enter.native.prevent="saveItem">
            </fg-input>
            
          </div>
          <div class="text-center col-md-2">
            <p-button type="info"
                    round
                    @click.native.prevent="saveItem">
           저장
          </p-button>  
          </div>
        </div>

        <div class="clearfix"></div>
      </form>
    </div>
  </card>
</template>
<script>
export default {
  name: 'admin-goods-form',
  data() {
    return {
      newGood: {
        name: "",
        price: "1000"
      }
    };
  },
  methods: {
    saveItem() {
      // alert("Your data: " + JSON.stringify(this.newGood));
      if(this.newGood.name){
        this.$emit('saveItem', this.newGood);
        this.newGood = {
          name: "",
          price: "1000"
        };
      }
    }
  }
};
</script>
<style>
</style>
