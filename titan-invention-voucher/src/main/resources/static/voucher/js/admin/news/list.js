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
			url: '/voucher/admin/news',
			mtype: "post",
			colModel:[
				{
					label:'标题',
					name:'title'
				},
				{
					label:'发布时间',
					name:'issueTime'
				},
				{
					label:'操作',
					formatter: function (cellvalue, options, rowObject) {
						return '<a class="Js_edit iconfont icon-bianji" data-id="'+ rowObject.id +'">修改</a>\
										            <a class="Js_del iconfont icon-shanchu" data-id="'+ rowObject.id +'">删除</a>\
										            <a target="_blank" class="iconfont icon-bianji" href="/news/'+rowObject.id+'">查看</a>'
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
			'click .Js_add,.Js_edit': function(event) {
				var $target = $(event.target)
				this.dialog({
					url:'/voucher/admin/news/add?id=' + $target.data('id') || '',
					title:'资讯',
					area:['860px','520px']
				})
			},
			'click .Js_del': function (event) {
				var id = $(event.target).data('id')
				this.del({
					url: '/voucher/admin/news/del',
					data: {
						id: id
					}
				})
			}
		}
	})
})
