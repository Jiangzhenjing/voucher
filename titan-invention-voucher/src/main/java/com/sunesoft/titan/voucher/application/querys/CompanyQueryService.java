package com.sunesoft.titan.voucher.application.querys;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.CompanyCretirias;
import com.sunesoft.titan.voucher.application.dtos.CompanyInfoDto;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/23
 */
public interface CompanyQueryService {


    /**
     * 根据ID 获取企业信息
     * @param uuid
     * @return
     */
    TResult<CompanyInfoDto> getById(UUID uuid);

    /**
     * 根据联系电话/账号 获取企业信息
     * @param phone
     * @return
     */
    TResult<CompanyInfoDto> getByPhone(String phone);

    /**
     * 根据用户ID 获取企业信息
     * @param userId
     * @return
     */
    TResult<CompanyInfoDto> getByUserId(UUID userId);

    /**
     * 公司信息查询
     * @param companyCretirias
     * @return
     */
    PagedResult<CompanyInfoDto> getCompanyInfoPaged(CompanyCretirias companyCretirias);











}
