<#assign content>
<div class="vou-sign">
    <div class="vou-sign-title">
        <strong>管理员登录</strong>
        <ul>
            <li>
                <a href="/voucher/common/homepg">返回首页</a>
            </li>
        </ul>
    </div>
    <div class="vou-sign-form">
        <form>
                <span>
                    <label>账号</label>
                    <input type="text" name="">
                </span>
            <span>
                    <label>密码</label>
                    <input type="password" name="">
                </span>
            <span>
                    <label>验证码</label>
                    <input type="text" name="" class="vou-sign-yz">
                    <div class="vou-yz-img">

                    </div>
                </span>
            <div class="vou-sign-btn">
                <button type="submit">登录</button>
            </div>
        </form>
    </div>
    <div class="vou-sign-explain">
        <strong>服务券说明</strong>
        <p>1、收到服务券20个工作日内需网上确认激活，激活后20个工作日内需选定产品和服务商，如过期视为放弃；</p>
        <p>2、本券为实名制发放，不得转让其他企业使用，转让自动失效；</p>
        <p>3、不得弄虚作假，一经核实，此券作废。</p>
    </div>
</div>
</#assign>
<#include "/voucher/layout/signLayout.ftl">