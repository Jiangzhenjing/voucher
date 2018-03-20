define(function (require) {
    var EasePage = require('easypage')
    new EasePage({
        //模块名称
        name:'provider',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'json',
            url:'/voucher/providers',
            colModel:[
                {
                    label:'服务商编号',
                    name:'pNo'},
                {
                    label:'服务商名称',
                    name:'corpName',
                    formatter:function(cellvalue, options, rowObject){
                        return "<a href='/voucher/providers/profile?id="+ rowObject.id +"' target='_blank'>"+cellvalue+"</a>";
                    }
                },
                {
                    label:'联系人',
                    name:'contacts'
                },
                {
                    label:'联系电话',
                    name:'phoneNo'
                },
                {
                    label:'联系地址',
                    name:'address'
                },
                {
                    label:'网址',
                    name:'website'
                },
                {
                    label:'传真',
                    name:'fax'
                },
                {
                    label:'操作',
                    formatter: function (cellvalue, options, rowObject) {
                        return '<a class="Js_edit iconfont icon-bianji" data-id="' + rowObject.id +'">编辑</a>\
                                <a class="Js_del iconfont icon-shanchu" data-id="' + rowObject.id +'">删除</a>'
                    }
                }
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            pager: '#Js_pager',
					  paging: true
        },
        // form查询表单容器
        searchEle:'#Js_search_form',
			  search: {},
        events:{
            'click .Js_add,.Js_edit':function(event){
                var id = $(event.target).data('id')
                this.dialog({
                    url:'/voucher/providers/add',
                      data: {
                        id: id
                      },
                    title:'添加服务商',
                    area:['700px','600px']
                })
            },
            'click .Js_del': function (event) {
                var id = $(event.target).data('id')
                this.del({
                  url: '/voucher/providers/del',
                  data: {
                        id: id
                  }
                })
            }
        }
    })
})