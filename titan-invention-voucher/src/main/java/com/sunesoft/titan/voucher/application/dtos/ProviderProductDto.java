package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.common.sqlBuilderTool.annotations.AliasName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ProviderProductDto implements Serializable {

    /*
        todo @zhouzh
        缺少电话，传真,联系人
     */
    /**
     * 联系电话
     */
    private String phoneNo;
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
     * 产品描述
     */
    private String productDesc;

    /**
     * 原价
     */
    private BigDecimal orginalPrice;


    /**
     * 优惠价
     */
    private BigDecimal discountPrice;

    /**
     * 适用对象
     */
    private String suitTarget;


    /**
     * 解决问题
     */
    private String solveProblem;


    /**
     * 服务年份
     */
    private Integer year;


    /**
     * 销售数量
     */
    private Integer sales;


    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public BigDecimal getOrginalPrice() {
        return orginalPrice;
    }

    public void setOrginalPrice(BigDecimal orginalPrice) {
        this.orginalPrice = orginalPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getSuitTarget() {
        return suitTarget;
    }

    public void setSuitTarget(String suitTarget) {
        this.suitTarget = suitTarget;
    }

    public String getSolveProblem() {
        return solveProblem;
    }

    public void setSolveProblem(String solveProblem) {
        this.solveProblem = solveProblem;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
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
}
