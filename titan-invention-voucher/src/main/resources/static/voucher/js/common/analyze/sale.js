define(function (require) {
    var EasePage = require('easypage')
	require('gallery/jquery.serializeobject/1.0.0/index.js')
    new EasePage({
        //模块名称
        name:'saleasta',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype: 'json',
            mtype: "post",
            url: '/voucher/analyze/sale',
            colModel:[
                {label:'所属区域', name:'region'},
                {label:'服务商', name:'providerName'},
                {label:'客户名称', name:'companyName'},
                {label:'企业类型', name:'corpType'},
                {label:'产品名称', name:'productName'},
                {label:'销售数量', name:'salesCount'},
                {label:'销售金额', name:'salesAmount'},
                {label:'服务人员', name:'provider'},
                {label:'交付评分', name:'totalScore'}
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            pager: '#Js_pager',
            postData: $.extend({}, $('#Js_search_form').serializeObject()),
					  paging: true,
              footerrow: true,
              gridComplete: function () {
                var $this = $(this)
                var rowNum = +$this.getGridParam('records');
                var userData = $this.getGridParam("userData")
                if (rowNum > 0) {
                  $(".ui-jqgrid-sdiv").show();
									$this.footerData("set", {
									    "salesCount": "合计:<span style='color: red'>" + userData.counts + "<span>",
                      "salesAmount": "合计:<span style='color: red'>" + userData.saleAmount + "</span>"
                  });
                } else {
                  $(".ui-jqgrid-sdiv").hide();
                }
              },
              userDataOnFooter: true

        },
			  searchEle:'#Js_search_form',
        search: {}
    })
})
