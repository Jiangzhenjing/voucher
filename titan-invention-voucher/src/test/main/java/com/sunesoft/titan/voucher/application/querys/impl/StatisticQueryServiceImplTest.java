package com.sunesoft.titan.voucher.application.querys.impl;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.voucher.application.cretirias.SalesStatisticCretirias;
import com.sunesoft.titan.voucher.application.dtos.SalesStatisticDto;
import com.sunesoft.titan.voucher.application.querys.StatisticQueryService;
import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import com.sunesoft.titan.voucher.domain.enums.ServiceLevel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by jzj on 2017/11/29.
 */
public class StatisticQueryServiceImplTest extends TitanTestBase {

    @Autowired
    StatisticQueryService statisticQueryService;
    @Test
    public void voucherStatistics() throws Exception {
    }

    @Test
    public void productStatistics() throws Exception {
    }

    @Test
    public void salesStatistics() throws Exception {
    }

    @Test
    public void serviceEvaluateStatistics() throws Exception {
        SalesStatisticCretirias salesStatisticCretirias = new SalesStatisticCretirias();
        salesStatisticCretirias.setServiceLevel(ServiceLevel.B);
        PagedResult<SalesStatisticDto> salesStatisticDtoPagedResult = statisticQueryService.salesStatistics(salesStatisticCretirias);
        System.out.println(JSON.toJSONString(salesStatisticDtoPagedResult));
    }

}