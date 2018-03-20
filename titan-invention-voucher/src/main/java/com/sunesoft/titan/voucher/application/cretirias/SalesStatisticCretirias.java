package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.cretiria.TCretiria;
import com.sunesoft.titan.common.sqlBuilderTool.annotations.AliasName;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;
import com.sunesoft.titan.voucher.domain.enums.ServiceLevel;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class SalesStatisticCretirias extends TCretiria {

    /**
     * 区域
     */
    private String region;
    /**
     * 服务商名称
     */
    private String providerId;
    /**
     * 公司类型
     */
    private String corpType;
    /**
     * 产品名称
     */
    private String productType;


    private UUID providerUserId;

    /**
     * 级别
     */
    private ServiceLevel serviceLevel;

    public Map<String, Object> getParams() {
        Map<String, Object> ps = super.getParams();

        if (!StringUtil.isEmpty(region)) {
            ps.put("region", region);
        } else {
            if (UserContext.getUser().getRoleIds().get(0).equals(RoleType.regionAdmin.name())) {
                ps.put("region", UserContext.getUser().getOrg_name());

            }
        }
        if (!StringUtil.isEmpty(providerId)) {
            ps.put("p.provider_id", providerId);
        }

        if (!StringUtil.isEmpty(corpType)) {
            ps.put("c.corpType", corpType);
        }

        if (!StringUtil.isEmpty(productType)) {
            ps.put("productType", productType);
        }
        if (providerUserId != null) {
            ps.put("pr.userId", providerUserId);
        }
        if (serviceLevel != null) {
            ps.put("s.serviceLevel", serviceLevel);
        }
        return ps;


    }

    public UUID getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(UUID providerUserId) {
        this.providerUserId = providerUserId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(ServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    //    /**
//     * 工程师
//     */
//    private String engineerName;

//    public String getEngineerName() {
//        return engineerName;
//    }
//
//    public void setEngineerName(String engineerName) {
//        this.engineerName = engineerName;
//    }
}
