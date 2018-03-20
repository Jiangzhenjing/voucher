<#assign content>
<form class="form-horizontal" id="Js_form" method="post" action="/voucher/${id}/comment">
    <div class="form-group">
        <label class="col-xs-1 control-label vou-bdlabel">问题</label>
        <div class="col-1g-10">
            <label class="radio-inline">
                <input type="radio" name="inlineRadioOptions" checked id="inlineRadio1" value="option1"> 已解决
            </label>
            <label class="radio-inline">
                <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 未解决
            </label>
        </div>
    </div>
    <table class="table table-bordered">
            <tr>
                <td width="60">序号</td>
                <td width="330">评价标准</td>
                <td>分数</td>
            </tr>
            <tr>
                <td>1</td>
                <td>服务主动、耐心、热情、周到 （0-10分）</td>
                <td class="form-group"><input type="number"
                                              class="form-control"
                                              name="sc01" max="10" min="0"
                                              data-fv-lessthan-message="请输入0-10的数字"
                ></td>
            </tr>
            <tr>
                <td>2</td>
                <td>服务人员具有充分的专业知识（0-10分）</td>
                <td class="form-group"><input type="number"
                                              class="form-control"
                                              name="sc02" max="10" min="0"
                                              data-fv-lessthan-message="请输入0-10的数字"
                >
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>服务人员佩戴证件，行为规范（0-10分）</td>
                <td class="form-group"><input type="text"
                                              class="form-control"
                                              name="sc03"
                                              max="10"
                                              min="0"
                                              data-fv-lessthan-message="请输入0-10的数字"
                ></td>
            </tr>
            <tr>
                <td>4</td>
                <td>服务合同执行到位不打折扣（0-15分）</td>
                <td class="form-group"><input type="text"
                                              class="form-control"
                                              name="sc04"
                                              max="15"
                                              min="0"
                                              data-fv-lessthan-message="请输入0-15的数字"
                ></td>
            </tr>
            <tr>
                <td>5</td>
                <td>服务产品高质量交付（0-15分）</td>
                <td class="form-group"><input type="text"
                                              class="form-control"
                                              name="sc05"
                                              max="15"
                                              min="0"
                                              data-fv-lessthan-message="请输入0-15的数字"
                ></td>
            </tr>
            <tr>
                <td>6</td>
                <td>产品价格优惠性价比高（0-15分）</td>
                <td class="form-group"><input type="text"
                                              class="form-control"
                                              name="sc06"
                                              max="15"
                                              min="0"
                                              data-fv-lessthan-message="请输入0-15的数字"
                ></td>
            </tr>
            <tr>
                <td>7</td>
                <td>产品贴合工作实际方便易用（0-10分）</td>
                <td class="form-group"><input type="text"
                                              class="form-control"
                                              name="sc07"
                                              max="10"
                                              min="0"
                                              data-fv-lessthan-message="请输入0-10的数字"
                ></td>
            </tr>
            <tr>
                <td>8</td>
                <td>售后服务响应及时问题快速解决（0-15分）</td>
                <td class="form-group"><input type="text"
                                              class="form-control"
                                              name="sc08"
                                              max="15"
                                              min="0"
                                              data-fv-lessthan-message="请输入0-15的数字"
                ></td>
            </tr>
            <tr>
                <td colspan="2" align="center">合计</td>
                <td><input type="text" class="form-control" readonly id="Js_total"></td>
            </tr>
            <tr>
                <td colspan="3">备注：90-100为优秀，80-90为良好，60-80为合格，60以下为不合格</td>
            </tr>
        </table>
    <div class="form-group">
        <label class="col-xs-4 control-label vou-bdlabel">实施信息化后对企业有哪些改善</label>
        <div class="col-xs-12">
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="降耗"> 降耗
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="其他"> 其他
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="扩大销售额"> 扩大销售额
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="增加了市场信息获取渠道"> 增加了市场信息获取渠道
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="节能"> 节能
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="提高生产效率"> 提高生产效率
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="降低生产成本"> 降低生产成本
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="技术创新"> 技术创新
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="afterInformationImprovement" value="提高资金使用效率"> 提高资金使用效率
            </label>
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-4 control-label vou-bdlabel">企业下一步信息化建设的重点</label>
        <div class="col-xs-12">
            <label class="radio-inline">
                <input type="checkbox" name="nextInformationKeyPoint" value="企业资源管理系统（ERP）"> 企业资源管理系统（ERP）
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="nextInformationKeyPoint" value="电子商务"> 电子商务
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="nextInformationKeyPoint" value="办公自动化（OA）"> 办公自动化（OA）
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="nextInformationKeyPoint" value="信息安全"> 信息安全
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="nextInformationKeyPoint" value="客户关系管理（CRM）"> 客户关系管理（CRM）
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="nextInformationKeyPoint" value="生产执行系统（MES）"> 生产执行系统（MES）
            </label>
            <label class="radio-inline">
                <input type="checkbox" name="nextInformationKeyPoint" value="其他"> 其他
            </label>
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-3 control-label">意见和建议</label>
        <div class="col-xs-9">
            <textarea class="form-control" name="evaluateContent" maxlength="200" placeholder="200字之内"></textarea>
        </div>
    </div>
</form>
</#assign>
<#assign script>
    <script>
        seajs.use("common/voucher/comment")
    </script>
</#assign>

<#include "/voucher/layout/singleLayout.ftl">
