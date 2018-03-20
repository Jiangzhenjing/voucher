<#--<#macro select options>-->
    <#--<#if options??>-->
        <#--<#list options as option>-->
            <#--<option value="${option.value!""}">${option.label!""}</option>-->
        <#--</#list>-->
    <#--</#if>-->
<#--</#macro>-->

    <#if roleCode == "regionAdmin">
        <input type="hidden" name="regionId" value="${userInfo.org_id}">
    <#else >
        <select name="regionId" id="Js_region" class="form-control">
            <option value="">请选择</option>
            <#list regions as region>
                <option value="${region.key!""}" <#if selectedRegion == region.key>selected</#if>>${region.value!""}</option>
            </#list>
        </select>
        <input type="hidden" name="region" value="${userInfo.org_name}">
    </#if>

<script>
    $("#Js_region").change(function () {
    	var $this = $(this)
    	$("[name=region]").val($this.val() ? $this.find("option:selected").text() : "")
    }).trigger("change")
</script>

