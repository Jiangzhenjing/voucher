<#assign content>
<style media="print">
    .vou-print {
        display: none;
    }
</style>
<div class="vou-printlist">
    <div class="vou-print"><button type="button" onclick="javascript:window.print();"> 打印</button></div>
    <div class="vou-print-title">南京市中小企业信息化服务券服务评价表</div>
    <p class="vou-print-time">服务产品名称：${providerInfo.corpName}</p>
    <table class="table table-bordered">
        <tr>
            <td>企业名称：</td>
            <td>${companyDto.companyName!""}</td>
            <td>服务券编号：</td>
            <td>${voucherInfo.voucherNo!""}</td>
        </tr>
        <tr>
            <td>服务机构：</td>
            <td>${providerInfo.corpName!""}</td>
            <td>服务人员编号：</td>
            <td>12321</td>
        </tr>
        <tr>
            <td>签约时间：</td>
            <td>${voucherInfo.signDate!""}</td>
            <td>交付时间：</td>
            <td>${voucherInfo.handDate!""}</td>
        </tr>
        <tr>
            <td colspan="4" align="center">评价</td>
        </tr>
        <tr>
            <td>序号：</td>
            <td colspan="2">评分标准：</td>
            <td>分数</td>
        </tr>
        <tr>
            <td>1</td>
            <td colspan="2">服务主动、耐心、热情、周到 （0-10分）</td>
            <td>${voucherInfo.sc01!""}</td>
        </tr>
        <tr>
            <td>2</td>
            <td colspan="2">服务人员具有充分的专业知识（0-10分）</td>
            <td>${voucherInfo.sc02!""}</td>
        </tr>
        <tr>
            <td>3</td>
            <td colspan="2">服务人员佩戴证件，行为规范（0-10分）</td>
            <td>${voucherInfo.sc03!""}</td>
        </tr>
        <tr>
            <td>4</td>
            <td colspan="2">服务合同执行到位不打折扣（0-15分）</td>
            <td>${voucherInfo.sc04!""}</td>
        </tr>
        <tr>
            <td>5</td>
            <td colspan="2">服务产品高质量交付（0-15分）</td>
            <td>${voucherInfo.sc05!""}</td>
        </tr>
        <tr>
            <td>6</td>
            <td colspan="2">产品价格优惠性价比高（0-15分）</td>
            <td>${voucherInfo.sc06!""}</td>
        </tr>
        <tr>
            <td>7</td>
            <td colspan="2">产品贴合工作实际方便易用（0-10分）</td>
            <td>${voucherInfo.sc07!""}</td>
        </tr>
        <tr>
            <td>8</td>
            <td colspan="2">售后服务响应及时问题快速解决（0-15分）</td>
            <td>${voucherInfo.sc08!""}</td>
        </tr>
        <tr>
            <td colspan="3" align="center">合计</td>
            <td>${voucherInfo.totalScore!""}</td>
        </tr>
        <tr>
            <td colspan="4">备注：90-100为优秀，80-90为良好，60-80为合格，60以下为不合格</td>
        </tr>
        <tr>
            <td colspan="4">
                <div class="form-group">
                    <label class="col-xs-2 control-label">意见和建议</label>
                    <div class="col-xs-10" style="min-height: 100px;">${voucherInfo.evaluateContent!""}</div>
                </div>
            </td>
        </tr>
    </table>
    <div class="print-sign">企业负责人签字(盖章)：</div>
    <div class="print-data">
        <ul>
            <li></li>
            <li>年</li>
            <li></li>
            <li>月</li>
            <li></li>
            <li>日</li>
        </ul>
    </div>
</div>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">
