define(function (require, exports, module) {
        var EaseForm = require('easyform')
        new EaseForm({
            // 与弹出此form的name一致，否则无法接受到消息
            superName: 'company',
            element: '#Js_form',
            fields: {
                voucherno: {
                    validators: {
                        notEmpty: {
                            message: '服务券号不能为空'
                        }
                    }
                }
            }
        })
})
