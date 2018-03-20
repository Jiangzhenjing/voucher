package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.voucher.domain.enums.ServiceLevel;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class EvaluateLevelStatisticDto {

    private ServiceLevel  serviceLevel;


    private Integer count;

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(ServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
