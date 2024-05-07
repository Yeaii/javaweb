<template>
<div class="background">

   <div class="login" >
<h1 align="center">登录</h1>
      <div class="main">
         <div class="quickLogin" @click="goNew">
           <button class="QQ"><img src="../assets/qq.png" height="30px" width="30px">QQ 登录</button></br>
            <button class="WX"><img src="../assets/wei.png" height="30px" width="30px">微信登录</button></br>
            <button class="ZFB"><img src="../assets/zhi.png" height="30px" width="30px">支付宝登录</button>
         </div>

         <div class="line">
         </div>
        
       
            <div class="normalLogin">
               <input id="1" class="user" type="text" name="username" placeholder="用户名" required lay-verify="required" /></br>
               <input id="2" class="pwd" type="password" name="password" placeholder="密码" requiredlay-verify="required" /></br>
               <button class="btn-1" @click="myFunction">登录</button>
            </div>
        
      </div>
      <div class="foot">
         <input class="sub" @click="goRegister" type="submit" value="注册" />
        <input class="sub" @click="goModify" type="submit" value="忘记密码?" />
      </div>
   </div>
</div>
</template>

<script>
 import user from "@/api/user"

 export default {
     methods:{
      goHome()
      {
        if(this.$route.path!=="/home/wel")
        {
          this.$router.push("/home/wel")
        }
      },
       goRegister()
      {
        if(this.$route.path!=="/register")
        {
          this.$router.push("/register")
        }
      },
       goNew()
      {
        if(this.$route.path!=="/new")
        {
          this.$router.push("/new")
        }
      },
       goModify()
      {
        if(this.$route.path!=="/modify")
        {
          this.$router.push("/modify")
        }
      },
      myFunction() {
            var uname = document.getElementById('1').value;
            var password = document.getElementById('2').value;
         
             if(uname == ""||password == ""){
               alert("用户名或密码不能为空");
               return false;
            }else{
              let userInfo={
              uname,password
              }
              user.login(userInfo).then((res) => { // 当收到后端的响应时执行该括号内的代码，res 为响应信息，也就是后端返回的信息
            if (res.data.code === "0") {  // 当响应的编码为 0 时，说明登录成功
              // 将用户信息存储到sessionStorage中
              sessionStorage.setItem("userInfo", JSON.stringify(res.data.data));
              // 跳转页面到首页
              this.$router.push('/home/wel');
              // 显示后端响应的成功信息
              this.$message({
                message: res.data.msg,
                type: "success",
              });
            } else {  // 当响应的编码不为 0 时，说明登录失败
              // 显示后端响应的失败信息
              this.$message({
                message: res.data.msg,
                type: "warning",
              });
            }
            });
            
            }
             
         }
     }
 }

</script>

<style acoped>

.background{
    position: absolute;
    width:100%;
    height:100%;
    background-image:url("../assets/login.png");
  background-size:cover;
}

.login {
    position: absolute;
    height: 70%;
    width:80%;
    background-color:white;
    opacity:0.7;
    top:15%;
    left:10%;
}

.main {
    position: absolute;
    width: 100%;
    top:18%;
}

.quickLogin {
    
    float: left;
    width: 49%;
    text-align: center;
   
}

.QQ {
    width: 260px;
    color: white;
    background-color: dodgerblue;
    border: none;
    height: 40px;
    border-radius: 5px;
}

.WX {
    width: 260px;
    color: white;
    background-color: lightgreen;
    margin-top: 10px;
    border: none;
    height: 40px;
    border-radius: 5px;
}

.ZFB {
    width: 260px;
    background-color: darkgray;
    margin-top: 10px;
    border: none;
    height: 40px;
    border-radius: 5px;
}
.line {
   width: 1%;
    height: 160px;
    float: left;
    border-left: 5px solid lightslategray;
}



.normalLogin {
   
    width: 49%;
    text-align: center;
    float: left;


}


  input {
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
  }



.user {
    margin-top: auto;
    border: none;
    border-radius: 5px;
    height: 35px;
    width: 260px;
}

.pwd{
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

.foot {
    color: white;
    width: 100%;
    height: 40px;
    text-align: center;
     margin-top: 310px; 

}

.sub {
    background-color: gray;
    color: white;
    height: 100%;
    border: none;
    float: left;
    justify-content: center;
}



@media screen and (max-width: 800px) {
  .quickLogin,.normalLogin{
    width: 100%;
  }
   .line {display:none}
    .sub {width: 100%;}
  }


  @media screen and (min-width: 800px) {
    .sub {width: 50%;}
  }


</style> 