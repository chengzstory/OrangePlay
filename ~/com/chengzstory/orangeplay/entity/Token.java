package com.chengzstory.orangeplay.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * token表
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Integer uid;
    /**
     * token
     */
    private String token;
    /**
     * 过期时间
     */
    private Date expiredTime;
    /**
     * 访问者IP
     */
    private String ip;
    /**
     * 登录的设备
     */
    private String device;
    /**
     * 登录时间
     */
    private Date ctime;
    /**
     * 0表示正常，1表示已过期
     */
    private Integer stat;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Token{" +
        ", uid=" + uid +
        ", token=" + token +
        ", expiredTime=" + expiredTime +
        ", ip=" + ip +
        ", device=" + device +
        ", ctime=" + ctime +
        ", stat=" + stat +
        "}";
    }
}
