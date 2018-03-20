define(function (require, exports, module) {
	var EasyForm = require('easyform')

	var PageForm = EasyForm.extend({
		submit: function () {
			this.$element.submit()
		}
	})

	module.exports = PageForm
})