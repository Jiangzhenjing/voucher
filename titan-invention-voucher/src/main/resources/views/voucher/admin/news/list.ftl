<#assign content>
<div class="vou-oper">
    <div></div>
    <a class="Js_add">添加资讯</a>
</div>
<div id="Js_table_container" class="vou-table-container">
    <table id="Js_table"></table>
    <div id="Js_pager"></div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('admin/news/list')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">