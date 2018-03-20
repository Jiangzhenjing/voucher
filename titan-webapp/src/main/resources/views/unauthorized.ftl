<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>unauthorized</title>
    <style type="text/css">
        body,div,p,a{
            margin: 0;
            padding: 0;
        }
        .waiting {
            position: absolute;
            top: 40%;
            margin-top: -130px;
            width: 100%;
            text-align: center;
            background: #fbfbfb;
        }
        .waiting p {
            margin: 10px;
            font-size: 16px;
            color: #5d5d5d;
        }
        .waiting a{
            display: inline-block;
            margin: 20px 10px 0;
            width: 108px;
            height: 36px;
            line-height: 36px;
            font-size: 14px;
            color: #fff;
            text-decoration: none;
            background: #4caf50;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="waiting">
    <img src="/static/voucher/images/unauth.jpg"/>
    <p>温馨提示：未授权，您没有权限访问！</p>
    <a href="/logout">切换账号</a>
    <a href="/index">返回首页</a>
</div>
</body>
</html>