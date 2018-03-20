<#assign content>
<div class="vou-infor-data">
    <div class="vou-infordata-nav">
        <ul>
            <li>
                <a href="/">首页</a>
            </li>
            <li>></li>
            <li>
                <a class="infordata-xz">实时资讯</a>
            </li>
        </ul>
    </div>
    <div>
        <ul class="vou-infor-ul">
            <#list news as new>
                 <li>
                     <a href="/news/${new.id}" target="_blank">
                         <div></div>
                         <span>${new.title!""}</span>
                         <em>${new.issueTime!""}</em>
                     </a>
                 </li>
            </#list>
        </ul>
    </div>
</div>
</#assign>

<#include "/voucher/layout/loginLayout.ftl">
