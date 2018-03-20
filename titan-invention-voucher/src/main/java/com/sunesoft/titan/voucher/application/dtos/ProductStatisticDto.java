package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.common.sqlBuilderTool.annotations.AliasName;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class ProductStatisticDto {


    private UUID id;


    /**
     * 服务商ID
     */
    @AliasName("p.provider_id")
    private String provider_id;

    /**
     * 服务商名称
     */
    @AliasName("corpName")
    private String providerName;

    /**
     * 产品编号
     */
    private String productNo;
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 销售数量
     */
    private Integer salesCount;

    /**
     * 销售收入
     */
    private BigDecimal salesAmount;

    /**
     * 企业自付金额
     */
    private BigDecimal companyPayAmount;

    /**
     * 评价得分
     */
    private Double avgScore;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
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

    public BigDecimal getCompanyPayAmount() {
        return companyPayAmount;
    }

    public void setCompanyPayAmount(BigDecimal companyPayAmount) {
        this.companyPayAmount = companyPayAmount;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }
}
