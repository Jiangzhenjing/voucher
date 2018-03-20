define(function (require) {
    var EasePage = require('easypage')
    var layer = require('layer')
    var myData = [
        { id: "1",ticket: "中小企业云服务", reg: "企业管理类", state: "200.00", provider: "小型企业、异地分支" },
        { id: "2", ticket: "20071002", reg: "note2", state: "300.00", provider: "20.00" },
        { id: "3", ticket: "20070901", reg: "note3", state: "400.00", provider: "30.00" },
        { id: "4", ticket: "20071004",reg: "note", state: "200.00", provider: "10.00" },
        { id: "5", ticket: "20071005",  reg: "note2", state: "300.00", provider: "20.00" },
    ]

    new EasePage({
        //模块名称
        name:'userlist',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'local',
            data:myData,
            colModel:[
                {label:'用户名', name:'ticket'},
                {label:'角色', name:'reg'},
                {label:'机构', name:'state'},
                {
                    label:'操作',
                    formatter: function (cellvalue, options, rowObject) {
                        return '<a class="Js_add_pass"><i class="iconfont icon-bianji"></i>重置密码</a>\
										<a class="Js_del"><i class="iconfont icon-shanchu"></i>删除</a>'
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
                    url:'/voucher/administrators/usermanage/useradd.ftl',
                    title:'用户信息',
                    area:['560px','290px'],
                    submit:{
                        url:''
                    }
                })
            },
            'click .Js_add_pass':function(){
                this.dialog({
                    url:'/voucher/administrators/usermanage/passwordreset.ftl',
                    title:'重置密码',
                    area:['560px','190px'],
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