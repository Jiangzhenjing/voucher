<#include "/voucher/common/components/companytype.ftl">
<#assign content>
<form class="form-horizontal" id="Js_form" method="post" action="/voucher/${id}/callback">

    <div class="form-group">
        <label for="inputdata" class="col-xs-2 control-label">撤回理由</label>
        <div class="col-xs-9">
            <textarea class="form-control" name="reason"></textarea>
        </div>
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('common/voucher/commit')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">
