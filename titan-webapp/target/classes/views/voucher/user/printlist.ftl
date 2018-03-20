<#assign content>
<div class="vou-printlist">
    <div class="vou-print"><button type="button"> 打印</button></div>
    <div class="vou-print-title">服务券信息表</div>
    <p class="vou-print-time">打印时间：2017-11-20</p>
    <table class="vou-print-table">
        <tr>
            <td colspan="4">企业信息</td>
        </tr>
        <tr>
            <td>统一社会信用代码：</td>
            <td>NO:000000000001</td>
            <td>企业名称：</td>
            <td>南京日光生物科技有限公司</td>
        </tr>
        <tr>
            <td>所属区：</td>
            <td>江宁区</td>
            <td>企业规模：</td>
            <td>中型</td>
        </tr>
        <tr>
            <td>法定代表人：</td>
            <td>张三</td>
            <td>成立日期：</td>
            <td>2000-01-01</td>
        </tr>
        <tr>
            <td>联系人：</td>
            <td>李四</td>
            <td>联系电话：</td>
            <td>15366893289</td>
        </tr>
        <tr>
            <td>地址：</td>
            <td colspan="3">南京市江宁区龙眠大道629号</td>
        </tr>
        <tr>
            <td colspan="4">产品信息</td>
        </tr>
        <tr>
            <td>服务商名称：</td>
            <td>用友网络南京分公司</td>
            <td>公司电话：</td>
            <td>13901588262</td>
        </tr>
        <tr>
            <td>联系人：</td>
            <td>张三</td>
            <td>产品名称：</td>
            <td>云监控系统</td>
        </tr>
        <tr>
            <td>价格（￥）：</td>
            <td>10000</td>
            <td>适用对象：</td>
            <td>中小微企业</td>
        </tr>
        <tr>
            <td colspan="4">服务信息</td>
        </tr>
        <tr>
            <div id="Js_table_container" class="vou-table-container">
                <table id="Js_table"></table>
            </div>
        </tr>
    </table>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('user/printlist')
</script>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">