package com.wccwin.doc.bean.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户登入信息")
public class AccessToken {

    @ApiModelProperty("用户id")
    private Integer uid;

    @ApiModelProperty("token")
    private String accessToken;

    public AccessToken() {

    }

    public AccessToken(Integer uid, String accessToken) {
        this.uid = uid;
        this.accessToken = accessToken;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
