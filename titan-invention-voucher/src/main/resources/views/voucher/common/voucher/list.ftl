<#assign content>
<div class="vou-oper">
    <form id="Js_search_form" method="" action="" class="form-inline">

            <div class="form-group">
                <label>服务券号：</label>
                <input type="text" class="form-control" name="voucherNo" placeholder="服务券号">
            </div>
            <div class="form-group">
                <label>服务商：</label>
                <#include "/voucher/common/components/providers.ftl">
            </div>
            <div class="form-group">
                <label>企业名称：</label>
                <input type="text" class="form-control" name="corpName" placeholder="企业名称">
            </div>
            <#if roleCode != "regionAdmin">
                <div class="form-group">
                    <label>区域：</label>
                    <#include "/voucher/common/components/regions.ftl">
                </div>
            </#if>
            <div class="form-group">
                <label>状态：</label>
                <select class="form-control" name="voucherStatus">
                    <#include "/voucher/common/components/vouchertypes.ftl">
                </select>
            </div>
            <button type="submit">
                <i class="iconfont icon-sousuo"></i>
            </button>
            <a href="/voucher/download" class="Js_download cs-down" target="_blank">导出</a>
    </form>
</div>
<div id="Js_table_container" class="vou-table-container">
    <table id="Js_table"></table>
    <div id="Js_pager"></div>
</div>
    <#if type == 'provider'>
    <input type="hidden" id="Js_isProvider" value="true">
    </#if>
</#assign>
<#assign script>
<script>
    seajs.use('common/voucher/list')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">