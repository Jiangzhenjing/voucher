package com.sunesoft.titan.voucher.application.querys;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.EvaluateCretirias;
import com.sunesoft.titan.voucher.application.cretirias.ProviderProductCretiria;
import com.sunesoft.titan.voucher.application.cretirias.SalesStatisticCretirias;
import com.sunesoft.titan.voucher.application.cretirias.ServiceVoucherCretiria;
import com.sunesoft.titan.voucher.application.dtos.ProductStatisticDto;
import com.sunesoft.titan.voucher.application.dtos.SalesStatisticDto;
import com.sunesoft.titan.voucher.application.service.CompanyService;
import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author: Zhouzh
 * @Date: 2017/11/24
 */
public class CompanyQueryServiceTest  extends TitanTestBase {

    @Autowired
    StatisticQueryService statisticQueryService;

    @Test
    public void query(){


        List r = statisticQueryService.serviceEvaluateStatistics(new EvaluateCretirias());
        System.out.println(JSON.toJSONString(r));



    }



    @Test
    public void query2(){

        SalesStatisticCretirias serviceVoucherCretiria = new SalesStatisticCretirias();
//        serviceVoucherCretiria.setRegion("1234ddddd");
        Object r= statisticQueryService.salesStatistics(serviceVoucherCretiria);
        System.out.println(JSON.toJSONString(r));



    }

}