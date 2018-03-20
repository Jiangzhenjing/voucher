<#function isActive url menu>
    <#if url == menu.value>
        <#return "active">
    <#else >
        <#if menu.children == "true" && url?contains(menu.value)>
            <#return "active">
        <#else>
            <#return "">
        </#if>
    </#if>
</#function>

<#macro menu list>
    <#list list as item>
    <li class="${isActive(requestURI, item)}">
        <a href="${item.value}">${item.label}</a>
    </li>
    </#list>
</#macro>
