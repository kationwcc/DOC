package com.wccwin.safe.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_log", schema = "word", catalog = "")
public class TLog {
    private int id;
    private Integer userId;
    private Integer logType;
    private String logDesc;
    private String action;
    private String ip;
    private Boolean isDeleted;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "log_type")
    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    @Basic
    @Column(name = "log_desc")
    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    @Basic
    @Column(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "is_deleted")
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
        TLog that = (TLog) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(logType, that.logType) &&
                Objects.equals(logDesc, that.logDesc) &&
                Objects.equals(action, that.action) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, logType, logDesc, action, ip, isDeleted);
    }
}
