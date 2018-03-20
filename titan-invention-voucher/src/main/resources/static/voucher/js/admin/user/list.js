define(function (require) {
    var EasePage = require('easypage')

    new EasePage({
        //模块名称
        name:'user',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'json',
            url: '/voucher/admin/user',
            mtype: "post",
            colModel:[
                {
                  label:'用户名',
                  name:'userName'
                },
                {
                  label:'角色',
                  name:'roleName'
                },
                {
                  label:'机构',
                  name:'userRealName'
                },
                {
                    label:'操作',
                    formatter: function (cellvalue, options, rowObject) {
                        return '<a class="Js_reset iconfont icon-bianji" data-id="'+ rowObject.id +'">重置密码</a>\
										            <a class="Js_del iconfont icon-shanchu" data-id="'+ rowObject.id +'">删除</a>'
                    }
                }
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
            rowNum: 20,
            rownumbers: true,
            rowList: [10, 20, 30],
            pager: '#Js_pager',
					  paging: true
        },
        // form查询表单容器
        searchEle:'#Js_search_form',
        search: {},
        events:{
            'click .Js_add':function(){
                this.dialog({
                    url:'/voucher/admin/user/add',
                    title:'用户信息',
                    area:['560px','320px']
                })
            },
            'click .Js_reset':function(event){
                var id = $(event.target).data('id')
                this.dialog({
                    url:'/voucher/admin/user/resetpw/' + id,
                    title:'重置密码',
                    area:['560px','200px']
                })
            },
            'click .Js_del': function (event) {
                var id = $(event.target).data('id')
                this.del({
                  url: '/voucher/admin/user/delete',
                  data: {
                      id: id
                  }
                })
            }
        }
    })
})