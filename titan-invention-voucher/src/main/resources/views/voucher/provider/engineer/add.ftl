<#assign content>
<form id="Js_form" class="form-horizontal" action="/voucher/provider/engineer/add" method="post">
    <div class="form-group">
        <label for="inputNo" class="col-xs-3 control-label">工程师编号</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputNo" placeholder="工程师编号" data-fv-field="engineerNo" name="engineerNo" >
        </div>
    </div>
    <div class="form-group">
        <label for="inputName" class="col-xs-3 control-label">工程师姓名</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputName" placeholder="工程师姓名" data-fv-field="engineerName" name="engineerName" >
        </div>
    </div>
    <input type="hidden" name="id">
</form>
</#assign>
<#assign script>
<script>
    seajs.use('provider/engineer/form.js')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">
