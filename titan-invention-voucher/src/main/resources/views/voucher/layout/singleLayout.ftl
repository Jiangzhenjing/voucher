<#include "/seajs/vendor.ftl">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>南京中小企业信息化服务券管理平台</title>
    ${vendor}
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
    <link href="/static/voucher/styles/theme/ts-theme.css" rel="stylesheet">
    <link href="/static/voucher/styles/layout/index.css" rel="stylesheet">
    <link href="/static/voucher/styles/vouindex.css" rel="stylesheet">
    <link href="/static/voucher/styles/iconfont/iconfont.css" rel="stylesheet">
    ${style!""}
</head>
<body>
    <div class="modal-body">
        ${content!""}
    </div>
    ${script!""}
</body>
</html>
