package com.sunesoft.titan.voucher.application.querys;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.ServiceVoucherCretiria;
import com.sunesoft.titan.voucher.application.dtos.ServiceVoucherDto;
import com.sunesoft.titan.voucher.application.dtos.ServiceVoucherWithProductDto;
import com.sunesoft.titan.voucher.application.dtos.VoucherServiceDetailDto;
import com.sunesoft.titan.voucher.application.dtos.VoucherWithCorpInfoDto;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * 服务券
 * @Date: 2017/11/20
 */

public interface ServiceVoucherQueryService {

    /**
     * 根据ID获取服务券信息
     *
     * @param uuid
     * @return
     */
    TResult<ServiceVoucherDto> getById(UUID uuid);

    /**
     * 根据username获取服务券信息
     *
     * @param userName
     * @return
     */
    TResult<ServiceVoucherDto> getServiceVoucherByUsername(String userName);

    /**
     * 根据企业ID获取服务券信息
     *
     * @param uuid
     * @return
     */
    TResult<ServiceVoucherDto> getByCompanyInfoId(UUID uuid);


    /**
     * 根据ServiceVoucherNo获取服务券信息
     *
     * @param voucherNo
     * @return
     */
    TResult<ServiceVoucherDto> getByNo(String voucherNo);

    PagedResult<VoucherWithCorpInfoDto> getVoucherByProvider(UUID providerId, ServiceVoucherCretiria cretiria);

    /**
     * 根据ID获取服务券信息
     *
     * @param uuid
     * @return
     */
    TResult<ServiceVoucherWithProductDto> getVoucherWithProductById(UUID uuid);

    /**
     * 获取所有服务券列表
     *
     * @return
     */
    List<ServiceVoucherDto> getServiceVoucherList();

    /**
     * 查询服务券
     *
     * @param cretiria
     * @return
     */
    PagedResult<VoucherWithCorpInfoDto> queryServiceVoucherPaged(ServiceVoucherCretiria cretiria);

    /**
     * 根据服务券id查询服务记录
     *
     * @param serviceVoucherId
     * @return
     */
    List<VoucherServiceDetailDto> queryVoucherServiceDetails(UUID serviceVoucherId);


    /**
     * 服务券统计
     *
     * @param cretiria
     * @return
     */
    Map<VoucherStatus, Integer> voucherStatistics(ServiceVoucherCretiria cretiria);

}
