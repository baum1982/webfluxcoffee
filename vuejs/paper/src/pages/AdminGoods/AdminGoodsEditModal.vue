<template lang="html">
  <transition name="modal">
    <div class="modal-mask" @keyup.esc="closeModal">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header"  @click="closeModal">
           <i class="closeModalBtn fa fa-times" aria-hidden="true"></i>
          </div>

          <div class="modal-body">
             <form @submit.prevent>
              <div class="row">
                <div class="col-md-12">
                  <fg-input type="text"
                            label=""
                            placeholder="상품명"
                            v-model="item.name"
                            @keyup.enter.native.prevent="updateGood">
                  </fg-input>
                </div>
                <div class="col-md-12">
                  <fg-input type="number"  min="1000"
                            label=""
                            value="1000"
                            step="500"
                            placeholder="가격"
                            v-model="item.price"
                            @keyup.enter.native.prevent="updateGood">
                  </fg-input>            
                </div>
              </div>
              <div class="clearfix"></div>
            </form>
          </div>

          <div class="modal-footer">
            <div class="row">
             <div class="col-xs-5">
                  <p-button type="info"
                          round
                          @click.native.prevent="updateGood">
                저장
                </p-button>
             </div>
          </div>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>



<script>
export default {
  name: 'EditModal',
  data() {
    return {
      
    };
  },
  props: {
    item: {
      name: "",
      price: "1000"
    }
  },
  methods: {
    updateGood() {
      alert("Your data: " + JSON.stringify(this.item));
      if(this.item.name){
        this.$emit('updateGood', this.item);
      
      }
      console.log('update');
    },
    closeModal(){
      console.log('close');
      this.$emit('closeModal');
    },
  },
};

</script>










<style lang="css">
.closeModalBtn {
  color: #62acde;
}
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}
.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}
.modal-container {
  width: 100%;
  max-width: 600px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  transition: all .3s ease;
  font-family: Helvetica, Arial, sans-serif;
}
.modal-header {
  align-items: flex-end;
}
.modal-header h3 {
  margin-top: 0;
  color: #62acde;
  align-items: flex-end;
}
.modal-body {
  margin: 20px 0;
}
.modal-default-button {
  float: right;
}
/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */
.modal-enter {
  opacity: 0;
}
.modal-leave-active {
  opacity: 0;
}
.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>