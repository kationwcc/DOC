package com.wccwin.api.service.impl;

import com.wccwin.api.entity.TUser;
import com.wccwin.api.repository.TUserRepository;
import com.wccwin.api.service.TUserService;
import com.wccwin.api.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tUserService")
public class TUserServiceImpl implements TUserService {


    @Autowired
    private TUserRepository tUserRepository;

    @Override
    public TUser getTUserByToken(String token) throws Exception {
        token = MD5Util.MD5(token);
        TUser user = tUserRepository.getTUserByToken(token);
        return null;
    }
}


