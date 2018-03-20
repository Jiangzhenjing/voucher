package com.sunesoft.titan.voucher.application.querys;

import com.sunesoft.titan.voucher.application.test.TitanTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author: Zhouzh
 * @Date: 2017/11/24
 */
public class ServiceVoucherQueryServiceTest extends TitanTestBase {

    @Autowired
    ServiceVoucherQueryService serviceVoucherQueryService;

    @Test
    public void getById() throws Exception {
        serviceVoucherQueryService.getById(UUID.randomUUID());
    }

    @Test
    public void getByNo() throws Exception {
    }

    @Test
    public void getVoucherWithProductById() throws Exception {
    }

    @Test
    public void getServiceVoucherList() throws Exception {
    }

    @Test
    public void queryServiceVoucherPaged() throws Exception {
    }

    @Test
    public void queryVoucherServiceDetails() throws Exception {
    }

    @Test
    public void voucherStatistics() throws Exception {
    }

}