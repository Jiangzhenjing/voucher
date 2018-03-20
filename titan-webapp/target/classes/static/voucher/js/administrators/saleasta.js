define(function (require) {
    var EasePage = require('easypage')
    var myData = [
        { id: "1",ticket: "中小企业云服务", reg: "note2", state: "300.00", provider: "20.00", evaluate:"5分" },
        { id: "2", ticket: "20071002", reg: "note2", state: "300.00", provider: "20.00", evaluate:"5分"},
        { id: "3", ticket: "20070901", reg: "note3", state: "400.00", provider: "30.00",evaluate:"5分" },
        { id: "4", ticket: "20071004",reg: "note", state: "200.00", provider: "10.00",evaluate:"5分" },
        { id: "5", ticket: "20071005",  reg: "note2", state: "300.00", provider: "20.00",evaluate:"5分" },
    ]

    new EasePage({
        //模块名称
        name:'saleasta',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'local',
            data:myData,
            colModel:[
                {label:'所属区域', name:'ticket'},
                {label:'服务商', name:'reg'},
                {label:'客户名称', name:'id'},
                {label:'企业类型', name:'state'},
                {label:'产品名称', name:'provider'},
                {label:'销售数量', name:'evaluate'},
                {label:'销售金额', name:'state'},
                {label:'服务人员', name:'provider'},
                {label:'交付评分', name:'evaluate'},
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            pager: '#Js_pager',
        }
    })
})