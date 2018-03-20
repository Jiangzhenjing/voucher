define(function (require, exports, module) {
	var EasePage = require('easypage')
	var Messenger = require("gallery/messenger/2.0.0/index-debug")

	var _layerId = "#layui-layer";

	var EasePage1 = EasePage.extend({
		_initMessenger: function () {
			var that = this;
			that.messenger = new Messenger(that.get("name"));

			that.messenger.listen(function (result) {
				result = JSON.parse(result);
				if (result.type == "ready") {
					$(_layerId + that._index).find(".Js_layer_confirm").removeAttr("disabled");
					return;
				}

				if (result.type == "loading") {
					$(_layerId + that._index).find(".Js_layer_confirm").attr("disabled", "disabled");
					return;
				}

				$(_layerId + that._index).find(".Js_layer_confirm").removeAttr("disabled");

				that.tipMessenger(result);
				if (result.is_success) {
					setTimeout(function () {
						window.location.reload()
					}, 1000)
				}
			})
		}
	})

	new EasePage1({
		// 模块name
		name: 'voucherInfo',
		grid: {},
		events: {
			'click #Js_addService': function (event) {
				var id = $(event.target).data('id')
				this.dialog({
					url: '/voucher/' + id +'/slogs',
					title: "添加服务记录",
					area: ['550px', '400px']
				})
			},
      'click #Js_addComment': function (event) {
				var id = $(event.target).data('id')
				this.dialog({
					url: '/voucher/'+ id +'/comment',
					title: "评论",
					area: ['750px', '600px']
				})
      },
      'click #Js_addCommit': function (event) {
				var id = $(event.target).data('id')
				this.dialog({
					url: '/voucher/' + id + '/handle',
					title: "提交服务",
					area: ['550px', '400px']
				})
      },
			'click .Js_voucher_callback': function (event) {
				var id = $(event.target).data('id')
				this.dialog({
					url: '/voucher/' + id + '/callback',
					title: "撤销购买",
					area: ['550px', '220px']
				})
			},
			'click #Js_sign': function (event) {
				var id = $(event.target).data('id')
				this.dialog({
					url: '/voucher/' + id + '/sign',
					title: "签订合同",
					area: ['550px', '420px']
				})
			}
		}
	})
})
