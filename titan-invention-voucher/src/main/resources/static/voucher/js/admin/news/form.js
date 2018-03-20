define(function (require) {
	var EaseForm = require('easyform')
	var EaseForm1 = EaseForm.extend({
		submit: function () {
			$('#Js_content').html(editor.html())
			EaseForm1.superclass.submit.call(this)
		}
	})

	var editor
	KindEditor.ready(function(K) {
		editor = K.create('#Js_content', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [
				'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'link']
		})
	})

	new EaseForm1({
		superName: 'user',
		element: '#Js_form',
		fields: {
			title: {
				validators: {
					notEmpty: {
						message: '标题不能为空'
					}
				}
			},
			content: {
				validators: {
					notEmpty: {
						message: '内容不能为空'
					}
				}
			}
		}
	})

})
