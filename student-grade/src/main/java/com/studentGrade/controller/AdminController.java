package com.studentGrade.controller;


import com.studentGrade.entity.Admin;
import com.studentGrade.entity.Result;
import com.studentGrade.server.AdminServer;
import com.studentGrade.utils.JwtUtil;
import com.studentGrade.utils.Md5Util;
import com.studentGrade.utils.ThreadLocalUtils;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServer adminServer;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/login")
    public Result login( Admin admin){
        System.out.println("admin="+admin);
        if(admin==null){
            return Result.error("没有该学生");
        }
        if(admin.getId()==null||StringUtil.isNullOrEmpty(admin.getPassword())){
            return Result.error("没有完整的账号和密码");
        }
        Admin adminById = adminServer.queryAdminById(admin);
        //加密再对比
        admin.setPassword(Md5Util.getMD5String(admin.getPassword()));
        //如果不相等
        if(!adminById.getPassword().equals(admin.getPassword())){
            return Result.error("密码错误");
        }
        //使用JWT工具加密
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",adminById.getId());
        String token = JwtUtil.getToken(hashMap);

        //存入到redis中
        redisTemplate.opsForValue().set("token"+adminById.getId(),token,1,TimeUnit.HOURS);
        return Result.success(token);
    }
    @GetMapping("/info")
    public Result getStudentInfo(){
        HashMap<String,Object> hashMap = ThreadLocalUtils.get();
        Integer id =(Integer) hashMap.get("id");
        Admin adminInfo = adminServer.getAdminInfo(id);
        return Result.success(adminInfo);
    }
}
