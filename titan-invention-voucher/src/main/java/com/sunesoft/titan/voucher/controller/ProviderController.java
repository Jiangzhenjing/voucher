package com.sunesoft.titan.voucher.controller;


import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderEngineerDto;
import com.sunesoft.titan.voucher.application.querys.ProviderQueryService;
import com.sunesoft.titan.voucher.application.service.ProviderService;
import com.sunesoft.titan.voucher.helper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("voucher/provider")
public class ProviderController {

    @Autowired
    private ProviderQueryService providerQueryService;

    @Autowired
    private ProviderService providerService;

    /**
     * 服务券
     * @return
     */
    @RequestMapping("")
    @RequiresRoles(value = {"Provider"})
    public String index () {
        return "forward:/voucher/search";
    }

    /**
     * 服务商简介
     * @return
     */
    @RequestMapping("voucher")
    @RequiresRoles(value = {"Provider"})
    public String product_search () {

        return "forward:/voucher/providers/profile?id=" + helper.getUserId();
    }

//    /**
//     * 服务券查看页面
//     * @return
//     */
//    @RequestMapping("voucher")
//    public String index () {
//        return "forward:/voucher/list";
//    }
//


    /**
     * 工程师列表
     */
    @RequestMapping(value = "engineer", method = RequestMethod.GET)
    @RequiresRoles(value = {"Provider"})
    public String search_view (@RequestParam(required = false) UUID id){
        return "voucher/provider/engineer/list";
    }

    @RequestMapping(value="engineer", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Provider"})
    public List<ProviderEngineerDto> search () {
        UUID id = helper.getUserId();
        return providerQueryService.getEngineersByProviderId(id);
    }

    /**
     * 工程师新增
     */
    @RequestMapping(value = "engineer/add", method = RequestMethod.GET)
    @RequiresRoles(value = {"Provider"})
    public void add_view(@RequestParam(required = false) UUID id, Model model) {
        if (id !=null ) {
            TResult<ProviderEngineerDto> engineerDtoTResult = providerQueryService.getEngineerById(id);
            model.addAttribute("engineerDto", engineerDtoTResult.getResult());
        }
    }

    @RequestMapping(value = "engineer/add", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Provider"})
    public TResult<ProviderDto> add (ProviderEngineerDto engineerDto) {
       engineerDto.setProviderId(helper.getUserId());
       return providerService.addOrUpdateProviderEngineer(engineerDto);
    }

    /**
     * 工程师删除
     * @param id
     * @return
     */
    @RequestMapping(value = "engineer/del", method = RequestMethod.POST)
    @ResponseBody
    @RequiresRoles(value = {"Provider"})
    public TResult del (UUID id) {

        return providerService.removeEngineer(helper.getUserId(), id);
    }

    /**
     * 统计分析
     * @return
     */
    @RequestMapping("analyze")
    @RequiresRoles(value = {"Provider"})
    public String analyze () {
        return "forward:/voucher/analyze/voucher";
    }

    /**
     * 评分统计
     * @return
     */
    @RequestMapping("analyze/comment")
    @RequiresRoles(value = {"Provider"})
    public String analyze_comment () {
        return "forward:/voucher/analyze/comment";
    }
}
