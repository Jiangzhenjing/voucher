package com.sunesoft.titan.voucher.application.task;

import com.sunesoft.titan.common.result.IResult;
import com.sunesoft.titan.voucher.application.service.ServiceVoucherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {
    Logger logger = LoggerFactory.getLogger("wxLogger");



    @Autowired
    ServiceVoucherService serviceVoucherService;

    //@Scheduled(fixedDelay = 5000)
    //0 0 1,9,16 * * ?
    public void testTask() {

        IResult planCompleteAndActiveNext = serviceVoucherService.setVoucherExpired();
        logger.info("测试定时任务");
    }
}
