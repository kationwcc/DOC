package com.wccwin.doc.service.impl;

import com.wccwin.doc.entity.TUser;
import com.wccwin.doc.repository.TUserRepository;
import com.wccwin.doc.service.TUserService;
import com.wccwin.doc.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service("tUserService")
public class TUserServiceImpl implements TUserService {


    @Autowired
    private TUserRepository tUserRepository;


    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public TUser signTUser(TUser user) throws Exception {
        TUser tuser = tUserRepository.getTUser(user.getPhone());
        if(tuser != null){
            throw new Exception("对不起,该手机已经注册过了。");
        }
        user.setDeleted(false);
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUpdateime(new Timestamp(System.currentTimeMillis()));
        user.setToken(UUID.randomUUID().toString());
        user.setPassword(MD5Util.MD5(user.getPassword()));
        user = tUserRepository.save(user);
        return user;
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public TUser getUser(int id) throws Exception {
        TUser user = tUserRepository.findOne(id);
        return user;
    }



}


