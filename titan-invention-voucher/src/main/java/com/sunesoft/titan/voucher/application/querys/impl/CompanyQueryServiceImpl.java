package com.sunesoft.titan.voucher.application.querys.impl;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.sqlBuilderTool.OrderType;
import com.sunesoft.titan.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.titan.common.sqlBuilderTool.SqlBulder;
import com.sunesoft.titan.hibernate.repository.GenericHibernateFinder;
import com.sunesoft.titan.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.titan.voucher.application.cretirias.CompanyCretirias;
import com.sunesoft.titan.voucher.application.dtos.CompanyInfoDto;
import com.sunesoft.titan.voucher.application.querys.CompanyQueryService;
import com.sunesoft.titan.voucher.domain.CompanyInfo;
import com.sunesoft.titan.voucher.domain.ProviderProduct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/23
 */
@Service
@SuppressWarnings("all")
public class CompanyQueryServiceImpl extends GenericHibernateFinder implements CompanyQueryService {
    /**
     * 根据ID 获取企业信息
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult<CompanyInfoDto> getById(UUID uuid) {
        HSqlBuilder builder = new HSqlBuilder();
        builder.from(CompanyInfo.class, "c")
                .where("id", uuid)
                .orderBy("c.create_datetime", OrderType.DESC)
                .select(CompanyInfoDto.class);
        CompanyInfoDto companyInfoDto = this.queryForObjectFirst(CompanyInfoDto.class, builder.getQuerySql(), builder.getParams());
        return new TResult<>(companyInfoDto);
    }

    /**
     * 根据联系电话/账号 获取企业信息
     *
     * @param phone
     * @return
     */
    @Override
    public TResult<CompanyInfoDto> getByPhone(String phone) {
        HSqlBuilder builder = new HSqlBuilder();
        builder.from(CompanyInfo.class, "c")
                .where("phoneNo", phone)
                .orderBy("c.create_datetime", OrderType.DESC)
                .select(CompanyInfoDto.class);
        CompanyInfoDto companyInfoDto = this.queryForObjectFirst(CompanyInfoDto.class, builder.getQuerySql(), builder.getParams());
        return new TResult<>(companyInfoDto);
    }
    /**
     * 根据用户id获取企业信息
     *
     * @param phone
     * @return
     */
    @Override
    public TResult<CompanyInfoDto> getByUserId(UUID userId) {
        HSqlBuilder builder = new HSqlBuilder();
        builder.from(CompanyInfo.class, "c").where("userId", userId).select(CompanyInfoDto.class);
        CompanyInfoDto companyInfoDto = this.queryForObjectFirst(CompanyInfoDto.class, builder.getQuerySql(), builder.getParams());
        return new TResult<>(companyInfoDto);
    }
    /**
     * 公司信息查询
     *
     * @param companyCretirias
     * @return
     */
    @Override
    public PagedResult<CompanyInfoDto> getCompanyInfoPaged(CompanyCretirias companyCretirias) {
        SqlBuilder builder = new HSqlBuilder();
        builder = builder.from(CompanyInfo.class, "c")
                .where(companyCretirias.getParams())
                .orderBy("c.create_datetime", OrderType.DESC)
                .select(CompanyInfoDto.class);
        return pagingBySql(companyCretirias.getPageIndex(), companyCretirias.getPageSize(), CompanyInfoDto.class, builder.getQuerySql(), builder.getParams());
    }
}
