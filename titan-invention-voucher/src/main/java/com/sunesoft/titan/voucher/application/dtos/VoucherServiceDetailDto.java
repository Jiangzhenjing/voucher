package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.common.sqlBuilderTool.annotations.AliasName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class VoucherServiceDetailDto implements Serializable {

    /**
     * 主键id
     */
    private UUID id;


    /**
     * 服务券ID
     */
    @AliasName("voucher_id")
    private UUID voucherId;


    /**
     * 服务工程师
     */
    private String serviceEngineer;

    /**
     * 服务日期
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
     * 评价得分
     */
    private Integer evaluateScore;

    /**
     * 评价
     */
    private String evaluateContent;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public UUID getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(UUID voucherId) {
        this.voucherId = voucherId;
    }
}
