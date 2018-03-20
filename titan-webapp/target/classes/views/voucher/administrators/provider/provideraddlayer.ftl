<#assign content>
<form id="Js_form">
    <div class="form-group">
        <span>*</span>
        <label >编号</label>
        <input type="text" class="form-control" name="number" placeholder="">
    </div>
    <div class="form-group">
        <span>*</span>
        <label >公司名</label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="form-group">
        <span></span>
        <label >联系人</label>
        <input type="text" class="form-control">
    </div>
    <div class="form-group">
        <span></span>
        <label >联系电话</label>
        <input type="text" class="form-control">
    </div>
    <div class="form-group">
        <span></span>
        <label >地址</label>
        <input type="text" class="form-control">
    </div>
    <div class="form-group">
        <span></span>
        <label >网址</label>
        <input type="text" class="form-control" >
    </div>
    <div class="form-group">
        <span></span>
        <label >传真</label>
        <input type="text" class="form-control" name="" >
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('administrators/provider/provideraddlayer')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">