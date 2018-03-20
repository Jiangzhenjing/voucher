package com.sunesoft.titan.voucher.application.service.impl;

import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.result.resultFactory.ResultFactory;
import com.sunesoft.titan.common.utils.BeanUtil;
import com.sunesoft.titan.common.utils.ConvertUtil;
import com.sunesoft.titan.systemManager.application.dtos.UserDto;
import com.sunesoft.titan.systemManager.application.service.SysRoleService;
import com.sunesoft.titan.systemManager.application.service.SysUserService;
import com.sunesoft.titan.voucher.application.dtos.CompanyInfoDto;
import com.sunesoft.titan.voucher.application.service.CompanyService;
import com.sunesoft.titan.voucher.domain.CompanyInfo;
import com.sunesoft.titan.voucher.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/23
 */
@Service
public class CompanyServiceImpl implements CompanyService {


    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService roleService;


    @Autowired
    CompanyInfoRepository companyInfoRepository;


    /**
     * 新增修改企业信息
     *
     * @param dto
     * @return
     */
    @Override
    public TResult addOrUpdateCompany(CompanyInfoDto dto) {

        UserDto userDto = convertUserDto(dto);
        TResult<UserDto> userResult = sysUserService.getUserByName(dto.getPhoneNo());

        if(!userResult.getIs_success()){
            return userResult;
        }
        if (!dto.getPhoneNo().equals(userResult.getResult().getUser_name())) {
            return new TResult(false, "手机号为用户登陆名 不允许修改！");
        }
        UserDto originUser = userResult.getResult();
        BeanUtil.copyPropertiesIgnoreNull(userDto, originUser);
        TResult<UserDto> result = sysUserService.addOrUpdateUser(originUser);
        if(!result.getIs_success())
            return result;
        CompanyInfo byNo = companyInfoRepository.getByNo(dto.getPhoneNo());
        if(byNo!=null){
            dto.setId(byNo.getId());
        }
        CompanyInfo companyInfo;
        //检查company 数据是可以修改
        if (dto.getId() == null) {
            companyInfo=ConvertUtil.convert(dto, CompanyInfo.class);
        } else {
            companyInfo = companyInfoRepository.get(dto.getId());

            BeanUtil.copyPropertiesIgnoreNull(dto, companyInfo);
        }


        companyInfo.setUserId(originUser.getId());
        UUID id = companyInfoRepository.save(companyInfo);
        dto.setId(id);
        return new TResult(dto);

    }

    private UserDto convertUserDto(CompanyInfoDto dto) {
        UserDto userDto = new UserDto();
        userDto.setOrg_id(dto.getRegionId());
        userDto.setOrg_name(dto.getRegion());
        userDto.setUser_name(dto.getPhoneNo());
        userDto.setEmail(dto.getEmail());
        userDto.setReal_name(dto.getCompanyName());
        userDto.setUser_code(dto.getCreditCode());
        return userDto;
    }


    /**
     * 删除公司
     *
     * @param uuid id
     * @return
     */
    @Override
    public TResult deleteCompany(UUID uuid) {
        CompanyInfo companyInfo = companyInfoRepository.get(uuid);
//        TResult<UserDto> userByName = sysUserService.getUserByName(companyInfo.getPhoneNo());
//        if (userByName.getIs_success())
//            sysUserService.deleteById(userByName.getResult().getId());
        companyInfoRepository.delete(uuid);
        return (TResult) ResultFactory.success();
    }

    /**
     * 删除公司
     *
     * @param name@return
     */
    @Override
    public TResult deleteCompany(String name) {
        CompanyInfo byNo = companyInfoRepository.getByNo(name);
        if (byNo != null) {
            byNo.markAsRemoved();
        }
        companyInfoRepository.save(byNo);
        return (TResult) ResultFactory.success();

    }
}
