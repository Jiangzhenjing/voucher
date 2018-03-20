<#assign content>
<#if isprovider != "true">
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
</#if>
<div class="vou-statb" id="Js_vou_infor"></div>
</#assign>
<#assign script>
<script>
    seajs.use('common/analyze/comment')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">