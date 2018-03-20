define(function (require, exports, module) {
	var EasePage = require('easypage')

	module.exports = function (pid) {
		new EasePage({
			//模块名称
			name:'product',
			//grid的渲染元素
			gridEle:'#Js_table',
			//grid的容器
			gridcontainer:'#Js_table_container',
			//grid配置项
			grid:{
				datatype:'json',
				url: '/voucher/products/' + pid,
				colModel:[
					{
						label: '编号',
						name: 'productNo'
					},
					{
						label:'名称',
						name:'productName'
					},
					{
						label:'类别',
						name:'productType'
					},
					{
						label:'价格',
						name:'discountPrice'
					},
					{
						label:'适用对象',
						name:'suitTarget'
					},
					{
						label:'操作',
						formatter: function (cellvalue, options, rowObject) {
							return '<a class="Js_edit iconfont icon-bianji" data-id="'+ rowObject.id+'">编辑</a>\
											<a class="Js_del iconfont icon-shanchu" data-id="' + rowObject.id +'">删除</a>'
						}
					}
				],
				width: "100%",
				autowidth: true,
				rowNum: 20,
				rowList: [10, 20, 30],
				search: {}
			},
			// form查询表单容器
			searchEle:'#Js_search_form',
			events:{
				'click .Js_add,.Js_edit':function(event){
					var id = $(event.target).data('id')
					this.dialog({
						url:'/voucher/products/add',
						title:'产品信息',
						data: {
							pid: pid,
							id: id
						},
						area:['700px','500px']
					})
				},
				'click .Js_del': function (event) {
					var id = $(event.target).data('id')
					this.del({
						url: '/voucher/product/del?pid=' + pid,
						data: {
							id: id
						}
					})
				}
			}
		})
	}
})
