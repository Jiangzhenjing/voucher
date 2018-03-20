package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.common.cretiria.TCretiria;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ProviderEngineerCretiria extends TCretiria {

    /**
     * 主键id
     */
    private UUID id;

    /**
     * 工程师编号
     */
    private String engineerNo;

    /**
     * 工程师名称
     */
    private String engineerName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
}
