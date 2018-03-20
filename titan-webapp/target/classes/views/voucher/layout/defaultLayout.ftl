<#include "/seajs/vendor.ftl">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    ${vendor}
    <link href="/system/style/theme/ts-theme.css" rel="stylesheet">
    <link href="/system/style/layout/index.css" rel="stylesheet">
    <link href="/voucher/styles/vouindex.css" rel="stylesheet">
    <link href="/voucher/styles/iconfont/iconfont.css" rel="stylesheet">
    <script>
        seajs.config({
            base:"/voucher/js"
        })
    </script>
</head>
<body class=" full-height-layout">
    <div class="vou-top">
        <div class="vou-title">南京中小企业信息化服务券管理平台</div>
        <ul class="vou-top-left" id="Js_top_left">
            <li>
                <a href="/voucher/common/svoucher/voucherlist.ftl">服务券</a>
            </li>
            <li class="active">
                <a href="/voucher/administrators/provider/providerlist.ftl">服务商</a>
            </li>
            <li>
                <a href="/voucher/administrators/usermanage/userlist.ftl">客户服务</a>
            </li>
            <li>
                <a href="/voucher/administrators/usermanage/userlist.ftl">用户管理</a>
            </li>
            <li>
                <a href="/voucher/administrators/productsta.ftl">产品统计</a>
            </li>
            <li>
                <a href="/voucher/administrators/saleasta.ftl">销售统计</a>
            </li>
            <li>
                <a href="/voucher/common/vouchersta/vstatistics.ftl">服务券统计</a>
            </li>
            <li>
                <a href="/voucher/administrators/evaluasta.ftl">评价统计</a>
            </li>
            <li>服务商：</li>
            <li>
                <a href="/voucher/common/svoucher/voucherlist.ftl">服务券</a>
            </li>
            <li class="active">
                <a href="/voucher/serviceprovider/personnelma.ftl">人员管理</a>
            </li>
            <li>
                <a href="/voucher/common/vouchersta/vstatistics.ftl">服务券统计</a>
            </li>
            <li>用户：</li>
            <li>
                <a href="/voucher/user/perfectdata.ftl">用户登录页面</a>
            </li>
        </ul>
        <ul class="vou-top-right">
            <li>
                admin
            </li>
            <li>
                <a href="/voucher/common/mypassword.ftl">[修改密码]</a>
            </li>
            <li><a href="/voucher/common/homepg.ftl">[退出]</a></li>
        </ul>
    </div>
    <div class="vou-centent">
            <div class="wrapper wrapper-content">
            ${content!""}
            </div>
            <div class="footer vou-sign-footer">
                copyright©2017 南京市经济和信息化委员会
            </div>
    </div>

${script!""}

<script>
    seajs.use("/system/js/layout/index");
    seajs.use("/voucher/js/common/commonjs.js")
</script>

</body>
</html>
