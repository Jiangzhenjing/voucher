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
			voucherNo: {
				validators: {
					notEmpty: {
						message: '请输入服务券号'
					}
				}
			},
			corpName: {
				validators: {
					notEmpty: {
						message: '请输入企业名称'
					}
				}
			},
			phoneNo: {
				validators: {
					notEmpty: {
						message: '请输入预留手机号'
					}
				}
			}
		}
	})
})
