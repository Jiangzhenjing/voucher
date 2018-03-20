<#assign content>
<form id="Js_form">
    <div class="form-group">
        <span>*</span>
        <label >日期</label>
        <input type="text" class="form-control" name="time" placeholder="">
    </div>
    <div class="form-group vou-form-group">
        <span>*</span>
        <label >企业类型</label>
        <div class="vou-form1">
            <label class="vou-label">
                <input type="checkbox" name="type">
                中型企业
            </label>
            <label class="vou-label">
                <input type="checkbox" name="type">
                小型企业
            </label>
            <label class="vou-label">
                <input type="checkbox" name="type">
                微型企业
            </label>
            <label class="vou-label">
                <input type="checkbox" name="type">
                初创型企业
            </label>
            <label class="vou-label">
                <input type="checkbox" name="type">
                专精特新企业
            </label>
            <label class="vou-label">
                <input type="checkbox" name="type">
                监测点企业
            </label>
        </div>
    </div>
    <div class="form-group">
        <span>*</span>
        <label>交付描述</label>
        <textarea name="describe"></textarea>
    </div>
</form>
</#assign>
<#assign script>
<script>
    seajs.use('common/svoucher/voudetailsform')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">