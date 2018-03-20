define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        // 与弹出此form的name一致，否则无法接受到消息
        superName: 'productadd',
        element: '#Js_form',
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: '名称不能为空'
                    }
                }
            },
            type: {
                validators: {
                    notEmpty: {
                        message: '类别不能为空'
                    }
                }
            },
            marketprice: {
                validators: {
                    notEmpty: {
                        message: '市场价格不能为空'
                    }
                }
            },
            favorableprice: {
                validators: {
                    notEmpty: {
                        message: '优惠价格不能为空'
                    }
                }
            }
        }
    })
})
