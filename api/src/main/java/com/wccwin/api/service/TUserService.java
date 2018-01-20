package com.wccwin.api.service;

import com.wccwin.api.entity.TUser;

public interface TUserService {

    /**
     * @Description: 根据用户token查询登入的用户ID
     * @Author: kation
     * @param token
     * @Date: 2018/1/20 16:07
     * @return:
     */
    public TUser getTUserByToken(String token)throws Exception;






}
