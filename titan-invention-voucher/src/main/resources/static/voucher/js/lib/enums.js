define(function (require, exports, module) {

	var VoucherStatus = {
		WaitActive: '待激活',
		Actived: '已激活',
		WaitConfirm: '待确认',
		Confirmed: '已确认',
		HandOver: '已交付',
		Expired: '已过期'
	}
	// 服务券状态
	exports.VoucherStatus = VoucherStatus

	exports.getVoucherStatusKey = function (str) {
		for(var key in VoucherStatus) {
			if (VoucherStatus[key] === str) {
				return key
			}
		}
	}

})
