package com.sunesoft.titan.voucher.application.querys.impl;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.result.resultFactory.ResultFactory;
import com.sunesoft.titan.common.sqlBuilderTool.OrderType;
import com.sunesoft.titan.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.titan.common.utils.ConvertUtil;
import com.sunesoft.titan.hibernate.repository.GenericHibernateFinder;
import com.sunesoft.titan.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.titan.voucher.application.cretirias.ServiceVoucherCretiria;
import com.sunesoft.titan.voucher.application.dtos.*;
import com.sunesoft.titan.voucher.application.querys.ServiceVoucherQueryService;
import com.sunesoft.titan.voucher.domain.*;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jzj on 2017/11/21.
 */
@Service
@SuppressWarnings("unchecked")
public class ServiceVoucherQueryServiceImpl extends GenericHibernateFinder implements ServiceVoucherQueryService {


    /**
     * 根据ID获取服务券信息
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult<ServiceVoucherDto> getById(UUID uuid) {
        SqlBuilder builder = new HSqlBuilder();
        builder = builder.from(ServiceVoucher.class, "v")
                .join(CompanyInfo.class, "c")
                .on("v.company_id=c.id")
                .where("id", uuid)
                .orderBy("v.create_datetime", OrderType.DESC)
                .select(ServiceVoucherDto.class);
        ServiceVoucherDto serviceVoucherDto = this.queryForObjectFirst(ServiceVoucherDto.class, builder.getQuerySql(), builder.getParams());
        return (TResult<ServiceVoucherDto>) ResultFactory.success(serviceVoucherDto);
    }


    /**
     * 根据username获取服务券信息 就是phoneNo
     *
     * @param userName
     * @return
     */
    @Override
    public TResult<ServiceVoucherDto> getServiceVoucherByUsername(String userName) {
        SqlBuilder builder = new HSqlBuilder();
        builder = builder.from(ServiceVoucher.class, "v")
                .join(CompanyInfo.class, "c")
                .on("v.company_id=c.id")
                .where("c.phoneNo", userName)
                .orderBy("v.create_datetime", OrderType.DESC)
                .select(ServiceVoucherDto.class);
        ServiceVoucherDto serviceVoucherDto = this.queryForObjectFirst(ServiceVoucherDto.class, builder.getQuerySql(), builder.getParams());
        return (TResult<ServiceVoucherDto>) ResultFactory.success(serviceVoucherDto);
    }


    /**
     * 根据企业ID获取服务券信息
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult<ServiceVoucherDto> getByCompanyInfoId(UUID uuid) {
        SqlBuilder builder = new HSqlBuilder();
        builder = builder.from(ServiceVoucher.class, "v")
                .join(CompanyInfo.class, "c")
                .on("v.company_id=c.id")
                .where("v.company_id", uuid.toString())
                .orderBy("v.create_datetime", OrderType.DESC)
                .select(ServiceVoucherDto.class);
        ServiceVoucherDto serviceVoucherDto = this.queryForObjectFirst(ServiceVoucherDto.class, builder.getQuerySql(), builder.getParams());
        return (TResult<ServiceVoucherDto>) ResultFactory.success(serviceVoucherDto);
    }


    /**
     * 根据provider用户id获取优惠券信息
     *
     * @param userId   用户ID
     * @param cretiria
     * @return
     */
    public PagedResult<VoucherWithCorpInfoDto> getVoucherByProvider(UUID userId, ServiceVoucherCretiria cretiria) {
        SqlBuilder<VoucherWithCorpInfoDto> builder = HSqlBuilder.hFrom(ServiceVoucher.class, "v")
                .join(CompanyInfo.class, "c")
                .on("v.company_id=c.id")
                .join(ProviderProduct.class, "p").on("v.product_id=p.id")
                .join(Provider.class, "pr").on("pr.id=p.provider_id")
                .where(cretiria.getParams())
                .and("pr.id", userId)
                .setFieldValue("region", "c.region")
                .setFieldValue("providerName", "pr.corpName")
                .orderBy("v.create_datetime", OrderType.DESC)

                .select(VoucherWithCorpInfoDto.class)
                .setFieldValue("userId", "pr.userId")
                .pagging(cretiria.getPageIndex(), cretiria.getPageSize());
        return this.queryBySqlPaged(builder);

    }

