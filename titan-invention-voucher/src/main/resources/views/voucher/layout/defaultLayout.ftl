<#include "/seajs/vendor.ftl">
<#if roleCode == "Admin" || roleCode == 'regionAdmin'>
    <#include "/voucher/layout/menus/admin.ftl">
</#if>

<#if roleCode == "Provider">
    <#include "/voucher/layout/menus/provider.ftl">
</#if>

<#include "/voucher/common/components/menu.ftl">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>南京中小企业信息化服务券管理平台</title>
    ${vendor}
    <link href="/static/voucher/styles/theme/ts-theme.css" rel="stylesheet">
    <link href="/static/voucher/styles/layout/index.css" rel="stylesheet">
    <link href="/static/voucher/styles/vouindex.css" rel="stylesheet">
    <link href="/static/voucher/styles/iconfont/iconfont.css" rel="stylesheet">
    <script>
        seajs.config({
            base:"/static/voucher/js",
            preload: ["jquery"],
            paths: {
                gallery: "/static/js/gallery",
                custom: "/static/js/custom"
            }
        })
    </script>
</head>
<body class=" full-height-layout">

    <div class="vou-top">
        <ul class="vou-top-left" id="Js_top_left">
            <@menu menuList></@menu>
        </ul>
        <ul class="vou-top-right">
            <li>
                ${userInfo.real_name}
            </li>
            <#if roleCode == "Company">
                <li>
                    <a href="/voucher/company/profile">[企业信息]</a>
                </li>
            </#if>
            <li>
                <a href="/changepw">[修改密码]</a>
            </li>
            <li><a href="/logout">[退出]</a></li>
        </ul>
    </div>
    <div class="vou-centent">
            <div class="wrapper wrapper-content">
            ${content!""}
            </div>
    </div>
    <div class="footer vou-sign-footer">
        copyright©2017 南京市经济和信息化委员会
    </div>
${script!""}

</body>
</html>
