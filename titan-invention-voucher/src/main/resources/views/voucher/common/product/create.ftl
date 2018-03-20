<#assign content>

<form class="form-horizontal" id="Js_form" action="/voucher/products/add" method="post">
    <div class="form-group">
        <label for="inputNo" class="col-xs-2 control-label">编号</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" name="productNo" id="inputNo" placeholder="编号" data-fv-field="productNo" value="${productDto.productNo!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputName" class="col-xs-2 control-label">名称</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" name="productName" id="inputName" placeholder="名称" data-fv-field="productName" value="${productDto.productName!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputType" class="col-xs-2 control-label">类别</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" name="productType" id="inputType" placeholder="类别" data-fv-field="productType" value="${productDto.productType!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPrice" class="col-xs-2 control-label">市场价格</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" name="orginalPrice" id="inputPrice" placeholder="市场价格" data-fv-field="orginalPrice" value="${productDto.orginalPrice!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPriced" class="col-xs-2 control-label">优惠价格</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" name="discountPrice" id="inputPriced" placeholder="优惠价格" data-fv-field="discountPrice" value="${productDto.discountPrice!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPriced" class="col-xs-2 control-label">适应对象</label>
        <div class="col-xs-9">
            <textarea class="form-control" name="suitTarget" rows="4">${productDto.suitTarget!""}</textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPriced" class="col-xs-2 control-label">解决问题</label>
        <div class="col-xs-9">
            <textarea class="form-control" name="solveProblem" rows="4">${productDto.solveProblem!""}</textarea>
        </div>
    </div>
    <input type="hidden" name="providerId" value="${pid}">
    <input type="hidden" name="id" value="${productDto.id!""}">
</form>
</#assign>
<#assign script>
<script>
    seajs.use('common/product/form.js')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">