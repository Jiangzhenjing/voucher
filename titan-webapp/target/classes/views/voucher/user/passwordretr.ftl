<#assign content>
<div class="vou-sign">
    <div class="vou-sign-title">
        <strong>找回密码</strong>
        <ul>
            <li>
                <a href="/voucher/user/usersign">直接登录</a>
            </li>
        </ul>
    </div>
    <div class="vou-sign-form">
        <form>
                <span>
                    <label>预留手机号</label>
                    <input type="text" name="">
                </span>
            <span>
                    <label>新密码</label>
                    <input type="password" name="">
                </span>
            <span>
                    <label>确认密码</label>
                    <input type="password" name="">
                </span>
            <span>
                    <label>短信验证码</label>
                    <input type="text" name="" class="vou-sign-yz">
                    <a class="vou-button">发送验证码</a>
                </span>
            <div class="vou-sign-btn">
                <button type="submit">重置密码</button>
            </div>
        </form>
    </div>
</div>
</#assign>
<#include "/voucher/layout/signLayout.ftl">