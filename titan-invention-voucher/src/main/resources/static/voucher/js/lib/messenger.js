define(function (require, exports, module) {
	var Messenger = require('messenger')
	var toastr = require('toastr')

	module.exports = function (options) {
		var messenger = new Messenger(options.name)
		var $button = $(options.button)

		messenger.listen(function (result) {
			result = JSON.parse(result);
			if (result.type == 'ready') {
				$button.removeAttr("disabled")
				return
			}

			if (result.type == 'loading') {
				$button.prop("disabled", true)
				return
			}

			var isSuccess = result.is_success
			toastr[isSuccess ? 'success' : 'error'](result.message || '')

			if (isSuccess) {
				options.callback && options.callback()
			} else {
				$button.removeAttr('disabled')
			}
		})
	}
})