    /**
     * 根据ServiceVoucherNo获取服务券信息
     *
     * @param voucherNo
     * @return
     */
    @Override
    public TResult<ServiceVoucherDto> getByNo(String voucherNo) {
        SqlBuilder<ServiceVoucherDto> builder = HSqlBuilder.hFrom(ServiceVoucher.class, "v").join(CompanyInfo.class, "c")
                .on("v.company_id=c.id")
                .where("voucherNo", voucherNo)
                .orderBy("v.create_datetime", OrderType.DESC)
                .select(ServiceVoucherDto.class);
        ServiceVoucherDto serviceVoucherDto = this.queryForObjectFirst(builder);
        return (TResult<ServiceVoucherDto>) ResultFactory.success(serviceVoucherDto);
    }

    /**
     * 根据ID获取服务券和产品信息
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult<ServiceVoucherWithProductDto> getVoucherWithProductById(UUID uuid) {
        String hql = "from ServiceVoucher s where s.id= :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", uuid);
        hql = hql + " order by create_datetime";
        Query query = this.createQuery(hql, params);
        List<ServiceVoucher> list = query.list();
        if (list.size() > 0) {
            ServiceVoucher voucher = list.get(0);
            ServiceVoucherWithProductDto dto = ConvertUtil.convert(voucher, ServiceVoucherWithProductDto.class);
            if (voucher.getCompanyInfo() != null) {
                dto.setCompanyInfoDto(ConvertUtil.convert(voucher.getCompanyInfo(), CompanyInfoDto.class));
            }
            if (voucher.getProviderProduct() != null) {
                dto.setProviderProductDto(ConvertUtil.convert(voucher.getProviderProduct(), ProviderProductDto.class));
                if (voucher.getProviderProduct().getProvider() != null) {
                    dto.setProviderDto(ConvertUtil.convert(voucher.getProviderProduct().getProvider(), ProviderDto.class));
                }
            }
            if (voucher.getVoucherServiceDetailList() != null && voucher.getVoucherServiceDetailList().size() > 0) {
                dto.setVoucherServiceDetailDtos(ConvertUtil.convert(voucher.getVoucherServiceDetailList(), VoucherServiceDetailDto.class));
            }
            return new TResult<>(dto);
        }
        return (TResult) ResultFactory.error("数据异常");
    }

    /**
     * 获取所有服务券列表
     *
     * @return
     */
    @Override
    public List<ServiceVoucherDto> getServiceVoucherList() {
        SqlBuilder<ServiceVoucherDto> builder = HSqlBuilder.hFrom(ServiceVoucher.class, "v")
                .join(CompanyInfo.class, "c")
                .on("v.company_id=c.id")
                .orderBy("v.create_datetime", OrderType.DESC)
                .select(ServiceVoucherDto.class);
        return this.queryForObjects(builder);
    }

    /**
     * 查询服务券
     *
     * @param cretiria
     * @return
     */
    @Override
    public PagedResult<VoucherWithCorpInfoDto> queryServiceVoucherPaged(ServiceVoucherCretiria cretiria) {
        SqlBuilder<VoucherWithCorpInfoDto> builder = HSqlBuilder.hFrom(ServiceVoucher.class, "v")
                .join(CompanyInfo.class, "c")
                .on("v.company_id=c.id")
                .leftJoin(ProviderProduct.class, "p").on("p.id = v.product_id")
                .leftJoin(Provider.class, "pr").on("pr.id= p.provider_id")
                .setFieldValue("region", "c.region")
                .setFieldValue("providerName", "pr.corpName")
                .where(cretiria.getParams())
                .select(VoucherWithCorpInfoDto.class)
                .orderBy("v.create_datetime", OrderType.DESC)
                .pagging(cretiria.getPageIndex(), cretiria.getPageSize());
        return this.queryBySqlPaged(builder);
    }

    /**
        * 根据服务券id查询服务记录
     *
             * @param serviceVoucherId
     * @return
             */
    @Override
    public List<VoucherServiceDetailDto> queryVoucherServiceDetails(UUID serviceVoucherId) {
        SqlBuilder<VoucherServiceDetailDto> builder = HSqlBuilder.hFrom(VoucherServiceDetail.class, "d")
                .join(ServiceVoucher.class, "v")
                .on("d.voucher_id=d.id")
                .where("id", serviceVoucherId)
                .orderBy("v.create_datetime", OrderType.DESC)
                .select(ServiceVoucherDto.class);
        return this.queryForObjects(builder);
    }

    /**
     * 服务券统计
     *
     * @param cretiria
     * @return
     */
    @Override
    public Map<VoucherStatus, Integer> voucherStatistics(ServiceVoucherCretiria cretiria) {
        return null;
    }
}
