define(function (require) {
    var EaseForm = require('easyform')
    new EaseForm({
        superName: 'user',
        element: '#Js_form',
        fields: {
            userName: {
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

  $("[name=roleType]").change(function () {
      $("#Js_regionAdmin").toggle()
  })
})
