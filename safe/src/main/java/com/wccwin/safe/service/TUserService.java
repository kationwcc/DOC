package com.wccwin.safe.service;

import com.wccwin.safe.bean.req.Login;
import com.wccwin.safe.bean.resp.AccessToken;
import com.wccwin.safe.entity.TUser;

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
