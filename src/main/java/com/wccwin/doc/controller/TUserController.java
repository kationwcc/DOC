package com.wccwin.doc.controller;

import com.wccwin.doc.bean.RespModel;
import com.wccwin.doc.entity.TUser;
import com.wccwin.doc.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TUserController {

    @Autowired
    private TUserService tUserService;


    /**
     * 获取用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value="用户详情", notes="获取单个用户的详情数据")
    public RespModel<TUser> getUser(
            @ApiParam(required=true, name="id", value="用户ID")
            @PathVariable(name="id",required=true) int id){
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
