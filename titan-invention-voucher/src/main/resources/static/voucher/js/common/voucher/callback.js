define(function (require) {
	var EaseForm = require('easyform')

	new EaseForm({
		superName: 'voucherInfo',
		element: '#Js_form',
		fields: {
			reason: {
				validators: {
					notEmpty: {
						message: '请输入撤回理由'
					}
				}
			}
		}
	})
})
