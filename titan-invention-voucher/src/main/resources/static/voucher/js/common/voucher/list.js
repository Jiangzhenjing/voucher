define(function (require) {
    var EasePage = require('easypage')
    var enums = require("../../lib/enums")
    var isProvider = $('#Js_isProvider').val()
    require('gallery/jquery.serializeobject/1.0.0/index.js')
    new EasePage({
        //模块名称
        name:'voucher',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'json',
            mtype: "post",
            url: '/voucher/search',
            colModel:[
                {
                    label:'服务券号',
                    name:'voucherNo',
                    formatter:function(cellvalue, options, rowObject){
                      return "<a href='/voucher/info/"+ rowObject.id +"' target='_blank'>"+cellvalue+"</a>";
                    }
                 },
                {
                    label:'公司名称',
                    name:'companyName'
                },
                {
                    label: '企业联系人',
                    name: 'contacts'
                },
                {
								    label: '企业联系电话',
								    name: 'phoneNo'
                },
                {
                    label:'区域',
                    name:'region'
                },
                {
                  label:'状态',
                  name:'voucherStatus',
                  formatter: function (cellvalue) {
                      return enums.VoucherStatus[cellvalue]
                  }
                },
                  {
                    label: '发券时间',
                    name: 'issuingDate'
                  },
                {
                    label:'服务商',
                    name:'providerName'
                },
                {
                    label:'操作',
                    formatter: function (cellvalue, options, rowObject) {
                        if (isProvider) {
                            if ( rowObject.voucherStatus  == 'WaitConfirm') {
                              return '<a class="Js_confirm iconfont icon-bianji" data-id="' + rowObject.id + '">确认</a>'
                            }
                            return ""
                        }

											  return '<a target="_blank" class="iconfont icon-bianji" href="/voucher/company/profile?id='+ rowObject.companyId +'">编辑</a>' +
                          '<a class="Js_del iconfont icon-shanchu" data-id="' + rowObject.id + '">删除</a>'
                    }
                }
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true,
					  rownumbers: true,
					  shrinkToFit:false,
					  autoScroll: true,
            rowNum: 20,
					  postData: $.extend({}, $('#Js_search_form').serializeObject()),
            rowList: [10, 20, 30],
            pager: '#Js_pager',
					  paging: true
        },
        // form查询表单容器
        searchEle:'#Js_search_form',
        search: {},
        events:{
            'click .Js_del': function (event) {
                var id = $(event.target).data('id')
                this.del({
                  url: '/voucher/delete',
                  data: {
                      id: id
                  }
                })
            },
          'click .Js_confirm': function (event) {
						var id = $(event.target).data('id')
						this.dialog({
              type: 0,
              contentType: 'page',
              content: '是否确认?',
							area: ['300px', '150px'],
              submit: {
                  url: '/voucher/product/confirm?pid=' + id
              }
						})
          },
            'click .Js_download':function (event) {
                var $target = $(event.target)
                var baseUrl = $target.attr('href')
                baseUrl += '?' + $('#Js_search_form').serialize()
                $target.attr('href', baseUrl)
            }
        }
    })
})