package com.sunesoft.titan.voucher.application.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/23
 */
public class CompanyInfoDto {

    private UUID id;

    private UUID userId;
    /**
     * 信用代码
     */
    private String creditCode;

    /**
     * 法人
     */
    private String artificialPerson;

    /**
     * 成立日期
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate establishDate;

    /**
     * 企业规模
     */

    private String companyScale;


    /**
     * 区域
     */
    private UUID regionId;

    /**
     * 区域
     */
    private String region;
    /**
     * 企业类型
     */
    private String corpType;


    /**
     * 行业
     */
    private String industry;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 手机号/账号
     */
    private String phoneNo;


    /**
     * 联系人
     */
    private String contacts;

    /**
     * 地址
     */
    private String address;

    /**
     * qq号
     */
    private String qq;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 邮件地址
     */
    private String email;
    /**
     * 年份
     */
    private Integer year;

    /**
     * 前年（2016）年总产值
     */
    private Integer productionValueYearBeforeLast;

    /**
     * 前年（2016） 营业额
     */
    private Integer turnoverYearBeforeLast;

    /**
     * 前年（2016） 利润
     */
    private Integer profitYearBeforeLast;

    /**
     * 去年(2017)年总产值
     */
    private Integer productionValueLastYear;

    /**
     * 去年(2017) 营业额
     */
    private Integer turnoverLastYear;

    /**
     * 去年(2017) 利润
     */
    private Integer profitLastYear;


    /**
     * 从业人数
     */
    private Integer employeeCount;


    /**
     * 困难
     */
    private String trouble;


    /**
     * 备注
     */
    private String remark;


    /**
     * 曾经选择的服务商
     */
    private String haveSelectedProvider;


    /**
     * 曾经选择的服务
     */
    private String haveSelectedService;


    /**
     * 软件投入
     */
    private String softwareInvest;


    /**
     * 硬件投入
     */
    private String hardwareInvest;


    /**
     * 咨询投入
     */
    private String consultationInvest;


    /**
     * 网站建设情况
     */
    private String websiteConstruction;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getArtificialPerson() {
        return artificialPerson;
    }

    public void setArtificialPerson(String artificialPerson) {
        this.artificialPerson = artificialPerson;
    }

    public LocalDate getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(LocalDate establishDate) {
        this.establishDate = establishDate;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getProductionValueYearBeforeLast() {
        return productionValueYearBeforeLast;
    }

    public void setProductionValueYearBeforeLast(Integer productionValueYearBeforeLast) {
        this.productionValueYearBeforeLast = productionValueYearBeforeLast;
    }

    public Integer getTurnoverYearBeforeLast() {
        return turnoverYearBeforeLast;
    }

    public void setTurnoverYearBeforeLast(Integer turnoverYearBeforeLast) {
        this.turnoverYearBeforeLast = turnoverYearBeforeLast;
    }

    public Integer getProfitYearBeforeLast() {
        return profitYearBeforeLast;
    }

    public void setProfitYearBeforeLast(Integer profitYearBeforeLast) {
        this.profitYearBeforeLast = profitYearBeforeLast;
    }

    public Integer getProductionValueLastYear() {
        return productionValueLastYear;
    }

    public void setProductionValueLastYear(Integer productionValueLastYear) {
        this.productionValueLastYear = productionValueLastYear;
    }

    public Integer getTurnoverLastYear() {
        return turnoverLastYear;
    }

    public void setTurnoverLastYear(Integer turnoverLastYear) {
        this.turnoverLastYear = turnoverLastYear;
    }

    public Integer getProfitLastYear() {
        return profitLastYear;
    }

    public void setProfitLastYear(Integer profitLastYear) {
        this.profitLastYear = profitLastYear;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getTrouble() {
        return trouble;
    }

    public void setTrouble(String trouble) {
        this.trouble = trouble;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHaveSelectedProvider() {
        return haveSelectedProvider;
    }

    public void setHaveSelectedProvider(String haveSelectedProvider) {
        this.haveSelectedProvider = haveSelectedProvider;
    }

    public String getHaveSelectedService() {
        return haveSelectedService;
    }

    public void setHaveSelectedService(String haveSelectedService) {
        this.haveSelectedService = haveSelectedService;
    }


    public UUID getRegionId() {
        return regionId;
    }

    public void setRegionId(UUID regionId) {
        this.regionId = regionId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSoftwareInvest() {
        return softwareInvest;
    }

    public void setSoftwareInvest(String softwareInvest) {
        this.softwareInvest = softwareInvest;
    }

    public String getHardwareInvest() {
        return hardwareInvest;
    }

    public void setHardwareInvest(String hardwareInvest) {
        this.hardwareInvest = hardwareInvest;
    }

    public String getConsultationInvest() {
        return consultationInvest;
    }

    public void setConsultationInvest(String consultationInvest) {
        this.consultationInvest = consultationInvest;
    }

    public String getWebsiteConstruction() {
        return websiteConstruction;
    }

    public void setWebsiteConstruction(String websiteConstruction) {
        this.websiteConstruction = websiteConstruction;
    }
}
