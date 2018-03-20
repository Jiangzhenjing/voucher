<#assign content>
<form class="form-horizontal" id="Js_form" action="/voucher/admin/user/add" method="post">
    <div class="form-group">
        <label for="inputName" class="col-xs-2 control-label">用户名</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputName" placeholder="用户名" data-fv-field="userName" name="userName" >
        </div>
    </div>
    <div class="form-group">
        <label for="inputpassword" class="col-xs-2 control-label">密码</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputpassword" placeholder="密码" data-fv-field="password" name="password">
        </div>
    </div>
    <div class="form-group">
        <label for="inputpassword" class="col-xs-2 control-label">角色</label>
        <div class="col-xs-9">
            <select name="roleType" class="form-control">
                <option value="Admin">管理员</option>
                <option value="regionAdmin">区管理员</option>
            </select>
        </div>
    </div>
    <div class="form-group" id="Js_regionAdmin" style="display: none">
        <label for="inputpassword" class="col-xs-2 control-label">区域</label>
        <div class="col-xs-9">
            <#include "/voucher/common/components/regions.ftl">
        </div>
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('admin/user/form')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">
