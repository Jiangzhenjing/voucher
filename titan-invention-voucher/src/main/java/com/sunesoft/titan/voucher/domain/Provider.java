package com.sunesoft.titan.voucher.domain;

import com.sunesoft.titan.hibernate.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */

/**
 * 服务商信息
 */
@Entity
@Table(name = "sv_provider")
public class Provider extends IEntity {

    /**
     * 服务商编号
     */
    private String pNo;

    /**
     * 用户ID
     */
    @Column(columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID userId;


    /**
     * 服务商简称当做新建user用户的用户名
     */
    private String sortName;

    /**
     * 服务商名称
     */
    private String corpName;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String phoneNo;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 网址
     */
    private String website;

    /**
     * 传真
     */
    private String fax;

    /**
     * 年份
     */
    private Integer year;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "provider_id")
    private List<ProviderEngineer> providerEngineers;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "provider_id")
    private List<ProviderProduct> providerProducts;


    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<ProviderEngineer> getProviderEngineers() {
        return providerEngineers;
    }

    public void setProviderEngineers(List<ProviderEngineer> providerEngineers) {
        this.providerEngineers = providerEngineers;
    }

    public List<ProviderProduct> getProviderProducts() {
        return providerProducts;
    }

    public void setProviderProducts(List<ProviderProduct> providerProducts) {
        this.providerProducts = providerProducts;
    }
}
