$(function(){
    $("#tabs").tabs();
    $(".dic").click(function(){
        $("#bg, #tabs").show();
    });
    $("#bg").click(function(){
        $("#bg, #tabs").hide();
    });
})
function windowclose(){
    window.close();
}