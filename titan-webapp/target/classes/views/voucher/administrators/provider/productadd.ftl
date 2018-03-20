<#assign content>
<form id="Js_form">
    <div class="form-group">
        <span></span>
        <label >编号</label>
        <input type="text" class="form-control" name="" placeholder="">
    </div>
    <div class="form-group">
        <span>*</span>
        <label >名称</label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="form-group">
        <span>*</span>
        <label >类别</label>
        <input type="text" class="form-control" name="type">
    </div>
    <div class="form-group">
        <span>*</span>
        <label >市场价格</label>
        <input type="text" class="form-control" name="marketprice" >
    </div>
    <div class="form-group">
        <span>*</span>
        <label >优惠价格</label>
        <input type="text" class="form-control" name="favorableprice" >
    </div>
    <div class="form-group">
        <span></span>
        <label >适应对象</label>
        <textarea></textarea>
    </div>
    <div class="form-group">
        <span></span>
        <label >解决问题</label>
        <textarea></textarea>
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('administrators/provider/productaddform.js')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">