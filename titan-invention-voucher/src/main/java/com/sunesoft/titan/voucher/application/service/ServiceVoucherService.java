package com.sunesoft.titan.voucher.application.service;

import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.dtos.*;
import com.sunesoft.titan.voucher.domain.ServiceVoucher;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public interface ServiceVoucherService {


    /**
     * 新增/修改创新券
     *
     * @param vencherNo
     * @param companyId
     * @return
     */
    TResult addOrUpdateVoucher(String vencherNo, UUID companyId);

    /**
     * 新增/修改服务记录
     *
     * @param dto
     * @return
     */
    TResult addVoucherServiceDetail(VoucherServiceDetailDto dto);

    /**
     * 添加签订合同日期
     *
     * @param uuid
     * @return
     */
    TResult signContract(UUID uuid, LocalDate time);

    /**
     * 服务券选择的服务商评价
     *
     * @return
     */
    TResult evaluateVoucherProvider(VoucherScoreDto voucherScoreDto);


    /**
     * 服务评价
     *
     * @param voucherId
     * @param serviceDetailId
     * @param score
     * @param evaluateContent
     * @return
     */
    TResult evaluateServiceDetail(UUID voucherId, UUID serviceDetailId, Integer score, String evaluateContent);


    /**
     * 删除创新券
     *
     * @param uuid
     * @return
     */
    TResult deleteVoucher(UUID uuid);


    /**
     * 删除服务记录
     *
     * @param voucherId
     * @param detailId
     * @return
     */
    TResult deleteVoucherServiceDetail(UUID voucherId, UUID detailId);


    /**
     * 激活服务券
     *
     * @param activeVoucherDto
     * @return
     */
    TResult activeVoucher(ActiveVoucherDto activeVoucherDto);


    /**
     * 选择产品
     *
     * @param userName
     * @param providerId
     * @param productId
     * @return
     */
    TResult chooseProduct(String userName, UUID providerId, UUID productId);

    /**
     * 选择产品
     *
     * @param voucherId
     * @param providerId
     * @param productId
     * @return
     */
    TResult chooseProduct(UUID voucherId, UUID providerId, UUID productId);

    /**
     * 选择产品
     *
     * @param serviceVoucher
     * @param providerId
     * @param productId
     * @return
     */
    TResult chooseProduct(ServiceVoucher serviceVoucher, UUID providerId, UUID productId);

    /**
     * 优惠券产品确认
     *
     * @param uuid
     * @return
     */
    TResult voucherConfirm(UUID providerId, UUID uuid, String remark);


    /**
     * 撤回优惠券 重新选择
     *
     * @param id
     * @return
     */
    TResult callBackVoucher(UUID id, String reason);


    /**
     * 管理员管理确认撤回优惠券
     *
     * @param
     * @return
     */
    TResult callBackConfirm(UUID id);


    /**
     * 管理员管理否决撤回优惠券
     *
     * @param
     * @return
     */
    TResult callBackRefuse(UUID id);

    /**
     * 重置到带选择状态。
     *
     * @param id
     * @return
     */
    TResult resetVoucherExpireDate(UUID id, LocalDate newExpiredDate, String reason);


    /**
     * 产品交付
     *
     * @param handOverDto
     * @return
     */
    TResult HandOverVoucher(HandOverDto handOverDto);


    TResult setVoucherExpired();


}
