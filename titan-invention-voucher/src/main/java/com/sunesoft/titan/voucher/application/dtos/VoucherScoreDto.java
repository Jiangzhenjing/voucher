package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.voucher.VSSetting;
import com.sunesoft.titan.voucher.domain.ProviderProduct;
import com.sunesoft.titan.voucher.domain.enums.ServiceLevel;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;

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
public class VoucherScoreDto implements Serializable {

    /**
     * 主键id？然而并不是，是服务券ID
     */
    private UUID id;
    /**
     * 券号
     */
    private String  voucherNo;
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
     * 评价内容
     */
    private String evaluateContent;

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

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
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
