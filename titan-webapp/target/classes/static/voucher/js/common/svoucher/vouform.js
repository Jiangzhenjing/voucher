define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        // 与弹出此form的name一致，否则无法接受到消息
        superName: 'voucherform',
        element: '#Js_form',
        fields: {
            ticketnumber: {
                validators: {
                    notEmpty: {
                        message: '服务券号不能为空'
                    }
                }
            },
        name: {
            validators: {
                notEmpty: {
                    message: '法人代表不能为空'
                }
            }
        },
            region: {
                validators: {
                    notEmpty: {
                        message: '区域不能为空'
                    }
                }
            },
            enterprisename: {
                validators: {
                    notEmpty: {
                        message: '企业名称不能为空'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: '登录账号不能为空'
                    }
                }
            },
            phonesj: {
                validators: {
                    notEmpty: {
                        message: '手机号不能为空'
                    }
                }
            },
            contacts: {
                validators: {
                    notEmpty: {
                        message: '联系人不能为空'
                    }
                }
            },
            qq: {
                validators: {
                    notEmpty: {
                        message: 'QQ不能为空'
                    }
                }
            },
            weixin: {
                validators: {
                    notEmpty: {
                        message: '微信不能为空'
                    }
                }
            }
        }
    })
})
