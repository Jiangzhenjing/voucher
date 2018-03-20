<#assign content>
    <form id="Js_search_form">
        <input type="text" name="test">
        <input type="submit" value="检索">
    </form>
    <div id="Js_table_container">
        <table id="Js_table"></table>
        <div id="Js_pager"></div>
    </div>
</#assign>

<#assign script>
<script>
    seajs.use('index/index')
</script>
</#assign>

<#include "/voucher/layout/defaultLayout.ftl">
