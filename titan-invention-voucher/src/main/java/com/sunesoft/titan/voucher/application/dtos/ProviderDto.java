package com.sunesoft.titan.voucher.application.dtos;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ProviderDto implements Serializable {

    /**
     * 主键id
     */
    private UUID id;

    /**
     * 密码
     */
    private String password;

    /**
     * 服务商编号
     */
    private String pNo;

    /**
     * 用户ID
     */
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
    private String  fax;

    /**
     * 年份
     */
    private Integer year;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
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
}
