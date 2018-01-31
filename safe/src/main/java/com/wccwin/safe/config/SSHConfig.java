package com.wccwin.safe.config;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSHConfig {

    @Value("${file.service.host}")
    private String host;

    @Value("${file.service.port}")
    private Integer port;

    @Value("${file.service.username}")
    private String username;

    @Value("${file.service.password}")
    private String password;

    @Value("${file.service.timeout}")
    private Integer timeout;

    @Bean(name = "channelExec")
    public ChannelExec channelExec(@Autowired Session session){
        try{
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.connect();
            return channelExec;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Bean(name = "jSch")
    public Session session(){
        try{
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.setTimeout(timeout);
            session.connect();
            return session;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
