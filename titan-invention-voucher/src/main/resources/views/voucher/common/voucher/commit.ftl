<#include "/voucher/common/components/companytype.ftl">
<#assign content>
<form class="form-horizontal" id="Js_form" method="post" action="/voucher/${id}/handle">
    <div class="form-group">
        <label for="inputdata" class="col-xs-2 control-label">日期</label>
        <div class="col-xs-9">
            <input type="text" class="form-control Js_date-picker" id="inputdata" placeholder="日期"
                   data-fv-field="data" name="handDate" value="${voucherInfo.handDate!""}">
        </div>
    </div>
    <#--<div class="form-group">-->
        <#--<label for="inputdata" class="col-xs-2 control-label">企业类型</label>-->
        <#--<div class="col-xs-9">-->
            <#--<select class="form-control" name="corpType">-->
                <#--<@companyType (voucherInfo.corpType)!""></@companyType>-->
            <#--</select>-->
        <#--</div>-->

    <#--</div>-->
    <div class="form-group">
        <label for="inputdata" class="col-xs-2 control-label">交付描述</label>
        <div class="col-xs-9">
            <textarea class="form-control" name="handContent" maxlength="200" placeholder="200字之内">${voucherInfo.handContent!""}</textarea>
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
