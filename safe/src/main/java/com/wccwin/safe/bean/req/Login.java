package com.wccwin.safe.bean.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户登入")
public class Login {

    @ApiModelProperty("手机号")
    private String phone;


    @ApiModelProperty("密码")
    private String pwd;


    @ApiModelProperty("来源")
    private String source;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
