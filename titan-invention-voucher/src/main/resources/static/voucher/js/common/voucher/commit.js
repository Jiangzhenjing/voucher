define(function (require) {
    var EaseForm = require('easyform')
      require("datepicker")

      //时间插件
      $(".Js_date-picker").bootstrapDP({
        language: "zh-CN",
        autoclose: true,
        format: "yyyy-mm-dd"
      });

    new EaseForm({
        // 与弹出此form的name一致，否则无法接受到消息
        superName: 'voucherInfo',
        element: '#Js_form',
        fields: {
            handDate: {
                validators: {
                    notEmpty: {
                        message: '日期不能为空'
                     }
                }
            },
            // corpType: {
            //     validators: {
            //         notEmpty: {
            //             message: '企业类型不能为空'
            //         }
            //     }
            // },
            handContent: {
                validators: {
                    notEmpty: {
                        message: '交付描述不能为空'
                    }
                }
            }
        }
    })
})
