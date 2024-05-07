<template>
<div class="img_new">
    <div class="login-re">
        <h3>外部账号登陆</h3>
        <div class="login-top"> 
            <form>
                <input type="text" placeholder="请输入账号" required lay-verify="required">
                 &emsp;&emsp;&emsp;&emsp;
                <input type="password" placeholder="请输入密码" required lay-verify="required">
                </br>
                </br>
                <div class="checkbox">&emsp;&emsp;&emsp;
                <input type="checkbox" checked>下次自动登录
                 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <span><a href="https://www.bytedance.com" style="color:green">找回密码?</a></span>
                </div>
                <input type="submit" value="登录" style="width:85%" @click="goHome">
                <div style="margin-left: 35px;"><span>登录即代表您 已阅读并同意<a style="color: rgb(77, 52, 19);">《服务协议条款》</a></span></div>   
            </form> 
            <button  @click="goLogin">返回登录界面</button>   
        </div>
    </div> 
</div>           
</template>


<script>
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
      }
     }
 }

</script>

<style acoped>

.img_new{
    background-image:url("../assets/new.avif");
    width:100%;
    height:100%;
    position:fixed;
    background-size:100% 100%;
}

.login-re {
    width: 480px;
    height: 400px;
    margin: 200px auto;
    position: relative;
    background-color: white;
    opacity:0.6;
}

.login-top {
    width: 480px;
    height: 400px;
    margin: 10px auto;
    position: relative;
    padding-left: 40px;
    border-radius: 5px;
}

.login-re h3 {
    line-height: 110px;
    color: black;
    text-align: center;
}

.checkbox {
    height: 40px;
    line-height: 40px;
    font-size: 14px;
}

.login-top button {
    background-color: darkslategray;
    width: 25%;
    margin-top: 40px;
    margin-left: 130px;
    border-radius: 5px;
}


</style>