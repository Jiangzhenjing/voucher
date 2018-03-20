<#assign content>
<div class="vou-sign">
    <div class="vou-sign-title">
        <strong>找回密码</strong>
        <ul>
            <li>
                <a href="/login?role=Company">直接登录</a>
            </li>
        </ul>
    </div>
    <div class="vou-sign-form">
        <form id="defaultForm" method="post" action="" class="form-inline">
            <div class="form-group">
                <label class="col-lg-3 control-label">预留手机号</label>
                <input type="text" class="form-control" name="username" id="Js_username" placeholder="填写手机号">
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">验证码</label>
                <input type="text" name="VeriCode" class="form-control vou-sign-yz">
                <input type="button" value="发送验证码" class="vou-button vou-fsyz" id="Js_VeriCode" disabled/>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">新密码</label>
                <input type="password" class="form-control" name="password" placeholder="填写密码" >
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">确认密码</label>
                <input type="password" class="form-control" name="confirmPassword" placeholder="填写密码" >
            </div>
            <div class="vou-sign-btn">
                <button type="submit" class="vou-cz-password">重置密码</button>
            </div>
        </form>

    </div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('company/setting/account')
</script>
</#assign>
<#include "/voucher/layout/loginLayout.ftl">