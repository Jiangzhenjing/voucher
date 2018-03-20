<#assign content>
<div class="vou-oper">
    <form>
    </form>
    <a class="Js_add">添加服务工程师</a>
</div>
<div id="Js_table_container" class="vou-table-container">
    <table id="Js_table"></table>
    <div id="Js_pager"></div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('provider/engineer/list.js')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">
