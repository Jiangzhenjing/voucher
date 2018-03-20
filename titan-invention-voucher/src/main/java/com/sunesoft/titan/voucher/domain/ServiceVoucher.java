package com.sunesoft.titan.voucher.domain;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */

import com.sunesoft.titan.hibernate.IEntity;
import com.sunesoft.titan.voucher.VSSetting;
import com.sunesoft.titan.voucher.domain.enums.ServiceLevel;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 服务券
 */
@Entity
@Table(name = "sv_service_voucher")
public class ServiceVoucher extends IEntity {

    /**
     * 用户ID
     */
    @Column(columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID userId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private CompanyInfo companyInfo;
    /**
     * 券号
     */
    private String voucherNo;


    /**
     * 发卡时间
     */
    private LocalDateTime issuingDate;

    /**
     * 激活日期
     */
    private LocalDateTime activeDate;


    /**
     * 金额
     */
    private BigDecimal amount;


    /**
     * 服务券状态
     */
    @Enumerated(EnumType.STRING)
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
    private LocalDate expiryDate;


    /**
     * 年份
     */
    private Integer year = VSSetting.year;


    /**
     * 购买产品
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProviderProduct providerProduct;


    /**
     * 销售日期
     */
    private LocalDateTime orderDate;


    private LocalDateTime confirmDate;

    private String confirmRemark;

    /**
     * 企业类型
     */
    private String corpType;

    /**
     * 交付日期
     */
    private LocalDate handDate;

    /**
     * 签订合同日期
     */
    private LocalDate signDate;

    /**
     * 交付内容
     */
    private String handContent;


    /**
     * 第1项评分
     */
    private Double sc01 = 0.0;

    /**
     * 第2项评分
     */
    private Double sc02 = 0.0;

    /**
     * 第3项评分
     */
    private Double sc03 = 0.0;

    /**
     * 第4项评分
     */
    private Double sc04 = 0.0;
    /**
     * 第5项评分
     */
    private Double sc05 = 0.0;

    /**
     * 第6项评分
     */
    private Double sc06 = 0.0;

    /**
     * 第7项评分
     */
    private Double sc07 = 0.0;

    /**
     * 第8项评分
     */
    private Double sc08 = 0.0;

    /**
     * 评价得分
     */
    private Double totalScore;


    /**
     * 级别
     */
    @Enumerated(EnumType.STRING)
    private ServiceLevel serviceLevel;


    /**
     * 评价内容
     */
    private String evaluateContent;

    /**
     * 是否解决
     */
    private Boolean isSolve;


    private String remark;

    private String serviceEngineers = "";

    /**
     * 实施信息化后改善
     */
    private String afterInformationImprovement;

    /**
     * 下一步信息化建设的重点
     */
    private String nextInformationKeyPoint;


    @Where(clause = "is_active=1")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "voucher_id")
    private List<VoucherServiceDetail> voucherServiceDetailList = new ArrayList<>();


    public void init(String vno, CompanyInfo companyInfo) {

//        if (vno.length() == 5) {
//            this.voucherNo = VSSetting.cardPrifix + vno;
//        } else {
//            this.voucherNo = vno;
//        }
        this.voucherNo = vno;

        this.issuingDate = LocalDateTime.now();
        this.amount = BigDecimal.valueOf(10000);
        this.year = VSSetting.year;
        this.voucherStatus = VoucherStatus.WaitActive;
        this.expiryDate = LocalDate.now().plusDays(VSSetting.expiredDateSpan);
        this.companyInfo = companyInfo;

    }


    public void Active() {
        this.activeDate = LocalDateTime.now();
        this.voucherStatus = VoucherStatus.Actived;
        this.expiryDate = LocalDate.of(this.getCreate_datetime().getYear(), this.getCreate_datetime().getMonth(), this.getCreate_datetime().getDayOfMonth()).plusDays(VSSetting.afterActiveexpiredDateSpan);
    }


    public void bugProduct(ProviderProduct product) {
        this.providerProduct = product;
        this.orderDate = LocalDateTime.now();
        this.expiryDate = null;
        this.voucherStatus = VoucherStatus.WaitConfirm;
    }


    public void confirm(LocalDateTime confirmDate, String content) {
        this.confirmDate = confirmDate;
        this.confirmRemark = content;
        this.voucherStatus = VoucherStatus.Confirmed;

    }

    public void hand(String corpType, LocalDate handDate, String content) {
        this.corpType = corpType;
        this.handDate = handDate;
        this.handContent = content;
        this.voucherStatus = VoucherStatus.HandOver;

    }

    public void scoreService() {

        this.totalScore = sc01 + sc02 + sc03 + sc04 + sc05 + sc06 + sc07 + sc08;
        if (totalScore >= 90)
            this.serviceLevel = ServiceLevel.A;
        if (totalScore >= 80 && totalScore < 90)
            this.serviceLevel = ServiceLevel.B;
        if (totalScore >= 60 && totalScore < 80)
            this.serviceLevel = ServiceLevel.C;
        if (totalScore < 60)
            this.serviceLevel = ServiceLevel.D;
    }

    public void callBack(String remark) {
        this.isCallBack = true;
        this.callbackReason = remark;
    }

    public Boolean callBackConfirm() {
        if (voucherStatus == VoucherStatus.WaitConfirm)
            this.voucherStatus = VoucherStatus.Actived;
        if (voucherStatus == VoucherStatus.Confirmed) {
            this.voucherStatus = VoucherStatus.Actived;
            this.confirmRemark = "";
            this.confirmDate = null;
        } else {
            return false;
        }
        this.isCallBack = false;
        this.providerProduct = null;
        this.orderDate = null;

        return true;

    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getAmount() {
        return amount;
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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ProviderProduct getProviderProduct() {
        return providerProduct;
    }

    public void setProviderProduct(ProviderProduct providerProduct) {
        this.providerProduct = providerProduct;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public String getHandContent() {
        return handContent;
    }

    public void setHandContent(String handContent) {
        this.handContent = handContent;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public List<VoucherServiceDetail> getVoucherServiceDetailList() {
        return voucherServiceDetailList;
    }

    public void setVoucherServiceDetailList(List<VoucherServiceDetail> voucherServiceDetailList) {
        this.voucherServiceDetailList = voucherServiceDetailList;
    }

    public Boolean getIsCallBack() {
        return isCallBack;
    }

    public void setIsCallBack(Boolean callBack) {
        isCallBack = callBack;
    }

    public Boolean getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(Boolean solve) {
        isSolve = solve;
    }

    public String getCallbackReason() {
        return callbackReason;
    }

    public void setCallbackReason(String callbackReason) {
        this.callbackReason = callbackReason;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getHandDate() {
        return handDate;
    }

    public void setHandDate(LocalDate handDate) {
        this.handDate = handDate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getServiceEngineers() {
        return serviceEngineers;
    }

    public void setServiceEngineers(String serviceEngineers) {
        this.serviceEngineers = serviceEngineers;
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
