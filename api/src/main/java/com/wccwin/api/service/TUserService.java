package com.wccwin.api.service;

import com.wccwin.api.bean.req.Login;
import com.wccwin.api.bean.resp.AccessToken;
import com.wccwin.api.entity.TUser;

public interface TUserService {

    /**
     * 用户登入接口
     * @param login
     * @return
     * @throws Exception
     */
    public AccessToken login(Login login) throws Exception;

    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    public AccessToken signUp(TUser user) throws Exception;

    /**
     * 获取用户信息
     * @param token
     * @return
     * @throws Exception
     */
    public TUser getUser(String token) throws Exception ;






}
