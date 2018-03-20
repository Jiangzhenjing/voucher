package com.sunesoft.titan.voucher.application.service;

import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.voucher.application.cretirias.SVUserCretirias;
import com.sunesoft.titan.voucher.application.dtos.SVUserDto;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/25
 */
public interface SysAuthService {

    TResult AddOrUpdateUser(SVUserDto userDto);




    PagedResult<SVUserDto> getSvUser(SVUserCretirias cretirias);



    TResult<SVUserDto> getUserById(UUID id);


    TResult deleteUser(UUID id);



}
