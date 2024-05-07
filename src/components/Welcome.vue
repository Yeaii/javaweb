<template> 
<div class="welcome">

 <div class="pic" style="width:50%;float:left;" align="center">
    <h2>&nbsp</h2>
     <h2>欢迎{{ user.uname }}!</h2>
    <img src="../assets/nailong.gif" width="70%">
    </div>
  <div class="pl">
    <el-calendar style="width:50%;float:right"></el-calendar>
    </div>

</div>

</template>
<script>
 export default {

   mounted: function() {
    this.methodToTrigger();
  },
     data() {
      return {
        user: {
        uname: "",
        uid: null,
   
    }
      }
    },
   
     methods:{
      methodToTrigger() {
    if (sessionStorage.getItem('userInfo')) {
      // 将用户信息存储到sessionStorage中
      this.user = JSON.parse(sessionStorage.getItem('userInfo'));
    }
  },
      
     }
    }
     
</script>

<style scoped>

</style>
