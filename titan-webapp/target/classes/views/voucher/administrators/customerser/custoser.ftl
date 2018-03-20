<#assign content>
<div class="vou-oper">
    <form id="Js_search_form">
        <div class="vou-search-mor">
            <div class="vou-search1">
                <label>客户名称：</label>
                <input type="text" name="" placeholder="客户名称">
                <label>是否关联服务券：</label>
                <select>
                    <option value="all">全部</option>
                    <option value="yes">已关联</option>
                    <option value="no">未关联</option>
                </select>
            </div>
            <button type="submit">
                <i class="iconfont icon-sousuo"></i>
            </button>
        </div>
    </form>
</div>
<div id="Js_table_container" class="vou-table-container">
    <table id="Js_table"></table>
    <div id="Js_pager"></div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('administrators/custoser')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">