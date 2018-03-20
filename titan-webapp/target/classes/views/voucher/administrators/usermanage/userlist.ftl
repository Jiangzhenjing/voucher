<#assign content>
<div class="vou-oper">
    <form id="Js_search_form">
        <div class="vou-search-mor">
            <div class="vou-search1">
                <label>用户名：</label>
                <input type="text" name="" placeholder="用户名">
            </div>
            <div class="vou-search-add Js_search_add">
                <span>
                    <label>角色：</label>
                    <select name="role">
                        <option value=""></option>
                        <option value="admin">系统管理员</option>
                        <option value="district">区管理员</option>
                        <option value="service">服务商</option>
                        <option value="customer">企业</option>
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
                <span>
                    <label>企业名：</label>
                    <input type="text" name="" placeholder="企业名称">
                </span>
            </div>
            <button type="submit">
                <i class="iconfont icon-sousuo"></i>
            </button>
            <a href="javascript:;" id="Js_shadd">全部条件</a>
        </div>
    </form>
    <a class="Js_add">创建用户</a>
</div>
<div id="Js_table_container" class="vou-table-container">
    <table id="Js_table"></table>
    <div id="Js_pager"></div>
</div>
</#assign>
<#assign script>
<script>
    seajs.use('administrators/usermanage/userlist')
</script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">