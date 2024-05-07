package com.example.demo.controller;



import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String uname, @RequestParam String password){
        User user = userService.loginService(uname, password);
        if(user!=null){
            return Result.success(user,"登录成功！");
        }else{
            return Result.error("123","账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public Result<User> registController( User newUser) throws IOException {

        User user = userService.registService(newUser);

        if(user!=null){
            return Result.success(user,"注册成功！");
        }else{
            return Result.error("456","用户名已存在！");
        }
    }



    @PostMapping("/modify")
    public Result<User> modifyController(@RequestParam String uname, @RequestParam String password,@RequestParam String newpassword){
        User user = userService.updateService(uname,password,newpassword);
        if(user!=null){
            return Result.success(user,"修改成功！");
        }else{
            return Result.error("789","账号或密码错误！");
        }
    }
}