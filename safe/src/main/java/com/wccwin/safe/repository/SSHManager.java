package com.wccwin.safe.repository;


import com.jcraft.jsch.ChannelExec;
import com.wccwin.safe.ExecuteMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SSHManager {


    @Autowired
    private ChannelExec channelExec;

    public ChannelExec getChannelExec(){
        try{
            if(!channelExec.getSession().isConnected()){
                channelExec.getSession().connect();
            }
            if(!channelExec.isConnected()){
                channelExec.connect();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return channelExec;
    }


    public ExecuteMessage execute(String action) throws Exception{



        return null;

    }


}
