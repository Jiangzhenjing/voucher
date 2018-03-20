define(function (require) {
	var EasePage = require('easypage')
	var enums = require("../../lib/enums")
	var isProvider = $('#Js_isProvider').val()
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
			url: '/voucher/callback/search',
			colModel:[
				{
					label:'服务券号',
					name:'voucherNo',
					formatter:function(cellvalue, options, rowObject){
						console.log(rowObject)
						return "<a href='/voucher/info/"+ rowObject.id +"'>"+cellvalue+"</a>";
					}
				},
				{
					label:'公司名称',
					name:'companyName'
				},
				{
					label:'区域',
					name:'region'
				},
				{
					label:'撤回原因',
					name:'callbackReason'
				},
				{
					label:'操作',
					formatter: function (cellvalue, options, rowObject) {
						return '<i class="Js_callbackConfirm iconfont" data-id="' + rowObject.id + '">确认撤回</i>\
										<i class="Js_disabledcallback iconfont" data-id="' + rowObject.id + '">否决撤回</i>'
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
			'click .Js_callbackConfirm': function (event) {
				var id = $(event.target).data('id')
				this.dialog({
					type: 0,
					contentType: 'page',
					content: '是否撤回?',
					area: ["300px", "150px"],
					submit: {
						url: '/voucher/' + id + '/callbackconfirm'
					}
				})
			},
			'click .Js_disabledcallback': function (event) {
				var id = $(event.target).data('id')
				this.dialog({
					type: 0,
					contentType: 'page',
					content: '是否否决撤回?',
					area: ["300px", "150px"],
					submit: {
						url: '/voucher/' + id + '/disablecallback'
					}
				})
			}
		}
	})
})