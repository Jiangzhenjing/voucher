define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        // 与弹出此form的name一致，否则无法接受到消息
        superName: 'provider',
        element: '#Js_form',
        fields: {
            pNo: {
                validators: {
                    notEmpty: {
                        message: '编号不能为空'
                    }
                }
            },
            corpName: {
                validators: {
                    notEmpty: {
                        message: '公司名不能为空'
                    }
                }
            }
        }
    })
})
