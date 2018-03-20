<select name="providerId" class="form-control">
    <option value="">请选择</option>
    <#list providerList as provider>
        <option value="${provider.id}" <#if provider.id == selectedProviderId>selected</#if>>${provider.corpName}</option>
    </#list>
</select>