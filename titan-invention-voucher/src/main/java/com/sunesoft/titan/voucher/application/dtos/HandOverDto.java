package com.sunesoft.titan.voucher.application.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class HandOverDto {

    private UUID providerId;


    private UUID voucherId;

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
     * 交付内容
     */
    private String handContent;

    public UUID getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(UUID voucherId) {
        this.voucherId = voucherId;
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

    public UUID getProviderId() {
        return providerId;
    }

    public void setProviderId(UUID providerId) {
        this.providerId = providerId;
    }
}
