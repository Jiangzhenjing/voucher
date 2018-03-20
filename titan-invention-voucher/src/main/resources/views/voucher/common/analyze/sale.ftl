<#include "/voucher/common/components/companytype.ftl">
<#assign content>
<div class="vou-oper">
        <form id="Js_search_form" method="" action="" class="form-inline">
            <#if isprovider != "true">
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
                <div class="form-group">
                    <label>产品：</label>
                    <input type="text" class="form-control" name="productType">
                </div>
                <div class="form-group">
                    <label>企业类型：</label>
                    <select name="corpType" class="form-control">
                        <@companyType ""></@companyType>
                    </select>
                </div>
            </#if>
            <div class="form-group">
                <label>评价：</label>
                <select name="serviceLevel" class="form-control">
                    <option value="">请选择</option>
                    <option value="A" <#if serviceLevel == "A">selected</#if>>优</option>
                    <option value="B" <#if serviceLevel == "B">selected</#if>>良</option>
                    <option value="C" <#if serviceLevel == "C">selected</#if>>中</option>
                    <option value="D" <#if serviceLevel == "D">selected</#if>>差</option>
                </select>
            </div>
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
    seajs.use('common/analyze/sale')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">
