package com.wccwin.doc.controller;

import com.wccwin.doc.Bean.RespModel;
import com.wccwin.doc.entity.TUser;
import com.wccwin.doc.service.TUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doc")
public class TUserController {

    @Autowired
    private TUserService tUserService;


    /**
     * 获取用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public RespModel<TUser> login(@RequestBody int id){
        try{
            return RespModel.success(tUserService.getUser(id));
        } catch (Exception e){
            e.printStackTrace();
            return RespModel.error(-1, null, e);
        }

    }

    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/sign")
    public RespModel<TUser> sign(@RequestBody TUser user){
        try{
            if(StringUtils.isBlank(user.getPhone())) throw new Exception("用户手机不能为空。");
            if(StringUtils.isBlank(user.getName())) throw new Exception("用户姓名不能为空。");
            if(StringUtils.isBlank(user.getPhone())) throw new Exception("用户手机不能为空。");
            if(StringUtils.isBlank(user.getPhone())) throw new Exception("用户手机不能为空。");
            if(StringUtils.isBlank(user.getPhone())) throw new Exception("用户手机不能为空。");

            return RespModel.success(tUserService.signTUser(user));
        } catch (Exception e){
            e.printStackTrace();
            return RespModel.error(-1, null, e);
        }

    }





}
