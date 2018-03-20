

<#include "/begin.ftl" />
<#assign layout="single">
<#assign style>
<style>
    body {
        background-color: #e4ecf3;
    }

    .wrapper-content {
        padding: 20px 10px;
        background: url(/system/img/login-bg.png) center no-repeat;
        height: 100%;
    }

    .wrapper-content h1 {
        font-size: 30px;
        position: relative;
        top:-20px;
    }

    .form-control {
        padding-left: 45px;
        height: 48px;
    }

    .form-group {
        position: relative;
    }

    .login-box .fa {
        font-size: 24px;
        position: absolute;
        top: 11px;
        left: 14px;
    }

    .login-box .btn-success {
        height: 48px;
    }
    .login_error_info{
        color: red;
        text-align: center;
        font-size: 16px;
    }
</style>
</#assign>
<#assign scritp>
<script type="text/javascript">
    $(function () {
        // 设置光标在用户名输入框内
        $("input[name='username']").focus();

        //绑定enter按键事件
        $('body').keydown(function (e) {
            var code = (e ? e : event).keyCode;
            // 清除错误提示信息
            $(".login_error_info").html('');
            if (code == 13) {
                $("input[type='submit']").click();
            }
        });
    });
</script>
</#assign>
<#assign content>
<div class="login-box animated fadeInDown">
    <h1 class="logo-name">尚易信息后台管理</h1>
    <div class="middle-box loginscreen ">
        <div>
            <form class="m-t" role="form" action="/login" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="账号" name="name" value="admin"
                           required="">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required="" value="123456"
                           name="passwd">
                    <i class="fa fa-lock"></i>
                </div>
                <div class="form-group">
                    <label>
                        <input name="rememberMe" type="checkbox" checked="checked"/>
                        记住账号
                    </label>
                </div>
                <button type="submit" class="btn btn-success block full-width m-b">登录</button>
            </form>

            <h2 class="color-red login_error_info">${msg!""}</h2>
        </div>
    </div>
</div>
<footer style="position: absolute;bottom:10px;left:0;right:0;font-size:16px;text-align: center;">常州尚易信息科技有限公司</footer>
</#assign>
<#include "/end.ftl" />
