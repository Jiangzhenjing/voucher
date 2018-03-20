package com.sunesoft.titan.voucher.application.querys.impl;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.CompanyCretirias;
import com.sunesoft.titan.voucher.application.cretirias.SVUserCretirias;
import com.sunesoft.titan.voucher.application.dtos.CompanyInfoDto;
import com.sunesoft.titan.voucher.application.querys.CompanyQueryService;
import com.sunesoft.titan.voucher.application.service.SysAuthService;
import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Created by jzj on 2017/11/24.
 */
public class CompanyQueryServiceImplTest extends TitanTestBase {

    @Autowired
    CompanyQueryService companyQueryService;


    @Autowired
    SysAuthService sysAuthService;

    @Test
    public void getById() throws Exception {
        TResult<CompanyInfoDto> byId = companyQueryService.getById(UUID.fromString("89091d88-b683-4975-bfad-429147e9fbdd"));
        System.out.println(JSON.toJSONString(byId));

    }

    @Test
    public void getByPhone() throws Exception {
        TResult<CompanyInfoDto> byPhone = companyQueryService.getByPhone("1111");
        System.out.println(JSON.toJSONString(byPhone));
        PagedResult svUser = sysAuthService.getSvUser(new SVUserCretirias());
        System.out.println(JSON.toJSONString(svUser));
    }

    @Test
    public void getCompanyInfoPaged() throws Exception {
        CompanyCretirias companyCretirias=new CompanyCretirias();
        companyCretirias.setCompanyName("aa");
//        companyCretirias.setPhone("");
//        companyCretirias.setRegion("");
        PagedResult<CompanyInfoDto> companyInfoPaged = companyQueryService.getCompanyInfoPaged(companyCretirias);
        System.out.println(JSON.toJSONString(companyInfoPaged));
    }

}