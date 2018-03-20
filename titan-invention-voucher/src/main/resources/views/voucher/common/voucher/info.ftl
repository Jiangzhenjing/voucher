<#assign content>
<div class="vou-conpageft">
    <div class="vou-details">
        <div class="vou-conft-cz">
            <span>
                <strong>服务券号：${voucherInfo.voucherNo!""}</strong>
                <span>发券时间：${issuingDate!""}</span>
            </span>
            <#if roleCode == "Company"
                && (voucherInfo.voucherStatus == "WaitConfirm" || voucherInfo.voucherStatus == "Confirmed" )
            >
                <#if !voucherInfo.isCallBack>
                    <a class="Js_voucher_callback" data-id="${voucherInfo.id}">服务券撤回</a>
                </#if>
            </#if>
           <#---->
            <#--<div>-->

                <#--<a href="/voucher/products/search">选择服务商/产品</a>-->
            <#--</div>-->
        </div>
        <div class="vou-conft-cz">
            <span>
                <strong>服务券状态：
                    <#if voucherInfo.voucherStatus == "WaitActive">
                        待激活
                    <#elseif voucherInfo.voucherStatus == "Actived">
                        已激活
                    <#elseif voucherInfo.voucherStatus == "WaitConfirm">
                        已购买产品，待购买确认
                    <#elseif voucherInfo.voucherStatus == "Confirmed">
                        已确认
                    <#elseif voucherInfo.voucherStatus == "HandOver">
                        已交付
                    <#elseif voucherInfo.voucherStatus == "Expired">
                        已过期
                    </#if>

                    <#if voucherInfo.isCallBack><span style="color: red;">已撤回,请等待审核！</span></#if>
                    <#if scored>
                        <span style="color: green;">已评价</span>
                    </#if>
                </strong>
            </span>
            <div>
                <#--您有<em>[1]</em>条服务记录等待评价-->
                <#if roleCode == "Company" && voucherInfo.voucherStatus == "HandOver">
                    <a href="/voucher/info/${voucherInfo.id}/print">打印</a>
                    <a href="/voucher/info/${voucherInfo.id}/download">下载</a>
                </#if>

            </div>
        </div>
        <div class="vou-deta-infor">
            <div class="vou-deta-title">
                <strong>企业信息</strong>
            </div>
            <ul>
                <li>
                    <span>统一社会信用代码：</span>
                    ${companyDto.creditCode!""}
                </li>
                <li>
                    <span>企业名称：</span>
                    ${companyDto.companyName!""}
                </li>
                <li>
                    <span>所属区：</span>
                    ${companyDto.region!""}
                </li>
                <li>
                    <span>企业规模：</span>
                    ${companyDto.corpType!""}
                </li>
                <li>
                    <span>法定代表人：</span>
                    ${companyDto.artificialPerson!""}
                </li>
                <li>
                    <span>地址：</span>
                    ${companyDto.address!""}
                </li>
                <li>
                    <span>成立日期：</span>
                    ${companyDto.establishDate!""}
                </li>
                <li>
                    <span>联系人：</span>
                    ${companyDto.contacts!""}
                </li>
                <li>
                    <span>联系电话：</span>
                    ${companyDto.phoneNo!""}
                </li>
                <li>
                    <span>QQ号：</span>
                    ${companyDto.qq!""}
                </li>
                <li>
                    <span>邮箱：</span>
                    ${companyDto.email!""}
                </li>
                <li>
                    <span>2016年总产值：</span>
                    ${companyDto.productionValueYearBeforeLast!""}万
                </li>
                <li>
                    <span>2017年预计总产值：</span>
                    ${companyDto.productionValueLastYear!""}万
                </li>
                <li>
                    <span>2016年营业收入：</span>
                    ${companyDto.turnoverYearBeforeLast!""}万
                </li>
                <li>
                    <span>2017年预计营业收入：</span>
                    ${companyDto.turnoverLastYear!""}万
                </li>
                <li>
                    <span>2016年利润：</span>
                    ${companyDto.profitYearBeforeLast!""}万
                </li>
                <li>
                    <span>2017年预计利润：</span>
                    ${companyDto.profitLastYear!""}万
                </li>
                <li>
                    <span>从业人数：</span>
                    ${companyDto.employeeCount!""}人
                </li>
                <li>
                    <span>目前最大困难：</span>
                    ${companyDto.trouble!""}。
                </li>
                <li>
                    <span>备注：</span>
                    ${companyDto.remark !""}
                </li>
            </ul>
        </div>
        <div class="vou-deta-infor">
            <div class="vou-deta-title">
                <strong>产品信息</strong>
            </div>
            <ul>
                <li>
                    <span>服务商名称：</span>
                    ${providerInfo.corpName!""}
                </li>
                <li>
                    <span>公司电话：</span>
                    ${providerInfo.phoneNo!""}
                </li>
                <li>
                    <span>公司传真：</span>
                    ${providerInfo.fax!""}
                </li>
                <li>
                    <span>联系人：</span>
                    ${providerInfo.contacts!""}
                </li>
                <li>
                    <span>公司地址：</span>
                    ${providerInfo.address!""}
                </li>
                <li>
                    <span>公司网站：</span>
                    ${providerInfo.website!""}
                </li>
                <li>
                    <span>服务产品名称：</span>
                    ${productDto.productName!""}
                </li>
                <li>
                    <span>价格：</span>
                    ${productDto.discountPrice!""}
                </li>
                <li>
                    <span>适用对象：</span>
                    ${productDto.suitTarget!""}
                </li>
                <li>
                    <span>类别：</span>
                    ${productDto.productType!""}
                </li>
                <li>
                    <span>应付：</span>
                    <#if productDto.discountPrice>
                        ${productDto.discountPrice - 10000}
                    </#if>
                </li>
                <li class="vou-conpg-width">
                    <span>解决问题：</span>
                    ${productDto.solveProblem}
                </li>
                <li class="vou-conpg-width">
                    <span>应用案例：</span>
                    ${productDto.productDesc}
                </li>
            </ul>
        </div>
        <#if !voucherInfo.signDate??>
            <#if roleCode == "Provider" && voucherInfo.voucherStatus == "Confirmed">
                <a id="Js_sign" data-id="${voucherInfo.id}">合同签订</a>
            </#if>
        <#else>
            <div class="vou-deta-infor">
                <div class="vou-deta-title">
                    <strong>合同签订日期</strong>
                </div>
                <div class="vou-eval">
                    <div class="vou-eval1">
                        <span>时间</span>
                        <p>${voucherInfo.signDate!""}</p>
                    </div>
                </div>
            </div>
        </#if>
        <#if voucherInfo.signDate??>
            <div class="vou-deta-infor">
                <div class="vou-deta-title">
                    <strong>服务信息</strong>
                    <#if roleCode == "Provider" && voucherInfo.voucherStatus == "Confirmed">
                        <a id="Js_addService" data-id="${voucherInfo.id}">添加服务信息</a>
                    </#if>
                    <#if roleCode == "Company" && voucherInfo.voucherStatus == "HandOver" && !scored>
                        <a id="Js_addComment" data-id="${voucherInfo.id}">添加服务评价</a>
                    </#if>
                </div>
                <#if voucherServices?? && (voucherServices?size > 0)>
                    <#list voucherServices as voucherService>
                        <div class="vou-eval">
                            <strong>
                            ${voucherService.serviceEngineer}
                                在${voucherService.serviceDate}
                                提供了服务
                            </strong>
                            <div class="vou-eval1">
                                <div>服务描述</div>
                                <p>${voucherService.serviceDesc}</p>
                            </div>
                            <div class="vou-eval1">
                                <div>备注</div>
                                <p>${voucherService.remark}</p>
                            </div>
                        </div>
                    </#list>
                </#if>
            </div>
        </#if>
        <#if voucherInfo.signDate?? >
            <div class="vou-deta-infor">
                <div class="vou-deta-title">
                    <strong>产品交付记录</strong>
                    <#if !voucherInfo.handDate??>
                        <#if roleCode == "Provider" && voucherInfo.voucherStatus == "Confirmed">
                            <a id="Js_addCommit" data-id="${voucherInfo.id}">编辑交付记录</a>
                        </#if>
                    </#if>
                </div>
                <#if voucherInfo.handDate??>
                    <div class="vou-eval">
                        <div class="vou-eval1">
                            <div>时间</div>
                            <p>${voucherInfo.handDate}</p>
                        </div>
                        <div class="vou-eval1">
                            <div>内容</div>
                            <p>${voucherInfo.handContent}</p>
                        </div>
                    </div>
                </#if>
            </div>
        </#if>
        <#if voucherInfo.totalScore>
            <div class="vou-deta-infor">
                <div class="vou-deta-title">
                    <strong>评价信息</strong>
                </div>
                <div class="vou-eval">
                    <div class="vou-eval1">
                        <div  style="width: 90px">评价得分：</div>
                        <p>${voucherInfo.totalScore}</p>
                    </div>
                    <div class="vou-eval1">
                        <div  style="width: 90px">评价内容：</div>
                        <p>${voucherInfo.evaluateContent}</p>
                    </div>
                </div>
            </div>
        </#if>
    </div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('common/voucher/info')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">
