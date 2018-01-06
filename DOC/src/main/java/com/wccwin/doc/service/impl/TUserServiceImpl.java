package com.wccwin.doc.service.impl;

import com.wccwin.doc.bean.req.Login;
import com.wccwin.doc.bean.resp.AccessToken;
import com.wccwin.doc.entity.TUser;
import com.wccwin.doc.repository.TUserRepository;
import com.wccwin.doc.service.TUserService;
import com.wccwin.doc.util.MD5Util;
import com.wccwin.doc.util.QEncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.UUID;

@Service("tUserService")
public class TUserServiceImpl implements TUserService {


    @Autowired
    private TUserRepository tUserRepository;

    /**
     * 用户登入接口
     * @param login
     * @return
     * @throws Exception
     */
    @Transactional
    @Override
    public AccessToken login(Login login) throws Exception {
        login.setPwd(MD5Util.MD5(login.getPwd()));
        TUser user = tUserRepository.getTUser(login.getPhone(), login.getPwd());
        if(user == null ){
            throw new Exception("您的账号和密码有误，请确认后重试");
        }

        user.setToken(UUID.randomUUID().toString());

        String token = QEncodeUtil.aesEncrypt(user.getToken(), String.valueOf(user.getId()));
        AccessToken accessToken = new AccessToken(user.getId(), token);

        return accessToken;
    }

    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public AccessToken signUp(TUser user) throws Exception {
        TUser tuser = tUserRepository.getTUser(user.getPhone());
        if(tuser != null){
            throw new Exception("对不起,该手机已经注册过了。");
        }
        user.setDeleted(false);
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        user.setToken(UUID.randomUUID().toString());
        user.setPassword(MD5Util.MD5(user.getPassword()));
        user.setUserStatus(1);
        user = tUserRepository.save(user);

        String token = QEncodeUtil.aesEncrypt(user.getToken(), String.valueOf(user.getId()));
        AccessToken accessToken = new AccessToken(user.getId(), token);
        return accessToken;
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     * @throws Exception
     */
    @Override
    public TUser getUser(String token) throws Exception {
        TUser user = tUserRepository.getTUserByToken(token);
        return user;
    }



}


