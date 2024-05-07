<template>
<el-container style="height:100%;border: 1px solid #eee;">

  <el-aside  width="200px">
  
    <el-menu :default-openeds="['1', '3']" style=" width:200px;">
    <div class="home">
    <el-menu-item @click="goHome"><i class="el-icon-s-home"></i>首页</el-menu-item>
    </div>
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-s-operation"></i>功能菜单</template>
       
          <el-menu-item index="1-1" @click="goUserManage">用户管理</el-menu-item>
          <el-menu-item index="1-2" @click="goArticleManage">文章管理</el-menu-item>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>主题切换</template>
          <el-menu-item index="2-1" @click="changeColor">蓝色主题</el-menu-item>
          <el-menu-item index="2-2" @click="changeColor2">黄色主题</el-menu-item>
      </el-submenu>
      
      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>设置</template>

          <el-menu-item index="3-1">选项1</el-menu-item>
          <el-menu-item index="3-2">选项2</el-menu-item>
     
      </el-submenu>
       <el-submenu index="4">
        <template slot="title"><i class="el-icon-more"></i>更多</template>
          <el-menu-item index="4-1" @click="goLogin">退出登录</el-menu-item>
      </el-submenu>
       
    </el-menu>

  </el-aside>
 
  <el-container>
    <el-header name="header" style="text-align: right; font-size: 12px;">
      <el-dropdown @command="handleCommand">
        <i class="el-icon-user" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item disabled>查看个人信息</el-dropdown-item>
          <el-dropdown-item >退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>{{ user.uname }}</span>
    </el-header>
    
    <el-main name="main"  >
    <router-view></router-view>
    </el-main>
  </el-container>
</el-container>
</template>

<script>

export default {
  name:"home",
   mounted: function() {
    this.methodToTrigger();
  },
     data() {
      return {
        value: new Date(),
        user: {
        uname: "",
        uid: null,
   
    }
      }
    },
   
     methods:{
      changeColor() {
     
      var x = document.getElementsByClassName("el-submenu");
       var y = document.getElementsByClassName("home");
      x[0].style.backgroundColor = "#adbae6";
      x[1].style.backgroundColor = "#adbae6";
      x[2].style.backgroundColor = "#adbae6";
      x[3].style.backgroundColor = "#adbae6";
       y[0].style.backgroundColor = "#adbae6";
      var header = document.getElementsByTagName("header")[0];
      header.style.backgroundColor = "#98a9e0";
      var main = document.getElementsByTagName("main")[0];
      main.style.backgroundColor = "#d6ddf2";
     
      
      },
      
      changeColor2() {
      var x = document.getElementsByClassName("el-submenu");
      var y = document.getElementsByClassName("home");
      x[0].style.backgroundColor = "#f4e399";
      x[1].style.backgroundColor = "#f4e399";
      x[2].style.backgroundColor = "#f4e399";
      x[3].style.backgroundColor = "#f4e399";    
      y[0].style.backgroundColor = "#f4e399";   
      
       var header = document.getElementsByTagName("header")[0];
      header.style.backgroundColor = "#f1d977";
      var main = document.getElementsByTagName("main")[0];
      main.style.backgroundColor = "#faf1cc";
      },
      

        handleCommand(command) {
        if(this.$route.path!=="/")
        {
          this.$router.push("/")
        }
      },
      goHome()
      {
        if(this.$route.path!=="/home/wel")
        {
          this.$router.push("/home/wel")
        }
      },
       goLogin()
      {
        if(this.$route.path!=="/")
        {
          this.$router.push("/")
        }
      },
      goUserManage()
      {
        if(this.$route.path!=="/home/user")
        {
          this.$router.push("/home/user")
        }
      },
      goArticleManage()
      {
        if(this.$route.path!=="/home/article")
        {
          this.$router.push("/home/article")
        }
      },
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
 .el-header {
    line-height: 60px;
  }
  
  .el-menu {
  background-color:#f4e399;
 
  }
  .el-main {
  background-color:#faf1cc;

  
  }
  .el-header {
  background-color:#f1d977;
 
  
  }

 
 @media screen and (max-width: 1000px) {
  .el-aside{
    display: none;
  }
 }

 
</style>