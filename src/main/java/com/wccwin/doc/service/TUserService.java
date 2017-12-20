package com.wccwin.doc.service;

import com.wccwin.doc.bean.req.Login;
import com.wccwin.doc.bean.resp.AccessToken;
import com.wccwin.doc.entity.TUser;

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
