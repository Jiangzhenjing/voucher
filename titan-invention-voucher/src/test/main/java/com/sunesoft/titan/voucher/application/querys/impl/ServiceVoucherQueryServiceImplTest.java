package com.sunesoft.titan.voucher.application.querys.impl;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.ServiceVoucherCretiria;
import com.sunesoft.titan.voucher.application.dtos.ServiceVoucherDto;
import com.sunesoft.titan.voucher.application.dtos.ServiceVoucherWithProductDto;
import com.sunesoft.titan.voucher.application.querys.ServiceVoucherQueryService;
import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by jzj on 2017/11/24.
 */
public class ServiceVoucherQueryServiceImplTest extends TitanTestBase {

    @Autowired
    ServiceVoucherQueryService serviceVoucherQueryService;

    @Test
    public void getById() throws Exception {
        TResult<ServiceVoucherDto> byCompanyInfoId = serviceVoucherQueryService.getById(UUID.fromString("64152fa0-28e8-4cff-82a8-69fb693690c4"));
        System.out.println(JSON.toJSONString(byCompanyInfoId));

    }


    @Test
    public void getServiceVoucherByUsername() throws Exception {
        TResult<ServiceVoucherDto> serviceVoucherByUsername = serviceVoucherQueryService.getServiceVoucherByUsername("888");
        System.out.println(JSON.toJSONString(serviceVoucherByUsername));

    }

    @Test
    public void getByCompanyInfoId() throws Exception {
        TResult<ServiceVoucherDto> byCompanyInfoId = serviceVoucherQueryService.getByCompanyInfoId(UUID.fromString("a50b451f-a3cb-4073-b940-264a24af8892"));
        System.out.println(JSON.toJSONString(byCompanyInfoId));
    }

    /**
     * 根据ServiceVoucherNo获取服务券信息
     */
    @Test
    public void getByNo() throws Exception {
        TResult<ServiceVoucherDto> byNo = serviceVoucherQueryService.getByNo("1700008");
        System.out.println(JSON.toJSONString(byNo));
    }

    /**
     * 根据服务商获取服务券信息
     */
    @Test
    public void getVoucherByProvider() throws Exception {
//        PagedResult<ServiceVoucherDto> voucherByProvider = serviceVoucherQueryService.getVoucherByProvider(UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0"), new ServiceVoucherCretiria());
//        System.out.println(JSON.toJSONString(voucherByProvider));
    }

    /**
     * 根据ID获取服务券信息
     */
    @Test
    public void getVoucherWithProductById() throws Exception {
        TResult<ServiceVoucherWithProductDto> voucherWithProductById = serviceVoucherQueryService.getVoucherWithProductById(UUID.fromString("64152fa0-28e8-4cff-82a8-69fb693690c4"));
        System.out.println(JSON.toJSONString(voucherWithProductById));
    }

    @Test
    public void getServiceVoucherList() throws Exception {
        List<ServiceVoucherDto> serviceVoucherList = serviceVoucherQueryService.getServiceVoucherList();
        System.out.println(JSON.toJSONString(serviceVoucherList));
    }

    @Test
    public void queryServiceVoucherPaged() throws Exception {
        ServiceVoucherCretiria serviceVoucherCretiria = new ServiceVoucherCretiria();
//        serviceVoucherCretiria.setCorpName("");
//        serviceVoucherCretiria.setIsCallBack(false);
//        serviceVoucherCretiria.setCorpName("");
//        serviceVoucherCretiria.setCorpName("");
//        serviceVoucherCretiria.setCorpName("");
//        PagedResult<ServiceVoucherDto> serviceVoucherDtoPagedResult = serviceVoucherQueryService.queryServiceVoucherPaged(serviceVoucherCretiria);
//        System.out.println(JSON.toJSONString(serviceVoucherDtoPagedResult));
    }

    /**
     * 根据服务券id查询服务记录
     */
    @Test
    public void queryVoucherServiceDetails() throws Exception {
        TResult<ServiceVoucherWithProductDto> voucherWithProductById = serviceVoucherQueryService.getVoucherWithProductById(UUID.fromString("53a2068b-0fe2-47c1-94f8-4305f9cfc961"));
        System.out.println(JSON.toJSONString(voucherWithProductById));
    }

    @Test
    public void voucherStatistics() throws Exception {
    }

}