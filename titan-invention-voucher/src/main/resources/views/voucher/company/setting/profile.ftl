<#assign content>
<div class="vou-details">
    <div class="vou-deta-infor vou-perfect">

        <#if isAdmin != "true">
            <form class="form-horizontal" id="Js_form" method="post" action="/voucher/company/profile">
        <#else >
            <form class="form-horizontal" id="Js_form" method="post" action="/voucher/admin/company/relate/${id}">
        </#if>
            <div class="vou-perfect-title">
                <span>使用信息化服务券企业所需登记资料信息</span>
            </div>

            <div class="vou-deta-title">
                <strong>基本信息</strong>
            </div>
            <ul class="vou-pro-ul">
                <li class="form-group">
                    <label for="inputNo" class="col-xs-4 control-label">联系电话：</label>
                    <div class="col-xs-8">
                    <#if isAdmin != "true">
                        <span>${userInfo.user_name}</span>
                    <#else >
                        ${companyInfo.phoneNo!""}
                        <input type="hidden" name="phoneNo" value="${companyInfo.phoneNo!""}">
                    </#if>
                    </div>
                </li>
                <input type="hidden"  name="id" value="${companyInfo.id!""}">
                <li class="form-group">
                    <label for="inputCode" class="col-xs-4 control-label">统一社会信用代码：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" placeholder="统一社会信用代码" name="creditCode" value="${companyInfo.creditCode!""}">
                    </div>
                </li>
                <li class="form-group">
                    <label for="inputName" class="col-xs-4 control-label">企业名称：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="inputName" placeholder="企业名称" name="companyName" value="${companyInfo.companyName!""}">
                    </div>
                </li>
                <li class="form-group">
                    <label class="col-xs-4 control-label">所属区：</label>
                    <div class="col-xs-8">
                        <#assign selectedRegion=companyInfo.regionId!"">
                        <#include "/voucher/common/components/regions.ftl">
                    </div>
                </li>
                <li class="form-group">
                    <label class="col-xs-4 control-label">行业分类：</label>
                    <div class="col-xs-8">
                        <select class="form-control" name="industry" data-value="${companyInfo.industry}">
                            <option value="农副食品加工业" >农副食品加工业</option>
                            <option value="食品制造业">食品制造业</option>
                            <option value="纺织业">纺织业</option>
                            <option value="纺织服装、服饰业">纺织服装、服饰业</option>
                            <option value="木材加工及木、竹、藤、棕、草制品业">木材加工及木、竹、藤、棕、草制品业</option>
                            <option value="家具制造业">家具制造业</option>
                            <option value="造纸及纸制品业">造纸及纸制品业</option>
                            <option value="印刷和记录媒介复制业">印刷和记录媒介复制业</option>
                            <option value="文教、工美、体育及娱乐用品制造业">文教、工美、体育及娱乐用品制造业</option>
                            <option value="石油加工、炼焦及核燃料加工业">石油加工、炼焦及核燃料加工业</option>
                            <option value="化学原料及化学制品制造业">化学原料及化学制品制造业</option>
                            <option value="医药制造业">医药制造业</option>
                            <option value="化学纤维制造业">化学纤维制造业</option>
                            <option value="橡胶及塑料制品业">橡胶及塑料制品业</option>
                            <option value="非金属矿物制品业">非金属矿物制品业</option>
                            <option value="黑色金属冶炼及压延加工业">黑色金属冶炼及压延加工业</option>
                            <option value="有色金属冶炼及压延加工业">有色金属冶炼及压延加工业</option>
                            <option value="金属制品业">金属制品业</option>
                            <option value="通用设备制造业">通用设备制造业</option>
                            <option value="专用设备制造业">专用设备制造业</option>
                            <option value="汽车制造业">汽车制造业</option>
                            <option value="铁路、船舶、航空航天及其他运输设备制造业">铁路、船舶、航空航天及其他运输设备制造业</option>
                            <option value="电气机械及器材制造业">电气机械及器材制造业</option>
                            <option value="计算机、通信及其他电子设备制造业">计算机、通信及其他电子设备制造业</option>
                            <option value="仪器仪表制造业">仪器仪表制造业</option>
                            <option value="其他制造业">其他制造业</option>
                            <option value="废弃资源综合利用业">废弃资源综合利用业</option>
                            <option value="金属制品、机械及设备修理业">金属制品、机械及设备修理业</option>
                        </select>
                    </div>
                </li>
                <li class="form-group">
                    <label for="inputScale" class="col-xs-4 control-label">企业类型：</label>
                    <div class="col-xs-8">
                        <select class="form-control" id="Js_companyscale" name="corpType">
                            <option value="微型" <#if companyInfo.corpType == "微型">selected</#if>>微型</option>
                            <option value="小型" <#if companyInfo.corpType == "小型">selected</#if>>小型</option>
                            <option value="中型" <#if companyInfo.corpType == "中型">selected</#if>>中型</option>
                        </select>
                        <div class="vou-scale-ts Js_companyScale_desc"></div>
                    </div>
                </li>
                <li class="form-group">
                    <label for="inputPerson" class="col-xs-4 control-label">法定代表人：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="inputPerson" placeholder="法定代表人" name="artificialPerson" value="${companyInfo.artificialPerson!""}">
                    </div>
                </li>
                <li class="form-group">
                    <label for="inputAddress" class="col-xs-4 control-label">地址：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="inputAddress" placeholder="地址" name="address" value="${companyInfo.address!""}">
                    </div>
                </li>
                <li class="form-group">
                    <label for="inputDate" class="col-xs-4 control-label">成立日期：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control date-picker" id="inputDate" placeholder="成立日期" value="${companyInfo.establishDate!""}" name="establishDate">
                        <i class="iconfont icon-rili"></i>
                    </div>
                </li>
                <li class="form-group">
                    <label for="inputContacts" class="col-xs-4 control-label">联系人：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="inputContacts" placeholder="联系人" name="contacts" value="${companyInfo.contacts!""}">
                    </div>
                </li>
                <li class="form-group">
                    <label for="inputQQ" class="col-xs-4 control-label">QQ：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="inputQQ" placeholder="QQ" name="qq" value="${companyInfo.qq!""}">
                    </div>
                </li>
                <li class="form-group">
                    <label for="inputemail" class="col-xs-4 control-label">Email：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="inputemail" placeholder="email" name="email" value="${companyInfo.email!""}">
                    </div>
                </li>
            </ul>
            <div class="vou-deta-title">
                <strong>企业信息化建设投入</strong>
            </div>
             <ul class="vou-pro-ul">
                <li class="form-group">
                    <label class="col-xs-4 control-label">软件投入：</label>
                    <div class="col-xs-8">
                        <select class="form-control" name="softwareInvest">
                            <option value="">请选择</option>
                            <option value="5万以下" <#if companyInfo.softwareInvest == "5万以下">selected</#if> >5万以下</option>
                            <option value="5-10万" <#if companyInfo.softwareInvest == "5-10万">selected</#if> >5-10万</option>
                            <option value="10-50万" <#if companyInfo.softwareInvest == "10-50万">selected</#if> >10-50万</option>
                            <option value="50-100万" <#if companyInfo.softwareInvest == "50-100万">selected</#if> >50-100万</option>
                            <option value="100万以上" <#if companyInfo.softwareInvest == "100万以上">selected</#if> >100万以上</option>
                        </select>
                    </div>
                </li>
                 <li class="form-group">
                     <label class="col-xs-4 control-label">硬件投入：</label>
                     <div class="col-xs-8">
                         <select class="form-control" name="hardwareInvest">
                             <option value="">请选择</option>
                             <option value="5万以下" <#if companyInfo.hardwareInvest == "5万以下">selected</#if> >5万以下</option>
                             <option value="5-10万" <#if companyInfo.hardwareInvest == "5-10万">selected</#if> >5-10万</option>
                             <option value="10-50万" <#if companyInfo.hardwareInvest == "10-50万">selected</#if> >10-50万</option>
                             <option value="50-100万" <#if companyInfo.hardwareInvest == "50-100万">selected</#if>>50-100万</option>
                             <option value="100万以上" <#if companyInfo.hardwareInvest == "100万以上">selected</#if> >100万以上</option>
                         </select>
                     </div>
                 </li>
                 <li class="form-group">
                     <label class="col-xs-4 control-label">咨询投入：</label>
                     <div class="col-xs-8">
                         <select class="form-control" name="consultationInvest">
                             <option value="">请选择</option>
                             <option value="5万以下" <#if companyInfo.consultationInvest == "5万以下">selected</#if> >5万以下</option>
                             <option value="5-10万" <#if companyInfo.consultationInvest == "5-10万">selected</#if>>5-10万</option>
                             <option value="10-50万" <#if companyInfo.consultationInvest == "10-50万">selected</#if> >10-50万</option>
                             <option value="50-100万" <#if companyInfo.consultationInvest == "50-100万">selected</#if>>50-100万</option>
                             <option value="100万以上" <#if companyInfo.consultationInvest == "100万以上">selected</#if>>100万以上</option>
                         </select>
                     </div>
                 </li>
                 <li class="form-group">
                     <label class="col-xs-4 control-label">企业门户网站：</label>
                     <div class="col-xs-8">
                         <select class="form-control" name="websiteConstruction">
                             <option value="无">无</option>
                             <option value="信息发布" <#if companyInfo.websiteConstruction == "信息发布">selected</#if> >信息发布</option>
                             <option value="电子商务" <#if companyInfo.websiteConstruction == "电子商务">selected</#if> >电子商务</option>
                         </select>
                     </div>
                 </li>
            </ul>
            <div class="vou-deta-title">
                <strong>其他信息</strong>
            </div>
            <ul class="vou-pro-ul">
                <li class="form-group">
                    <label for="inputBeforeLast" class="col-xs-4 control-label">2016年总产值：</label>
                    <div class="col-xs-7">
                         <input type="number" class="form-control" id="inputBeforeLast" placeholder="2016年总产值"
                                name="productionValueYearBeforeLast" value="${companyInfo.productionValueYearBeforeLast!""}">
                    </div>
                    <div class="vou-element">万元</div>
                </li>
                <li class="form-group">
                    <label for="inputLastYear" class="col-xs-4 control-label">2017年预计总产值：</label>
                    <div class="col-xs-7">
                        <input type="number" class="form-control" id="inputLastYear" placeholder="2017年预计总产值"
                               name="productionValueLastYear" value="${companyInfo.productionValueLastYear!""}">
                    </div>
                    <div class="vou-element">万元</div>
                </li>
                <li class="form-group">
                    <label for="inputBeforeLast" class="col-xs-4 control-label">2016年营业收入：</label>
                    <div class="col-xs-7">
                        <input type="number" class="form-control" id="inputBeforeLast" placeholder="2016年营业收入"
                               name="turnoverYearBeforeLast" value="${companyInfo.turnoverYearBeforeLast!""}">
                    </div>
                    <div class="vou-element">万元</div>
                </li>
                <li class="form-group">
                    <label for="inputLastYear" class="col-xs-4 control-label">2017年预计营业收入：</label>
                    <div class="col-xs-7">
                        <input type="number" class="form-control" id="inputLastYear" placeholder="2017年预计营业收入"
                               name="turnoverLastYear" value="${companyInfo.turnoverLastYear!""}">
                    </div>
                    <div class="vou-element">万元</div>
                </li>
                <li class="form-group">
                    <label for="inputBeforeLast" class="col-xs-4 control-label">2016年利润：</label>
                    <div class="col-xs-7">
                        <input type="number" class="form-control" id="inputBeforeLast" placeholder="2016年利润"
                               name="profitYearBeforeLast" value="${companyInfo.profitYearBeforeLast!""}">
                    </div>
                    <div class="vou-element">万元</div>
                </li>
                <li class="form-group">
                    <label for="inputLastYear" class="col-xs-4 control-label">2017年预计利润：</label>
                    <div class="col-xs-7">
                        <input type="number" class="form-control" id="inputLastYear" placeholder="2017年预计利润"
                               name="profitLastYear" value="${companyInfo.profitLastYear!""}">
                    </div>
                    <div class="vou-element">万元</div>
                </li>
                <li class="form-group">
                    <label for="inputLastYear" class="col-xs-4 control-label">从业人数：</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="inputLastYear" placeholder="从业人数"
                               name="employeeCount" value="${companyInfo.employeeCount!""}">
                    </div>
                </li>
                <li class="form-group">
                    <label class="col-xs-4 control-label">曾选择服务券：</label>
                    <div class="col-xs-8">
                        <div id="Js_voucher_picker" class="vou-once-sel">
                            <select id="Js_year" class="form-control vou-once-sel1">
                            </select>
                            <select id="Js_company" class="form-control vou-once-sel2"></select>
                            <select id="Js_product" class="form-control vou-once-sel3"></select>
                        </div>
                        <input type="hidden" name="haveSelectedProvider" id="Js_voucher" value="${companyInfo.haveSelectedProvider}">
                        <#--<select class="form-control">-->
                            <#--<option></option>-->
                        <#--</select>-->
                    </div>
                </li>
                <li class="form-group">
                    <label class="col-xs-4 control-label">目前企业最大的信息化困难：</label>
                    <div class="col-xs-8">
                        <textarea class="form-control" name="trouble">${companyInfo.trouble}</textarea>
                    </div>
                </li>
                <li class="form-group">
                    <label class="col-xs-4 control-label">备注：</label>
                    <div class="col-xs-8">
                        <textarea class="form-control" name="remark">${companyInfo.remark}</textarea>
                    </div>
                </li>
            </ul>
            <#if isAdmin == "true">
                <div class="vou-deta-title">
                    <strong>绑定服务券</strong>
                </div>
                <ul class="vou-pro-ul">
                    <li class="form-group">
                        <label class="col-xs-4 control-label">服务券号：</label>
                        <div class="col-xs-8">
                            <input name="voucherno" class="form-control" type="text" value="${voucherNo!""}">
                        </div>
                    </li>
                </ul>
            </#if>

                <div class="vou-sign-btn vou-pro-btn">
                    <button type="submit">保存</button>
                </div>
            </form>
    </div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('company/setting/profile')
    var $industry = $("[name=industry]")
    $industry.val($industry.data('value'))
    <#if msg>
        alert('${msg}')
    </#if>
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">