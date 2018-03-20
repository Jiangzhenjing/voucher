<#assign content>
<div class="vou-banner-div">
    <img src="/static/voucher/images/indexpg.jpg">
    <div class="vou-index-title">南京中小企业信息化服务券管理平台</div>
</div>
<div class="vou-index-ul">
    <div class="vou-btn_div" style="margin: 0;">
        <a href="/login?role=company">
            <div class="vou-btn_icon customer_icon"></div>
            <span class="btn_text">客户登录</span>
        </a>
    </div>
    <div class="vou-btn_div">
        <a href="/login?role=provider">
            <div class="vou-btn_icon service_icon"></div>
            <span class="btn_text">服务商登录</span>
        </a>
    </div>
    <div class="vou-btn_div">
        <a href="/login?role=admin">
            <div class="vou-btn_icon admin_iocn"></div>
            <span class="btn_text">管理员登录</span>
        </a>
    </div>
</div>
<#if news>
    <div class="vou-information">
        <div>
            <div class="vou-infor-title">
                实时资讯
                <a href="/news">更多&gt;</a>
            </div>
            <ul class="vou-infor-ul">
            <#list news as new>
                <li>
                    <a href="/news/${new.id}" target="_blank">
                        <div></div>
                        <span>${new.title!""}</span>
                        <em>${new.issueTime!""}</em>
                    </a>
                </li>
            </#list>
            </ul>
        </div>
    </div>
</#if>

<div class="vou-index-ts">
    <span>使用说明：</span>
    <a href="/static/voucher/help/南京中小企业信息化服务券管理平台企业操作手册.pdf" target="_blank" >
        客户 </a> <span class="vou-span-line">|</span>
    <a href="/static/voucher/help/南京中小企业信息化服务券管理平台服务商操作手册.pdf" target="_blank" >服务商 </a> <span class="vou-span-line">|</span>
    <a href="/static/voucher/help/南京中小企业信息化服务券管理平台区管理员操作手册.pdf" target="_blank" >管理员 </a>
    <span class="vou-span-line">|</span>
    <a href="/static/voucher/help/2017信息化产品推荐清单.pdf" target="_blank" >信息化产品推荐清单</a>

    <span class="vou-index-tspan">监督电话：68788937</span>
</div>
<div class="vou-index-ts" style="margin-top: 25px;">
    <strong style="display:block;margin-bottom:10px">南京市中小企业信息化服务券各区咨询电话（咨询时间：上午9：00-11:30 下午2:00-5:30）</strong>
    <span style="display: inline-block;margin: 0 20px 10px 0;">江北新区：58155306</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">江宁区：52285135</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">浦口区：68121892</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">六合区：57758548</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">栖霞区：52234893</span><br>
    <span style="display: inline-block;margin: 0 20px 10px 0;">雨花区：52407764</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">溧水区：57421776</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">高淳区：68613183</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">玄武区：83682467</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">秦淮区：84556843</span><br>
    <span style="display: inline-block;margin: 0 20px 10px 0;">建邺区：87778481</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">鼓楼区：83230141</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">南京开发区：85896375</span>
    <span style="display: inline-block;margin: 0 20px 10px 0;">江宁开发区：52111230</span>
</div>

<div class="vou-index-footer"><p>copyright©2017 南京市经济和信息化委员会</p></div>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">