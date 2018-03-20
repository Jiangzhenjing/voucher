<#assign content>
<div class="vou-infor-data">
    <div class="vou-infordata-nav">
        <ul>
            <li>
                <a href="/">首页</a>
            </li>
            <li>></li>
            <li>
                <a href="/news">实时资讯</a>
            </li>
            <li>></li>
            <li>
                <a class="infordata-xz">${newInfo.title!""}</a>
            </li>
        </ul>
    </div>
    <div class="infor-data">
        <h2>
            <span>${newInfo.title!""}</span>
            <em>${newInfo.issueTime!""}</em>
        </h2>
        <p>${newInfo.content!""}</p>
    </div>
</div>
</#assign>

<#include "/voucher/layout/loginLayout.ftl">
