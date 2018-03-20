<#assign content>
<form class="form-horizontal" id="Js_form" method="post" action="/voucher/admin/user/resetpw">
    <div class="form-group">
        <label for="inputpassword" class="col-xs-3 control-label">输入新密码</label>
        <div class="col-xs-6">
            <input type="password" class="form-control"  placeholder="输入新密码" name="pw" >
        </div>
        <input type="hidden" name="id" value="${id}">
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('admin/user/resetpw')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">
