package com.sunesoft.titan.voucher.application.service.impl;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderEngineerDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderProductDto;
import com.sunesoft.titan.voucher.application.service.CompanyService;
import com.sunesoft.titan.voucher.application.service.ProviderService;
import com.sunesoft.titan.voucher.application.service.ServiceVoucherService;
import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by jzj on 2017/11/24.
 */
public class ProviderServiceImplTest extends TitanTestBase {

    @Autowired
    CompanyService companyService;

    @Autowired
    ProviderService providerService;

    @Test
    public void addOrUpdateProvider() throws Exception {
        ProviderDto providerDto=new ProviderDto();
//        providerDto.setId(UUID.fromString("53e112df-255b-4b98-881e-e510ff21ae9f"));
        providerDto.setpNo("yy");
        providerDto.setCorpName("yy");
        providerDto.setSortName("y");
        TResult<ProviderDto> providerDtoTResult = providerService.addOrUpdateProvider(providerDto);
        System.out.println(JSON.toJSONString(providerDtoTResult));
    }

    @Test
    public void addOrUpdateProviderProduct() throws Exception {
        ProviderProductDto providerProductDto=new ProviderProductDto();
//        providerProductDto.setId(UUID.fromString("c76049f6-ab4c-436c-80e7-97e8fc70b6dc"));
        providerProductDto.setProviderId(UUID.fromString("6788e2be-1aed-4672-a58d-33d73e9234ca"));
        providerProductDto.setProductName("gg");
//        TResult<ProviderDto> providerDtoTResult = providerService.addOrUpdateProviderProduct(providerProductDto);
//        System.out.println(JSON.toJSONString(providerDtoTResult));
    }

    @Test
    public void addOrUpdateProviderEngineer() throws Exception {
        ProviderEngineerDto providerEngineerDto=new ProviderEngineerDto();
//        providerEngineerDto.setId(UUID.fromString("420d1fb1-88c2-4ef0-90f8-21c511c00664"));
        providerEngineerDto.setProviderId(UUID.fromString("6788e2be-1aed-4672-a58d-33d73e9234ca"));
        providerEngineerDto.setEngineerNo("08");
        providerEngineerDto.setEngineerName("oo");
        TResult<ProviderDto> providerDtoTResult = providerService.addOrUpdateProviderEngineer(providerEngineerDto);
        System.out.println(JSON.toJSONString(providerDtoTResult));
    }

    @Test
    public void deleteProvider() throws Exception {
        TResult tResult = providerService.deleteProvider(UUID.fromString("6788e2be-1aed-4672-a58d-33d73e9234ca"));
        System.out.println(JSON.toJSONString(tResult));
    }

    @Test
    public void removeProduct() throws Exception {
        TResult tResult = providerService.removeProduct(UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0"), UUID.fromString("0edf017e-3527-4517-8282-31d00c6c21fb"));
        System.out.println(JSON.toJSONString(tResult));
    }

    @Test
    public void removeEngineer() throws Exception {
        TResult tResult = providerService.removeEngineer(UUID.fromString("6788e2be-1aed-4672-a58d-33d73e9234ca"), UUID.fromString("3262c628-f55c-473c-900d-530212dc3090"));
        System.out.println(JSON.toJSONString(tResult));
    }

}