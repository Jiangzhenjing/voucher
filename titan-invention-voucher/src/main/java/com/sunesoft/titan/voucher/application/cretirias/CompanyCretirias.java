package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.cretiria.TCretiria;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;

import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/23
 */
public class CompanyCretirias extends TCretiria {

    private UUID userId;

    private String phone;

    private String companyName;

    private String region;

    /**
     * 是否发放服务券
     */
    private Boolean isHandVoucher = null;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public Boolean getIsHandVoucher() {
        return isHandVoucher;
    }

    public void setIsHandVoucher(Boolean handVoucher) {
        isHandVoucher = handVoucher;
    }

    @Override
    public Map<String, Object> getParams() {
        Map<String, Object> params = super.getParams();
        if (!StringUtil.isEmpty(phone)) {
            params.put("phoneNo", phone);
        }
        if (!StringUtil.isEmpty(companyName)) {
            params.put("companyName", "%" + companyName + "%");
        }
        if (!StringUtil.isEmpty(region)) {
            params.put("region", region);
        } else {
            if (UserContext.getUser().getRoleIds().get(0).equals(RoleType.regionAdmin.name())) {
                params.put("region", UserContext.getUser().getOrg_name());

            }
        }
        if (userId != null) {
            params.put("userId", userId);
        }
        if (isHandVoucher != null) {
            params.put("c.isHandVoucher", isHandVoucher);

        }
        return params;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
