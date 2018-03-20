package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.common.sqlBuilderTool.annotations.AliasName;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;

import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/25
 */
public class SVUserDto {

    private UUID id;

    @AliasName("user_name")
    private String userName;

    private String password;

    @AliasName("org_id")
    private UUID regionId;

    @AliasName("org_name")
    private String region;

    @AliasName("role_code")
    private String roleType;

    @AliasName("role_name")
    private String roleName;

    @AliasName("real_name")
    private String userRealName;
    private String open_id;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getRegionId() {
        return regionId;
    }

    public void setRegionId(UUID regionId) {
        this.regionId = regionId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }
}
