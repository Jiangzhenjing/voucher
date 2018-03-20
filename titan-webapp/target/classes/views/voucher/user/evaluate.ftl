<#assign content>
<form id="Js_form">
    <div class="form-group">
        <div class="vou-eval-div">问题</div>
        <label class="vou-eval-label"><input type="radio" name="evaluate">已解决</label>
        <label class="vou-eval-label"><input type="radio" name="evaluate">未解决</label>
    </div>
    <div class="form-group">
    <table>
        <tr class="vou-tr-bt">
            <td width="60">序号</td>
            <td width="330">评价标准</td>
            <td width="60">分数</td>
        </tr>
        <tr>
            <td>1</td>
            <td>服务主动、耐心、热情、周到 （0-10分）</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>2</td>
            <td>服务人员具有充分的专业知识（0-10分）</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>3</td>
            <td>服务人员佩戴证件，行为规范（0-10分）</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>4</td>
            <td>服务合同执行到位不打折扣（0-15分）</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>5</td>
            <td>服务产品高质量交付（0-15分）</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>6</td>
            <td>产品价格优惠性价比高（0-15分）</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>7</td>
            <td>产品贴合工作实际方便易用（0-10分）</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>8</td>
            <td>售后服务响应及时问题快速解决（0-15分）</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">合计</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td colspan="3">备注：90-100为优秀，80-90为良好，60-80为合格，60以下为不合格</td>
        </tr>
    </table>
    </div>
    <div class="form-group vou-form-group">
        <div class="vou-eval-div">意见和建议</div>
        <textarea class="vou-eval-tarea" placeholder=""></textarea>
    </div>
</form>
</#assign>
<#include "/voucher/layout/singleLayout.ftl">