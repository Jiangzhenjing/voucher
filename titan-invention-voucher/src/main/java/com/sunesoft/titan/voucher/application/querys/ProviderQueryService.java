package com.sunesoft.titan.voucher.application.querys;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.ProviderCretiria;
import com.sunesoft.titan.voucher.application.cretirias.ProviderProductCretiria;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderEngineerDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderProductDto;

import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public interface ProviderQueryService {


    /**
     * 根据ID获取服务商信息
     *
     * @param uuid
     * @return
     */
    TResult<ProviderDto> getById(UUID uuid);


    /**
     * 根据UserID获取服务商信息
     *
     * @param uuid
     * @return
     */
    TResult<ProviderDto> getByUserId(UUID uuid);


    /**
     * 获取所有服务商列表
     *
     * @return
     */
    List<ProviderDto> getProviderList();


    /**
     * 获取工程师列表
     *
     * @param id
     * @return
     */
    List<ProviderEngineerDto> getEngineersByProviderId(UUID id);

    /**
     * 获取单个工程师
     *
     * @param id
     * @return
     */
    TResult<ProviderEngineerDto> getEngineerById(UUID id);

    /**
     * 获取单个工程师
     *
     * @param id
     * @return
     */
    TResult<ProviderEngineerDto> getEngineerByUserId(UUID id);

    /**
     * 查询服务商
     *
     * @param cretiria
     * @return
     */
    PagedResult<ProviderDto> queryProviderPaged(ProviderCretiria cretiria);


    /**
     * 查询服务商下所有产品
     *
     * @param uuid
     * @return
     */
    List<ProviderProductDto> queryProductsByProviderId(UUID uuid);


    /**
     * 根据UserID查询服务商下所有产品
     *
     * @param uuid
     * @return
     */
    List<ProviderProductDto> queryProductsByProviderUserId(UUID uuid);

    /**
     * 查询单个产品
     *
     * @param uuid
     * @return
     */
    TResult<ProviderProductDto> queryProductById(UUID uuid);


    /**
     * 产品查询
     *
     * @param providerProductCretiria
     * @return
     */
    List<ProviderProductDto> queryProducts(ProviderProductCretiria providerProductCretiria);


    /**
     * 产品类型查询
     *
     * @param
     * @return
     */
    List<String> queryProductsType();

}
