define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        superName: 'engineer',
        element: '#Js_form',
        fields: {
            engineerNo: {
                validators: {
                    notEmpty: {
                        message: '编号不能为空'
                    }
                }
            },
            engineerName: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    }
                }
            }
        }
    })
})
