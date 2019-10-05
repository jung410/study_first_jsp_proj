var temp = 1;
var money = 0;
var clickedWin1 = false;
var clickedDraw1 = false;
var clickedlose1 = false;
var clickedWin2 = false;
var clickedDraw2 = false;
var clickedlose2 = false;
var clickedWin3 = false;
var clickedDraw3 = false;
var clickedlose3 = false;
var clickedWin4 = false;
var clickedDraw4 = false;
var clickedlose4 = false;
var clickedWin5 = false;
var clickedDraw5 = false;
var clickedlose5 = false;
var clickedWin6 = false;
var clickedDraw6 = false;
var clickedlose6 = false;
$(function(){
    $("nav > ul:first > li:nth-child(2), .submenu1").hover(function() {
        $(".submenu1").stop().slideDown(300);
        $(".fast_search").css("visibility", "hidden");
    }, function() {
        $(".submenu1").stop().slideUp(300);
        $(".fast_search").css("visibility", "visible");
    });
    
    $("nav > ul:last > li:nth-child(2), .submenu2").hover(function() {
        $(".submenu2").stop().slideDown(300);
        $(".fast_search").css("visibility", "hidden");
    }, function() {
        $(".submenu2").stop().slideUp(300);
        $(".fast_search").css("visibility", "visible");
    });
    
    // 로그인 버튼 누르면 header_top_right 모두 사라지고
    // 정민영님 환영합니다. / 사람아이콘 / 로그아웃버튼
    // 으로 치환되게 만들어야함
    function authed(){
        $(".header_top_right ul").hide();
        $(".header_top_right ul:last").show();
        $(".header_top_right ul:last").css("padding-top", "20px");
    }
    
    if(sessionStorage.getItem("login") == 'a'){
        authed();
    }

    $('[value="로그인"]').click(function(){
        sessionStorage.setItem("login", "a");
        authed();
    });

    $('[value="로그아웃"]').click(function(){
        sessionStorage.setItem("login", "b");
        $(".header_top_right ul").show();
        $(".header_top_right ul:last").hide();
        console.log($(location).attr('pathname'));
        if($(location).attr('pathname') == "/buyGame.jsp"){
            window.location.replace("index");
        }
    });

    $('.confirm').click(function(){
        sessionStorage.setItem("login", "b");
        $(".header_top_right ul").show();
        $(".header_top_right ul:last").hide();
    })

    // 로그인 상태가 아닐 때
    // 마이페이지 접근 불가로 만들어야함
    // 마이페이지 + 정보수정 + 구매한게임 모두.
    $('nav > ul:last > li:last a').click(function(){
        if(sessionStorage.getItem("login") == 'b'){
            $("nav > ul:last > li:last a").prop("href", "#");
            // alert("로그인 해주세요.");
            $("#dialog").dialog({
                modal: true,
                resizable: false,
                dragable: false,
                height: "auto",
                buttons: {
                    Ok: function() {
                    $( this ).dialog( "close" );
                    }
                }
            });
        }else{
            $("nav > ul:last > li:last a").prop("href", "updateMember");
            $("nav > ul:last > li:last > ul > li:last a").prop("href", "boughtGame.jsp");
        }
    })

    // slide menu
    var currentPos = parseInt($("#slidemenu").css("top"));
    $(window).scroll(function(){
        var position = $(window).scrollTop();
        $("#slidemenu").stop().animate({"top" : position + currentPos + "px"}, 10);
    });

    // beginer guide open
    function openGuide(){
        guidePop = window.open('guidePop',  'height=650,width=950,toolbar=no,directories=no,status=no,linemenubar=no,scrollbars=no,resizable=no,modal=yes,dependent=yes');
    }

    // 회원수정 취소 버튼 클릭 이벤트
    $("#form > input:last").click(function(){
        window.location.href = "index";
    });

    // 버튼 onclick 속성에서 click event로 젼환
    $("[value='간편로그인'").click(function(){
        window.location.href = 'easyLogin.jsp';
    });
    $("[value='ID/PW찾기'").click(function(){
        window.location.href = 'findMember.jsp';
    });
    $("[value='회원가입'").click(function(){
        window.location.href = 'regist.jsp';
    });

    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }

    $('[name="select_1"]').on("click", function(){
        if($('[name="select_1"]:checked').val() == "1"){
            if(!clickedDraw1 && !clickedlose1 && !clickedWin1){
                clickedWin1 = true;
                temp = temp*1.5;
            } else if(clickedWin1){
                clickedWin1 = true;
                temp = temp/1.5;
                temp = temp*1.5;
            } else if(clickedDraw1){
                clickedDraw1 = false;
                clickedWin1 = true;
                temp = temp/2.5;
                temp = temp*1.5;
            } else if(clickedlose1){
                clickedlose1 = false;
                clickedWin1 = true;
                temp = temp/3.5;
                temp = temp*1.5;
            }
        } 
        else if($('[name="select_1"]:checked').val() == "2"){
            if(!clickedWin1 && !clickedlose1 && !clickedDraw1){
                clickedDraw1 = true;
                temp = temp*2.5;
            } else if(clickedWin1){
                clickedWin1 = false;
                clickedDraw1 = true;
                temp = temp/1.5;
                temp = temp*2.5;
            } else if(clickedlose1){
                clickedlose1 = false;
                clickedDraw1 = true;
                temp = temp/3.5;
                temp = temp*2.5;
            } else if(clickedDraw1){
                clickedDraw1 = true;
                temp = temp/2.5;
                temp = temp*2.5;
            }
        }
        else if($('[name="select_1"]:checked').val() == "3"){
            if(!clickedWin1 && !clickedDraw1 && !clickedlose1){
                clickedlose1 = true;
                temp = temp*3.5;
            } else if(clickedWin1){
                clickedWin1 = false;
                clickedlose1 = true;
                temp = temp/1.5;
                temp = temp*3.5;
            } else if(clickedDraw1){
                clickedDraw1 = false;
                clickedlose1 = true;
                temp = temp/2.5;
                temp = temp*3.5;
            } else if(clickedlose1){
                clickedlose1 = true;
                temp = temp/3.5;
                temp = temp*3.5;
            }
        } 
        if(money > parseInt($(".realbuy > ul > li:first input").val())){
            $(".buy_amount").val(($(".realbuy > ul > li:first input").val()));    
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor($(".buy_amount").val()*temp)));
        } else{
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor(money*temp)));
        }
    })
    $('[name="select_2"]').on("click", function(){
        if($('[name="select_2"]:checked').val() == "1"){
            if(!clickedDraw2 && !clickedlose2 && !clickedWin2){
                clickedWin2 = true;
                temp = temp*1.5;
            } else if(clickedWin2){
                clickedWin2 = true;
                temp = temp/1.5;
                temp = temp*1.5;
            } else if(clickedDraw2){
                clickedDraw2 = false;
                clickedWin2 = true;
                temp = temp/2.5;
                temp = temp*1.5;
            } else if(clickedlose2){
                clickedlose2 = false;
                clickedWin2 = true;
                temp = temp/3.5;
                temp = temp*1.5;
            }
        } 
        else if($('[name="select_2"]:checked').val() == "2"){
            if(!clickedWin2 && !clickedlose2 && !clickedDraw2){
                clickedDraw2 = true;
                temp = temp*2.5;
            } else if(clickedWin2){
                clickedWin2 = false;
                clickedDraw2 = true;
                temp = temp/1.5;
                temp = temp*2.5;
            } else if(clickedlose2){
                clickedlose2 = false;
                clickedDraw2 = true;
                temp = temp/3.5;
                temp = temp*2.5;
            } else if(clickedDraw2){
                clickedDraw2 = true;
                temp = temp/2.5;
                temp = temp*2.5;
            }
        }
        else if($('[name="select_2"]:checked').val() == "3"){
            if(!clickedWin2 && !clickedDraw2 && !clickedlose2){
                clickedlose2 = true;
                temp = temp*3.5;
            } else if(clickedWin2){
                clickedWin2 = false;
                clickedlose2 = true;
                temp = temp/1.5;
                temp = temp*3.5;
            } else if(clickedDraw2){
                clickedDraw2 = false;
                clickedlose2 = true;
                temp = temp/2.5;
                temp = temp*3.5;
            } else if(clickedlose2){
                clickedlose2 = true;
                temp = temp/3.5;
                temp = temp*3.5;
            }
        } 
        if(money > parseInt($(".realbuy > ul > li:first input").val())){
            $(".buy_amount").val(($(".realbuy > ul > li:first input").val()));    
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor($(".buy_amount").val()*temp)));
        } else{
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor(money*temp)));
        }
    })
    $('[name="select_3"]').on("click", function(){
        if($('[name="select_3"]:checked').val() == "1"){
            if(!clickedDraw3 && !clickedlose3 && !clickedWin3){
                clickedWin3 = true;
                temp = temp*1.5;
            } else if(clickedWin3){
                clickedWin3 = true;
                temp = temp/1.5;
                temp = temp*1.5;
            } else if(clickedDraw3){
                clickedDraw3 = false;
                clickedWin3 = true;
                temp = temp/2.5;
                temp = temp*1.5;
            } else if(clickedlose3){
                clickedlose3 = false;
                clickedWin3 = true;
                temp = temp/3.5;
                temp = temp*1.5;
            }
        } 
        else if($('[name="select_3"]:checked').val() == "2"){
            if(!clickedWin3 && !clickedlose3 && !clickedDraw3){
                clickedDraw3 = true;
                temp = temp*2.5;
            } else if(clickedWin3){
                clickedWi3n3 = false;
                clickedDraw3 = true;
                temp = temp/1.5;
                temp = temp*2.5;
            } else if(clickedlose3){
                clickedlose3 = false;
                clickedDraw3 = true;
                temp = temp/3.5;
                temp = temp*2.5;
            } else if(clickedDraw3){
                clickedDraw3 = true;
                temp = temp/2.5;
                temp = temp*2.5;
            }
        }
        else if($('[name="select_3"]:checked').val() == "3"){
            if(!clickedWin3 && !clickedDraw3 && !clickedlose3){
                clickedlose3 = true;
                temp = temp*3.5;
            } else if(clickedWin3){
                clickedWin3 = false;
                clickedlose3 = true;
                temp = temp/1.5;
                temp = temp*3.5;
            } else if(clickedDraw3){
                clickedDraw3 = false;
                clickedlose3 = true;
                temp = temp/2.5;
                temp = temp*3.5;
            } else if(clickedlose3){
                clickedlose3 = true;
                temp = temp/3.5;
                temp = temp*3.5;
            }
        } 
        if(money > parseInt($(".realbuy > ul > li:first input").val())){
            $(".buy_amount").val(($(".realbuy > ul > li:first input").val()));    
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor($(".buy_amount").val()*temp)));
        } else{
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor(money*temp)));
        }
    })
    $('[name="select_4"]').on("click", function(){
        if($('[name="select_4"]:checked').val() == "1"){
            if(!clickedDraw4 && !clickedlose4 && !clickedWin4){
                clickedWin4 = true;
                temp = temp*1.5;
            } else if(clickedWin4){
                clickedWin4 = true;
                temp = temp/1.5;
                temp = temp*1.5;
            } else if(clickedDraw4){
                clickedDraw4 = false;
                clickedWin4 = true;
                temp = temp/2.5;
                temp = temp*1.5;
            } else if(clickedlose4){
                clickedlose4 = false;
                clickedWin4 = true;
                temp = temp/3.5;
                temp = temp*1.5;
            }
        } 
        else if($('[name="select_4"]:checked').val() == "2"){
            if(!clickedWin4 && !clickedlose4 && !clickedDraw4){
                clickedDraw4 = true;
                temp = temp*2.5;
            } else if(clickedWin4){
                clickedWin4 = false;
                clickedDraw4 = true;
                temp = temp/1.5;
                temp = temp*2.5;
            } else if(clickedlose4){
                clickedlose4 = false;
                clickedDraw4 = true;
                temp = temp/3.5;
                temp = temp*2.5;
            } else if(clickedDraw4){
                clickedDraw4 = true;
                temp = temp/2.5;
                temp = temp*2.5;
            }
        }
        else if($('[name="select_4"]:checked').val() == "3"){
            if(!clickedWin4 && !clickedDraw4 && !clickedlose4){
                clickedlose4 = true;
                temp = temp*3.5;
            } else if(clickedWin4){
                clickedWin4 = false;
                clickedlose4 = true;
                temp = temp/1.5;
                temp = temp*3.5;
            } else if(clickedDraw4){
                clickedDraw4 = false;
                clickedlose4 = true;
                temp = temp/2.5;
                temp = temp*3.5;
            } else if(clickedlose4){
                clickedlose4 = true;
                temp = temp/3.5;
                temp = temp*3.5;
            }
        } 
        if(money > parseInt($(".realbuy > ul > li:first input").val())){
            $(".buy_amount").val(($(".realbuy > ul > li:first input").val()));    
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor($(".buy_amount").val()*temp)));
        } else{
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor(money*temp)));
        }
    })
    $('[name="select_5"]').on("click", function(){
        if($('[name="select_5"]:checked').val() == "1"){
            if(!clickedDraw5 && !clickedlose5 && !clickedWin5){
                clickedWin5 = true;
                temp = temp*1.5;
            } else if(clickedWin5){
                clickedWin5 = true;
                temp = temp/1.5;
                temp = temp*1.5;
            } else if(clickedDraw5){
                clickedDraw5 = false;
                clickedWin5 = true;
                temp = temp/2.5;
                temp = temp*1.5;
            } else if(clickedlose5){
                clickedlose5 = false;
                clickedWin5 = true;
                temp = temp/3.5;
                temp = temp*1.5;
            }
        } 
        else if($('[name="select_5"]:checked').val() == "2"){
            if(!clickedWin5 && !clickedlose5 && !clickedDraw5){
                clickedDraw5 = true;
                temp = temp*2.5;
            } else if(clickedWin5){
                clickedWin5 = false;
                clickedDraw5 = true;
                temp = temp/1.5;
                temp = temp*2.5;
            } else if(clickedlose5){
                clickedlose5 = false;
                clickedDraw5 = true;
                temp = temp/3.5;
                temp = temp*2.5;
            } else if(clickedDraw5){
                clickedDraw5 = true;
                temp = temp/2.5;
                temp = temp*2.5;
            }
        }
        else if($('[name="select_5"]:checked').val() == "3"){
            if(!clickedWin5 && !clickedDraw5 && !clickedlose5){
                clickedlose5 = true;
                temp = temp*3.5;
            } else if(clickedWin5){
                clickedWin5 = false;
                clickedlose5 = true;
                temp = temp/1.5;
                temp = temp*3.5;
            } else if(clickedDraw5){
                clickedDraw5 = false;
                clickedlose5 = true;
                temp = temp/2.5;
                temp = temp*3.5;
            } else if(clickedlose5){
                clickedlose5 = true;
                temp = temp/3.5;
                temp = temp*3.5;
            }
        } 
        if(money > parseInt($(".realbuy > ul > li:first input").val())){
            $(".buy_amount").val(($(".realbuy > ul > li:first input").val()));    
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor($(".buy_amount").val()*temp)));
        } else{
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor(money*temp)));
        }
    })
    $('[name="select_6"]').on("click", function(){
        if($('[name="select_6"]:checked').val() == "1"){
            if(!clickedDraw6 && !clickedlose6 && !clickedWin6){
                clickedWin6 = true;
                temp = temp*1.5;
            } else if(clickedWin6){
                clickedWin6 = true;
                temp = temp/1.5;
                temp = temp*1.5;
            } else if(clickedDraw6){
                clickedDraw6 = false;
                clickedWin6 = true;
                temp = temp/2.5;
                temp = temp*1.5;
            } else if(clickedlose6){
                clickedlose6 = false;
                clickedWin6 = true;
                temp = temp/3.5;
                temp = temp*1.5;
            }
        } 
        else if($('[name="select_6"]:checked').val() == "2"){
            if(!clickedWin6 && !clickedlose6 && !clickedDraw6){
                clickedDraw6 = true;
                temp = temp*2.5;
            } else if(clickedWin6){
                clickedWin6 = false;
                clickedDraw6 = true;
                temp = temp/1.5;
                temp = temp*2.5;
            } else if(clickedlose6){
                clickedlose6 = false;
                clickedDraw6 = true;
                temp = temp/3.5;
                temp = temp*2.5;
            } else if(clickedDraw6){
                clickedDraw6 = true;
                temp = temp/2.5;
                temp = temp*2.5;
            }
        }
        else if($('[name="select_6"]:checked').val() == "3"){
            if(!clickedWin6 && !clickedDraw6 && !clickedlose6){
                clickedlose6 = true;
                temp = temp*3.5;
            } else if(clickedWin6){
                clickedWin6 = false;
                clickedlose6 = true;
                temp = temp/1.5;
                temp = temp*3.5;
            } else if(clickedDraw6){
                clickedDraw6 = false;
                clickedlose6 = true;
                temp = temp/2.5;
                temp = temp*3.5;
            } else if(clickedlose6){
                clickedlose6 = true;
                temp = temp/3.5;
                temp = temp*3.5;
            }
        } 
        if(money > parseInt($(".realbuy > ul > li:first input").val())){
            $(".buy_amount").val(($(".realbuy > ul > li:first input").val()));    
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor($(".buy_amount").val()*temp)));
        } else{
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor(money*temp)));
        }
    })
    $(".buy_amount").on("input", function(){
        $(this).val( $(this).val().replace(/[^0-9]/,"") );
        money = $(this).val();
        if(money > parseInt($(".realbuy > ul > li:first input").val())){
            $(".buy_amount").val(($(".realbuy > ul > li:first input").val()));    
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor($(".buy_amount").val()*temp)));
        } else{ 
            $(".realbuy > ul > li:last > input").val(numberWithCommas(Math.floor(money*temp)));
        }
    })


    $(".button_retry").click(function(){
        window.location.reload();
    })
    $(".button_buy").click(function(){
        $("#buy_complete").dialog({
            modal: true,
            resizable: false,
            dragable: false,
            height: "auto",
            buttons: {
                Ok: function() {
                $( this ).dialog( "close" );
                window.location.reload();
                }
            }
        });
    })
})
