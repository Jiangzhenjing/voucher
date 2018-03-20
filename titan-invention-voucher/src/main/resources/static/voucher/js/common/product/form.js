define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        superName: 'product',
        element: '#Js_form',
        fields: {
            productName: {
                validators: {
                    notEmpty: {
                        message: '名称不能为空'
                    }
                }
            },
            productType: {
                validators: {
                    notEmpty: {
                        message: '类别不能为空'
                    }
                }
            },
            orginalPrice: {
                validators: {
                    notEmpty: {
                        message: '市场价格不能为空'
                    }
                }
            },
            discountPrice: {
                validators: {
                    notEmpty: {
                        message: '优惠价格不能为空'
                    }
                }
            }
        }
    })
})
