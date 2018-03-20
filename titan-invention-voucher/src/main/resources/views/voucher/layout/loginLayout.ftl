<#include "/seajs/vendor.ftl">
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
<div class="vou-sign-top">
    <p>南京中小企业信息化服务券管理平台</p>
</div>
<div class="wrapper wrapper-content vou-sign-centent">
    ${content!""}
</div>
<div class="footer vou-sign-footer">
    copyright©2017 南京市经济和信息化委员会
</div>
${script!""}
</body>
</html>
