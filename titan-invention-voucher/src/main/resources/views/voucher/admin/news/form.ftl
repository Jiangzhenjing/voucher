<#assign style>
    <link href="/static/voucher/js/lib/themes/default/default.css" rel="stylesheet">
</#assign>
<#assign content>
<form class="form-horizontal" id="Js_form" action="/voucher/admin/news/add" method="post">
    <div class="form-group">
        <label for="inputName" class="col-xs-2 control-label">标题</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" placeholder="标题" name="title" value="${newsInfo.title!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputpassword" class="col-xs-2 control-label">内容</label>
        <div class="col-xs-9">
            <textarea name="content" id="Js_content" style="display: none;width:500px;height:200px" class="form-control">${newsInfo.content!""}</textarea>
        </div>
    </div>
    <input type="hidden" value="${newsInfo.id!""}" name="id">
</form>
</#assign>
<#assign script>
<script src="/static/voucher/js/lib/kindeditor-min.js"></script>
<script src="/static/voucher/js/lib/zh-CN.js"></script>
<script>
    seajs.use('admin/news/form')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">
