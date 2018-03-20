package com.sunesoft.titan.voucher.controller.common;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.ProviderCretiria;
import com.sunesoft.titan.voucher.application.cretirias.ProviderProductCretiria;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderProductDto;
import com.sunesoft.titan.voucher.application.dtos.ServiceVoucherDto;
import com.sunesoft.titan.voucher.application.querys.ProviderQueryService;
import com.sunesoft.titan.voucher.application.querys.ServiceVoucherQueryService;
import com.sunesoft.titan.voucher.application.service.ProviderService;
import com.sunesoft.titan.voucher.application.service.ServiceVoucherService;
import com.sunesoft.titan.voucher.helper;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 服务商 - 产品
 */
@Controller
@RequestMapping("voucher")
public class ProviderProductController {

    @Autowired
    private ProviderQueryService providerQueryService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ServiceVoucherService serviceVoucherService;

    @Autowired
    private ServiceVoucherQueryService serviceVoucherQueryService;

    /**
     * 服务商查询
     * @return
     */
    @RequestMapping(value = "providers", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String search_view () {
        return "voucher/common/provider/list";
    }

    @RequestMapping(value = "providers", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public PagedResult<ProviderDto> search (ProviderCretiria providerCretiria) {
        return providerQueryService.queryProviderPaged(providerCretiria);
    }

    /**
     * 添加或修改服务商
     * @return
     */
    @RequestMapping(value="providers/add", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String add_provider_view (@RequestParam(required = false) UUID id, Model model) {
        if (id != null) {
            TResult<ProviderDto> providerDto = providerQueryService.getById(id);
            model.addAttribute("providerDto", providerDto.getResult());
        }
        return "voucher/common/provider/form";
    }

    @RequestMapping(value="providers/add", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public TResult<ProviderDto> add_provider (ProviderDto ProviderDto) {
        return providerService.addOrUpdateProvider(ProviderDto);
    }

    /**
     * 删除服务商
     * @param id
     * @return
     */
    @RequestMapping(value="providers/del", method =RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public TResult del_provider (UUID id) {
        return providerService.deleteProvider(id);
    }

    /**
     * 产品维护页面 (管理员、服务商页面)
     * @param id 企业id
     * @param model
     * @return
     */
    @RequestMapping(value = "providers/profile", method = RequestMethod.GET)
    public String provider_view (@RequestParam UUID id,
                            Model model) {
        TResult<ProviderDto> providerDto = providerQueryService.getById(id);
        model.addAttribute("providerDto", providerDto.getResult());

        if (helper.isProvider()) {
            model.addAttribute("type", "provider");
        }
        model.addAttribute("id", id);

        return "voucher/common/provider/info";
    }

    /**
     * 根据企业id获取产品列表
     * @param id 企业id
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
    @ResponseBody
    public List<ProviderProductDto> products (@PathVariable UUID id) {
        return providerQueryService.queryProductsByProviderId(id);
    }

    /**
     * 新增产品
     * @param id 产品id
     * @param pid 服务商id
     * @param model
     * @return
     */
    @RequestMapping(value="/products/add", method = RequestMethod.GET)
    public String productsAdd_view (@RequestParam(required = false) UUID id, @RequestParam(required = false) UUID pid, Model model) {
        if (id != null) {
            TResult<ProviderProductDto> productDtoTResult = providerQueryService.queryProductById(id);
            model.addAttribute("productDto", productDtoTResult.getResult());
        }

        model.addAttribute("pid", pid);
        return "voucher/common/product/create";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    @ResponseBody
    public TResult<ProviderDto> productAdd (ProviderProductDto dto) {
       return providerService.addOrUpdateProviderProductAdmin(dto.getProviderId(), dto);
    }

    /**
     * 产品删除
     * @param id
     * @return
     */
    @RequestMapping(value="/product/del", method = RequestMethod.POST)
    @ResponseBody
    public TResult productDel (UUID id, @RequestParam UUID pid) {
        return providerService.removeProduct(pid, id);
    }

    /**
     * 查询产品(企业)
     */
    @RequestMapping(value = "/products/search", method = RequestMethod.GET)
    @RequiresRoles(value = {"Company"})
    public String prodSearch_view (ProviderProductCretiria providerProductCretiria, Model model) {
        List<ProviderProductDto> productDtos = providerQueryService.queryProducts(providerProductCretiria);

        model.addAttribute("productDtos", productDtos);
        model.addAttribute("searchDto", providerProductCretiria);

        TResult<ServiceVoucherDto> serviceVoucherByUsername = serviceVoucherQueryService.getServiceVoucherByUsername(UserContext.getUserName());
        model.addAttribute("date", serviceVoucherByUsername.getResult().getExpiryDate());
        return "voucher/common/product/list_page";
    }

    /**
     * 授权产品 (企业)
     */
    @RequestMapping(value = "/product/auth", method = RequestMethod.GET)
    @RequiresRoles(value = {"Company"})
    public String auth_view () {
        return "voucher/common/product/auth";
    }

    @RequestMapping(value = "/product/auth", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Company"})
    public void auth (@RequestParam UUID providerId, @RequestParam UUID productId) {

        String userName = helper.getUsername();
        serviceVoucherService.chooseProduct(userName, providerId, productId);
    }

    /**
     * 确认服务券
     * @param pid
     * @return
     */
    @RequestMapping(value="product/confirm", method = RequestMethod.POST)
    @ResponseBody
    public TResult product_confirm (@RequestParam UUID pid) {
        return serviceVoucherService.voucherConfirm(UserContext.getUser().getId(), pid, "");
    }

}
