<template>
  <section class="inputBox shadow">
    <!-- <button v-on:click="addTodo">추가</button> -->
    <input type="text" v-model="newTodoItem" placeholder="입력하세요" v-on:keyup.enter="addTodo">
    <span class="addContainer" v-on:click="addTodo">
      <i class="addBtn fa fa-plus" aria-hidden="true"></i>
    </span>

    <Modal v-if="showModal" @close="showModal=false">
      <h3 slot="header">경고</h3>
      <span slot="footer" @click="showModal=false">
        할일을 입력하세요.
        <i class="closeModalBtn fa fa-times" aria-hidden="true"></i>
      </span>
    </Modal>

  </section> 
</template>

<script>
import Modal from './common/Modal.vue';

export default {
  data() {
    return {
      newTodoItem: '',
      showModal: false
    };
  },
  methods:{
    addTodo: function(){
     // console.log(this.newTodoItem);
     
     // 저장
     if(this.newTodoItem !== "") {
       var value = this.newTodoItem && this.newTodoItem.trim();
      //  localStorage.setItem(value, value);
       this.$emit('addTodo', value);
       this.clearInput();  
     } else {
       this.showModal = !this.showModal;
       console.log(this.showModal);
     }
    },
    clearInput: function(){
      this.newTodoItem = '';
    }
  },
  components: {
    Modal: Modal
  }
}
</script>

<style scoped>
/* input {
  height: 50px;
  width: 80%;
} */
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: inline-block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
}

</style>