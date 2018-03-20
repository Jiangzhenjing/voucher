package com.sunesoft.titan.voucher.domain.enums;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public enum VoucherStatus {

    /**
     * 待激活
     */
    WaitActive,

    /**
     * 已激活
     */
    Actived,


    /**
     * 已购买产品，待购买确认
     */
    WaitConfirm,


    /**
     * 已确认
     */
    Confirmed,

    /**
     * 已交付
     */
    HandOver,

    /**
     * 已过期
     */
    Expired


}
