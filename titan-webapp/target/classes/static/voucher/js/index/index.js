/**
 * 这个是demo
 */
define(function (require) {
	var EasePage = require('easypage')
	var layer = require('layer')
	var myData = [
		{ id: "1", invdate: "2007-10-01", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00" },
		{ id: "2", invdate: "2007-10-02", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00" },
		{ id: "3", invdate: "2007-09-01", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00" },
		{ id: "4", invdate: "2007-10-04", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00" },
		{ id: "5", invdate: "2007-10-05", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00" },
		{ id: "6", invdate: "2007-09-06", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00" },
		{ id: "7", invdate: "2007-10-04", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00" },
		{ id: "8", invdate: "2007-10-03", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00" },
		{ id: "9", invdate: "2007-09-01", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00" }
	]
	
	new EasePage({
		// 模块name
		name: 'index',
		// grid的渲染元素
		gridEle: '#Js_table',

		// grid的容器
		gridContainer: '#Js_table_container',

		// grid配置项
		grid: {
			datatype: "local",
			data: myData,
			colModel: [
				{label: 'label', name: 'name', key: true, width: 75, sortable: false},
				{label: 'label1', name: 'note', width: 150},
				{
					label: '操作',
					formatter: function (cellvalue, options, rowObject) {
						return '<a class="Js_add">新增</a>\
										<a class="Js_del">删除</a>'
					}
				}
			],
			viewRecords: true,
			width: "100%",
			autowidth: true,
			height: 520,
			rowNum: 20,
			rowList: [10, 20, 30],
			pager: '#Js_pager',
		},

		// form查询表单容器
		searchEle: '#Js_search_form',

		// search配置项，默认为异步提交search表单
		search: {
			// 可以通过此选项来重置默认的search事件
			// submit: function () {
			// 	alert(1)
			// }
		},

		events: {
			'click .Js_add': function () {
				this.dialog({
					url: "/voucher/index/addorupdate?id=" + $(this).attr("data-id"),
                    title: "编辑人员",
                    area: ['550px', '600px'],
					submit: {
						url: '',
						data: {}
					}
                })
			},
			'click .Js_del': function () {

				layer.msg('删除成功');
			}
		}
	})

})
