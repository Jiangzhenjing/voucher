/**
 * 这个是demo
 */
define(function (require) {
    var EasePage = require('easypage')

    new EasePage({
        // 模块name
        name: 'contentpage',
        grid: {},
        events: {
            'click .Js_add': function () {
                this.dialog({
                    url: '/voucher/user/evaluate.ftl',
                    title: "评价",
                    area: ['550px', '400px'],
                    submit: {
                        url: '/voucher/common/svoucher/voucherdetails.ftl',
                        data: {}
                    }
                })
            },
        }
    })

})
