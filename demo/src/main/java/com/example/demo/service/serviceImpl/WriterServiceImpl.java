package com.example.demo.service.serviceImpl;

import com.example.demo.repository.WriterDao;
import com.example.demo.domain.Writer;
import com.example.demo.service.UserService;
import com.example.demo.service.WriterService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WriterServiceImpl  implements WriterService {
    @Resource
    private WriterDao writerDao;
    @Override
    public Writer addService(Writer writer){
        //当新用户的用户名已存在时

        if(writerDao.findByWname(writer.getWname())!=null){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            Writer newWriter = writerDao.save(writer);
            if(newWriter != null){
                newWriter.setZipcode("");
            }
            return writer;
        }

    }
}
