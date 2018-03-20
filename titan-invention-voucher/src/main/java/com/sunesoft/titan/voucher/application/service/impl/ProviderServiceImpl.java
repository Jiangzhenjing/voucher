package com.sunesoft.titan.voucher.application.service.impl;

import com.sunesoft.titan.common.result.TResult;
import com.sunesoft.titan.common.result.resultFactory.ResultFactory;
import com.sunesoft.titan.common.utils.BeanUtil;
import com.sunesoft.titan.common.utils.ConvertUtil;
import com.sunesoft.titan.systemManager.application.dtos.UserAuthDto;
import com.sunesoft.titan.systemManager.application.dtos.UserDto;
import com.sunesoft.titan.systemManager.application.service.SysRoleService;
import com.sunesoft.titan.systemManager.application.service.SysUserService;
import com.sunesoft.titan.systemManager.domain.Role;
import com.sunesoft.titan.voucher.application.dtos.ProviderDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderEngineerDto;
import com.sunesoft.titan.voucher.application.dtos.ProviderProductDto;
import com.sunesoft.titan.voucher.application.dtos.enums.RoleType;
import com.sunesoft.titan.voucher.application.service.ProviderService;
import com.sunesoft.titan.voucher.domain.Provider;
import com.sunesoft.titan.voucher.domain.ProviderEngineer;
import com.sunesoft.titan.voucher.domain.ProviderProduct;
import com.sunesoft.titan.voucher.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by jzj on 2017/11/21.
 */
