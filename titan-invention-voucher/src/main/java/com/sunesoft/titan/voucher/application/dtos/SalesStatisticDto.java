package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.common.sqlBuilderTool.annotations.AliasName;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class SalesStatisticDto {


    private UUID id;

    /**
     * 区域
     */
    private String region;


    /**
     * 服务商名称
     */
    @AliasName("corpName")
    private String providerName;


    /**
     * 公司名称
     */
    private String companyName;


    /**
     * 公司类型
     */
    private String corpType;


    /**
     * 产品名称
     */
    private String productName;



    private Double totalScore;


    /**
     * 销售数量
     */
    private Integer salesCount;

    /**
     * 销售金额
     */
    private BigDecimal salesAmount;

    /**
     * 工程师
     */
    private String serviceEngineers;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String getServiceEngineers() {
        return serviceEngineers;
    }

    public void setServiceEngineers(String serviceEngineers) {
        this.serviceEngineers = serviceEngineers;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }
}
