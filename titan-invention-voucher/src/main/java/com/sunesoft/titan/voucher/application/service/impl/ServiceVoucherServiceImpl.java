package com.sunesoft.titan.voucher.application.service.impl;

import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.result.resultFactory.ResultFactory;
import com.sunesoft.titan.common.utils.BeanUtil;
import com.sunesoft.titan.common.utils.ConvertUtil;
import com.sunesoft.titan.hibernate.repository.GenericHibernateFinder;
import com.sunesoft.titan.systemManager.application.service.SysUserService;
import com.sunesoft.titan.voucher.VSSetting;
import com.sunesoft.titan.voucher.application.dtos.*;
import com.sunesoft.titan.voucher.application.service.ServiceVoucherService;
import com.sunesoft.titan.voucher.domain.*;
import com.sunesoft.titan.voucher.domain.enums.VoucherStatus;
import com.sunesoft.titan.voucher.repository.CompanyInfoRepository;
import com.sunesoft.titan.voucher.repository.ProviderRepository;
import com.sunesoft.titan.voucher.repository.ServiceVoucherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jzj on 2017/11/21.
 */
@Service
public class ServiceVoucherServiceImpl extends GenericHibernateFinder implements ServiceVoucherService {

    @Autowired
    ServiceVoucherRepository serviceVoucherRepository;

    @Autowired
    CompanyInfoRepository companyInfoRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    SysUserService sysUserService;

    Logger logger = LoggerFactory.getLogger("wxLogger");

    /**
     * 新增/修改创新券
     *
     * @param vencherNo
     * @param companyId
     * @return
     */
    @Override
    public TResult addOrUpdateVoucher(String vencherNo, UUID companyId) {
        if (vencherNo.length() != 6) {
            return (TResult) ResultFactory.error("请输入6位服务券号！");
        }
        ServiceVoucher newServiceVoucher = serviceVoucherRepository.getByNo(vencherNo);
        ServiceVoucher nowServiceVoucher = serviceVoucherRepository.getByCompanyId(companyId);
        if (nowServiceVoucher != null) {//修改
            if (!nowServiceVoucher.getVoucherNo().equals(vencherNo) && newServiceVoucher != null)
                return (TResult) ResultFactory.error("该服务券编号已使用！");
            nowServiceVoucher.setVoucherNo(vencherNo);
            newServiceVoucher = nowServiceVoucher;
        } else {//新增
            if (newServiceVoucher != null) return (TResult) ResultFactory.error("该服务券编号已使用！");
            CompanyInfo companyInfo = companyInfoRepository.get(companyId);
            companyInfo.setHandVoucher(true);
            newServiceVoucher = new ServiceVoucher();
            newServiceVoucher.init(vencherNo, companyInfo);
            UUID id = serviceVoucherRepository.save(newServiceVoucher);
            sysUserService.setUserOpenId(companyInfo.getPhoneNo(), id.toString());
        }
        return new TResult(ConvertUtil.convert(newServiceVoucher, ServiceVoucherDto.class));
    }

