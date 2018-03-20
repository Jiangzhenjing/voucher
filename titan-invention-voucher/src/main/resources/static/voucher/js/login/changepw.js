define(function (require) {

  require('formvalidation')
  require('formvalidation.bootstrap')
  var toastr =  require('toastr')

    $(function(){
        toastr.options = {
            "closeButton": false, //是否显示关闭按钮
            "debug": false, //是否使用debug模式
            "positionClass": "toast-top-full-width",//弹出窗的位置
            "showDuration": "300",//显示的动画时间
            "hideDuration": "1000",//消失的动画时间
            "timeOut": "5000", //展现时间
            "extendedTimeOut": "1000",//加长展示时间
        };
    })

  $("#defaultForm").formValidation({
    icon: {
      valid: 'glyphicon glyphicon-ok',
      invalid: 'glyphicon glyphicon-remove',
      validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
      oripassword: {
        validators: {
          notEmpty: {
            message: '请输入正确的原始密码'
          }
        }
      },
      newpassword: {
        validators: {
          notEmpty: {
            message: '密码不能为空'
          }
        }
      },
        confirmpassword: {
            validators: {
                notEmpty: {
                    message: '两次密码不一致，请重新输入'
                }
            }
        }
    }
  })
      .on('success.form.fv',function(e){
        //防止表单提交
        e.preventDefault();

        //获取表单实例
        var $form = $(e.target);

        //得到formvalidation实例
        var bv = $form.data('formValidation');

        //使用Ajax提交表单数据
          $.ajax({
              url: $form.attr('action'),
              type: 'post',
              data: $form.serialize(),
              dataType: 'json'
          }).done(function (res) {
              if (res.is_success) {
                  window.location.href = '/'
                  return
              }
              toastr.error(res.message)
          }).always(function () {

          })
      })
})
