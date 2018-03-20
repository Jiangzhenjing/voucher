package com.sunesoft.titan.voucher.controller.admin;

import com.sunesoft.titan.common.result.IResult;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.voucher.application.cretirias.CompanyCretirias;
import com.sunesoft.titan.voucher.application.dtos.CompanyInfoDto;
import com.sunesoft.titan.voucher.application.dtos.ServiceVoucherDto;
import com.sunesoft.titan.voucher.application.querys.CompanyQueryService;
import com.sunesoft.titan.voucher.application.service.CompanyService;
import com.sunesoft.titan.voucher.application.service.ServiceVoucherService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

/**
 * 分发优惠券
 */
@Controller
@RequestMapping("voucher/admin/company")
public class CompanyAdminController {

    @Autowired
    private CompanyQueryService companyQueryService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ServiceVoucherService serviceVoucherService;

    /**
     * 企业列表
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String list() {
        return "voucher/admin/company/list";
    }

    /**
     * 获取企业列表数据
     * @param companyCretirias 查询条件
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public PagedResult<CompanyInfoDto> getListResult (CompanyCretirias companyCretirias) {
        companyCretirias.setIsHandVoucher(false);
        return companyQueryService.getCompanyInfoPaged(companyCretirias);
    }

    /**
     * 新增服务券
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String relate_view (@PathVariable UUID id, Model model) {
        model.addAttribute("id", id);
        return "voucher/admin/company/form";
    }

//     /**
//     * 新增服务券
//     */
//    @RequestMapping(value = "{id}", method = RequestMethod.POST)
//    public String relate (@RequestParam String voucherno, @PathVariable UUID id, RedirectAttributes attributes) {
//
//    }

    /**
     * 删除企业
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public TResult delete (@PathVariable UUID id) {
        return companyService.deleteCompany(id);
    }

    /**
     * 修改企业信息与信息服务券
     * @param id
     * @param companyInfoDto
     * @param voucherno
     * @param attributes
     * @return
     */
    @RequestMapping(value="relate/{id}", method = RequestMethod.POST)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String changeUserInfo (@PathVariable UUID id, CompanyInfoDto companyInfoDto, String voucherno, RedirectAttributes attributes) {
        // companyInfoDto.setPhoneNo(UserContext.getUser().getUser_name());
        TResult result = companyService.addOrUpdateCompany(companyInfoDto);
        if (!result.getIs_success()) {
            attributes.addFlashAttribute("msg", result.getMessage());
            return "redirect:/voucher/company/profile?id=" + id;
        }
        if(!StringUtil.isEmpty(voucherno)) {
            IResult<ServiceVoucherDto> result1 = serviceVoucherService.addOrUpdateVoucher(voucherno, id);
            if (result1.getIs_success()) {
                if (result1.getResult() == null || result1.getResult().getId() == null) {
                    attributes.addFlashAttribute("msg", result1.getMessage());
                    return "redirect:/voucher/search";
                }
                return "redirect:/voucher/info/" + result1.getResult().getId();
            } else {
                attributes.addFlashAttribute("msg", result1.getMessage());
                return "redirect:/voucher/company/profile?id=" + id;
            }
        }
        return "redirect:/voucher/company/profile?id=" + id;
    }

}
