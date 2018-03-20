
define(function (require) {
    require("datepicker")
    $(function(){

        $("#Js_top_left li").click(function(event){
            $(event.target).addClass('active')
                .siblings().removeClass('active');
        });

        $('#Js_shadd').click(function(){
            $('.Js_search_add').toggle();
        });

    })

})
