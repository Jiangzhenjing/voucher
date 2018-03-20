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

<script>
    seajs.use('common/product/list_table', function (listtable) {
    	listtable("${id}")
    })
</script>
