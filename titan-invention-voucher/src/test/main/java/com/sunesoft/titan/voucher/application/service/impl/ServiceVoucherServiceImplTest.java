package com.sunesoft.titan.voucher.application.service.impl;

import com.alibaba.fastjson.JSON;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.dtos.ActiveVoucherDto;
import com.sunesoft.titan.voucher.application.dtos.HandOverDto;
import com.sunesoft.titan.voucher.application.dtos.VoucherScoreDto;
import com.sunesoft.titan.voucher.application.dtos.VoucherServiceDetailDto;
import com.sunesoft.titan.voucher.application.service.ServiceVoucherService;
import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by jzj on 2017/11/25.
 */
public class ServiceVoucherServiceImplTest extends TitanTestBase {

    @Autowired
    ServiceVoucherService serviceVoucherService;

    @Test
    public void addVoucher() throws Exception {
        TResult tResult = serviceVoucherService.addOrUpdateVoucher("1711111", UUID.fromString("e173e093-2269-4f27-8845-8850e4c0e35e"));
        System.out.println(JSON.toJSONString(tResult));
    }

    @Test
    public void addVoucherServiceDetail() throws Exception {
        VoucherServiceDetailDto voucherServiceDetailDto = new VoucherServiceDetailDto();
        voucherServiceDetailDto.setVoucherId(UUID.fromString("53a2068b-0fe2-47c1-94f8-4305f9cfc961"));
        voucherServiceDetailDto.setServiceDate(LocalDate.now());
        voucherServiceDetailDto.setServiceEngineer("888888888");
        voucherServiceDetailDto.setServiceDesc("88888888888888888");
        TResult tResult = serviceVoucherService.addVoucherServiceDetail(voucherServiceDetailDto);
        System.out.println(JSON.toJSONString(tResult));
    }

    /**
     * 服务券选择的服务商 评价
     * 给服务券的评分
     *
     * @return
     */
    @Test
    public void evaluateVoucherProvider() throws Exception {
        VoucherScoreDto voucherScoreDto = new VoucherScoreDto();
        voucherScoreDto.setId(UUID.fromString("53a2068b-0fe2-47c1-94f8-4305f9cfc961"));
        voucherScoreDto.setEvaluateContent("8888888888888");
        voucherScoreDto.setSc01(10.6);
        voucherScoreDto.setSc02(10.6);
        voucherScoreDto.setSc03(66.6);
        TResult tResult = serviceVoucherService.evaluateVoucherProvider(voucherScoreDto);
        System.out.println(JSON.toJSONString(tResult));
    }


    /**
     * 服务评价
     * 这里应该是先有服务券的评分然后才有服务评价，不然会报错
     * voucherId 服务券ID
     * serviceDetailId 服务记录ID
     * score 评分
     * evaluateContent 评价内容
     *
     * @return
     */
    @Test
    public void evaluateServiceDetail() throws Exception {
        TResult result = serviceVoucherService.evaluateServiceDetail(UUID.fromString("53a2068b-0fe2-47c1-94f8-4305f9cfc961")
                , UUID.fromString("f964fe26-20da-42a6-aa11-ff183cfb7c7a"), 88, "88888");
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void deleteVoucher() throws Exception {
        TResult tResult = serviceVoucherService.deleteVoucher(UUID.fromString("b1e9938e-8178-4fb8-b3bf-0e0e31179568"));
        System.out.println(JSON.toJSONString(tResult));
    }

    /**
     * 删除服务记录
     * voucherId
     * detailId
     */
    @Test
    public void deleteVoucherServiceDetail() throws Exception {
        TResult tResult = serviceVoucherService.deleteVoucherServiceDetail(UUID.fromString("64152fa0-28e8-4cff-82a8-69fb693690c4"),
                UUID.fromString("1acd9ea8-3d33-413f-bccf-7eb23fe6d268"));
        System.out.println(JSON.toJSONString(tResult));
    }

    /**
     * 激活服务券
     *
     * @throws Exception
     */
    @Test
    public void activeVoucher() throws Exception {
        ActiveVoucherDto activeVoucherDto = new ActiveVoucherDto();
        activeVoucherDto.setCorpName("qq");
        activeVoucherDto.setVoucherNo("1700008");
        activeVoucherDto.setPhoneNo("888");
        TResult tResult = serviceVoucherService.activeVoucher(activeVoucherDto);
        System.out.println(JSON.toJSONString(tResult));
    }

    /**
     * 选择产品 userName登录名电话号码 providerId 服务商ID productId产品ID
     *
     * @throws Exception
     */
    @Test
    public void chooseProduct() throws Exception {
        TResult tResult = serviceVoucherService.chooseProduct("999", UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0")
                , UUID.fromString("fa4a6e1f-549d-457c-be82-f244c2a0ba85"));
        System.out.println(JSON.toJSONString(tResult));
    }

    /**
     * 选择产品 voucherId服务券ID  providerId 服务商ID productId产品ID
     *
     * @throws Exception
     */
    @Test
    public void chooseProduct1() throws Exception {
        TResult tResult = serviceVoucherService.chooseProduct(UUID.fromString("53a2068b-0fe2-47c1-94f8-4305f9cfc961")
                , UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0")
                , UUID.fromString("fa4a6e1f-549d-457c-be82-f244c2a0ba85"));
        System.out.println(JSON.toJSONString(tResult));
    }

    /**
     * 选择产品 serviceVoucher服务券  providerId 服务商ID  productId 产品ID
     *
     * @throws Exception
     */
    @Test
    public void chooseProduct2() throws Exception {
    }


    /**
     * 优惠券产品确认 服务商ID  服务券ID  备注
     */
    @Test
    public void voucherConfirm() throws Exception {
        TResult tResult = serviceVoucherService.voucherConfirm(UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0")
                , UUID.fromString("53a2068b-0fe2-47c1-94f8-4305f9cfc961")
                , "好了区确认了");
        System.out.println(JSON.toJSONString(tResult));

    }

    @Test
    public void callBackVoucher() throws Exception {
        TResult tResult = serviceVoucherService.callBackVoucher(UUID.fromString("64152fa0-28e8-4cff-82a8-69fb693690c4")
                , "没什么理由");
        System.out.println(JSON.toJSONString(tResult));
    }

    @Test
    public void resetVoucherExpireDate() throws Exception {
        LocalDate localDate = LocalDate.of(2016, 12, 12);
        TResult tResult = serviceVoucherService.resetVoucherExpireDate(UUID.fromString("64152fa0-28e8-4cff-82a8-69fb693690c4")
                , localDate
                , "没什么理由");
        System.out.println(JSON.toJSONString(tResult));
    }

    @Test
    public void handOverVoucher() throws Exception {// 服务券ID  服务商ID
        HandOverDto handOverDto=new HandOverDto();
        handOverDto.setVoucherId(UUID.fromString("53a2068b-0fe2-47c1-94f8-4305f9cfc961"));
        handOverDto.setProviderId(UUID.fromString("a89e3d42-798a-471a-8678-b2634c0840a0"));
        handOverDto.setCorpType("企业类型");
        handOverDto.setHandContent("交付内容");
        LocalDateTime localDateTime=LocalDateTime.of(2017,12,12,12,12);
        handOverDto.setHandDate(LocalDate.now());
        TResult tResult = serviceVoucherService.HandOverVoucher(handOverDto);
        System.out.println(JSON.toJSONString(tResult));
    }

}