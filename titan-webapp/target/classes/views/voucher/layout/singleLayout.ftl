<#include "/seajs/vendor.ftl">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    ${vendor}
    <script>
        seajs.config({
            base:"/voucher/js"
        })
    </script>
    <link href="/system/style/theme/ts-theme.css" rel="stylesheet">
    <link href="/system/style/layout/index.css" rel="stylesheet">
    <link href="/voucher/styles/vouindex.css" rel="stylesheet">
    <link href="/voucher/styles/iconfont/iconfont.css" rel="stylesheet">
    ${style!""}
</head>
<body>
    <div class="vou-wapper">
        ${content!""}
    </div>
    ${script!""}
</body>
</html>
