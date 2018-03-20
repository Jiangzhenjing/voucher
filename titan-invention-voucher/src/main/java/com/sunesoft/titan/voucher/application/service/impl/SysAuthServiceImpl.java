package com.sunesoft.titan.voucher.application.service.impl;

import com.sunesoft.titan.common.result.IResult;
import com.sunesoft.titan.common.result.PagedResult;
import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.result.resultFactory.ResultFactory;
import com.sunesoft.titan.common.sqlBuilderTool.SqlBuilder;
import com.sunesoft.titan.common.utils.BeanUtil;
import com.sunesoft.titan.common.utils.ConvertUtil;
import com.sunesoft.titan.hibernate.repository.GenericHibernateFinder;
import com.sunesoft.titan.hibernate.sqlBuilder.HSqlBuilder;
import com.sunesoft.titan.systemManager.application.dtos.UserAuthDto;
import com.sunesoft.titan.systemManager.application.dtos.UserDto;
import com.sunesoft.titan.systemManager.application.service.SysRoleService;
import com.sunesoft.titan.systemManager.application.service.SysUserService;
import com.sunesoft.titan.systemManager.domain.Organization;
import com.sunesoft.titan.systemManager.domain.RelateUserAndRole;
import com.sunesoft.titan.systemManager.domain.Role;
import com.sunesoft.titan.systemManager.domain.User;
import com.sunesoft.titan.voucher.application.cretirias.SVUserCretirias;
import com.sunesoft.titan.voucher.application.dtos.SVUserDto;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;
import com.sunesoft.titan.voucher.application.querys.ServiceVoucherQueryService;
import com.sunesoft.titan.voucher.application.service.CompanyService;
import com.sunesoft.titan.voucher.application.service.ProviderService;
import com.sunesoft.titan.voucher.application.service.ServiceVoucherService;
import com.sunesoft.titan.voucher.application.service.SysAuthService;
import com.sunesoft.titan.voucher.domain.CompanyInfo;
import com.sunesoft.titan.voucher.domain.ServiceVoucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2017/11/25
 */
@SuppressWarnings("all")
@Service
public class SysAuthServiceImpl extends GenericHibernateFinder implements SysAuthService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService roleService;

    @Autowired
    CompanyService companyService;

    @Autowired
    ServiceVoucherService serviceVoucherService;


    @Autowired
    ServiceVoucherQueryService serviceVoucherQueryService;


    @Autowired
    ProviderService  providerService;

    @Override
    public TResult AddOrUpdateUser(SVUserDto userDto) {
        UserDto dto = new UserDto();
        if (userDto.getId() != null) {
            dto.setId(userDto.getId());
        }
        dto.setUser_name(userDto.getUserName());
        if (userDto.getRegionId() != null && userDto.getRoleType().equals(RoleType.regionAdmin.name())) {
            dto.setOrg_id(userDto.getRegionId());
            dto.setOrg_name(userDto.getRegion());
            dto.setReal_name(userDto.getRegion() + "管理员");

         }if(userDto.getRoleType().equals(RoleType.Admin.name())){
            dto.setReal_name("管理员");
        }
        if(userDto.getRoleType().equals(RoleType.Company.name()))
        {
            dto.setOrg_id(userDto.getRegionId());
            dto.setOrg_name(userDto.getRegion());
            dto.setReal_name(userDto.getUserRealName());
        }
        dto.setPassword(userDto.getPassword());
        TResult<UUID> result = sysUserService.addOrUpdateUser(dto);
        if (!result.getIs_success()) {
            return result;
        }
        Role role = roleService.getRoleByCode(userDto.getRoleType());
        UserAuthDto userAuthDto = new UserAuthDto();
        userAuthDto.setUserId(result.getResult());
        userAuthDto.setRoleIds(Arrays.asList(role.getId()));
        sysUserService.setUserAuthInfo(userAuthDto);
        return result;

    }

    @Override
    public PagedResult getSvUser(SVUserCretirias cretirias) {

        SqlBuilder<SVUserDto> builder = HSqlBuilder.hFrom(User.class,"u")
                .leftJoin(Organization.class,"o").on("u.org_id=o.id")
                .leftJoin(RelateUserAndRole.class,"ur").on("ur.user_id = u.id")
                .leftJoin(Role.class,"r").on("r.id=ur.role_id")
                .where(cretirias.getParams())
                .select(SVUserDto.class)
                .pagging(cretirias.getPageIndex(),cretirias.getPageSize());

        return this.queryBySqlPaged(builder);
    }

    @Override
    public TResult<SVUserDto> getUserById(UUID id) {
        SqlBuilder<SVUserDto> builder = HSqlBuilder.hFrom(User.class,"u")
                .leftJoin(Organization.class,"o").on("u.org_id=o.id")
                .leftJoin(RelateUserAndRole.class,"ur").on("ur.user_id = u.id")
                .leftJoin(Role.class,"r").on("r.id=ur.role_id")
                .where("u.id",id)
                .select(SVUserDto.class);
        SVUserDto svUserDto = queryForObjectFirst(builder);
        return new TResult<>(svUserDto);
    }

    @Override
    public TResult deleteUser(UUID id) {
        SqlBuilder<SVUserDto> builder = HSqlBuilder.hFrom(User.class,"u")
                .leftJoin(Organization.class,"o").on("u.org_id=o.id")
                .leftJoin(RelateUserAndRole.class,"ur").on("ur.user_id = u.id")
                .leftJoin(Role.class,"r").on("r.id=ur.role_id")
                .where("u.id",id)
                .select(SVUserDto.class);
        SVUserDto svUserDto = queryForObjectFirst(builder);
        if(svUserDto.getRoleType().equals(RoleType.Company.name())){
            TResult tResult = serviceVoucherService.deleteVoucher(UUID.fromString(svUserDto.getOpen_id()));
            if(!tResult.getIs_success()){
                companyService.deleteCompany(svUserDto.getUserName());
            }

        }
        if(svUserDto.getRoleType().equals(RoleType.Provider.name())){
            providerService.deleteProvider(UUID.fromString(svUserDto.getOpen_id()));
        }
        IResult iResult = sysUserService.deleteById(id);

        return(TResult) ResultFactory.success(id);
    }
}
