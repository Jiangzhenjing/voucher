<#assign content>
<div class="vou-sign">
    <div style="color: red;font-size: 14px;">${msg!""}</div>
    <div class="vou-sign-title">
        <strong>激活服务券</strong>
    </div>
    <div class="vou-sign-form">
        <form id="defaultForm" method="post" action="/voucher/active" class="form-inline">
            <div class="form-group">
                 <label>服务券号</label>
                 <input type="text" class="form-control" name="voucherNo">
            </div>
            <div class="form-group">
                 <label>企业名称</label>
                 <input type="text" class="form-control" name="corpName">
            </div>
            <div class="form-group">
                 <label>预留手机号</label>
                 <input type="text" class="form-control" name="phoneNo">
            </div>
            <div class="vou-sign-btn">
                <button type="submit" class="vou-voujh">激活</button>
            </div>
        </form>
    </div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('common/voucher/active')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">
