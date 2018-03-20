<#assign content>
<form class="form-horizontal" id="Js_form" action="/voucher/${id}/slogs" method="post">
    <div class="form-group">
        <label for="inputengineer" class="col-xs-3 control-label">服务工程师</label>
        <div class="col-xs-8">
            <select class="form-control" name="serviceEngineer">
                <option value="">请选择服务工程师</option>
                <#list engineers as engineer>
                    <option value="${engineer.engineerName}">${engineer.engineerName}</option>
                </#list>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="inputdata" class="col-xs-3 control-label">日期</label>
        <div class="col-xs-8">
            <input type="text" class="form-control Js_date-picker" id="inputdata" placeholder="日期" name="serviceDate">
        </div>
    </div>
    <div class="form-group">
        <label for="inputdata" class="col-xs-3 control-label">服务描述</label>
        <div class="col-xs-8">
            <textarea class="form-control" name="serviceDesc" placeholder="200字之内" maxlength="200"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="inputdata" class="col-xs-3" control-label">备注</label>
        <div class="col-xs-8">
            <textarea class="form-control" name="remark" maxlength="200" placeholder="200字之内"></textarea>
        </div>
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('common/voucher/service.js')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">