@Service(" providerService")
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    SysRoleService roleService;

    /**
     * 新增修改服务商信息
     *
     * @param dto
     * @return
     */
    @Override
    public TResult<ProviderDto> addOrUpdateProvider(ProviderDto dto) {
        UserDto userDto = convertUserDto(dto);
        List<Provider> providers = providerRepository.queryProviderUnique(dto);
        if (dto.getId() != null) {//修改
            Provider provider = providerRepository.get(dto.getId());//取出当前数据
            if (!provider.getSortName().equals(dto.getSortName())) {
                return new TResult(false, "公司简称为用户登陆名 不允许修改！");
            }
            TResult<UserDto> user = sysUserService.getUserByName(dto.getSortName());
            userDto.setId(user.getResult().getId());
            if (!providers.contains(provider) && providers.size() == 1 || providers.size() > 1) {
                return (TResult<ProviderDto>) ResultFactory.error("服务商名称或编号已经存在，请重新输入！");
            }
            sysUserService.addOrUpdateUser(userDto);
            BeanUtil.copyPropertiesIgnoreNull(dto, provider);
            providerRepository.save(provider);
        } else {//新增
            if (providers.size() != 0) {
                return (TResult<ProviderDto>) ResultFactory.error("服务商名称或编号已经存在，请重新输入！");
            }
            Role role = roleService.getRoleByCode(RoleType.Provider.name());
            if (dto.getPassword() == null) {
                userDto.setPassword("123456");
            }
            TResult<UUID> result = sysUserService.addOrUpdateUser(userDto);
            if (!result.getIs_success()) {
                return (TResult<ProviderDto>) ResultFactory.error(result.getMessage());
            }
            UserAuthDto userAuthDto = new UserAuthDto();
            userAuthDto.setUserId(result.getResult());
            userAuthDto.setRoleIds(Arrays.asList(role.getId()));
            sysUserService.setUserAuthInfo(userAuthDto);
            Provider provider = new Provider();
            BeanUtil.copyPropertiesIgnoreNull(dto, provider);
            provider.setUserId(result.getResult());
            providerRepository.save(provider);
            sysUserService.setUserOpenId(userDto.getUser_name(),provider.getId().toString());

        }
        return new TResult(dto);
    }


    private UserDto convertUserDto(ProviderDto dto) {
        UserDto userDto = new UserDto();
        userDto.setUser_name(dto.getSortName());
        userDto.setEmail(dto.getFax());
        userDto.setReal_name(dto.getCorpName());
        userDto.setUser_code(dto.getpNo());
        if (dto.getPassword() != null) {
            userDto.setPassword(dto.getPassword());
        }
        return userDto;
    }

    public TResult<ProviderDto> addOrUpdateProviderProductByUserId(UUID userId, ProviderProductDto dto) {
        Provider provider = providerRepository.queryProviderByUserId(userId);
        return addOrUpdateProviderProductByProvider(provider, dto);
    }


    public TResult<ProviderDto> addOrUpdateProviderProductByProvider(Provider provider, ProviderProductDto dto) {
        List<ProviderProduct> providerProducts = providerRepository.queryByDto(dto);
        if (dto.getId() != null) {//修改
            ProviderProduct providerProduct = new ProviderProduct();
            List<ProviderProduct> allProducts = provider.getProviderProducts();
//            Optional<ProviderProduct> first = allProducts.stream().filter(x -> x.getId().equals(dto.getId())).findFirst();
            for (ProviderProduct Product : allProducts) {
                if (Product.getId().equals(dto.getId())) {
                    providerProduct = Product;
                    break;
                }
            }
            if (!providerProduct.getProductName().equals(dto.getProductName()) && providerProducts.size() != 0) {//修改了产品名称且重复
                return (TResult<ProviderDto>) ResultFactory.error("产品名称已经存在，请重新输入！");
            }
            BeanUtil.copyPropertiesIgnoreNull(dto, providerProduct);
            providerRepository.save(provider);
        } else {//新增
            if (providerProducts.size() != 0) {
                return (TResult) ResultFactory.error("产品名称已经存在，请修改！");
            }
            ProviderProduct providerProduct = new ProviderProduct();
            BeanUtil.copyPropertiesIgnoreNull(dto, providerProduct);
            provider.getProviderProducts().add(providerProduct);
            providerRepository.save(provider);
        }
        ProviderDto convert = ConvertUtil.convert(provider, ProviderDto.class);
        return (TResult) ResultFactory.success(convert);
    }

    /**
     * 新增
     * 依赖服务商建立
     *
     * @param dto
     * @return
     */
    @Override
    public TResult<ProviderDto> addOrUpdateProviderProductAdmin(UUID providerId, ProviderProductDto dto) {
        Provider provider = providerRepository.get(providerId);
        return addOrUpdateProviderProductByProvider(provider, dto);
    }

    /**
     * 新增修改工程师
     * 依赖服务商建立
     *
     * @param dto
     * @return
     */
    @Override
    public TResult<ProviderDto> addOrUpdateProviderEngineer(ProviderEngineerDto dto) {
        Provider provider = providerRepository.get(dto.getProviderId());
        List<ProviderEngineer> providerEngineers = providerRepository.queryEngineerByDto(dto);
        if (dto.getId() != null) {//修改
            List<ProviderEngineer> allEngineers = provider.getProviderEngineers();
            ProviderEngineer providerEngineer = new ProviderEngineer();
            for (ProviderEngineer Engineer : allEngineers) {
                if (Engineer.getId().equals(dto.getId())) {
                    providerEngineer = Engineer;
                    break;
                }
            }
            if (!providerEngineer.getEngineerNo().equals(dto.getEngineerNo()) && providerEngineers.size() != 0) {
                return (TResult) ResultFactory.error("工程师编号已经存在，请修改！");
            }
            BeanUtil.copyPropertiesIgnoreNull(dto, providerEngineer);
            providerRepository.save(provider);
        } else {//新增
            if (providerEngineers.size() != 0) {
                return (TResult) ResultFactory.error("工程师编号已经存在，请修改！");
            }
            ProviderEngineer providerEngineer = new ProviderEngineer();
            BeanUtil.copyPropertiesIgnoreNull(dto, providerEngineer);
            provider.getProviderEngineers().add(providerEngineer);
            providerRepository.save(provider);
        }
        ProviderDto convert = ConvertUtil.convert(provider, ProviderDto.class);
        return (TResult) ResultFactory.success(convert);
    }

    /**
     * 删除服务商信息
     * 下面的产品以及工程师一起删除
     *
     * @param id
     * @return
     */
    @Override
    public TResult deleteProvider(UUID id) {
        Provider provider = providerRepository.get(id);
        List<ProviderProduct> providerProducts = provider.getProviderProducts();
        providerProducts.clear();
        List<ProviderEngineer> providerEngineers = provider.getProviderEngineers();
        providerEngineers.clear();
        provider.markAsRemoved();
        providerRepository.save(provider);
        return (TResult) ResultFactory.success(id);
    }

    /**
     * 删除产品
     *
     * @param providerId
     * @param productId
     * @return
     */
    @Override
    public TResult removeProduct(UUID providerId, UUID productId) {
        Provider provider = providerRepository.get(providerId);
        List<ProviderProduct> providerProducts = provider.getProviderProducts();
        for (ProviderProduct Product : providerProducts) {
            if (Product.getId().equals(productId)) {
                providerProducts.remove(Product);
                break;
            }
        }
        providerRepository.save(provider);
        ProviderDto convert = ConvertUtil.convert(provider, ProviderDto.class);
        return (TResult) ResultFactory.success(productId);
    }

    /**
     * 删除工程师
     *
     * @param providerId
     * @param engginerId
     * @return
     */
    @Override
    public TResult removeEngineer(UUID providerId, UUID engginerId) {
        Provider provider = providerRepository.get(providerId);
        List<ProviderEngineer> providerEngineers = provider.getProviderEngineers();
        for (ProviderEngineer providerEngineer : providerEngineers) {
            if (providerEngineer.getId().equals(engginerId)) {
                providerEngineers.remove(providerEngineer);
                break;
            }
        }
        providerRepository.save(provider);
        ProviderDto convert = ConvertUtil.convert(provider, ProviderDto.class);
        return (TResult) ResultFactory.success(engginerId);
    }
}
