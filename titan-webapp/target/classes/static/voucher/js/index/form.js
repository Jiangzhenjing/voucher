define(function (require) {
	var EaseForm = require('easyform')
	new EaseForm({
		// 与弹出此form的name一致，否则无法接受到消息
		superName: 'index',
		element: '#Js_form',
		fields: {
			email: {
				validators: {
					notEmpty: {
						message: '邮箱不能为空'
					}
				}
			},
			password: {
				validators: {
					notEmpty: {
						message: '密码不能为空'
					}
				}
			}
		}
	})
})
