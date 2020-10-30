package cn.yunhe.java.pojo;

import java.io.Serializable;

public class SysRoleRights implements Serializable {
    private Integer roleRightId;

    private Integer roleId;

    private Integer popedomId;

    private String createTime;

    private Integer createUserId;

    private String createUserName;

    public Integer getRoleRightId() {
        return roleRightId;
    }

    public void setRoleRightId(Integer roleRightId) {
        this.roleRightId = roleRightId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPopedomId() {
        return popedomId;
    }

    public void setPopedomId(Integer popedomId) {
        this.popedomId = popedomId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }
}