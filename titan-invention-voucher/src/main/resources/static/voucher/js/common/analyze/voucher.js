/**
 * Created by shaoda on 2017/8/1.
 */
define(function (require, exports, module) {
    var echarts = require("echarts")
		var enums = require("../../lib/enums")

    var myChart = echarts.init(document.getElementById("Js_vou_infor"))
    var option = {

					noDataLoadingOption: {
						text: '暂无数据'
					},
            title : {
                text: '服务券统计',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['待激活','已激活','待确认','已确认', '已交付', '已过期']
            },
            series : [
                {
                    name: '服务券统计',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        },
												normal: {
													label: {
														show: true,
														formatter: '{b} : {c} \n ({d}%)'
													}
												}
                    }
                }
            ]
        };

		myChart.setOption(option)

		function getData() {
			$.ajax({
				url: '/voucher/analyze/voucher',
				type: 'post',
				dataType: 'json',
				data: $('#Js_search_form').serialize()
			}).done(function (data) {
				if(data.length > 0) {
					var result = []
					for(var i =0; i< data.length; i++) {
						result.push({name: enums.VoucherStatus[data[i].voucherStatus], value: data[i].count})
					}
					option.series[0].data = result

				} else{
					option.series[0].data=[{name: "待激活", value: 0}, {name: "已激活",value: 0}]
				}
				myChart.setOption(option)
			})
		}
		getData()
		$("#Js_search_form").submit(function () {
				getData()

				return false
			})

		myChart.on('click', function (param) {
			location.href= '/voucher/search?voucherStatus=' + enums.getVoucherStatusKey(param.name) +
				'&regionId=' + ($('[name=regionId]').val() || "") + '&providerId=' + ($('[name=providerId]').val() || "")
		})
})