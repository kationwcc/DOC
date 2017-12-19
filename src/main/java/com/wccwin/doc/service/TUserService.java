package com.wccwin.doc.service;

import com.wccwin.doc.entity.TUser;

public interface TUserService {


    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    public TUser signTUser(TUser user) throws Exception;

    /**
     * 获取用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public TUser getUser(int id) throws Exception ;


}
