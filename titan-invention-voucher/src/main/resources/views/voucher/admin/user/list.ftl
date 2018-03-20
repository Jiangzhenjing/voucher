<#assign content>
<div class="vou-oper">
    <form id="Js_search_form" class="form-inline">
        <div class="form-group">
            <label>用户名：</label>
            <input type="text" class="form-control" name="userName" placeholder="用户名">
        </div>
        <div class="form-group">
            <label>角色：</label>
            <select class="form-control" name="roleType">
                <option value="">请选择</option>
                <option value="Provider">服务商</option>
                <option value="Company">企业</option>
                <option value="regionAdmin">区域管理员</option>
                <option value="Admin">总管理员</option>
            </select>
        </div>
        <#if roleCode != "regionAdmin">
            <div class="form-group">
                <label>区域：</label>
                <#include "/voucher/common/components/regions.ftl">
            </div>
        </#if>
        <div class="form-group">
            <label>机构：</label>
            <input type="text" class="form-control" name="userRealName">
        </div>
        <button type="submit">
            <i class="iconfont icon-sousuo"></i>
        </button>
    </form>
    <#if roleCode == "Admin">
        <a class="Js_add">创建用户</a>
    </#if>
</div>
<div id="Js_table_container" class="vou-table-container">
    <table id="Js_table"></table>
    <div id="Js_pager"></div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('admin/user/list')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">
