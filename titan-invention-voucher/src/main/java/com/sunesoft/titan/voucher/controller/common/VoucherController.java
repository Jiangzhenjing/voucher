package com.sunesoft.titan.voucher.controller.common;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.office.excel.ExpotExcel;
import com.sunesoft.titan.office.word.WordPlaceHolder;
import com.sunesoft.titan.office.word.wdWord;
import com.sunesoft.titan.voucher.application.cretirias.ServiceVoucherCretiria;
import com.sunesoft.titan.voucher.application.dtos.*;
import com.sunesoft.titan.voucher.application.querys.ProviderQueryService;
import com.sunesoft.titan.voucher.application.querys.ServiceVoucherQueryService;
import com.sunesoft.titan.voucher.application.service.ServiceVoucherService;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;
import com.sunesoft.titan.voucher.helper;
import com.sunesoft.titan.voucher.module.exportVoucherModel;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 服务券页面
 */
@Controller
@RequestMapping("voucher")
public class VoucherController {

    @Autowired
    private ServiceVoucherService serviceVoucherService;

    @Autowired
    private ServiceVoucherQueryService serviceVoucherQueryService;

    @Autowired
    private ProviderQueryService providerQueryService;

    /**
     * 服务券列表页面，(只有管理员可以操作)
     *
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search_view(Model model,
                              @RequestParam(required = false) UUID regionId,
                              @RequestParam(required = false) String voucherStatus,
                              @RequestParam(required = false) UUID providerId
    ) {
        if (helper.isProvider()) {
            model.addAttribute("type", "provider");
        }

        model.addAttribute("selectedRegion", regionId);
        model.addAttribute("selectedProviderId", providerId);
        model.addAttribute("voucherStatus", voucherStatus);

        List<ProviderDto> providerList = providerQueryService.getProviderList();
        model.addAttribute("providerList", providerList);
        return "voucher/common/voucher/list";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public PagedResult<VoucherWithCorpInfoDto> search(ServiceVoucherCretiria serviceVoucherCretiria) {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);

        if (helper.isProvider()) {
            return serviceVoucherQueryService.getVoucherByProvider(helper.getUserId(), serviceVoucherCretiria);
        }
        return serviceVoucherQueryService.queryServiceVoucherPaged(serviceVoucherCretiria);
    }


    /**
     * 服务券列表导出
     */
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public void downLoadVoucher(HttpServletResponse response, ServiceVoucherCretiria cretiria) {
        cretiria.setPageIndex(1);
        cretiria.setPageSize(100000);
        PagedResult<VoucherWithCorpInfoDto> voucherByProvider;
        if (helper.isProvider()) {
            voucherByProvider = serviceVoucherQueryService.getVoucherByProvider(helper.getUserId(), cretiria);
        } else {
            voucherByProvider = serviceVoucherQueryService.queryServiceVoucherPaged(cretiria);
        }
        List<VoucherWithCorpInfoDto> result = voucherByProvider.getResult();
        List<exportVoucherModel> list = new ArrayList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (VoucherWithCorpInfoDto voucherWithCorpInfoDto : result) {
            exportVoucherModel model = new exportVoucherModel();
            model.setVoucherNo(voucherWithCorpInfoDto.getVoucherNo());
            model.setCompanyName(voucherWithCorpInfoDto.getCompanyName());
            model.setContacts(voucherWithCorpInfoDto.getContacts());
            model.setPhoneNo(voucherWithCorpInfoDto.getPhoneNo());
            model.setRegion(voucherWithCorpInfoDto.getRegion());
            VoucherStatus voucherStatus = voucherWithCorpInfoDto.getVoucherStatus();
            switch(voucherStatus)
            {
                case Actived:model.setVoucherStatus("已激活");  break;
                case WaitActive:model.setVoucherStatus("待激活");  break;
                case WaitConfirm:model.setVoucherStatus("待购买确认");  break;
                case Confirmed:model.setVoucherStatus("已确认");  break;
                case HandOver:model.setVoucherStatus("已交付");  break;
                case Expired:model.setVoucherStatus("已过期");  break;
            }
            model.setIssuingDate(df.format(voucherWithCorpInfoDto.getIssuingDate()));
            list.add(model);
        }
        ExpotExcel<exportVoucherModel> expotExcel = new ExpotExcel<>();
        String[] header = new String[]{"服务券号", "公司名称", "联系人", "联系电话", "区域", "状态", "发券时间"};
        expotExcel.doExportExcel("服务券列表", header, list, "yyyy-MM-dd", response);
    }

