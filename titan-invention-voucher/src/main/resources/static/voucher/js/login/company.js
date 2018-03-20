define(function (require) {
	require('formvalidation')
	require('formvalidation.bootstrap')

  $("#defaultForm").formValidation({
		icon: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
            phoneNumber: {
				validators: {
					notEmpty: {
						message: '请输入预留手机号'
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
      $this.attr("src", $this.attr("src") + '?t=' + new Date().getTime())
  })
})
