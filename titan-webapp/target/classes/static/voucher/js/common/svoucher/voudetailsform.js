define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        // 与弹出此form的name一致，否则无法接受到消息
        superName: 'voudetailsform',
        element: '#Js_form',
        fields: {
           time: {
                validators: {
                    notEmpty: {
                        message: '日期不能为空'
                    }
                }
            },
            type: {
                validators: {
                    notEmpty: {
                        message: '企业类型不能为空'
                    }
                }
            },
            describe: {
                validators: {
                    notEmpty: {
                        message: '交付描述不能为空'
                    }
                }
            }
        },
    })
})
