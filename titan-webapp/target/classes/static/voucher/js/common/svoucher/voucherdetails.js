define(function (require) {
    var EasePage = require('easypage')
    var layer = require('layer')

    new EasePage({
        //模块名称
        name:'voucherdetails',
        grid: {},
        events:{
            'click .Js_sevrecord':function(){
                this.dialog({
                    url:'/voucher/common/svoucher/servicerecord.ftl',
                    title:'新增服务记录',
                    area:['560px','490px'],
                    submit:{
                        url:''
                    }
                })
            },
            'click .Js_record':function(){
                this.dialog({
                    url:'/voucher/common/svoucher/voudetailsform.ftl',
                    title:'交付记录',
                    area:['560px','500px'],
                    submit:{
                        url:''
                    }
                })
            },

        }
    });

})