    /**
     * 新增服务记录
     *
     * @param dto
     * @return
     */
    @Override
    public TResult addVoucherServiceDetail(VoucherServiceDetailDto dto) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(dto.getVoucherId());
        VoucherServiceDetail detail = ConvertUtil.convert(dto, VoucherServiceDetail.class);
        serviceVoucher.getVoucherServiceDetailList().add(detail);
        if (!(serviceVoucher.getServiceEngineers().indexOf(dto.getServiceEngineer()) > 0)) {
            if (serviceVoucher.getServiceEngineers().equals("")) {
                serviceVoucher.setServiceEngineers(dto.getServiceEngineer());
            } else {
                serviceVoucher.setServiceEngineers(serviceVoucher.getServiceEngineers() + "," + dto.getServiceEngineer());
            }
        }
        serviceVoucherRepository.save(serviceVoucher);
        return new TResult(detail.getId());

    }

    @Override
    public TResult signContract(UUID uuid, LocalDate time) {
        if (uuid == null || time == null) {
            return (TResult) ResultFactory.error("参数有误，保存失败！");
        }
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(uuid);
        serviceVoucher.setSignDate(time);
        serviceVoucherRepository.save(serviceVoucher);
        return new TResult(serviceVoucher.getId());
    }


    /**
     * 服务券选择的服务商评价
     *
     * @return
     */
    @Override
    public TResult evaluateVoucherProvider(VoucherScoreDto voucherScoreDto) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(voucherScoreDto.getId());
        if (serviceVoucher.getServiceLevel() != null) {
            return new TResult(ResultFactory.error("已评价，不可重复评价！"));
        }
        BeanUtil.copyPropertiesIgnoreNull(voucherScoreDto, serviceVoucher);
        serviceVoucher.scoreService();
        serviceVoucherRepository.save(serviceVoucher);
        return new TResult(serviceVoucher.getId());
    }

    /**
     * 服务评价
     *
     * @param voucherId       服务券ID
     * @param serviceDetailId 服务记录ID
     * @param score           评分
     * @param evaluateContent 评价内容
     * @return
     */
    @Override
    public TResult evaluateServiceDetail(UUID voucherId, UUID serviceDetailId, Integer score, String evaluateContent) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(voucherId);
        serviceVoucher.getVoucherServiceDetailList().stream().filter(x -> x.getId().equals(serviceDetailId)).forEach(e -> {
            e.setEvaluate(true);
            e.setEvaluateContent(evaluateContent);
            e.setEvaluateScore(score);
        });
        serviceVoucherRepository.save(serviceVoucher);
        return (TResult) ResultFactory.success();
    }

    /**
     * 删除创新券
     *
     * @param uuid
     * @return
     */
    @Override
    public TResult deleteVoucher(UUID uuid) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(uuid);
        if (serviceVoucher != null) {
            serviceVoucher.markAsRemoved();
            serviceVoucher.getCompanyInfo().markAsRemoved();
            serviceVoucherRepository.save(serviceVoucher);
        }
        return (TResult) ResultFactory.success(uuid);
    }

    /**
     * 删除服务记录
     *
     * @param voucherId
     * @param detailId
     * @return
     */
    @Override
    public TResult deleteVoucherServiceDetail(UUID voucherId, UUID detailId) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(voucherId);
        serviceVoucher.getVoucherServiceDetailList().stream().filter(x -> x.getId().equals(detailId)).forEach(e -> {
            e.markAsRemoved();
        });
        serviceVoucherRepository.save(serviceVoucher);
        return (TResult) ResultFactory.success();
    }

    /**
     * 激活服务券
     *
     * @param activeVoucherDto
     * @return
     */
    @Override
    public TResult activeVoucher(ActiveVoucherDto activeVoucherDto) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.getByNo(activeVoucherDto.getVoucherNo());
        if (serviceVoucher.getVoucherStatus() == VoucherStatus.Expired) {
            return (TResult) ResultFactory.error("服务券已过期！");
        }
        if (serviceVoucher.getVoucherStatus() != VoucherStatus.WaitActive) {
            return (TResult) ResultFactory.error("激活失败，请勿重复激活！");
        }
        if (serviceVoucher == null) {
            return (TResult) ResultFactory.error("服务券号码错误，请核实！");
        }
        if (!activeVoucherDto.getPhoneNo().trim().equals(serviceVoucher.getCompanyInfo().getPhoneNo().trim())) {
            return (TResult) ResultFactory.error("联系人电话与登记不符，请核实！");
        }
        if (!activeVoucherDto.getCorpName().trim().equals(serviceVoucher.getCompanyInfo().getCompanyName().trim())) {
            return (TResult) ResultFactory.error("企业名称与登记不符，请核实！");
        }
        serviceVoucher.Active();
        serviceVoucherRepository.save(serviceVoucher);
        return (TResult) ResultFactory.success();
    }

    /**
     * 选择产品
     *
     * @param userName
     * @param providerId
     * @param productId
     * @return
     */
    @Override
    public TResult chooseProduct(String userName, UUID providerId, UUID productId) {
        CompanyInfo companyInfo = companyInfoRepository.getByNo(userName);
        ServiceVoucher serviceVoucher = companyInfo.getServiceVoucher();

        return chooseProduct(serviceVoucher, providerId, productId);
    }

    /**
     * 选择产品
     *
     * @param voucherId
     * @param providerId
     * @param productId
     * @return
     */
    @Override
    public TResult chooseProduct(UUID voucherId, UUID providerId, UUID productId) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(voucherId);
        return chooseProduct(serviceVoucher, providerId, productId);
    }

    /**
     * 选择产品
     *
     * @param serviceVoucher
     * @param providerId
     * @param productId
     * @return
     */
    @Override
    public TResult chooseProduct(ServiceVoucher serviceVoucher, UUID providerId, UUID productId) {
        if (serviceVoucher.getVoucherStatus() == VoucherStatus.Expired) {
            return (TResult) ResultFactory.error("服务券已过期！");
        }
        if (serviceVoucher.getVoucherStatus() != VoucherStatus.Actived) {
            return (TResult) ResultFactory.error("购买失败，是否已买过产品！");
        }
        Provider provider = providerRepository.get(providerId);
        ProviderProduct product = provider.getProviderProducts().stream().filter(x -> x.getId().equals(productId)).findFirst().get();
        serviceVoucher.bugProduct(product);
        serviceVoucherRepository.save(serviceVoucher);
        return (TResult) ResultFactory.success();
    }

    /**
     * 优惠券产品确认
     *
     * @param uuid 服务商ID  服务券ID  备注
     * @return
     */
    @Override
    public TResult voucherConfirm(UUID providerId, UUID uuid, String remark) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(uuid);
        if (serviceVoucher.getIsCallBack()) {
            return (TResult) ResultFactory.error("确认失败，该优惠券用户已申请撤回！");
        }
        if (!serviceVoucher.getProviderProduct().getProvider().getUserId().equals(providerId)) {
            return (TResult) ResultFactory.error("确认失败，服务券已被被撤回！");
        }
        if (serviceVoucher.getVoucherStatus() == VoucherStatus.WaitConfirm) {
            serviceVoucher.confirm(LocalDateTime.now(), remark);
            serviceVoucherRepository.save(serviceVoucher);
            return (TResult) ResultFactory.success();
        }
        return (TResult) ResultFactory.error("确认失败，请核实信息后重试！");
    }


    /**
     * 撤回优惠券 重新选择
     *
     * @param id 服务券ID 理由
     * @return
     */
    @Override
    public TResult callBackVoucher(UUID id, String reason) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(id);
        if (!(serviceVoucher.getVoucherStatus() == VoucherStatus.Confirmed || serviceVoucher.getVoucherStatus() == VoucherStatus.WaitConfirm))
            return (TResult) ResultFactory.error("撤回失败，服务券当前状态不允许撤回！");
        if (serviceVoucher.getVoucherStatus() == VoucherStatus.Confirmed) {
            serviceVoucher.callBack(reason);
        }
        if (serviceVoucher.getVoucherStatus() == VoucherStatus.WaitConfirm) {
            serviceVoucher.callBackConfirm();
        }
        UUID save = serviceVoucherRepository.save(serviceVoucher);
        return (TResult) ResultFactory.success(save);
    }

    /**
     * 管理员管理确认撤回优惠券
     *
     * @param
     * @return
     */
    @Override
    public TResult callBackConfirm(UUID id) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(id);
        if (serviceVoucher.getIsCallBack() && serviceVoucher.getVoucherStatus() == VoucherStatus.Confirmed) {
            serviceVoucher.callBackConfirm();
        }
        UUID save = serviceVoucherRepository.save(serviceVoucher);
        return (TResult) ResultFactory.success(save);
    }


    /**
     * 管理员管理否决撤回优惠券
     *
     * @param
     * @return
     */
    @Override
    public TResult callBackRefuse(UUID id) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(id);
        if (serviceVoucher.getIsCallBack() && serviceVoucher.getVoucherStatus() == VoucherStatus.Confirmed) {
            serviceVoucher.setIsCallBack(false);
        }
        UUID save = serviceVoucherRepository.save(serviceVoucher);
        return (TResult) ResultFactory.success(save);
    }

    /**
     * 设置过期日期。
     *
     * @param id 服务券ID
     * @return
     */
    @Override
    public TResult resetVoucherExpireDate(UUID id, LocalDate newExpiredDate, String reason) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(id);
        serviceVoucher.setRemark(reason);
        if (serviceVoucher.getVoucherStatus() == VoucherStatus.Expired) {
            if (newExpiredDate.isAfter(LocalDate.now())) {
                serviceVoucher.setVoucherStatus(VoucherStatus.WaitActive);
                serviceVoucher.setExpiryDate(newExpiredDate);
            }
        } else {
            serviceVoucher.setExpiryDate(newExpiredDate);
            if (serviceVoucher.getExpiryDate().isBefore(LocalDate.now())) {
                serviceVoucher.setVoucherStatus(VoucherStatus.Expired);
            }
        }
        UUID save = serviceVoucherRepository.save(serviceVoucher);
        return (TResult) ResultFactory.success(save);
    }

    /**
     * 产品交付
     *
     * @param handOverDto
     * @return
     */
    @Override
    public TResult HandOverVoucher(HandOverDto handOverDto) {
        ServiceVoucher serviceVoucher = serviceVoucherRepository.get(handOverDto.getVoucherId());
        if (serviceVoucher.getIsCallBack()) {
            return (TResult) ResultFactory.error("确认失败，该优惠券用户已申请撤回！");
        }
        if (!serviceVoucher.getProviderProduct().getProvider().getId().equals(handOverDto.getProviderId())) {
            return (TResult) ResultFactory.error("确认失败，服务券已被撤回！");
        }
        if (serviceVoucher.getVoucherStatus() == VoucherStatus.Confirmed) {
            serviceVoucher.hand(handOverDto.getCorpType(), handOverDto.getHandDate(), handOverDto.getHandContent());
            UUID save = serviceVoucherRepository.save(serviceVoucher);
            return (TResult) ResultFactory.success(save);

        }
        return (TResult) ResultFactory.error("确认失败，请核实信息后重试！");
    }

    @Override
    public TResult setVoucherExpired() {

        String sql = "from ServiceVoucher s where s.is_active =1 and s.expiryDate<:expireDate and s.voucherStatus!='Expired' ";
        Map<String, Object> params = new HashMap<>();
        params.put("expireDate", LocalDate.now());
        List<ServiceVoucher> list = this.createQuery(sql, params).list();
        if (list.size() > 0) {
            for (ServiceVoucher voucher : list) {
                voucher.setVoucherStatus(VoucherStatus.Expired);
                voucher.setExpiryDate(null);
                serviceVoucherRepository.save(voucher);

                logger.info("expiryVoucher:voucherNo:" + voucher.getVoucherNo());

            }
        }
        return (TResult) ResultFactory.success();
    }
}
