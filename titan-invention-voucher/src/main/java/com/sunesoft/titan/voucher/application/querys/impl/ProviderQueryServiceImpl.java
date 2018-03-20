package com.sunesoft.titan.voucher.application.querys.impl;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.sqlBuilderTool.OrderType;
import com.sunesoft.titan.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.titan.common.utils.ConvertUtil;
import com.sunesoft.titan.hibernate.repository.GenericHibernateFinder;
import com.sunesoft.titan.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.titan.voucher.application.cretirias.ProviderCretiria;
import com.sunesoft.titan.voucher.application.cretirias.ProviderProductCretiria;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderEngineerDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderProductDto;
import com.sunesoft.titan.voucher.application.querys.ProviderQueryService;
import com.sunesoft.titan.voucher.domain.Provider;
import com.sunesoft.titan.voucher.domain.ProviderEngineer;
import com.sunesoft.titan.voucher.domain.ProviderProduct;
import com.sunesoft.titan.voucher.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jzj on 2017/11/21.
 */
@Service
@SuppressWarnings("all")
public class ProviderQueryServiceImpl extends GenericHibernateFinder implements ProviderQueryService {

    @Autowired
    ProviderRepository providerRepository;

    /**
     * 根据ID获取服务商信息
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult<ProviderDto> getById(UUID uuid) {
        HSqlBuilder builder = new HSqlBuilder();
        builder.from(Provider.class, "p").where("id", uuid)
                .setFieldValue("password", "''")
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderDto.class);
        ProviderDto providerDto = this.queryForObjectFirst(ProviderDto.class, builder.getQuerySql(), builder.getParams());
        return new TResult<>(providerDto);
    }

    /**
     * 根据userID获取服务商信息
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult<ProviderDto> getByUserId(UUID uuid) {
        HSqlBuilder builder = new HSqlBuilder();
        builder.from(Provider.class, "p").where("userId", uuid)
                .setFieldValue("password", "''")
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderDto.class);
        ProviderDto providerDto = this.queryForObjectFirst(ProviderDto.class, builder.getQuerySql(), builder.getParams());
        return new TResult<>(providerDto);
    }

    /**
     * 获取所有服务商列表
     *
     * @return
     */
    @Override
    public List<ProviderDto> getProviderList() {
        HSqlBuilder hSqlBuilder = new HSqlBuilder();
        SqlBuilder query = hSqlBuilder.from(Provider.class, "p")
                .setFieldValue("password", "''")
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderDto.class);
        List<ProviderDto> list = this.queryForObjects(ProviderDto.class, query.getQuerySql(), hSqlBuilder.getParams());
        return list;
    }

    /**
     * 获取工程师列表
     *
     * @param id
     * @return
     */
    @Override
    public List<ProviderEngineerDto> getEngineersByProviderId(UUID id) {
        SqlBuilder hSqlBuilder = new HSqlBuilder();
        hSqlBuilder.from(ProviderEngineer.class, "p")
                .join(Provider.class, "v")
                .on("p.provider_id = v.id")
                .where("p.provider_id", id.toString())
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderEngineerDto.class);
        List<ProviderEngineerDto> list = this.queryForObjects(hSqlBuilder);
        return list;
    }

    /**
     * 根据ID获取工程师
     * @param id
     * @return
     */
    @Override
    public TResult<ProviderEngineerDto> getEngineerById(UUID id) {
        HSqlBuilder hSqlBuilder = new HSqlBuilder();
        hSqlBuilder.from(ProviderEngineer.class, "p")
                .join(Provider.class, "v")
                .on("p.provider_id = v.id")
                .where("p.id", id)
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderEngineerDto.class);
        ProviderEngineerDto providerEngineerDto = this.queryForObjectFirst(ProviderEngineerDto.class, hSqlBuilder.getQuerySql(), hSqlBuilder.getParams());
        return new TResult<>(providerEngineerDto);
    }


    /**
     * 根据UserID获取工程师
     * @param id
     * @return
     */
    @Override
    public TResult<ProviderEngineerDto> getEngineerByUserId(UUID id) {
        HSqlBuilder hSqlBuilder = new HSqlBuilder();
        hSqlBuilder.from(ProviderEngineer.class, "p")
                .join(Provider.class, "v")
                .on("p.provider_id = v.id")
                .where("v.userId", id)
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderEngineerDto.class);
        ProviderEngineerDto providerEngineerDto = this.queryForObjectFirst(ProviderEngineerDto.class, hSqlBuilder.getQuerySql(), hSqlBuilder.getParams());
        return new TResult<>(providerEngineerDto);
    }

    /**
     * 查询服务商
     *
     * @param cretiria
     * @return
     */
    @Override
    public PagedResult<ProviderDto> queryProviderPaged(ProviderCretiria cretiria) {
        HSqlBuilder hSqlBuilder = new HSqlBuilder();
        SqlBuilder query = hSqlBuilder.from(Provider.class, "p")
                .where(cretiria.getParams())
                .setFieldValue("password", "''")
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderDto.class)
                .pagging(cretiria.getPageIndex(), cretiria.getPageSize());
        PagedResult<ProviderDto> providerDtoPagedResult = this.queryBySqlPaged(hSqlBuilder);
        return providerDtoPagedResult;
    }

    /**
     * 查询服务商下所有产品
     *
     * @param uuid
     * @return
     */
    @Override
    public List<ProviderProductDto> queryProductsByProviderId(UUID uuid) {
        SqlBuilder hSqlBuilder = new HSqlBuilder();
        hSqlBuilder.from(ProviderProduct.class, "p")
                .join(Provider.class, "v")
                .on("p.provider_id = v.id")
                .where("p.provider_id", uuid.toString())
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderProductDto.class);
        List<ProviderProductDto> list = this.queryForObjects(hSqlBuilder);
        return list;
    }


    /**
     * 根据userID查询服务商下所有产品
     *
     * @param uuid
     * @return
     */
    @Override
    public List<ProviderProductDto> queryProductsByProviderUserId(UUID uuid) {
        SqlBuilder hSqlBuilder = new HSqlBuilder();
        hSqlBuilder.from(ProviderProduct.class, "p")
                .join(Provider.class, "v")
                .on("p.provider_id = v.id")
                .where("v.userId", uuid.toString())
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderProductDto.class);
        List<ProviderProductDto> list = this.queryForObjects(hSqlBuilder);
        return list;
    }

    /**
     * 查询单个产品
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult<ProviderProductDto> queryProductById(UUID uuid) {
        HSqlBuilder builder = new HSqlBuilder();
        builder.from(ProviderProduct.class, "p")
                .join(Provider.class, "v")
                .on("p.provider_id = v.id")
                .where("p.id", uuid)
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderProductDto.class);
        ProviderProductDto providerProductDto = this.queryForObjectFirst(ProviderProductDto.class, builder.getQuerySql(), builder.getParams());
        return new TResult<>(providerProductDto);
    }

    /**
     * 产品查询
     *
     * @param providerProductCretiria
     * @return
     */
    @Override
    public List<ProviderProductDto> queryProducts(ProviderProductCretiria providerProductCretiria) {
        HSqlBuilder hSqlBuilder = new HSqlBuilder();
        SqlBuilder query = hSqlBuilder.from(ProviderProduct.class, "p")
                .join(Provider.class, "v")
                .on("p.provider_id = v.id")
                .where(providerProductCretiria.getParams())
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderProductDto.class)
                .pagging(providerProductCretiria.getPageIndex(), providerProductCretiria.getPageSize());
        List<ProviderProductDto> list = this.queryForObjects(hSqlBuilder);
        return list;
    }


    /**
     * 产品所有类型查询
     */
    @Override
    public List<String> queryProductsType() {
        List<String> result = new ArrayList<>();
        SqlBuilder hSqlBuilder = new HSqlBuilder();
        hSqlBuilder.from(ProviderProduct.class, "p")
                .join(Provider.class, "v")
                .on("p.provider_id = v.id")
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(ProviderProductDto.class);
        List<ProviderProductDto> list = this.queryForObjects(hSqlBuilder);
        for (ProviderProductDto providerProductDto : list) {
            result.add(providerProductDto.getProductType());
        }
        return result;
    }
}
