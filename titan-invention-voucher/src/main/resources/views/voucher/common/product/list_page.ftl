<#assign content>
<div class="vou-conpageft">
    <#if productDtos??>
    <div class="vou-conpage-title">
        <#--<strong>选择服务产品</strong>-->
        <form id="defaultForm" method="post" action="" class="form-inline">
            <#--<div class="vou-conpage-type form-group">-->
                <#--<span>类型：</span>-->
                <#--<select class="form-control">-->
                    <#--<option>企业管理类</option>-->
                <#--</select>-->
            <#--</div>-->
        </form>
        <div>
            <i class="iconfont icon-tanhao"></i>
            请于
            <em>${date}</em>
            前选择产品，如过期视为放弃
        </div>
    </div>
    <ul class="vou-conpageft-ul">
        <#list productDtos as product>
            <li>
                <h3>${product.productName !""}</h3>
                <div class="vou-conul-sm">
                    <span>类别：${product.productType!""}</span>
                    <span>适用对象：${product.suitTarget}</span>
                </div>
                <div class="vou-conul-deta">
                    <div class="vou-conul-jso">
                        <div>
                            <span>服务商：</span>
                            <div>${product.providerName}</div>
                            <span>电话：</span>
                            <div>${product.phoneNo}</div>
                            <span>传真：</span>
                            <div></div>
                        </div>
                        <div>
                            <span>解决问题：</span>
                            <div>${product.solveProblem}</div>
                        </div>
                        <div>
                            <span>应用案例：</span>
                            <div>${product.productDesc}</div>
                        </div>
                    </div>
                    <div class="vou-conul-cz">
                <span>
                    <i class="iconfont icon-icon"></i>
                    <div class="pro-price">优惠价格:</div>
                ${product.discountPrice}/
                    <div class="pro-price">市场价格:</div>
                    <s>${product.orginalPrice}</s>
                </span>
                        <button
                                type="button"
                                class="Js_conul_cz"
                                data-providerId="${product.providerId}"
                                data-productId="${product.id}"
                                data-title="${product.productName}"
                                data-discountprice="${product.discountPrice}"
                                data-orginalprice="${product.orginalPrice}"
                        >购买</button>
                    </div>
                </div>
            </li>
        </#list>
    </ul>
    <#else >
        暂无产品！
    </#if>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('common/product/list_page.js')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">
