<template>
<div class="img_3">
<div class="title">
    <h1>修改密码</h1>
</div>

    <div class="mainbody1">
       <div class="left">
        <input class="user" type="text" name="username" placeholder="姓名" required lay-verify="required"/></br>
        <input class="pwd" type="password" name="password" placeholder="旧密码" required lay-verify="required"/>
        </div>
        <div class="right">
        <input class="pwd" type="password" name="password" placeholder="新密码" required lay-verify="required"/></br>
        <input class="pwd" type="password" name="password" placeholder="确认新密码" required lay-verify="required"/>
        </div>
    </div>

    <div class="return">
    <button class="btn" id="confirm" @click="func">确认修改</button>
    <button class="btn"  @click="goLogin">返回登陆界面</button>
    </div>
</div>
</template>

<script>
import user from "@/api/user"
export default {
    
     methods:{
       goLogin()
      {
        if(this.$route.path!=="/")
        {
          this.$router.push("/")
        }
      },
      goHome()
      {
        if(this.$route.path!=="/home")
        {
          this.$router.push("/home")
        }
      },
       func(){
       var inputs = document.querySelectorAll('.mainbody1 input');
       var btn2 =document.getElementById('confirm');
        var uname = inputs[0].value;
        var password = inputs[1].value;
        var password2 = inputs[2].value;
        var newpassword = inputs[3].value;
        if(uname == '' || password == '' || password2 == ''||newpassword == ''){
            alert('用户名和密码不能为空');
            return false;
        }
        if( password2 != newpassword){
            alert('请使两次密码保持一致');
            return false;
        }
        else
       {
         let userInfo={
              uname,password,newpassword
              }
              user.modify(userInfo).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
            if (res.data.code === "0") {  // 当响应的编码为 0 时，说明注册成功
              // 显示后端响应的成功信息
              this.$message({
                message: res.data.msg,
                type: "success",
              });
              alert("修改成功！");
            } else {  // 当响应的编码不为 0 时，说明注册失败
              // 显示后端响应的失败信息
              this.$message({
                message: res.data.msg,
                type: "warning",
              });
                alert("修改失败！");
            }
            });
       }
       }
    }
};

</script>

<style acoped>

.img_3{
    background-image:url("../assets/modify.avif");
    width:100%;
    height:100%;
    position:fixed;
    background-size:100% 100%;
}

.mainbody1 {
    position: absolute;
    top: 40%;
    width: 100%;
    text-align:center;
    
}
.return {
    position: absolute;
    bottom: 15%;
    width: 100%;
    height: 40px;
}

.btn {
    background-color: dimgray;
    color: white;
    width: 50%;
    height: 100%;
    border: none;
}
.user {
    margin-top: auto;
    border: none;
    border-radius: 5px;
    height: 35px;
    width: 260px;
}

.pwd,
.e,
.date {
    margin-top: 10px;
    border: none;
    border-radius: 5px;
    height: 35px;
    width: 260px;
}

.btn-1 {
    width: 260px;
    height: 35px;
    margin-top: 15px;
    background-color: green;
    color: white;
    border-radius: 5px;
    border: none;
}

.left{
    float: left;
    width:50%;
}

.right{
    float: left;
    width:50%;
}

@media screen and (max-width: 800px) {
  .left,.right{
    width: 100%;
  }
   .btn{width: 100%;}
}
</style>