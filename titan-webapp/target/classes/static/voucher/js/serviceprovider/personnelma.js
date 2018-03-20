define(function (require) {
    var EasePage = require('easypage')
    var layer = require('layer')
    var myData = [
        { id: "1", reg: "note2" },
        { id: "1", reg: "note2" },
        { id: "1", reg: "note2" }
    ]

    new EasePage({
        //模块名称
        name:'personnelma',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'local',
            data:myData,
            colModel:[
                {label:'工程师编号', name:'id'},
                {label:'工程师姓名', name:'reg'},
                {
                    label:'操作',
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
                    url:'/voucher/serviceprovider/engineeradd.ftl',
                    title:'新增服务工程师',
                    area:['560px','236px'],
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