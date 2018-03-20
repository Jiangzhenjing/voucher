<#assign content>
<div class="vou-oper">
    <form id="Js_search_form">
        <div class="vou-search-mor">
            <div class="vou-search1">
                <span>
                    <label>服务商：</label>
                    <select name="fuwushang">
                        <option value="">选择服务商</option>
                        <option value="582530e9e881e0a955c577f6">用友网络南京分公司</option>
                        <option value="5825334de657f13f134c5fb7">江苏巨成软件科技有限公司</option>
                        <option value="58255ee0e881e00603a5d0d1">南京丹书科技有限公司</option>
                        <option value="5825608ce657f1411357600c">南京东进诚软件有限公司</option>
                        <option value="58256402e881e003039ae0ac">江苏鹏为软件有限公司</option>
                        <option value="5825676fe881e0050389f89d">南京苏豪科技实业有限公司</option>
                        <option value="58256860e881e0ff0206df18">南京敏行软件有限公司</option>
                        <option value="58256994e657f14113d8179c">江苏叁拾叁信息技术有限公司</option>
                        <option value="5825772de657f13b1351dcf5">南京新模式软件集成有限公司</option>
                        <option value="582592e4e657f140138d63b4">江苏天网计算机技术有限公司</option>
                        <option value="582593dc05e9053869ac2140">南京星霸科技有限公司</option>
                        <option value="58259c4505e9053769c8a002">南京壹进制信息技术股份有限公司</option>
                        <option value="5825a896e881e00003ed1187">江苏移动信息系统集成有限公司</option>
                        <option value="5825b3a605e9053569b9a5c5">朗坤智慧科技股份有限公司</option>
                        <option value="5825bb8205e905376970ce1b">南京掌控网络科技有限公司</option>
                        <option value="5825c0fb05e9053369e61272">南京佰腾发发信息科技有限公司</option>
                        <option value="5825c594e657f1401321bf58">南京首屏商擎网络技术有限公司</option>
                        <option value="58269524e657f19c7810db79">斯坦德云科技股份有限公司</option>
                        <option value="582696b105e905e64536ef41">南京睦泽信息科技有限公司</option>
                        <option value="58257021e657f13b13733269">南京管家婆软件有限公司</option>
                        <option value="597ebc366c6db00e4b637fae">changjie</option>
                    </select>
                </span>
                <span>
                    <label>区域：</label>
                    <select name="districtId">
		                <option value=""></option>
                        <option value="5566cdeb2a4466d4b3b8c1f3">玄武区</option>
                        <option value="5566cdeb2a4466d4b3b8c1f4">鼓楼区</option>
                        <option value="5566cdeb2a4466d4b3b8c1f5">建邺区</option>
                        <option value="5566cdeb2a4466d4b3b8c1f6">秦淮区</option>
                        <option value="5566cdeb2a4466d4b3b8c1f7">雨花台区</option>
                        <option value="5566cdeb2a4466d4b3b8c1f9">栖霞区</option>
                        <option value="5566cdeb2a4466d4b3b8c1fa">江宁区</option>
                        <option value="5566cdeb2a4466d4b3b8c1fc">溧水区</option>
                        <option value="5566cdeb2a4466d4b3b8c1fd">高淳区</option>
                        <option value="5566cdeb2a4466d4b3b8c1fe">江宁经济技术开发区</option>
                        <option value="5566cdeb2a4466d4b3b8c200">浦口区</option>
                        <option value="5566cdeb2a4466d4b3b8c201">六合区</option>
                        <option value="55b070843e59186365943250">南京经济技术开发区</option>
                        <option value="55b070843e59186365943251">南京高新技术开发区</option>
                        <option value="55b070843e59186365943252">南京化学工业园</option>
                        <option value="55b070843e59186365943253">南京市中小企业服务中心</option>
                        <option value="5840e7154d883f1f8be50164">雨花软件谷</option>
                    </select>
                </span>
            </div>
        </div>
    </form>
</div>
<div class="vou-statb" id="Js_vou_infor"></div>
</#assign>
<#assign script>
<script>
    seajs.use('administrators/evaluasta')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">