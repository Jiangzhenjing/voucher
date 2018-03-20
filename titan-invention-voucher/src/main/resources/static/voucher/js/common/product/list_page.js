/**
 *
 * **/
define(function (require) {
    var layer = require("layer");


    $(".Js_conul_cz").on('click',function(event){
        var data = $(event.target).data()
        var providerId = data.providerid
			  var productId = data.productid
        var title = data.title
			  var discountprice = data.discountprice
			layer.open({
            type: 0,
            title: '选择服务产品',
            area: ['560px', '380px'],
            shadeClose: true, //点击遮罩关闭
            btn: ['确认', '取消'],
            content: '<div class="vou-select-pro"><ul><li><span>服务产品</span>' + title + '</li><li><span>价格</span>' + discountprice + '</li><li><span>服务券抵扣</span>10000元</li> <li> <span>应付</span><strong>' +
                (discountprice - 10000) +
						    '元</strong><em>差额部分请按照与服务商签订的合同执行</em></li></ul></div>',
            yes: function () {
                $.ajax({
                  url: "/voucher/product/auth?providerId=" + providerId + '&productId=' + productId,
                  type: 'post'
                }).done(function () {
                    window.location.reload()
                })
            }
        })
    });
        // var options = {
        //     currentPage: 3,
        //     totalPages: 10,
        //     numberOfPages: 5,
					//   onPageClicked: function (event, originalEvent, type, page) {
        //        window.location.href= "/voucher/company?page=" + page
        //     }
        // }
        // $('#Js_listpage').bootstrapPaginator(options);

})
