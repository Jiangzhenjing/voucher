<#assign content>
<form class="form-horizontal" id="Js_form" method="post" action="/voucher/providers/add">
    <div class="form-group">
        <label for="inputNo" class="col-xs-2 control-label">编号</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputNo" placeholder="编号" data-fv-field="pNo" name="pNo"  value="${providerDto.pNo!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputSorto" class="col-xs-2 control-label">登录名</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputSort" placeholder="登录名" name="sortName"  value="${providerDto.sortName!""}">
        </div>
    </div>
    <#if !providerDto.sortName>
        <div class="form-group">
            <label for="inputSorto" class="col-xs-2 control-label">密码</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="inputSort" placeholder="登录名" name="password"  value="123456">
            </div>
        </div>
    </#if>
    <div class="form-group">
        <label for="inputName" class="col-xs-2 control-label">公司名</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputName" placeholder="公司名" name="corpName" value="${providerDto.corpName!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputcontacts" class="col-xs-2 control-label">联系人</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputcontacts" placeholder="联系人" name="contacts" value="${providerDto.contacts!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputphone" class="col-xs-2 control-label">联系电话</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputphone" placeholder="联系电话" name="phoneNo" value="${providerDto.phoneNo!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputaddress" class="col-xs-2 control-label">地址</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputaddress" placeholder="地址" name="address" value="${providerDto.address!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputwebsite" class="col-xs-2 control-label">网址</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputwebsite" placeholder="网址" name="website" value="${providerDto.website!""}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputfax" class="col-xs-2 control-label">传真</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="inputfax" placeholder="传真" name="fax" value="${providerDto.fax!""}">
        </div>
    </div>
    <input type="hidden" name="id" value="${providerDto.id}">
</form>
</#assign>
<#assign script>
<script>
    seajs.use('common/provider/form')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">