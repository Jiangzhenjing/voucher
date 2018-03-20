define(function (require) {
        require('formvalidation')
        require('formvalidation.bootstrap')

    var time;
    var $Js_VeriCode = $('#Js_VeriCode');
    //表单验证部分
    $('#defaultForm')
        .formValidation({
            message: 'This value is not valid',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    validators: {
                        notEmpty: {
                            message: '请输入预留手机号'
                        },
                        phone: {
                            country: 'CN',
                            message: '请输入正确的手机号'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: '请重新输入密码'
                        },
                        identical: {
                            field: 'password',
                            message: '请输入重新输入确认密码'
                        }
                    }
                },
                VeriCode: {
                    validators: {
                        notEmpty: {
                            message: '请输入验证码'
                        }
                    }
                }
            }
        })
        .on('err.field.fv',function(e,data){ //当手机号码错误时
            if(data.field == 'username'){
                $Js_VeriCode.prop('disabled',true); //获取验证码的按钮为锁定状态
            }
        })
        .on('success.field.fv',function(e,data){ //手机验证正确时
            if(data.field == 'username'){
                if(time>0){
                    $Js_VeriCode.prop('disabled',true);
                }else{
                    $Js_VeriCode.prop('disabled',false);
                }
            }
        })

    //按钮触发部分
    $Js_VeriCode.click(function(){
        timeto0() //调用定时器
        $.ajax({
            url:'',
            data:{'username':$('#Js_username').val()},
            type:'post', //数据提交方式为post
            dataType:'json'//传输文件类型为json

        })
    })

    //定时器部分
    var timer
    function timeto0() { //定一个定时器函数
        clearInterval(timer);
        time = 60; //定义初始值为60
        $Js_VeriCode.prop('disabled',true); //禁用按钮
        timer = setInterval(function (){
            time--;
            if  (time < 0) {
                clearInterval(timer); //清除定时器
                $Js_VeriCode.prop('disabled',false); //恢复按钮
                $Js_VeriCode.val('获取验证码');
                return;
            }
            $Js_VeriCode.val('重新发送('+ time +')');
        }, 1000);//定时器time没1000毫秒执行一次；
    }
})