define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        superName: 'user',
        element: '#Js_form',
        fields: {
            pw: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    })
})
