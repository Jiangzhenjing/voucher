<#assign content>
    <form id="Js_form">
        <div class="form-group">
            <span>*</span>
            <label>服务券号</label>
            <input type="text" class="form-control" name="ticketnumber">
        </div>
        <div class="form-group">
            <span>*</span>
            <label >企业名称</label>
            <input type="text" class="form-control" name="enterprisename" >
        </div>
        <div class="form-group">
            <span>*</span>
            <label >法人代表</label>
            <input type="text" class="form-control" name="name" >
        </div>
        <div class="form-group">
            <span>*</span>
            <label >手机号(登录账号)</label>
            <input type="text" class="form-control" name="phone" >
        </div>
        <div class="form-group">
            <span>*</span>
            <label >地址</label>
            <select name="region">
                <option></option>
            </select>
        </div>
        <div class="form-group">
            <span>*</span>
            <label >联系人</label>
            <input type="text" class="form-control" name="contacts" >
        </div>
        <div class="form-group">
            <span>*</span>
            <label >联系电话</label>
            <input type="text" class="form-control" name="phonesj" >
        </div>
        <div class="form-group">
            <span>*</span>
            <label >QQ号</label>
            <input type="text" class="form-control" name="qq" >
        </div>
        <div class="form-group">
            <span>*</span>
            <label >微信</label>
            <input type="text" class="form-control" name="weixin" >
        </div>
        <div class="form-group">
            <span></span>
            <label >Email</label>
            <input type="text" class="form-control" name="" >
        </div>
    </form>
</#assign>
<#assign script>
    <script>
        seajs.use('common/svoucher/vouform')
    </script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">