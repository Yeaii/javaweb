package com.example.demo.service.serviceImpl;

import com.example.demo.domain.User;
import com.example.demo.repository.UserDao;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User loginService(String uname, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null

        User user = userDao.findByUnameAndPassword(uname, password);
        // 重要信息置空
        if(user != null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        //当新用户的用户名已存在时
        if(userDao.findByUname(user.getUname())!=null){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }

    @Override
    public User updateService(String uname,String password,String newpassword) {
        User user1 = userDao.findByUnameAndPassword(uname,password);
        if(user1 != null){
            user1.setPassword(newpassword);
            userDao.save(user1);
        }
        return user1;
    }




}
