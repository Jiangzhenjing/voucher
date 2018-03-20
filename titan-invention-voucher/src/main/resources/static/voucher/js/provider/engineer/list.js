define(function (require) {
    var EasePage = require('easypage')

    new EasePage({
        //模块名称
        name:'engineer',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'json',
            url: '/voucher/provider/engineer',
            colModel:[
                {
                    label:'工程师编号',
                    name:'engineerNo'
                },
                {
                    label:'工程师姓名',
                    name:'engineerName'
                },
                {
                    label:'操作',
                    formatter: function (cellvalue, options, rowObject) {
                        return '<i class="Js_del iconfont icon-shanchu" data-id="'+rowObject.id+'">删除</i>'
                    }
                }
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
					  rownumbers: true,
            rowNum: 20
        },
        // form查询表单容器
        searchEle:'#Js_search_form',
			  search: {},
        events:{
            'click .Js_add': function(event){
                var id = $(event.target).data('id')
                this.dialog({
                    url:'/voucher/provider/engineer/add',
                    title:'新增服务工程师',
                    area:['560px','300px'],
                    data: {
                        id: id
                    }
                })
            },
            'click .Js_del': function (event) {
                var id = $(event.target).data('id')
                this.del({
									url: '/voucher/provider/engineer/del',
                  data: {
									    id: id
                  }
                })
            }
        }
    })
})