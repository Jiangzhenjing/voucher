package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.voucher.VSSetting;
import com.sunesoft.titan.voucher.domain.ProviderProduct;
import com.sunesoft.titan.voucher.domain.enums.ServiceLevel;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ServiceVoucherDto implements Serializable {

    /**
     * 主键id
     */
    private UUID id;

    private UUID userId;
    /**
     * 券号
     */
    private String voucherNo;


    /**
     * 企业名称
     */
    private String companyName;


    /**
     * 发卡时间
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime issuingDate;

    /**
     * 激活日期
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime activeDate;


    /**
     * 金额
     */
    private BigDecimal amount;


    /**
     * 服务券状态
     */
    private VoucherStatus voucherStatus = VoucherStatus.WaitActive;


    /**
     * 是否撤回
     */
    private Boolean isCallBack = false;


    /**
     * 撤回原因
     */
    private String callbackReason;

    /**
     * 失效日期
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate expiryDate;


    /**
     * 年份
     */
    private Integer year = VSSetting.year;

    /**
     * 销售日期
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime orderDate;


    /**
     * 确认日期
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime confirmDate;

    /**
     * 确认备注
     */
    private String confirmRemark;

    /**
     * 企业类型
     */
    private String corpType;

    /**
     * 交付日期
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate handDate;


    /**
     * 签订合同日期
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate signDate;

    /**
     * 交付内容
     */
    private String handContent;


    /**
     * 第1项评分
     */
    private Double sc01;

    /**
     * 第2项评分
     */
    private Double sc02;

    /**
     * 第3项评分
     */
    private Double sc03;

    /**
     * 第4项评分
     */
    private Double sc04;
    /**
     * 第5项评分
     */
    private Double sc05;

    /**
     * 第6项评分
     */
    private Double sc06;

    /**
     * 第7项评分
     */
    private Double sc07;

    /**
     * 第8项评分
     */
    private Double sc08;

    /**
     * 评价得分
     */
    private Double totalScore;


    /**
     * 级别
     */
    private ServiceLevel serviceLevel;


    /**
     * 评价内容
     */
    private String evaluateContent;

    /**
     * 服务工程师
     */
    private String serviceEngineers = "";

    /**
     * 是否解决
     */
    private Boolean isSolve;

    /**
     * 实施信息化后改善
     */
    private String afterInformationImprovement;

    /**
     * 下一步信息化建设的重点
     */
    private String nextInformationKeyPoint;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDateTime getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(LocalDateTime issuingDate) {
        this.issuingDate = issuingDate;
    }

    public LocalDateTime getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(LocalDateTime activeDate) {
        this.activeDate = activeDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public VoucherStatus getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(VoucherStatus voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public Boolean getIsCallBack() {
        return isCallBack;
    }

    public void setIsCallBack(Boolean callBack) {
        isCallBack = callBack;
    }

    public String getCallbackReason() {
        return callbackReason;
    }

    public void setCallbackReason(String callbackReason) {
        this.callbackReason = callbackReason;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(LocalDateTime confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getConfirmRemark() {
        return confirmRemark;
    }

    public void setConfirmRemark(String confirmRemark) {
        this.confirmRemark = confirmRemark;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public LocalDate getHandDate() {
        return handDate;
    }

    public void setHandDate(LocalDate handDate) {
        this.handDate = handDate;
    }

    public String getHandContent() {
        return handContent;
    }

    public void setHandContent(String handContent) {
        this.handContent = handContent;
    }

    public Double getSc01() {
        return sc01;
    }

    public void setSc01(Double sc01) {
        this.sc01 = sc01;
    }

    public Double getSc02() {
        return sc02;
    }

    public void setSc02(Double sc02) {
        this.sc02 = sc02;
    }

    public Double getSc03() {
        return sc03;
    }

    public void setSc03(Double sc03) {
        this.sc03 = sc03;
    }

    public Double getSc04() {
        return sc04;
    }

    public void setSc04(Double sc04) {
        this.sc04 = sc04;
    }

    public Double getSc05() {
        return sc05;
    }

    public void setSc05(Double sc05) {
        this.sc05 = sc05;
    }

    public Double getSc06() {
        return sc06;
    }

    public void setSc06(Double sc06) {
        this.sc06 = sc06;
    }

    public Double getSc07() {
        return sc07;
    }

    public void setSc07(Double sc07) {
        this.sc07 = sc07;
    }

    public Double getSc08() {
        return sc08;
    }

    public void setSc08(Double sc08) {
        this.sc08 = sc08;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(ServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getServiceEngineers() {
        return serviceEngineers;
    }

    public void setServiceEngineers(String serviceEngineers) {
        this.serviceEngineers = serviceEngineers;
    }

    public Boolean getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(Boolean solve) {
        isSolve = solve;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getAfterInformationImprovement() {
        return afterInformationImprovement;
    }

    public void setAfterInformationImprovement(String afterInformationImprovement) {
        this.afterInformationImprovement = afterInformationImprovement;
    }

    public String getNextInformationKeyPoint() {
        return nextInformationKeyPoint;
    }

    public void setNextInformationKeyPoint(String nextInformationKeyPoint) {
        this.nextInformationKeyPoint = nextInformationKeyPoint;
    }
}
