<#assign content>
<div class="vou-sign">
    <div class="vou-sign-title">
        <strong>修改密码</strong>
    </div>
    <div class="vou-sign-form">
        <form id="defaultForm" method="post" action="/changepw" class="form-inline">
            <div class="form-group">
                <label>原密码</label>
                <input type="password" class="form-control" name="oldpassword" autocomplete="off">
            </div>
            <div class="form-group">
                <label>新密码</label>
                <input type="password" class="form-control" name="newpassword" autocomplete="off">
            </div>
            <div class="form-group">
                <label>确认新密码</label>
                <input type="password" class="form-control" name="confirmpassword" autocomplete="off">
            </div>
            <div class="vou-sign-btn">
                <button type="submit" class="vou-findpw">修改密码</button>
            </div>
        </form>
    </div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('login/changepw')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">
