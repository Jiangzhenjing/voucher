package com.sunesoft.titan.voucher.domain;

import com.sunesoft.titan.hibernate.IEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */

/**
 * 服务商产品
 */
@Entity
@Table(name = "sv_provider_product")
public class ProviderProduct extends IEntity {


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


    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;


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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
