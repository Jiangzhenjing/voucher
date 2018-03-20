/**
 * Created by shaoda on 2017/8/1.
 */
define(function (require, exports, module) {
    var echarts = require("echarts")

    $(document).ready(function () {

        var myChart = echarts.init(document.getElementById("Js_vou_infor"))
        option = {
            title : {
                text: '服务券状态统计',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['已确认','已激活','未激活','已交付']
            },
            series : [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        {value:335, name:'已确认'},
                        {value:310, name:'已激活'},
                        {value:234, name:'未激活'},
                        {value:135, name:'已交付'}
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myChart.setOption(option);
    });
})