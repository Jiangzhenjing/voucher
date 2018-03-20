define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        // 与弹出此form的name一致，否则无法接受到消息
        superName: 'servicerecord',
        element: '#Js_form',
        fields: {
            engineer: {
                validators: {
                    notEmpty: {
                        message: '工程师不能为空'
                    }
                }
            },
            time: {
                validators: {
                    notEmpty: {
                        message: '日期不能为空'
                    }
                }
            },
            describe: {
                validators: {
                    notEmpty: {
                        message: '服务描述不能为空'
                    }
                }
            }
        }
    })
})
