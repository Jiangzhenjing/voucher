package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.cretiria.TCretiria;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;

import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/25
 */
public class SVUserCretirias  extends TCretiria{
    private String userName;

    private UUID regionId;


    private String roleType;

    private String userRealName;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getRegionId() {
        return regionId;
    }

    public void setRegionId(UUID regionId) {
        this.regionId = regionId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public Map<String,Object> getParams(){
        Map<String,Object> param =  super.getParams();

        if(!StringUtil.isEmpty(userName)){
            param.put("user_name","%"+userName+"%");
        }

        if(!StringUtil.isEmpty(roleType)){
            param.put("role_code",roleType);
        }

        if(!StringUtil.isEmpty(userRealName)){
            param.put("real_name","%"+userRealName+"%");
        }

        if(regionId!=null){
            param.put("u.org_id",regionId);
        }else{
            if(UserContext.getUser().getRoleIds().get(0).equals(RoleType.regionAdmin.name())){
                param.put("u.org_id",UserContext.getUser().getOrg_id());

            }
        }
        return param;

    }


}
