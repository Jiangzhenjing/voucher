<#assign content>
<form id="Js_form">
    <div class="form-group">
        <span>*</span>
        <label >服务工程师</label>
        <select name="engineer">
            <option value="">请选择服务工程师</option>
            <option value="">赵春晖</option>
            <option value="">程宇飞</option>
        </select>
    </div>
    <div class="form-group">
        <span>*</span>
        <label >日期</label>
        <input type="text" class="form-control" name="time" placeholder="">
    </div>
    <div class="form-group">
        <span>*</span>
        <label>服务描述</label>
        <textarea name="describe" placeholder=""></textarea>
    </div>
    <div class="form-group">
        <span></span>
        <label>备注</label>
        <textarea placeholder=""></textarea>
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('common/svoucher/servicerecord.js')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">