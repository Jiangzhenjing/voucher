<#assign content>
<div class="vou-oper">
    <form id="Js_search_form" method="" action="" class="form-inline">
        <div class="form-group">
            <label>服务商：</label>
            <#include "/voucher/common/components/providers.ftl">
        </div>
        <#if roleCode != "regionAdmin">
            <div class="form-group">
                <label>区域：</label>
                <#include "/voucher/common/components/regions.ftl">
            </div>
        </#if>

        <button type="submit">
            <i class="iconfont icon-sousuo"></i>
        </button>
    </form>
</div>
    <div id="Js_table_container" class="vou-table-container">
        <table id="Js_table"></table>
    <div id="Js_pager"></div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('common/analyze/product')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">
