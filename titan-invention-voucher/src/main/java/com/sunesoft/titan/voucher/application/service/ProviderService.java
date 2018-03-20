package com.sunesoft.titan.voucher.application.service;

import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderEngineerDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderProductDto;
import com.sunesoft.titan.voucher.domain.Provider;

import java.util.UUID;

/**
 * @author: Zhouzh
 * 服务商
 * @Date: 2017/11/20
 */
public interface ProviderService {

       /**
     * 新增修改服务商信息
     * @param dto
     * @return
     */
    TResult<ProviderDto> addOrUpdateProvider(ProviderDto dto);

    /**
     * 新增
     * @param dto
     * @return
     */
    TResult<ProviderDto> addOrUpdateProviderProductAdmin(UUID providerId,ProviderProductDto dto);


    /**
     * 新增ByuserId
     * @param dto
     * @return
     */
    TResult<ProviderDto> addOrUpdateProviderProductByUserId(UUID userId,ProviderProductDto dto);


    /**
     * 新增ByProvider
     * @param dto
     * @return
     */
    TResult<ProviderDto> addOrUpdateProviderProductByProvider(Provider provider, ProviderProductDto dto);


    /**
     * 新增修改工程师
     * @param dto
     * @return
     */
    TResult<ProviderDto> addOrUpdateProviderEngineer(ProviderEngineerDto dto);

    /**
     * 删除服务商信息
     * @param id
     * @return
     */
    TResult deleteProvider(UUID id);



    /**
     * 删除产品
     * @param providerId
     * @param productId
     * @return
     */
    TResult removeProduct(UUID providerId,UUID productId);




    /**
     * 删除工程师
     * @param providerId
     * @param engginerId
     * @return
     */
    TResult removeEngineer(UUID providerId,UUID engginerId);




}
