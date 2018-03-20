package com.sunesoft.titan.voucher.application.service.impl;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.dtos.CompanyInfoDto;
import com.sunesoft.titan.voucher.application.service.CompanyService;
import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by jzj on 2017/11/24.
 */
public class CompanyServiceImplTest extends TitanTestBase {

    @Autowired
    CompanyService companyService;


    @Test
    public void addOrUpdateCompany() throws Exception {
        CompanyInfoDto companyInfoDto = new CompanyInfoDto();
//        companyInfoDto.setId(UUID.fromString("a50b451f-a3cb-4073-b940-264a24af8892"));
        companyInfoDto.setCreditCode("111");
        companyInfoDto.setCompanyName("11");
        companyInfoDto.setPhoneNo("111");
        TResult tResult = companyService.addOrUpdateCompany(companyInfoDto);
        System.out.println(JSON.toJSONString(tResult));
    }

    @Test
    public void deleteCompany() throws Exception {
        TResult tResult = companyService.deleteCompany(UUID.fromString("edf38227-ab28-46d1-a362-18322add6e19"));
        System.out.println(JSON.toJSONString(tResult));
    }



}