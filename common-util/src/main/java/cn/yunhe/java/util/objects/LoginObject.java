package cn.yunhe.java.util.objects;

import java.io.Serializable;

public class LoginObject implements Serializable {
    private Integer userId;

    private String loginName;

    private String loginPwd;

    private String userName;

    private Integer provinceId;

    private Integer cityId;

    private Integer servicePointId;

    private String lastLoginIp;

    private String lastLoginTime;

    private Integer loginTimes;

    public LoginObject() {
    }

    public LoginObject(Integer userId, String loginName, String loginPwd, String userName,
                       Integer provinceId, Integer cityId, Integer servicePointId,
                       String lastLoginIp, String lastLoginTime, Integer loginTimes) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.userName = userName;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.servicePointId = servicePointId;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginTime = lastLoginTime;
        this.loginTimes = loginTimes;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(Integer servicePointId) {
        this.servicePointId = servicePointId;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }
}
