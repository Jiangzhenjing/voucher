<#assign content>
<div class="vou-sign">
    <div class="vou-sign-title">
        <strong>激活服务券</strong>
        <ul>
            <li>
                <a href="/voucher/user/usersign">直接登录</a>
            </li>
        </ul>
    </div>
    <div class="vou-sign-form">
        <form method="get" action="/voucher/user/contentpage.ftl">
            <span>
                    <label>服务券号</label>
                    <input type="text" name="">
                </span>
            <span>
                    <label>企业名称</label>
                    <input type="text" name="">
                </span>
            <span>
                    <label>预留手机号</label>
                    <input type="text" name="">
                </span>
            <span>
                    <label>新密码</label>
                    <input type="password" name="">
                </span>
            <span>
                    <label>校验码</label>
                    <input type="text" name="" class="vou-sign-yz">
                    <div class="vou-yz-img">

                    </div>
                </span>
            <div class="vou-sign-btn">
                <button type="submit">激活</button>
            </div>
        </form>
    </div>
</div>
</#assign>
<#include "/voucher/layout/signLayout.ftl">