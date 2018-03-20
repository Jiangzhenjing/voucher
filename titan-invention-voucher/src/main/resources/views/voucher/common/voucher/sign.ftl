<#include "/voucher/common/components/companytype.ftl">
<#assign content>
<form class="form-horizontal" id="Js_form" method="post" action="/voucher/${id}/sign">
    <div class="form-group">
        <label for="inputdata" class="col-xs-2 control-label">日期</label>
        <div class="col-xs-9">
            <input type="text" class="form-control Js_date-picker" id="inputdata" placeholder="日期"
                   data-fv-field="data" name="time" >
        </div>
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('common/voucher/sign')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">
