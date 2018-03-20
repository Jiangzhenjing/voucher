define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        // 与弹出此form的name一致，否则无法接受到消息
        superName: 'useradd',
        element: '#Js_form',
        fields: {
            username: {
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }
        }
    })
})
