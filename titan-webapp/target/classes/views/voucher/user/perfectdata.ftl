<#assign content>
<div class="vou-details">
    <div class="vou-deta-infor vou-perfect">
        <div class="vou-perfect-title">
            <span>使用信息化服务券企业所需登记资料信息</span>
            <a href="/voucher/user/contentpage.ftl">保存</a>
        </div>
        <div class="vou-deta-title">
            <strong>基本信息</strong>
        </div>
        <ul class="vou-pro-ul">
            <li>
                <em>*</em>
                <span>统一社会信用代码：</span>
                <input type="text" name="">
            </li>
            <li>
                <em>*</em>
                <span>企业名称：</span>
                <input type="text" name="name" >
            </li>
            <li>
                <em>*</em>
                <span>所属区：</span>
                <select name="region">
                    <option></option>
                </select>
            </li>
            <li>
                <em>*</em>
                <span>企业规模：</span>
                <input type="text" name="scale">
            </li>
            <li>
                <em>*</em>
                <span>法定代表人：</span>
                <input type="text" name="rep">
            </li>
            <li>
                <em>*</em>
                <span>地址：</span>
                <input type="text" name="address">
            </li>
            <li>
                <em>*</em>
                <span>成立日期：</span>
                <input type="text" name="time">
            </li>
            <li>
                <em>*</em>
                <span>联系人：</span>
                <input type="text" name="contacts">
            </li>
            <li>
                <em>*</em>
                <span>联系电话：</span>
                <input type="text" name="phone">
            </li>
            <li>
                <em></em>
                <span>QQ：</span>
                <input type="text" name="">
            </li>
            <li>
                <em></em>
                <span>Email：</span>
                <input type="text" name="">
            </li>
        </ul>
        <div class="vou-deta-title">
            <strong>其他信息</strong>
        </div>
        <ul class="vou-pro-ul">
            <li>
                <em></em>
                <span>2016年总产值：</span>
                <input type="text" name="">
            </li>
            <li>
                <em></em>
                <span>2017年预计总产值：</span>
                <input type="text" name="" >
            </li>
            <li>
                <em></em>
                <span>2016年营业收入：</span>
                <input type="text" name="" >
            </li>
            <li>
                <em></em>
                <span>2017年预计营业收入：</span>
                <input type="text" name="">
            </li>
            <li>
                <em></em>
                <span>2016年利润：</span>
                <input type="text" name="">
            </li>
            <li>
                <em></em>
                <span>2017年预计利润：</span>
                <input type="text" name="">
            </li>
            <li>
                <em></em>
                <span>从业人数：</span>
                <input type="text" name="">
            </li>
            <li>
                <em></em>
                <span>曾选择服务券：</span>
                <select>
                    <option></option>
                </select>
            </li>
            <li class="vou-ptr-bz">
                <em></em>
                <span>目前企业最大的困难：</span>
                <textarea></textarea>
            </li>
            <li class="vou-ptr-bz">
                <em></em>
                <span >备注：</span>
                <textarea></textarea>
            </li>
        </ul>
    </div>

</div>
</#assign>
<#assign script>
<script>
    seajs.use('administrators/provider/provideradd')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">