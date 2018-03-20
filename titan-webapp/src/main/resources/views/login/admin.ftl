<#assign content>
<div class="vou-sign">
    <div class="vou-sign-title">
        <strong>管理员登录</strong>
        <ul>
            <li>
                <a href="/">返回首页</a>
            </li>
        </ul>
    </div>
    <div class="vou-sign-form">
        <form id="defaultForm" method="post" action="/login?role=admin" class="form-inline" >
            <div class="form-group">
                <label class="col-lg-3 control-label">账号</label>
                <input type="text" class="form-control" name="username" placeholder="账户名" autocomplete="off">
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">密码</label>
                <input type="password" class="form-control" name="password" placeholder="密码" autocomplete="off">
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">验证码</label>
                <input type="text" name="jcaptchaCode" class="form-control vou-sign-yz">
                <div class="vou-yz-img">
                    <img class="jcaptcha-btn jcaptcha-img" src="/jcaptcha.jpg" title="点击更换验证码">
                </div>
            </div>
            <h3 class=" login_error_info" style="color: red">${msg!""}</h3>
            <div class="vou-sign-btn">
                <button type="submit">登录</button>
            </div>
        </form>
    </div>
    <div class="vou-sign-explain">
        <strong>服务券说明</strong>
        <p>1、收到服务券15日内需网上确认激活，收到服务券30日内需选定产品和服务商，如过期视为放弃；</p>
        <p>2、本券为实名制发放，不得转让其他企业使用，转让自动失效；</p>
        <p>3、不得弄虚作假，一经核实，此券作废。</p>
    </div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('login/index.js')
</script>
</#assign>
<#include "/voucher/layout/loginLayout.ftl">
