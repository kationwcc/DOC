package com.wccwin.safe.controller;

import com.wccwin.doc.req.Login;
import com.wccwin.doc.resp.AccessToken;
import com.wccwin.RespModel;
import com.wccwin.safe.entity.TUser;
import com.wccwin.safe.service.TUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TUserController extends OperController {



    @Autowired
    private TUserService tUserService;


    /**
     * 获取用户信息
     * @param token
     * @return
     * @throws Exception
     */
    @GetMapping("/{token}")
    @ApiOperation(value="用户详情", notes="获取单个用户的详情数据")
    public RespModel<TUser> getUser(
            @ApiParam(required=true, name="token", value="用户ID")
            @PathVariable(name="token",required=true) String token){
        try{
            return RespModel.success(tUserService.getUser(token));
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
    @PostMapping("/signUp")
    @ApiOperation(value="用户注册", notes="用户注册")
    public RespModel<AccessToken> signUp(@RequestBody TUser user){
        try{
            if(StringUtils.isBlank(user.getPhone())) throw new Exception("用户手机不能为空。");
            if(StringUtils.isBlank(user.getName())) throw new Exception("用户姓名不能为空。");
            if(StringUtils.isBlank(user.getPassword())) throw new Exception("用户密码不能为空。");

            return RespModel.success(tUserService.signUp(user));
        } catch (Exception e){
            e.printStackTrace();
            return RespModel.error(-1, null, e);
        }

    }

    /**
     * 用户登入接口
     * @param login
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    @ApiOperation(value="用户登入", notes="用户登入")
    public RespModel<AccessToken> login(
            @RequestBody Login login){
        try{
            return RespModel.success(tUserService.login(login));
        } catch (Exception e){
            e.printStackTrace();
            return RespModel.error(-1, null, e);
        }

    }



}
