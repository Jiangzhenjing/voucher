define(function (require) {
    var EasePage = require('easypage')
    var myData = [
        { id: "1",time: "2007-10-01", name: "number", content: "note", eval: "200.00" },
        { id: "2", time: "2007-10-02", name: "test2", content: "note2", eval: "300.00" }
    ]

    new EasePage({
        //模块名称
        name:'printlist',
        //grid的渲染元素
        gridEle:'#Js_table',
        //grid的容器
        gridcontainer:'#Js_table_container',
        //grid配置项
        grid:{
            datatype:'local',
            data:myData,
            colModel:[
                {label:'编号', name:'id'},
                {label:'时间', name:'time'},
                {label:'工程师姓名', name:'name'},
                {label:'服务内容', name:'content'},
                {label:'评价', name:'eval'}
            ],
            viewRecords: true,
            width: "100%",
            autowidth: true
        },
    })
})