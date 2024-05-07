<template>
<div class="img_2">
<div class="title">
    <h1>注册</h1>
</div>
 <div class="reg" >
 
  <div class="mainbody" >
    
    <div class="left1">
    <h4>&nbsp</h4>
        <input  class="user" type="text" name="username" placeholder="姓名" required /></br>
        <input class="pwd" type="password" name="password" placeholder="密码" required /></br>
        <input class="e" type="text" name="e-mail" placeholder="电子邮箱" required /></br>
        <input class="date" type="date" required/>
    </div>
    
    <div class="right1">
    <h4>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp请上传头像</h4>
    <el-upload class="avatar-uploader" action="https://localhost:8081/user/register" :show-file-list="false"
    :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
    <img v-if="imageUrl" :src="imageUrl" class="avatar">
    <i v-else class="el-icon-plus avatar-uploader-icon">上传头像</i>
    </el-upload>

    </div>
   
  </div>
</div>
<div class="return1" >
    <button class="btn" id="register" @click="fun">注册</button>
    <button class="btn" @click="goLogin">返回登陆界面</button>
</div>


</div>

</template>

<script>

import user from "@/api/user"
export default {
     data() {
      return {
        imageUrl: ''
      };
    },
    
    
     methods:{
               //图片回显
      handleAvatarSuccess(res, file) {
        console.log(res)
        this.imageUrl = res.data.final_fileName
        sessionStorage.setItem("imgUrl",this.imageUrl)
        alert(this.imageUrl)
      },
     //图片上传大小限制
      beforeAvatarUpload(file) {
        const isLt2M = file.size / 1024 / 1024 < 2;
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isLt2M;
      },

       goLogin()
      {
        if(this.$route.path!=="/")
        {
          this.$router.push("/")
        }
      },
     
    fun()
    {
    var inputs = document.querySelectorAll('.mainbody input');
    var btn1 =document.getElementById('register');
    var uname = inputs[0].value;
    var password = inputs[1].value;
    var email = inputs[2].value;
    var imageUrl = document.getElementById('imageUrl');
    if(uname == '' || password == '' ){
        alert('用户名和密码不能为空');
        return false;
    }
    var pattern = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/
    if( !pattern.test(email)){
        alert('请输入正确的邮箱');
        return false;
    }
    else{
        let userInfo={
              imageUrl,uname,password,email
              }
              user.register(userInfo).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
            if (res.data.code === "0") {  // 当响应的编码为 0 时，说明注册成功
              // 显示后端响应的成功信息
              this.$message({
                message: res.data.msg,
                type: "success",
              });
              alert("注册成功！");
            } else {  // 当响应的编码不为 0 时，说明注册失败
              // 显示后端响应的失败信息
              this.$message({
                message: res.data.msg,
                type: "warning",
              });
                alert("注册失败！");
            }
            });
          
    }
}
 }
}

</script>

<style acoped>
.img_2{
    position:absolute ;
    width:100%;
    height:100%;
    background-size:100% 100%;
    background-image:url("../assets/register.jpg");
}
.title {
    position: absolute;
    width: 100%;
    text-align: center;
    top:16%;
}
.reg{
    position: absolute;
    width: 100%;
    top:20%;
 
}
.mainbody {
    position: absolute;
    width: 100%;
    height:50%;
}

.return1 {
    position: absolute;
    bottom: 11%;
    width: 100%;
    height: 40px;
}

.btn {
    background-color: dimgray;
    color: white;
    width: 100%;
    height: 100%;
    border: none;
}

.left1{
    float: left;
    width:50%;
    text-align:right;
  
}

.right1{

    float: left;
    width:50%;

}


.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;

left:1%;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 170px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
   
  }


  @media screen and (max-width: 800px) {
  .left1,.right1{
    width: 100%;
    text-align:center;
  }
  }
</style> 

