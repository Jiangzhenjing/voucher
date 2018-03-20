<#assign content>
<form id="Js_form">
    <div class="form-group">
        <span>*</span>
        <label >工程师编号</label>
        <input type="text" class="form-control" name="number" placeholder="">
    </div>
    <div class="form-group">
        <span>*</span>
        <label >工程师姓名</label>
        <input type="text" class="form-control" name="name" placeholder="">
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('serviceprovider/engineeraddform')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">