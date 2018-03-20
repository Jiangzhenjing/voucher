define(function (require) {
    var EasyFrom = require('gallery/easyform/1.0.0/index-debug.js')
		var messenger = require('../lib/messenger')

		messenger({
			name: 'signup',
			button: '[type=submit]',
			callback: function () {
				window.location.href = "/login?role=company"
			}
		})

    new EasyFrom({
			superName: 'signup',
			element: '#defaultForm',
      fields: {
			userName: {
				validators: {
					notEmpty: {
						message: '请输入注册手机号'
					},
					phone: {
						country: 'CN',
						message: '请输入正确的手机号'
					}
				}
            },
          password: {
              validators: {
                  notEmpty: {
                      message: '密码不能为空'
                  }
              }
          },
          confirmPassword: {
              validators: {
                  notEmpty: {
                      message: '请重新输入密码'
                  },
									identical: {
										field: 'password',
										message: '请输入重新输入确认密码'
									}
              }
          },
          VeriCode: {
              validators: {
                  notEmpty: {
                      message: '请输入验证码'
                  }
              }
          }
      }
    })


})
