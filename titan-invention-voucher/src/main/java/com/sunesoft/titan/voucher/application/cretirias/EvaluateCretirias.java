package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.cretiria.TCretiria;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;

import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class EvaluateCretirias extends TCretiria {

    private UUID providerId;

    private String region;

    private UUID providerUserId;





    public Map<String,Object> getParams(){
        Map<String,Object> ps = super.getParams();
        if(!StringUtil.isEmpty(region)){
            ps.put("region",region);
        }else{
            if(UserContext.getUser().getRoleIds().get(0).equals(RoleType.regionAdmin.name())){
                ps.put("region",UserContext.getUser().getOrg_name());
            }
        }

        if(!StringUtil.isEmpty(providerId)){
            ps.put("p.provider_id",providerId);
        }

        if(providerUserId!=null){
            ps.put("pr.userId",providerUserId);
        }

        return ps;


    }

    public UUID getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(UUID providerUserId) {
        this.providerUserId = providerUserId;
    }

    public UUID getProviderId() {
        return providerId;
    }

    public void setProviderId(UUID providerId) {
        this.providerId = providerId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
