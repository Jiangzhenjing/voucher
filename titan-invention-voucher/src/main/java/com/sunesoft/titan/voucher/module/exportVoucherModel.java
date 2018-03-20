package com.sunesoft.titan.voucher.module;

import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Created by jzj on 2017/12/1.
 */
public class exportVoucherModel {
    /**
     * 券号
     */
    private String voucherNo;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 企业联系人
     */
    private String contacts;
    /**
     * 企业联系电话
     */
    private String phoneNo;
    /**
     * 区域
     */
    private String region;
    /**
     * 服务券状态
     */
    private String voucherStatus;
    /**
     * 发卡时间
     */
    private String issuingDate;

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(String voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public String getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        this.issuingDate = issuingDate;
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
}
