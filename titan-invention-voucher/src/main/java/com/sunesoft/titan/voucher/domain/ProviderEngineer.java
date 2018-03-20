package com.sunesoft.titan.voucher.domain;

import com.sunesoft.titan.hibernate.IEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */

/**
 * 服务商工程师
 */
@Entity
@Table(name = "sv_provider_engineer")
public class ProviderEngineer extends IEntity {

    /**
     * 工程师编号
     */
    private String engineerNo;

    /**
     * 工程师名称
     */
    private String engineerName;

    /**
     * 工程师描述
     */
    private String engineerDesc;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    public String getEngineerNo() {
        return engineerNo;
    }

    public void setEngineerNo(String engineerNo) {
        this.engineerNo = engineerNo;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getEngineerDesc() {
        return engineerDesc;
    }

    public void setEngineerDesc(String engineerDesc) {
        this.engineerDesc = engineerDesc;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
