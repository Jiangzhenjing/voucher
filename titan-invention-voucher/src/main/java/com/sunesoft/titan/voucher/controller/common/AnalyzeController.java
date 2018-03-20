package com.sunesoft.titan.voucher.controller.common;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.voucher.application.cretirias.EvaluateCretirias;
import com.sunesoft.titan.voucher.application.cretirias.ProviderProductCretiria;
import com.sunesoft.titan.voucher.application.cretirias.SalesStatisticCretirias;
import com.sunesoft.titan.voucher.application.cretirias.ServiceVoucherCretiria;
import com.sunesoft.titan.voucher.application.dtos.*;
import com.sunesoft.titan.voucher.application.querys.ProviderQueryService;
import com.sunesoft.titan.voucher.application.querys.StatisticQueryService;
import com.sunesoft.titan.voucher.helper;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * 统计分析
 */
@Controller
@RequestMapping("voucher/analyze")
public class AnalyzeController {

    @Autowired
    private ProviderQueryService providerQueryService;

    @Autowired
    private StatisticQueryService statisticQueryService;
    /**
     * 产品
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String product_view (Model model) {
        model.addAttribute("providerList", getProviderList());
        return "voucher/common/analyze/product";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public PagedResult<ProductStatisticDto> product (ProviderProductCretiria providerProductCretiria) {

        return statisticQueryService.productStatistics(providerProductCretiria);
    }

    /**
     * 销售
     */
    @RequestMapping(value = "sale", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin", "Provider"}, logical = Logical.OR)
    public String sale_view (Model model,
                             @RequestParam(required = false) String serviceLevel,
                             @RequestParam(required = false) UUID providerId,
                             @RequestParam(required = false) UUID regionId
                             ) {
        model.addAttribute("selectedRegion", regionId);
        model.addAttribute("selectedProviderId", providerId);
        model.addAttribute("serviceLevel", serviceLevel);

        model.addAttribute("providerList", getProviderList());

        if (helper.isProvider()) {
            model.addAttribute("isprovider", "true");
        }
        return "voucher/common/analyze/sale";
    }

    @RequestMapping(value = "sale", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin", "Provider"}, logical = Logical.OR)
    public PagedResult<SalesStatisticDto> sale (SalesStatisticCretirias salesStatisticCretirias,
                                                ServiceVoucherCretiria serviceVoucherCretiria
                                                ) {
        if (helper.isProvider()) {
            salesStatisticCretirias.setProviderUserId(UserContext.getUser().getId());
        }

        PagedResult<SalesStatisticDto> salesStatisticDtoPagedResult = statisticQueryService.salesStatistics(salesStatisticCretirias);

        return salesStatisticDtoPagedResult;
    }

    /**
     * 服务券统计
     */
    @RequestMapping(value = "voucher", method = RequestMethod.GET)
    public String voucher_view (Model model) {
        model.addAttribute("providerList", getProviderList());

        if (helper.isProvider()) {
            model.addAttribute("isprovider", "true");
        }
        return "voucher/common/analyze/voucher";
    }

    @RequestMapping(value = "voucher", method = RequestMethod.POST)
    @ResponseBody
    public List<VoucherStatusStatisticDto>  voucher (ServiceVoucherCretiria cretiria) {
        if (helper.isEqualRole("Provider")) {
            cretiria.setProviderUserId(UserContext.getUser().getId());
        }

        return statisticQueryService.voucherStatistics(cretiria);
    }

    /**
     * 评价统计
     * @param model
     * @return
     */
    @RequestMapping(value = "comment", method = RequestMethod.GET)
    public String comment_view (Model model) {
        model.addAttribute("providerList", getProviderList());
        if (helper.isProvider()) {
            model.addAttribute("isprovider", "true");
        }
        return "voucher/common/analyze/comment";
    }

    @RequestMapping(value = "comment", method = RequestMethod.POST)
    @ResponseBody
    public List<EvaluateLevelStatisticDto> comment (EvaluateCretirias evaluateCretirias) {

        if (helper.isProvider()) {
            evaluateCretirias.setProviderUserId(UserContext.getUser().getId());
        }
        return statisticQueryService.serviceEvaluateStatistics(evaluateCretirias);
    }

    private List<ProviderDto> getProviderList () {
        return providerQueryService.getProviderList();
    }
}
