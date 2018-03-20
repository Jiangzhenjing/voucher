<#assign content>
<div class="vou-details">
    <div class="vou-deta-infor">
        <div class="vou-deta-title">
            <strong>服务商信息</strong>
            <a href="javascript:;" id="Js_eidt">编辑</a>
        </div>
        <ul class="vou-pro-ul">
            <li>
                <span>编号<em>*</em>：</span>
                <input type="text" name="">
            </li>
            <li>
                <span>公司名<em>*</em>：</span>
                <input type="text" name="" value="江苏巨成软件科技有限公司" disabled="disabled">
            </li>
            <li>
                <span>联系人：</span>
                <input type="text" name="">
            </li>
            <li>
                <span>联系电话：</span>
                <input type="text" name="">
            </li>
            <li>
                <span>地址：</span>
                <input type="text" name="">
            </li>
            <li>
                <span>网址：</span>
                <input type="text" name="">
            </li>
            <li>
                <span>传真：</span>
                <input type="text" name="">
            </li>
            <li>
                <button type="button" id="Js_preser">保存</button>
            </li>
        </ul>
    </div>
    <div class="vou-deta-infor">
        <div class="vou-deta-title">
            <strong>产品列表</strong>
            <a class="Js_add">添加产品</a>
        </div>
        <div id="Js_table_container" class="vou-table-container">
            <table id="Js_table"></table>
            <div id="Js_pager"></div>
        </div>
    </div>

</div>
</#assign>
<#assign script>
<script>
    seajs.use('administrators/provider/provideradd')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">