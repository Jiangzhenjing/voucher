package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.cretiria.TCretiria;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ProviderProductCretiria extends TCretiria {


    private String providerId;


    private String region;

    /**
     * 主键id
     */
    private UUID id;

    /**
     * 产品编号
     */
    private String productNo;


    /**
     * 产品名称
     */
    private String productName;


    /**
     * 产品类型
     */
    private String productType;


    /**
     * 服务年份
     */
    private Integer year;


    /**
     * 统计分析专用
     */
    private UUID providerUserId;



    public Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<>();
        if (id != null) {
            params.put("id", id);
        }
        if (productNo != null) {
            params.put("productNo", productNo);
        }
        if (productName != null) {
            params.put("productName", "%" + productName + "%");
        }
        if (productType != null) {
            params.put("productType", productType);
        }
        if (year != null) {
            params.put("year", year);
        }

        if(!StringUtil.isEmpty(region)){
            params.put("region",region);
        }else{
            if(UserContext.getUser().getRoleIds().get(0).equals(RoleType.regionAdmin.name())){
                params.put("region",UserContext.getUser().getOrg_name());
            }
        }

        if(!StringUtil.isEmpty(providerId)){
            params.put("p.provider_id",providerId);
        }

        //统计分析专用
        if (providerUserId != null) {
            params.put("pr.userId", providerUserId);
        }
        return params;
    }


    public UUID getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(UUID providerUserId) {
        this.providerUserId = providerUserId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}