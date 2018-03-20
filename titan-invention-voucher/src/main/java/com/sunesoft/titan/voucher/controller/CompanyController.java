package com.sunesoft.titan.voucher.controller;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.user.Dtos.TitanUser;
import com.sunesoft.titan.voucher.application.dtos.CompanyInfoDto;
import com.sunesoft.titan.voucher.application.dtos.ServiceVoucherDto;
import com.sunesoft.titan.voucher.application.querys.CompanyQueryService;
import com.sunesoft.titan.voucher.application.querys.ServiceVoucherQueryService;
import com.sunesoft.titan.voucher.application.service.CompanyService;
import com.sunesoft.titan.voucher.application.service.SysAuthService;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;
import com.sunesoft.titan.voucher.helper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/voucher/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyQueryService companyQueryService;

    @Autowired
    private SysAuthService sysAuthService;

    @Autowired
    private ServiceVoucherQueryService serviceVoucherQueryService;

    /**
     *
     * @return
     */
    @RequestMapping("")

    @RequiresRoles(value = {"Company"})
    public String home () {
        TitanUser userInfo = UserContext.getUser();

        TResult<CompanyInfoDto> companyInfoDtoTResult = companyQueryService.getByUserId(userInfo.getId());

        // 如果是首次维护信息
        if( companyInfoDtoTResult.getResult() == null ){
            return "redirect:/voucher/company/profile";
        }

        TResult<ServiceVoucherDto> serviceVoucherDtoTResult = serviceVoucherQueryService.getByCompanyInfoId(companyInfoDtoTResult.getResult().getId());

        // 如果信息已维护，则等待
        ServiceVoucherDto serviceVoucherDto = serviceVoucherDtoTResult.getResult();
        if (serviceVoucherDto == null ) {
            //return "redirect:/voucher/company/profile";
            return "/voucher/company/waiting";
        }

        VoucherStatus voucherStatus = serviceVoucherDtoTResult.getResult().getVoucherStatus();
        if (voucherStatus == VoucherStatus.WaitActive) {
            // 激活
            return "forward:/voucher/active";
        } else if (voucherStatus == VoucherStatus.Actived) {
            // 选择产品
            return "forward:/voucher/products/search";
        } else {
            // 查看服务进度
            return "forward:/voucher/info/" + serviceVoucherDto.getId();
        }
    }

    /**
     * 完善信息
     */
    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile_view (Model model, @RequestParam(required = false) UUID id,
                                @ModelAttribute("msg") String msg
    ) {
        TResult<CompanyInfoDto> companyInfo;
        if (id != null && helper.isAdmin()) {
            model.addAttribute("isAdmin", "true");
            model.addAttribute("id", id);
            companyInfo = companyQueryService.getById(id);
            TResult<ServiceVoucherDto> serviceVoucherByUsername = serviceVoucherQueryService.getByCompanyInfoId(id);
            if (serviceVoucherByUsername.getResult()!=null) {
                model.addAttribute("voucherNo", serviceVoucherByUsername.getResult().getVoucherNo());
            }

        } else {
            String userName = UserContext.getUser().getUser_name();
            companyInfo = companyQueryService.getByPhone(userName);
            TResult<ServiceVoucherDto> serviceVoucherByUsername = serviceVoucherQueryService.getServiceVoucherByUsername(userName);
            if (serviceVoucherByUsername.getResult() != null) {
                return "redirect:/voucher/company";
            }
        }

        model.addAttribute("companyInfo", companyInfo.getResult());
        model.addAttribute("msg", msg);
        return "voucher/company/setting/profile";
    }

    @RequestMapping(value = "profile", method = RequestMethod.POST)
    public String profile (CompanyInfoDto companyInfoDto, RedirectAttributes attributes) {

        if(helper.isProvider()) {
            return "redirect:/";
        }

        companyInfoDto.setPhoneNo(UserContext.getUser().getUser_name());
        TResult result = companyService.addOrUpdateCompany(companyInfoDto);

        if (result.getIs_success()) {
            return "redirect:/voucher/company";
        }

        attributes.addFlashAttribute("msg", result.getMessage());
        return "redirect:/voucher/company/profile";
    }
}
