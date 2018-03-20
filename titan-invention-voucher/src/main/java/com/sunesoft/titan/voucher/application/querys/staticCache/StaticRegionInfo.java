package com.sunesoft.titan.voucher.application.querys.staticCache;

import com.sunesoft.titan.common.result.ListResult;
import com.sunesoft.titan.systemManager.application.cretirias.OrgCretiria;
import com.sunesoft.titan.systemManager.application.dtos.OrgDto;
import com.sunesoft.titan.systemManager.application.service.SysOrganizationService;
import com.sunesoft.titan.systemManager.domain.Organization;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Zhouzh
 * @Date: 2017/11/25
 */

@Component
public class StaticRegionInfo implements InitializingBean {


    public static List<RegionInfo> regionInfos = new ArrayList<>();


    @Autowired
    SysOrganizationService organizationService;

    public static List<RegionInfo> getRegionInfos() {
        return regionInfos;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if(regionInfos.size()>0){
            return;
        }
        System.out.println("初始化regions");
        List<RegionInfo> regions = new ArrayList<>();
        ListResult<OrgDto> result = organizationService.queryOrg(new OrgCretiria());
        if (result.getResult() != null && result.getResult().size() > 0) {
            result.getResult().stream().forEach(x -> {
                RegionInfo regionInfo = new RegionInfo();
                regionInfo.setKey(x.getId().toString());
                regionInfo.setValue(x.getOrg_name());
                regions.add(regionInfo);
            });
            regionInfos = regions;
        }
    }
}
