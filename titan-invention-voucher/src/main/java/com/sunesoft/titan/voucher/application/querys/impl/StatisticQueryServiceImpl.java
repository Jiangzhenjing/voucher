package com.sunesoft.titan.voucher.application.querys.impl;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.sqlBuilderTool.GroupByMath;
import com.sunesoft.titan.common.sqlBuilderTool.GroupMath;
import com.sunesoft.titan.common.sqlBuilderTool.OrderType;
import com.sunesoft.titan.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.titan.hibernate.repository.GenericHibernateFinder;
import com.sunesoft.titan.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.titan.voucher.application.cretirias.EvaluateCretirias;
import com.sunesoft.titan.voucher.application.cretirias.ProviderProductCretiria;
import com.sunesoft.titan.voucher.application.cretirias.SalesStatisticCretirias;
import com.sunesoft.titan.voucher.application.cretirias.ServiceVoucherCretiria;
import com.sunesoft.titan.voucher.application.dtos.EvaluateLevelStatisticDto;
import com.sunesoft.titan.voucher.application.dtos.ProductStatisticDto;
import com.sunesoft.titan.voucher.application.dtos.SalesStatisticDto;
import com.sunesoft.titan.voucher.application.dtos.VoucherStatusStatisticDto;
import com.sunesoft.titan.voucher.application.querys.StatisticQueryService;
import com.sunesoft.titan.voucher.domain.CompanyInfo;
import com.sunesoft.titan.voucher.domain.Provider;
import com.sunesoft.titan.voucher.domain.ProviderProduct;
import com.sunesoft.titan.voucher.domain.ServiceVoucher;
import com.sunesoft.titan.voucher.domain.enums.ServiceLevel;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Zhouzh
 * @Date: 2017/11/26
 */
@Service
@SuppressWarnings("all")
public class StatisticQueryServiceImpl extends GenericHibernateFinder implements StatisticQueryService {
    /**
     * 服务券统计
     *
     * @param cretiria
     * @return
     */
    @Override
    public List<VoucherStatusStatisticDto> voucherStatistics(ServiceVoucherCretiria cretiria) {

        SqlBuilder<VoucherStatusStatisticDto> builder = HSqlBuilder.hFrom(ServiceVoucher.class,"s")
                .join(CompanyInfo.class,"c").on("c.id = s.company_id")
                .leftJoin(ProviderProduct.class,"p").on("s.product_id=p.id")
                .leftJoin(Provider.class,"pr").on("p.provider_id = pr.id")
                .groupByMathField("count",GroupByMath.Count())
                .where(cretiria.getParams())
                .orderBy("p.create_datetime", OrderType.DESC)
                .select(VoucherStatusStatisticDto.class);
        return this.queryForObjects(builder);


    }

    /**
     * 产品统计
     *
     * @param cretiria
     * @return
     */
    @Override
    public PagedResult<ProductStatisticDto> productStatistics(ProviderProductCretiria cretiria) {

        SqlBuilder builder = HSqlBuilder.hFrom(ProviderProduct.class,"p")
                .join(Provider.class,"pr").on("p.provider_id = pr.id")
                .join(ServiceVoucher.class,"s").on("s.product_id=p.id")
                .join(CompanyInfo.class,"c").on("c.id = s.company_id")
                .groupByMathField("salesCount",GroupByMath.Count())
                .groupByMathField("salesAmount",GroupByMath.Sum("discountPrice"))
                .groupByMathField("companyPayAmount",GroupByMath.Sum("discountPrice-amount"))
                .groupByMathField("avgScore",GroupByMath.Avg("totalScore"))
                .where(cretiria.getParams())
                .orderBy("p.create_datetime", OrderType.DESC)
                .pagging(cretiria.getPageIndex(),cretiria.getPageSize())
                .select(ProductStatisticDto.class);
        PagedResult pagedResult = this.queryBySqlPaged(builder);
        pagedResult.setUserData(this.productAmountStatistics(cretiria));
        return pagedResult;
    }

