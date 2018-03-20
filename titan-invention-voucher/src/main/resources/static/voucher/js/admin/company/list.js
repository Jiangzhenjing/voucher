define(function (require) {
    var EasePage = require('easypage')

    new EasePage({
        //模块名称
        name:'company',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'json',
            url: "/voucher/admin/company",
            mtype: "post",
            colModel:[
                {
                    label:'企业名称',
                    name:'companyName'
                },
                  {
                    label: '电话',
                    name: 'phoneNo'
                  },
                {
                    label:'所属区域',
                    name:'region'
                },
                {
                    label:'法定代表人',
                    name:'artificialPerson'
                },

                {
                    label:'企业规模',
                    name:'corpType'
                },
                {
                    label:'地址',
                    name:'address'
                },
                {
                    label:'操作',
                    width: '230px',
                    formatter: function (cellvalue, options, rowObject) {
                    console.log(rowObject)
                        return '<a class="iconfont icon-bianji" href="/voucher/company/profile?id=' + rowObject.id +'" target="_blank">编辑关联</a>\
                                <a class="Js_del iconfont icon-shanchu" data-id="' + rowObject.id + '">删除</a>'
                    }
                }
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
					  rownumbers: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            pager: '#Js_pager',
					  paging: true
        },
        // form查询表单容器
        searchEle:'#Js_search_form',
        search: {},
        events:{
            'click .Js_add': function (event) {
                var id = $(event.target).data('id')
                this.dialog({
                    url:'/voucher/admin/company/' + id,
                    title:'编辑客户关联服务券',
                    area:['660px','520px']
                })
            },
            'click .Js_del': function (event) {
                var id = $(event.target).data('id')
                this.del({
                  url: '/voucher/admin/company/delete/' + id
                })
            }
        }
    });
})
