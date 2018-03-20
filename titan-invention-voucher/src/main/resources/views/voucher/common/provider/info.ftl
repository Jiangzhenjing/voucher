<#assign content>
<style>
    .vou-pro-ul li span {
        display: inline;
        width: auto;
    }
</style>
<div class="vou-details">
    <div class="vou-deta-infor">

            <div class="vou-deta-title">
                <strong>服务商信息</strong>
            </div>
            <ul class="vou-pro-ul">
                <li class="form-group">
                    <span>编号<em>*</em>：</span>
                    <span>${providerDto.pNo!""}</span>
                </li>
                <li class="form-group">
                    <span>公司名<em>*</em>：</span>
                    <span>${providerDto.corpName!""}</span>
                </li>
                <li class="form-group">
                    <span>联系人：</span>
                    <span>${providerDto.contacts!""}</span>
                </li>
                <li class="form-group">
                    <span>联系电话：</span>
                    <span>${providerDto.phoneNo!""}</span>
                </li>
                <li class="form-group">
                    <span>地址：</span>
                    <span>${providerDto.address!""}</span>
                </li>
                <li class="form-group">
                    <span>网址：</span>
                    <span>${providerDto.website!""}</span>
                </li>
                <li class="form-group">
                    <span>传真：</span>
                    <span>${providerDto.fax!""}</span>
                </li>
            </ul>
    </div>
    <#include "/voucher/common/product/list_table.ftl">
</div>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">