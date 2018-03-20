package com.sunesoft.titan.voucher.application.querys;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.EvaluateCretirias;
import com.sunesoft.titan.voucher.application.cretirias.ProviderProductCretiria;
import com.sunesoft.titan.voucher.application.cretirias.SalesStatisticCretirias;
import com.sunesoft.titan.voucher.application.cretirias.ServiceVoucherCretiria;
import com.sunesoft.titan.voucher.application.dtos.EvaluateLevelStatisticDto;
import com.sunesoft.titan.voucher.application.dtos.ProductStatisticDto;
import com.sunesoft.titan.voucher.application.dtos.SalesStatisticDto;
import com.sunesoft.titan.voucher.application.dtos.VoucherStatusStatisticDto;
import com.sunesoft.titan.voucher.domain.enums.ServiceLevel;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;

import java.util.List;
import java.util.Map;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
public interface StatisticQueryService {

    /**
     * 服务券统计
     *
     * @param cretiria
     * @return
     */
    List<VoucherStatusStatisticDto> voucherStatistics(ServiceVoucherCretiria cretiria);


    /**
     * 产品统计
     *
     * @param cretiria
     * @return
     */
    PagedResult<ProductStatisticDto> productStatistics(ProviderProductCretiria cretiria);


    /**
     * 销售统计
     *
     * @param cretiria
     * @return
     */
    PagedResult<SalesStatisticDto> salesStatistics(SalesStatisticCretirias cretiria);


    /**
     * 评价统计
     *
     * @param cretiria
     * @return
     */
    List<EvaluateLevelStatisticDto> serviceEvaluateStatistics(EvaluateCretirias cretiria);


    /**
     * 统计数量
     *
     * @param cretiria
     * @return
     */
    Map<String, Object> saleAmountStatistics(SalesStatisticCretirias cretiria);





    Map<String,Object> productAmountStatistics(ProviderProductCretiria cretiria);

}
