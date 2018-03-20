define(function (require) {
    var EasePage = require('easypage')
    var layer = require('layer')
    var myData = [
        { id: "1",name: "南京苏拓流体设备有限公司", region: "number", porsen: "note", scale: "200.00", address: "10.00" },
        { id: "2",name: "南京苏拓流体设备有限公司", region: "number", porsen: "note", scale: "200.00", address: "10.00" },
        { id: "3",name: "南京苏拓流体设备有限公司", region: "number", porsen: "note", scale: "200.00", address: "10.00" },
        { id: "4",name: "南京苏拓流体设备有限公司", region: "number", porsen: "note", scale: "200.00", address: "10.00" },
        { id: "5",name: "南京苏拓流体设备有限公司", region: "number", porsen: "note", scale: "200.00", address: "10.00" },
        { id: "6",name: "南京苏拓流体设备有限公司", region: "number", porsen: "note", scale: "200.00", address: "10.00" }
    ]

    new EasePage({
        //模块名称
        name:'custoser',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'local',
            data:myData,
            colModel:[
                {label:'用户编号', name:'id'},
                {label:'用户名称', name:'name'},
                {label:'所属区域', name:'region'},
                {label:'法定代表人', name:'porsen'},
                {label:'企业规模', name:'scale'},
                {label:'地址', name:'address'},
                {label:'操作',
                    formatter: function (cellvalue, options, rowObject) {
                        return '<a class="Js_add"><i class="iconfont icon-bianji"></i>编辑关联</a>'
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
                    url:'/voucher/administrators/customerser/custoserform.ftl',
                    title:'编辑客户关联服务券',
                    area:['660px','520px'],
                    submit:{
                        url:''
                    }
                })
            },
        }
    })
})