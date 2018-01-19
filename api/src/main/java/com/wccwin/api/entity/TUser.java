package com.wccwin.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_user", schema = "doc")
@ApiModel("用户信息")
public class TUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID", hidden = true)
    private int id;

    @Column(name = "token")
    @ApiModelProperty(value = "token", hidden = true)
    private String token;

    @Column(name = "name")
    @ApiModelProperty(value = "姓名", hidden = true)
    private String name;

    @Column(name = "phone")
    @ApiModelProperty("手机号")
    private String phone;

    @Column(name = "password")
    @ApiModelProperty("密码")
    private String password;

    @Column(name = "user_status")
    @ApiModelProperty(value = "用户状态", hidden = true)
    private Integer userStatus;

    @Column(name = "point")
    @ApiModelProperty(value = "point", hidden = true)
    private Double point;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Timestamp createTime;

    @Column(name = "update_time")
    @ApiModelProperty(value = "修改时间", hidden = true)
    private Timestamp updateTime;

    @Column(name = "is_deleted")
    @ApiModelProperty(value = "是否删除", hidden = true)
    private Boolean isDeleted;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TUser that = (TUser) o;
        return id == that.id &&
                Objects.equals(token, that.token) &&
                Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(password, that.password) &&
                Objects.equals(userStatus, that.userStatus) &&
                Objects.equals(point, that.point) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, token, name, phone, password, userStatus, point, createTime, updateTime, isDeleted);
    }
}
