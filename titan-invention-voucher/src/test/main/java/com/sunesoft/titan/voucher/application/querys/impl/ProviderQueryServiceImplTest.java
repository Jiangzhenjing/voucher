package com.sunesoft.titan.voucher.application.querys.impl;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.ProviderCretiria;
import com.sunesoft.titan.voucher.application.cretirias.ProviderProductCretiria;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderEngineerDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderProductDto;
import com.sunesoft.titan.voucher.application.querys.ProviderQueryService;
import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by jzj on 2017/11/24.
 */
public class ProviderQueryServiceImplTest extends TitanTestBase {

    @Autowired
    ProviderQueryService providerQueryService;

    @Test
    public void getById() throws Exception {
        TResult<ProviderDto> byId = providerQueryService.getById(UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0"));
        System.out.println(JSON.toJSONString(byId));
    }

    @Test
    public void getProviderList() throws Exception {
        List<ProviderDto> providerList = providerQueryService.getProviderList();
        System.out.println(JSON.toJSONString(providerList));
    }

    @Test
    public void getEngineersByProviderId() throws Exception {
        List<ProviderEngineerDto> engineersByProviderId = providerQueryService.getEngineersByProviderId(UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0"));
        System.out.println(JSON.toJSONString(engineersByProviderId));
    }


    @Test
    public void queryProductById() throws Exception {
        TResult<ProviderProductDto> providerProductDtoTResult = providerQueryService.queryProductById(UUID.fromString("fa4a6e1f-549d-457c-be82-f244c2a0ba85"));
        System.out.println(JSON.toJSONString(providerProductDtoTResult));
    }

    @Test
    public void getEngineerById() throws Exception {
        TResult<ProviderEngineerDto> engineerById = providerQueryService.getEngineerById(UUID.fromString("7343df55-d04d-4a8d-a3e6-29117ca7d53b"));
        System.out.println(JSON.toJSONString(engineerById));
    }

    @Test
    public void getEngineerByUserId() throws Exception {
        TResult<ProviderEngineerDto> engineerById = providerQueryService.getEngineerByUserId(UUID.fromString("7b2e05131-b51f-4f67-99a8-607436fe5106"));
        System.out.println(JSON.toJSONString(engineerById));
    }

    @Test
    public void queryProviderPaged() throws Exception {
        ProviderCretiria providerCretiria = new ProviderCretiria();
//        providerCretiria.setId(UUID.fromString(""));
//        providerCretiria.setpNo("c");
        providerCretiria.setCorpName("d");
//        providerCretiria.setYear(1999);
        PagedResult<ProviderDto> providerDtoPagedResult = providerQueryService.queryProviderPaged(providerCretiria);
        System.out.println(JSON.toJSONString(providerDtoPagedResult));
    }

    @Test
    public void queryProductsByProviderId() throws Exception {
        List<ProviderProductDto> providerProductDtos = providerQueryService.queryProductsByProviderId(UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0"));
        System.out.println(JSON.toJSONString(providerProductDtos));
    }

    @Test
    public void queryProducts() throws Exception {
        ProviderProductCretiria providerProductCretiria = new ProviderProductCretiria();
        providerProductCretiria.setProductName("dd");
        List<ProviderProductDto> providerProductDtos = providerQueryService.queryProducts(providerProductCretiria);
        System.out.println(JSON.toJSONString(providerProductDtos));
    }

    /**
     * 产品类型查询
     *
     * @throws Exception
     */
    @Test
    public void queryProductsType() throws Exception {
        List<String> strings = providerQueryService.queryProductsType();
        System.out.println(JSON.toJSONString(strings));
    }


}