    /**
     * 销售统计
     *
     * @param cretiria
     * @return
     */
    @Override
    public PagedResult<SalesStatisticDto> salesStatistics(SalesStatisticCretirias cretiria) {
        SqlBuilder builder = HSqlBuilder.hFrom(ProviderProduct.class,"p")
                .join(Provider.class,"pr").on("p.provider_id = pr.id")
                .join(ServiceVoucher.class,"s").on("s.product_id=p.id")
                .join(CompanyInfo.class,"c").on("c.id = s.company_id")
                .groupByMathField("salesCount", GroupByMath.Count())
                .groupByMathField("salesAmount",GroupByMath.Sum("discountPrice"))
                .setFieldValue("corpType","c.corpType")
                .where(cretiria.getParams())
                .pagging(cretiria.getPageIndex(),cretiria.getPageSize())
                .select(SalesStatisticDto.class);
        PagedResult pagedResult = this.queryBySqlPaged(builder);
        pagedResult.setUserData(saleAmountStatistics(cretiria));
        return pagedResult;
    }

    /**
     * 评价统计
     *
     * @param cretiria
     * @return
     */
    @Override
    public List<EvaluateLevelStatisticDto> serviceEvaluateStatistics(EvaluateCretirias cretiria) {
        SqlBuilder<EvaluateLevelStatisticDto> builder = HSqlBuilder.hFrom(ProviderProduct.class,"p")
                .join(Provider.class,"pr").on("p.provider_id = pr.id")
                .join(ServiceVoucher.class,"s").on("s.product_id=p.id")
                .join(CompanyInfo.class,"c").on("c.id = s.company_id")
                .groupByMathField("count",GroupByMath.Count())
                .where(cretiria.getParams())
                .and(" s.serviceLevel is not null ")
                .select(EvaluateLevelStatisticDto.class);
       return  this.queryForObjects(builder);

    }


    /**
     * 统计数量
     *
     * @param cretiria
     * @return
     */
    @Override
    public Map<String,Object> saleAmountStatistics(SalesStatisticCretirias cretiria) {

        SqlBuilder builder = HSqlBuilder.hFrom(ProviderProduct.class,"p")
                .join(Provider.class,"pr").on("p.provider_id = pr.id")
                .join(ServiceVoucher.class,"s").on("s.product_id=p.id")
                .join(CompanyInfo.class,"c").on("c.id = s.company_id")
                .where(cretiria.getParams())
                .selectField(GroupByMath.Sum("p.discountPrice"),"saleAmount")
                .selectField(GroupByMath.Sum("p.discountPrice-s.amount"),"selfSumAmount")
                .selectField(GroupByMath.Count(),"counts");
        List<Map<String, Object>> maps = this.queryAsMap(builder);
        if(maps.size()>0){
            return   maps.get(0);
        }
        return null;


    }

    /**
     * 统计数量
     *
     * @param cretiria
     * @return
     */
    @Override
    public Map<String,Object> productAmountStatistics(ProviderProductCretiria cretiria) {

        SqlBuilder builder = HSqlBuilder.hFrom(ProviderProduct.class,"p")
                .join(Provider.class,"pr").on("p.provider_id = pr.id")
                .join(ServiceVoucher.class,"s").on("s.product_id=p.id")
                .join(CompanyInfo.class,"c").on("c.id = s.company_id")
                .where(cretiria.getParams())
                .selectField(GroupByMath.Sum("p.discountPrice"),"saleAmount")
                .selectField(GroupByMath.Sum("p.discountPrice-s.amount"),"selfSumAmount")
                .selectField(GroupByMath.Count(),"counts");
        List<Map<String, Object>> maps = this.queryAsMap(builder);
        if(maps.size()>0){
            return   maps.get(0);
        }
        return null;


    }
}
