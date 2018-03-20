define(function (require) {
    var EasePage = require('easypage')

    new EasePage({
        //模块名称
        name:'productsta',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'json',
            url: '/voucher/analyze',
            colModel:[
                {
                    label:'产品名称',
                    name:'productName'
                },
                {
                    label:'服务商',
                    name:'providerName',
                    formatter:function(cellvalue, options, rowObject){
                        return "<a href='/voucher/providers/profile?id=" + rowObject.provider_id + "' target='_blank'>"+cellvalue+"</a>";
                    }
                },
                {
                    label:'销售数量',
                    name:'salesCount'
                },
                {
                    label:'销售收入',
                    name:'salesAmount'
                },
                {
                    label:'企业自付金额',
                    name:'companyPayAmount'
                },
                {
                    label:'评价统计',
                     name:'avgScore'
                }
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            pager: '#Js_pager',
					  paging: true,
              footerrow: true,
              gridComplete: function () {
                var $this = $(this)
                var rowNum = +$this.getGridParam('records')
                if (rowNum > 0) {
                  $(".ui-jqgrid-sdiv").show();

									var userData = $this.getGridParam("userData")

                  $this.footerData("set", {
                    "salesCount": "合计:<span style='color: red'>" + userData.counts + "<span>",
                    "salesAmount": "合计:<span style='color: red'>" + userData.saleAmount + "</span>",
										"companyPayAmount": "合计:<span style='color: red'>" + userData.selfSumAmount + "</span>"
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