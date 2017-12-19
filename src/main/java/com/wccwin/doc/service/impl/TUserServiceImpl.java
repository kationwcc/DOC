package com.wccwin.doc.service.impl;

import com.wccwin.doc.entity.TUser;
import com.wccwin.doc.repository.TUserRepository;
import com.wccwin.doc.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


