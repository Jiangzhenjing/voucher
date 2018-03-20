/**
 * 这个是demo
 */

define(function (require) {
	var EaseForm = require('easyform')

	new EaseForm({
		// 与弹出此form的name一致，否则无法接受到消息
		superName: 'voucherInfo',
		element: '#Js_form',
		fields: {
            companyImprove: {
                validators: {
                    notEmpty: {
                        message: '实施信息化后对企业有哪些改善不能为空'
                    }
                }
            },
            pointKey: {
				validators: {
					notEmpty: {
						message: '企业下一步信息化建设的重点不能为空'
					}
				}
			}
		}
	})
	var $total = $('#Js_total')
	var $scs = $("[name^='sc']")
	$scs.on("input", function () {
		var score = 0
		$scs.each(function () {
			score += +$(this).val()
		})
		$total.val(score)
	})
})
