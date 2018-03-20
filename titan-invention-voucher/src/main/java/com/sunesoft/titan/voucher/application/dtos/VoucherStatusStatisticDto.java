package com.sunesoft.titan.voucher.application.dtos;

import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public class VoucherStatusStatisticDto {

    private VoucherStatus voucherStatus;

    private Integer count;

    public VoucherStatus getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(VoucherStatus voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
