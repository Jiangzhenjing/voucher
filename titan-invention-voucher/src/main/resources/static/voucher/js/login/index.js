define(function (require) {

	require('formvalidation')
	require('formvalidation.bootstrap')

  $('#defaultForm').formValidation({
		icon: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			username: {
				validators: {
					notEmpty: {
						message: '请输入账号'
					}
				}
			},
			password: {
				validators: {
					notEmpty: {
						message: '请输入密码'
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

	$(".jcaptcha-btn").click(function () {
		var $this = $(this)
		$this.attr("src", $this.attr("src") + '?' + new Date().getTime())
	})
})