    /**
     * 服务券详情页面
     *
     * @return
     */
    @RequestMapping("/info/{id}")
    public String info(@PathVariable UUID id, Model model) {
        TResult<ServiceVoucherWithProductDto> serviceVoucherDtoTResult = serviceVoucherQueryService.getVoucherWithProductById(id);
        ServiceVoucherWithProductDto serviceVoucherWithProductDto = serviceVoucherDtoTResult.getResult();
        model.addAttribute("companyDto", serviceVoucherWithProductDto.getCompanyInfoDto());
        model.addAttribute("productDto", serviceVoucherWithProductDto.getProviderProductDto());
        model.addAttribute("providerInfo", serviceVoucherWithProductDto.getProviderDto());
        model.addAttribute("voucherServices", serviceVoucherWithProductDto.getVoucherServiceDetailDtos());
        model.addAttribute("voucherInfo", serviceVoucherWithProductDto);
        if (serviceVoucherWithProductDto.getIssuingDate() != null) {
            model.addAttribute("issuingDate", serviceVoucherWithProductDto.getIssuingDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));

        }
        model.addAttribute("scored", serviceVoucherWithProductDto.getTotalScore() == null ? false : true);
        return "voucher/common/voucher/info";
    }

    /**
     * 服务券激活 (企业专用)
     *
     * @return
     */
    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public String active_view(@ModelAttribute("msg") String msg, Model model) {
        model.addAttribute("msg", msg);
        return "voucher/common/voucher/active";
    }

    @RequestMapping(value = "/active", method = RequestMethod.POST)
    public String active(ActiveVoucherDto activeVoucherDto, RedirectAttributes attributes) {
        TResult result = serviceVoucherService.activeVoucher(activeVoucherDto);
        if (result.getIs_success()) {
            return "redirect:/voucher/company";
        } else {
            attributes.addFlashAttribute("msg", result.getMessage());
            return "redirect:/voucher/company";
        }
    }

    @RequestMapping(value = "/info/{id}/print")
    public String print(@PathVariable UUID id, Model model) {
        TResult<ServiceVoucherWithProductDto> serviceVoucherDtoTResult = serviceVoucherQueryService.getVoucherWithProductById(id);
        ServiceVoucherWithProductDto serviceVoucherWithProductDto = serviceVoucherDtoTResult.getResult();

        model.addAttribute("now", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        model.addAttribute("companyDto", serviceVoucherWithProductDto.getCompanyInfoDto());
        model.addAttribute("productDto", serviceVoucherWithProductDto.getProviderProductDto());
        model.addAttribute("providerInfo", serviceVoucherWithProductDto.getProviderDto());
        model.addAttribute("voucherServices", serviceVoucherWithProductDto.getVoucherServiceDetailDtos());
        model.addAttribute("voucherInfo", serviceVoucherWithProductDto);
        return "voucher/common/voucher/print";
    }

    /**
     * 签订
     *
     * @return
     */
    @RequestMapping(value = "{id}/sign", method = RequestMethod.GET)
    public String sign_view(@PathVariable UUID id, Model model) {
        model.addAttribute("id", id);
        return "/voucher/common/voucher/sign";
    }

    @RequestMapping(value = "{id}/sign", method = RequestMethod.POST)
    @ResponseBody
    public TResult sign(@PathVariable UUID id, String time) {
        return serviceVoucherService.signContract(id, LocalDate.parse(time, DateTimeFormatter.ISO_DATE));
    }

    /**
     * 服务券  服务记录 (服务商)
     */
    @RequiresRoles(value = {"Provider"})
    @RequestMapping(value = "{id}/slogs", method = RequestMethod.GET)
    public String servicelog_view(@PathVariable UUID id, Model model) {
        model.addAttribute("id", id);
        List<ProviderEngineerDto> engineers = providerQueryService.getEngineersByProviderId(helper.getUserId());
        model.addAttribute("engineers", engineers);
        return "voucher/common/voucher/service";
    }

    @RequestMapping(value = "{id}/slogs", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Provider"})
    public TResult servicelog(VoucherServiceDetailDto dto, @PathVariable UUID id) {
        dto.setVoucherId(id);
        dto.setId(null);
        return serviceVoucherService.addVoucherServiceDetail(dto);
    }

    /**
     * 服务券 评价记录（企业）
     *
     * @return
     */
    @RequiresRoles(value = {"Company"})
    @RequestMapping(value = "{id}/comment", method = RequestMethod.GET)
    public String comment_view(Model model, @PathVariable UUID id) {
        model.addAttribute("id", id);
        return "voucher/common/voucher/comment";
    }

    @RequestMapping(value = "{id}/comment", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Company"})
    public TResult comment(VoucherScoreDto voucherScoreDto, @PathVariable UUID id) {
        voucherScoreDto.setId(id);
        return serviceVoucherService.evaluateVoucherProvider(voucherScoreDto);
    }

    /**
     * 服务券 完成（服务商）
     *
     * @return
     */
    @RequestMapping(value = "{id}/handle")
    @RequiresRoles(value = {"Provider"})
    public String handleOver_view(@PathVariable UUID id, Model model) {
        TResult<ServiceVoucherWithProductDto> serviceVoucherDtoTResult = serviceVoucherQueryService.getVoucherWithProductById(id);
        if (serviceVoucherDtoTResult.getResult() != null) {
            model.addAttribute("voucherInfo", serviceVoucherDtoTResult.getResult());
        }
        model.addAttribute("id", id);
        return "voucher/common/voucher/commit";
    }

    @RequestMapping(value = "{id}/handle", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Provider"})
    public TResult handleOver(HandOverDto handOverDto, @PathVariable UUID id) {
        handOverDto.setVoucherId(id);
        handOverDto.setProviderId(helper.getUserId());
        return serviceVoucherService.HandOverVoucher(handOverDto);
    }

    /**
     * 删除服务券
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public TResult delete(UUID id) {
        if (!helper.isAdmin()) {
            return helper.getErrorMsg();
        }
        return serviceVoucherService.deleteVoucher(id);
    }

    /**
     * 撤回服务券
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}/callback", method = RequestMethod.GET)
    @RequiresRoles(value = {"Company"})
    public String callBackVoucher_view(@PathVariable UUID id, Model model) {
        model.addAttribute("id", id);
        return "/voucher/common/voucher/callback";
    }

    @RequestMapping(value = "{id}/callback", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Company"})
    public TResult callBackVoucher(@PathVariable UUID id, String reason) {
        return serviceVoucherService.callBackVoucher(id, reason);
    }

    /**
     * 撤回查询
     *
     * @return
     */
    @RequestMapping(value = "callback/search", method = RequestMethod.GET)
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public String callback_search_view() {
        return "/voucher/common/voucher/callback_list";
    }

    @RequestMapping(value = "callback/search", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public PagedResult<VoucherWithCorpInfoDto> callback_search(ServiceVoucherCretiria serviceVoucherCretiria) {
        serviceVoucherCretiria.setIsCallBack(true);
        return serviceVoucherQueryService.queryServiceVoucherPaged(serviceVoucherCretiria);
    }

    /**
     * 确认撤回服务券
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}/callbackconfirm", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public TResult callBackConfirm(@PathVariable UUID id) {
        if (!helper.isAdmin()) {
            return helper.getErrorMsg();
        }
        return serviceVoucherService.callBackConfirm(id);
    }

    /**
     * 确认否决撤回服务券
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}/disablecallback", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Admin", "regionAdmin"}, logical = Logical.OR)
    public TResult disablecallback(@PathVariable UUID id) {
        if (!helper.isAdmin()) {
            return helper.getErrorMsg();
        }
        return serviceVoucherService.callBackRefuse(id);
    }


    @RequestMapping(value="/info/{id}/download")
    public void download (@PathVariable UUID id, Model model, HttpServletResponse response) {
        TResult<ServiceVoucherWithProductDto> serviceVoucherDtoTResult = serviceVoucherQueryService.getVoucherWithProductById(id);
        ServiceVoucherWithProductDto serviceVoucherWithProductDto = serviceVoucherDtoTResult.getResult();


        String docPath = VoucherController.class.getClassLoader().getResource("scoreTmpl.doc").getPath();//.substring(1).substring(1).replace("/", File.separator);
        if(docPath.indexOf(":")>0){
            docPath = docPath.substring(1);

        }
        WordPlaceHolder wph = getSameWordPlaceHolder(docPath,serviceVoucherWithProductDto);
        wdWord.exportServletWordByTemplate(wph, response, "南京市中小企业信息化服务券服务评价表.doc");

    }

    private WordPlaceHolder getSameWordPlaceHolder(String docPath,ServiceVoucherWithProductDto dto) {

        WordPlaceHolder holder = new WordPlaceHolder(docPath);

        holder.addTextHolder("productName",dto.getProviderProductDto().getProductName());
        holder.addTextHolder("companyName",dto.getCompanyInfoDto().getCompanyName());
        holder.addTextHolder("voucherNo",dto.getVoucherNo());
        holder.addTextHolder("providerName",dto.getProviderDto().getCorpName());
        holder.addTextHolder("serviceEngineers", StringUtil.isEmpty(dto.getServiceEngineers())?" ":dto.getServiceEngineers());
        holder.addTextHolder("signDate",dto.getSignDate()==null?" ":dto.getSignDate().format(DateTimeFormatter.ISO_DATE));
        holder.addTextHolder("handDate",dto.getHandDate()==null?" ":dto.getHandDate().format(DateTimeFormatter.ISO_DATE));
        holder.addTextHolder("sc01",dto.getSc01()==null?" ":dto.getSc01().toString());
        holder.addTextHolder("sc02",dto.getSc02()==null?" ":dto.getSc02().toString());
        holder.addTextHolder("sc03",dto.getSc03()==null?" ":dto.getSc03().toString());
        holder.addTextHolder("sc04",dto.getSc04()==null?" ":dto.getSc04().toString());
        holder.addTextHolder("sc05",dto.getSc05()==null?" ":dto.getSc05().toString());
        holder.addTextHolder("sc06",dto.getSc06()==null?" ":dto.getSc06().toString());
        holder.addTextHolder("sc07",dto.getSc07()==null?" ":dto.getSc07().toString());
        holder.addTextHolder("sc08",dto.getSc08()==null?" ":dto.getSc08().toString());
        holder.addTextHolder("totalScore",dto.getTotalScore()==null?" ":dto.getTotalScore().toString());

        holder.addTextHolder("evaluateContent",StringUtil.isEmpty(dto.getEvaluateContent())?" ":dto.getEvaluateContent());

        return holder;








    }

}
