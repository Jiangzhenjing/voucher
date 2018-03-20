package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.common.sqlBuilderTool.annotations.AliasName;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ProviderEngineerDto implements Serializable {

    /**
     * 主键id
     */
    private UUID id;

    /**
     * 服务商ID
     */
    @AliasName("provider_id")
    private UUID providerId;

    /**
     * 服务商名称
     */
    @AliasName("corpName")
    private String providerName;

    /**
     * 工程师编号
     */
    private String engineerNo;

    /**
     * 工程师名称
     */
    private String engineerName;

    /**
     * 工程师描述
     */
    private String engineerDesc;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProviderId() {
        return providerId;
    }

    public void setProviderId(UUID providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getEngineerNo() {
        return engineerNo;
    }

    public void setEngineerNo(String engineerNo) {
        this.engineerNo = engineerNo;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getEngineerDesc() {
        return engineerDesc;
    }

    public void setEngineerDesc(String engineerDesc) {
        this.engineerDesc = engineerDesc;
    }
}
