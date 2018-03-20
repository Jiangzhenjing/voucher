package com.sunesoft.titan.voucher.application.service;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.CompanyCretirias;
import com.sunesoft.titan.voucher.application.dtos.CompanyInfoDto;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/23
 */
public interface CompanyService {


    /**
     * 新增修改企业信息
     *
     * @param dto
     * @return
     */
    TResult addOrUpdateCompany(CompanyInfoDto dto);


    /**
     * 删除公司
     *
     * @param uuid id
     * @return
     */
    TResult deleteCompany(UUID uuid);



    /**
     * 删除公司
     *
     * @param uuid id
     * @return
     */
    TResult deleteCompany(String name);


}
