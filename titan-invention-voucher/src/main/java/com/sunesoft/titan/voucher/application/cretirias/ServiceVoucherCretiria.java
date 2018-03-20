package com.sunesoft.titan.voucher.application.cretirias;

import com.sunesoft.titan.UserContext;
import com.sunesoft.titan.common.cretiria.TCretiria;
import com.sunesoft.titan.common.utils.StringUtil;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ServiceVoucherCretiria extends TCretiria {

    /**
     * 主键id
     */
    private UUID id;

    private UUID providerId;

    /**
     * 券号
     */
    private String voucherNo;

    /**
     * 生效日期
     */
    private LocalDate activeDate;

    /**
     * 服务券状态
     */
    private VoucherStatus voucherStatus;

    /**
     * 区域
     */
    private String region;

    /**
     * 企业名称
     */
    private String corpName;

    /**
     * 企业类型
     */
    private String corpType;

    /**
     * 是否撤回
     */
    private Boolean isCallBack;


    private UUID providerUserId;

    /**
     * 企业ID
     */
    private UUID companyId;


    public Map<String, Object> getParams() {
        Map<String, Object> param = super.getParams();

        if (id != null) {
            param.put("id", id);
        }
        if (!StringUtil.isEmpty(voucherNo)) {
            param.put("voucherNo", voucherNo);
        }
        if (!StringUtil.isEmpty(region)) {
            param.put("region", region);
        } else {
            if (UserContext.getUser().getRoleIds().get(0).equals(RoleType.regionAdmin.name())) {
                param.put("region", UserContext.getUser().getOrg_name());

            }
        }
        if (!StringUtil.isEmpty(corpName)) {
            param.put("companyName", "%" + corpName + "%");
        }

        if (!StringUtil.isEmpty(corpType)) {
            param.put("corpType", corpType);
        }
        if (voucherStatus != null) {
            param.put("voucherStatus", voucherStatus.name());
        }
        if (isCallBack != null) {
            param.put("isCallBack", isCallBack ? 1 : 0);
        }
        if (providerId != null) {
            param.put("p.provider_id", providerId);
        }
        if (providerUserId != null) {
            param.put("pr.userId", providerUserId);
        }
        if (companyId != null) {
            param.put("c.id", companyId);
        }
        return param;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public LocalDate getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(LocalDate activeDate) {
        this.activeDate = activeDate;
    }

    public VoucherStatus getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(VoucherStatus voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public Boolean getIsCallBack() {
        return isCallBack;
    }

    public void setIsCallBack(Boolean callBack) {
        isCallBack = callBack;
    }


    public UUID getProviderId() {
        return providerId;
    }

    public void setProviderId(UUID providerId) {
        this.providerId = providerId;
    }

    public UUID getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(UUID providerUserId) {
        this.providerUserId = providerUserId;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }
}
