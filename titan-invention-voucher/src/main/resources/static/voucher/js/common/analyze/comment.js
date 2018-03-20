/**
 * Created by shaoda on 2017/8/1.
 */
define(function (require, exports, module) {
    var echarts = require("echarts")
        var myChart = echarts.init(document.getElementById("Js_vou_infor"))
        var option = {
            title : {
                text: '评价统计',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['优','良','中','差']
            },
            series : [
                {
                    name: '评价统计',
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
        }

        var enums = {
					'A': '优',
          'B': '良',
          'C': '中',
          'D': '差'
        }

        function getEnumsStr (str) {
    			for(var key in enums) {
    				if (enums[key] == str) {
    					return key
						}
					}
				}
        myChart.setOption(option)
        function getData () {
					$.ajax({
						url: '/voucher/analyze/comment',
						type: 'post',
						dataType: 'json',
						data: $("#Js_search_form").serialize()
					}).done(function (data) {
						if(data.length > 0) {
							var result = []
							for(var i =0; i< data.length; i++) {
								result.push({name: enums[data[i].serviceLevel], value: data[i].count})
							}
							option.series[0].data = result
						} else {
							option.series[0].data = [{name: "优", value: 0}, {name: "良", value: 0},{name: "中", value: 0}, {name: "差", value: 0}]
						}
						myChart.setOption(option)
					})
        }
	      getData()
        $("#Js_search_form").submit(function () {
					getData()
          return false
        })

				myChart.on('click', function (params) {
					location.href = "/voucher/analyze/sale?serviceLevel=" + getEnumsStr(params.name) +
						'&regionId=' + ($('[name=regionId]').val() || "") + '&providerId=' + ($('[name=providerId]').val() || "")
				})

})