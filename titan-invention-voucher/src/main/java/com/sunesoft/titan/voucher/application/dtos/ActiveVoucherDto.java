package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ActiveVoucherDto implements Serializable {

    /**
     * 券号
     */
    private String voucherNo;

    /**
     * 区域
     */
    private String region;

    /**
     * 企业名称
     */
    private String corpName;

    /**
     * 手机号/账号
     */
    private String phoneNo;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * qq号
     */
    private String qq;

    /**
     * 邮件地址
     */
    private String email;

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
