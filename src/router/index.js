import Vue from "vue";
import Router from "vue-router";
import Login from '@/views/login.vue';
import Home from '@/views/home.vue';
import Register from '@/views/register.vue';
import Modify from '@/views/modify.vue';
import New from '@/views/new.vue';
import VueRouter from "vue-router";
import ArticleManage from '@/components/ArticleManage.vue';
import UserManage from '@/components/UserManage.vue';
import Welcome from '@/components/Welcome.vue';
Vue.use(Router);

const routes=[
  {
    path: '/home',name: 'home', component: Home ,
    children:[
    {
    path: '/home/article',name: 'ArticleManage', component: ArticleManage,
    },
    {
    path: '/home/user',name: 'UserManage', component: UserManage,
    },
    {
      path: '/home/wel',name: 'Welcome', component: Welcome,
      },
    ]
  },
  {
    path: '/',name: 'login', component: Login,
  },
  {
    path: '/register',name: 'register', component: Register,
  },
  {
    path: '/new',name: 'new', component: New,
  },
  {
    path: '/modify',name: 'modify', component: Modify,
  },
 
]

const router =new VueRouter({ 
  mode:"history",
  base: process.env.BASE_URL,
  routes

})

// 导航守卫，前置处理
router.beforeEach((to, from, next) => {
  let isAuthenticated = !!sessionStorage.getItem('userInfo')
  // 如果路由要跳转到除了登录和注册的界面的话就判断是否已经登录，如果没有登录就强制跳到登录界面
  if (to.path !== '/' && to.path !== '/register' && !isAuthenticated) {
      next({ path: '/' })
      Message({
          message: '请先登录！',
          type: "warning",
      });
  } else next()
})
export default router
