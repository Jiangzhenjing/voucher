define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        // 与弹出此form的name一致，否则无法接受到消息
        superName: 'engineeradd',
        element: '#Js_form',
        fields: {
            number: {
                validators: {
                    notEmpty: {
                        message: '信用代码不能为空'
                    }
                }
            },
            name: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
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
            scale: {
                validators: {
                    notEmpty: {
                        message: '企业规模不能为空'
                    }
                }
            },
            rep: {
                validators: {
                    notEmpty: {
                        message: '法定代表人不能为空'
                    }
                }
            },
            address: {
                validators: {
                    notEmpty: {
                        message: '地址不能为空'
                    }
                }
            },
            time: {
                validators: {
                    notEmpty: {
                        message: '成立日期不能为空'
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
            phone: {
                validators: {
                    notEmpty: {
                        message: '联系电话不能为空'
                    }
                }
            },
        }
    })
})
