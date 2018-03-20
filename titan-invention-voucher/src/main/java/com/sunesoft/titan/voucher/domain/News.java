package com.sunesoft.titan.voucher.domain;

import com.sunesoft.titan.hibernate.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author: Zhouzh
 * @Date: 2017/12/11
 */
@Entity
@Table(name = "sv_news")
public class News extends IEntity{

    /**
     * 标题
     */
    private String title;


    private String newsType;

    /**
     * 内容
     */
    @Column(name="content", columnDefinition="longtext", nullable=true)
    private String content;

    /**
     * 发布日期
     */
    private LocalDateTime issueTime;

    /**
     * 发布人
     */
    private String   issuer;

    private String remark;


    private String attr1;


    private String attr2;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }
}
