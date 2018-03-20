<#assign content>
    <div class="vou-oper">
        <form id="Js_search_form">
            <div class="vou-search-mor">
                <div class="vou-search1">
                    <label>服务券号：</label>
                    <input type="text" name="" placeholder="服务券号">
                </div>
                <div class="vou-search-add Js_search_add">
                <span>
                    <label>企业名称：</label>
                    <input type="text" name="" placeholder="企业名称">
                </span>
                    <span>
                    <label>区域：</label>
                    <select>
                        <option></option>
                    </select>
                </span>
                    <span>
                    <label>状态：</label>
                    <select>
                        <option value="">请选择</option>
                        <option value="inactive">未激活</option>
                        <option value="active">已激活</option>
                        <option value="bind">已确认</option>
                        <option value="used">已使用</option>
                    </select>
                </span>
                </div>
                <button type="submit">
                    <i class="iconfont icon-sousuo"></i>
                </button>
                <a href="javascript:;" id="Js_shadd">全部条件</a>
            </div>
        </form>
        <a class="Js_add">添加服务券</a>
    </div>
    <div id="Js_table_container" class="vou-table-container">
        <table id="Js_table"></table>
        <div id="Js_pager"></div>
    </div>
</#assign>
<#assign script>
    <script>
        seajs.use('common/svoucher/voulist')
    </script>
</#assign>
<#include "/voucher/layout/defaultLayout.ftl">