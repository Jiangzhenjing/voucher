/**
 * 这个是demo
 * **/
define(function (require) {
    var EasePage = require('easypage')
    new EasePage({
        // 模块name
        name: 'conpagefirst',
        grid: {},
        events: {
            'click .Js_conul_cz': function () {
                this.dialog({
                    url: '/voucher/user/selectproducts.ftl',
                    title: "选择服务产品",
                    area: ['560px', '280px'],
                    submit: {
                        url: '/voucher/user/contentpage.ftl',
                        data: {}
                    }
                })
            }
        }
    })

})
