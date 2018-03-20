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
<div class="vou-sign-top">
    <p>南京中小企业信息化服务券管理平台</p>
</div>
<div class="wrapper wrapper-content vou-sign-centent">
${content!""}
</div>
<div class="footer vou-sign-footer">
    copyright©2016 南京市经济和信息化委员会
</div>
${script!""}

<script>
    seajs.use("/system/js/layout/index")
</script>

</body>
</html>
