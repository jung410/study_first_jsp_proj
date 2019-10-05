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
        if($(location).attr('pathname') == "/board-write.jsp"){
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
    $("#container > div > button").click(function(){
        window.location.href = 'boardWrite';
    })
    
    Number.prototype.convertByte = function(){
		if(this < 1024){
			return this.toFixed(2)+" Bytes";
		}
		else if(this < (1024 * 1024)){
			return (this/1024).toFixed(2) + " KB";
		}
		else {
			return (this/1024/1024).toFixed(2) + " MB";
		}
	}
	
	function calcFileSize(){
		var sum = 0;
		$(".file-area :file").each(function() {
			if($(this).get(0).files.length != 0){
				sum += $(this).get(0).files[0].size;
			}
		});
		
		$(".file-area div span").eq(0).text(sum.convertByte());
		return sum;
	}
	
	$(".file-area :file").change(function(){
		var val = $(this).val();
		val = val.slice(val.lastIndexOf("\\") + 1);
		$(this).prev().text(val);
		
		var size = $(this).get(0).files[0].size;
		
		$(this).parent().next().next().text(size.convertByte());
		
		calcFileSize();
	});
	
	
	
	$(".file-area div button").click(function(){
		if($(".file-area").find("p").length >= 5) return false;
		var $clone = $(".file-area").find("p").eq(0).clone(true);
		$clone.find("span").text("파일첨부");
		$clone.find("span:eq(1)").text("");
		$clone.find(":file").val("");
		console.log($clone.find(":file").val());
		$(".file-area").append($clone);
		setAttrName();
		calcFileSize();
		var $height = parseInt($("#container > div").css("height"));
		$height += 49;
		$("#container > div").css("height", $height+"px");
		
	});
	
	// 동적생성된 html은 위임을 해야 이런게 가능하다.
	$(".file-area").on("click", "p button", function(){
		if($(".file-area").find("p").length > 1){
			$(this).parent().remove();
			var $height = parseInt($("#container > div").css("height"));
			$height -= 49;
			$("#container > div").css("height", $height+"px");
		}
		else{
			$(this).parent().find("span").text("파일첨부");
			$(this).parent().find("span:eq(1)").text("");
			$(this).parent().find(":file").val("");
		}
		setAttrName();
		calcFileSize();
	});
	
	function setAttrName(){
		$(".file").each(function(i){
			$(this).attr("name", "file"+(i+1));
		});
	};
	
	$("button:submit").click(function(){
		if($(":text[name='title']").val().trim().length == 0){
			alert("제목을 작성해주세요");
			return false;
		}
		if(calcFileSize() > (20 * 1024 * 1024)){
			alert("첨부파일의 크기가 초과되었습니다.");
			return false;
		}
	});
	
	$(".back-list").click(function(){
		history.back();
	})
})
