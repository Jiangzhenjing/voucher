package com.sunesoft.titan.voucher.domain;

import com.sunesoft.titan.hibernate.IEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */

/**
 * 服务记录
 */
@Entity
@Table(name = "sv_service_voucher_detail")
public class VoucherServiceDetail extends IEntity {

    /**
     * 服务工程师
     */
    private String serviceEngineer;

    /**
     * 服务日期
     */
    private LocalDate serviceDate;


    /**
     * 服务描述
     */
    private String serviceDesc;

    /**
     * 服务备注
     */
    private String remark;


    /**
     * 是否评价
     */
    private Boolean isEvaluate=false;


    /**
     * 评价得分
     */
    private Integer evaluateScore;

    /**
     * 评价
     */
    private String evaluateContent;


    public String getServiceEngineer() {
        return serviceEngineer;
    }

    public void setServiceEngineer(String serviceEngineer) {
        this.serviceEngineer = serviceEngineer;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(Integer evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public Boolean getEvaluate() {
        return isEvaluate;
    }

    public void setEvaluate(Boolean evaluate) {
        isEvaluate = evaluate;
    }
}
