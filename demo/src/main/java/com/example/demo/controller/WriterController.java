package com.example.demo.controller;
import com.example.demo.domain.Writer;
import com.example.demo.service.WriterService;
import com.example.demo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/writer")
public class WriterController {
    @Resource
    private WriterService writerService;

    @PostMapping("/modify")
    public Result<Writer> modifyController(Writer writer){
        Writer writer1 = writerService.addService(writer);
        if(writer!=null){
            return Result.success(writer,"修改成功！");
        }else{
            return Result.error("789","账号或密码错误！");
        }
    }
}