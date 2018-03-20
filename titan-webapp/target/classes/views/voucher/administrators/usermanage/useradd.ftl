<#assign content>
<form id="Js_form">
    <div class="form-group">
        <span>*</span>
        <label >用户名</label>
        <input type="text" class="form-control" name="username" placeholder="">
    </div>
    <div class="form-group">
        <span>*</span>
        <label >密码</label>
        <input type="text" class="form-control" name="password">
    </div>
    <div class="form-group">
        <span></span>
        <label >角色</label>
        <select name="role">
            <option value="admin">管理员</option>
            <option value="district">区管理员</option>
            <option value="service">服务商</option>
        </select>
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('administrators/usermanage/useradd')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">