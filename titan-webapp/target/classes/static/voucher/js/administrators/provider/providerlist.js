define(function (require) {
    var EasePage = require('easypage')
    var layer = require('layer')
    var myData = [
        { id: "1",ticket: "20071001", name: "number", reg: "note", state: "200.00", provider: "10.00" },
        { id: "2", ticket: "20071002", name: "test2", reg: "note2", state: "300.00", provider: "20.00" },
        { id: "3", ticket: "20070901", name: "test3", reg: "note3", state: "400.00", provider: "30.00" },
        { id: "4", ticket: "20071004", name: "test", reg: "note", state: "200.00", provider: "10.00" },
        { id: "5", ticket: "20071005", name: "test2", reg: "note2", state: "300.00", provider: "20.00" },
        { id: "6", ticket: "20070906", name: "test3", reg: "note3", state: "400.00", provider: "30.00" },
        { id: "7", ticket: "20071004", name: "test", reg: "note", state: "200.00", provider: "10.00"},
        { id: "8", ticket: "20071003", name: "test2", reg: "note2", state: "300.00", provider: "20.00" },
        { id: "9", ticket: "20070902", name: "test3", reg: "note3", state: "400.00", provider: "30.00" }
    ]

    new EasePage({
        //模块名称
        name:'providerlist',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'local',
            data:myData,
            colModel:[
                {label:'服务商编号', name:'id'},
                {label:'服务商名称', name:'ticket', formatter:function(cellvalue, options, rowObject){
                    return "<a href='/voucher/administrators/provider/provideradd.ftl' target='_blank'>"+cellvalue+"</a>";
                    }},
                {label:'联系人', name:'reg'},
                {label:'联系电话', name:'state'},
                {label:'操作',
                    formatter: function (cellvalue, options, rowObject) {
                        return '<a class="Js_del"><i class="iconfont icon-shanchu"></i>删除</a>'
                    }
                }
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            pager: '#Js_pager',
        },
        // form查询表单容器
        searchEle:'#Js_search_form',
        events:{
            'click .Js_add':function(){
                this.dialog({
                    url:'/voucher/administrators/provider/provideraddlayer.ftl',
                    title:'添加服务商',
                    area:['560px','520px'],
                    submit:{
                        url:''
                    }
                })
            },
            'click .Js_del': function () {

                layer.msg('删除成功');
            }
        }
    })
})