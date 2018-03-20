<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inneral Error</title>
    <style type="text/css">
        body,div,p,a{
            margin: 0;
            padding: 0;
        }
        .waiting {
            position: absolute;
            top: 40%;
            left: 50%;
            margin-top: -140px;
            margin-left: -473px;
            width: 946px;
            text-align: center;
            background: #fbfbfb;
        }
        .error-btn{
            position: absolute;
            right: 0;
            top: 60px;
        }
        .error-btn a{
            display: inline-block;
            margin: 40px 10px 0;
            width: 148px;
            height: 50px;
            line-height: 50px;
            color: #fff;
            text-decoration: none;
            background: #4caf50;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="waiting">
    <img src="/static/voucher/images/f5.jpg"/>
    <div class="error-btn">
        <#--<a href="javascript:history.go(-1)">返回上一级</a>-->
        <a href="/index">返回首页</a>
    </div>
</div>
</body>
</html>