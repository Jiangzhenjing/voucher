package com.sunesoft.titan.voucher.application.dtos;

import java.util.List;

/**
 * @author: Zhouzh
 * @Date: 2017/11/20
 */
public class ServiceVoucherWithProductDto extends ServiceVoucherDto {

    private ProviderProductDto providerProductDto;

    private CompanyInfoDto companyInfoDto;

    private ProviderDto providerDto;


    private  List<VoucherServiceDetailDto>  voucherServiceDetailDtos;

    public ProviderProductDto getProviderProductDto() {
        return providerProductDto;
    }

    public void setProviderProductDto(ProviderProductDto providerProductDto) {
        this.providerProductDto = providerProductDto;
    }

    public List<VoucherServiceDetailDto> getVoucherServiceDetailDtos() {
        return voucherServiceDetailDtos;
    }

    public void setVoucherServiceDetailDtos(List<VoucherServiceDetailDto> voucherServiceDetailDtos) {
        this.voucherServiceDetailDtos = voucherServiceDetailDtos;
    }

    public CompanyInfoDto getCompanyInfoDto() {
        return companyInfoDto;
    }

    public void setCompanyInfoDto(CompanyInfoDto companyInfoDto) {
        this.companyInfoDto = companyInfoDto;
    }

    public ProviderDto getProviderDto() {
        return providerDto;
    }

    public void setProviderDto(ProviderDto providerDto) {
        this.providerDto = providerDto;
    }
}
