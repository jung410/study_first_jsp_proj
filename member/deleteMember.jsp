<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>인생은 아이언맨 처럼 - IRONMAN</title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/deletemember.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="js/guide.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="js/deletemember.js"></script>
    <script src="js/guideOpen.js"></script>
    <script>
        
    </script>
</head>

<body>
    <div class="mask"></div>
    <div id="header">
        <div class="logo">
            <a href="index"><img src="images/logo.jpg" alt="아이언맨사이트의 로고입니다."></a>
        </div>
        
        <div class="header_top_right">
            <form method="post">
        		<c:if test="${empty user}">
	            <ul>
	                <li><img src="images/lock.jpg" alt=""></li>
	                <li>LOGIN</li>
	                <li><input name="userid" type="text" placeholder="ID 입력"></li>
	                <li><button formaction="login">로그인</button></li>
	                <li><input type="button" value="회원가입"></li>
	            </ul>
	            <ul>
	                <li><input type="checkbox">ID저장</li>
	                <li><input name="password" type="password" placeholder="비밀번호 입력"></li>
	                <li><input type="button" value="간편로그인"></li>
	                <li><input type="button" value="ID/PW찾기"></li>
	            </ul>
        		</c:if>
	            <c:if test="${not empty user}">
	            <ul>
	                <li><p><span>${user.name}</span>님 환영합니다.</p></li>
	                <li><a href="updateMember"><img src="images/user.png" alt="마이페에지로 갈 수 있는 아이콘 입니다."></a></li>
	                <li><button formaction="logout">로그아웃</button></li>
	            </ul>	            
	            </c:if>
            </form>
        </div>
        <div class="background">
            
        </div>
        <nav>
            <ul>
                <li><a href="javascript:openGuide()">초보자 가이드</a></li>
                <li><a href="startBuyGame.jsp">게임구매</a>
                    <ul class="submenu1">
                        <li><a href="startBuyGame.jsp">구매가능 게임</a></li>
                        <li><a href="#">마감게임 보기</a></li>
                        <li><a href="#">게임일정</a></li>
                    </ul>
                </li>
                <li><a href="#">경기정보</a></li>
                <li><a href="resultGame.jsp">적중결과</a></li>
                <li><a href="#">이벤트/혜택</a></li>
            </ul>
            <ul>
                <li><a href="board-list.jsp">자유게시판</a></li>
                <li><a href="updateMember">마이페이지</a>
                    <ul class="submenu2">
                        <li><a href="updateMember">정보 수정</a></li>
                        <li><a href="boughtGame.jsp">구매한 게임</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        
        <div class="fast_search">
            <h4>빠른 경기 검색</h4>
            <form action="http://www.google.com/search?" target="_blank">
                <input type="submit" value="" class="btn_search">
                <input type="text" placeholder="검색어를 입력후 돋보기를 누르거나 Enter키를 누르면 google 검색창으로 이동합니다." size="85" name="q">
            </form>
        </div>
    </div>
    
    <div id="slidemenu">
        <div><p>QUICK MENU</p></div>
        <div><a href="startBuyGame.jsp">구매가능게임▷</a></div>
        <div><a href="javascript:openGuide()">초보자가이드</a></div>
        <div><a href="#">환급금계산기</a></div>
    </div>
    
    <div id="sidemenu">
        <h2>마이페이지</h2>
        <h4>MyPage</h4>
        <a href="updateMember">정보 수정 ></a>
        <a href="boughtGame.jsp">구매한 게임 ></a>
    </div>

    <div id="container">
        <div class="regist">
            <img src="images/regist.png" alt="">
            <h1>회원 탈퇴</h1>
            <p><span>회원 탈퇴</span>를 위해 <span>비밀번호</span>를 재입력 해주세요.</p>
        </div>
        <div class="label">
            <h3>비밀번호</h3>
            <h3>비밀번호 확인</h3>
        </div>
        <div>
	        <form id="form" name="form" method="post">
	            <input type="password" id="pw1" name="password" placeholder="6글자 이상">
	            <input type="password" id="pw2" name="password2" placeholder="비밀번호를 재입력해주세요">
			<c:choose>
			<c:when test="${empty user}">
	           <div id="layer_popup_delete">
	               <h2>회원탈퇴가 완료되었습니다</h2>
	               <button type="submit" class="confirm">확인</button>
	           </div>						
			</c:when>
			<c:otherwise>
			<div id="layer_popup_delete">
	               <h2>비밀번호가 틀렸습니다</h2>
	               <button type="submit" class="confirm">확인</button>
	           </div>
			</c:otherwise>
			</c:choose>
	       	<button formaction="removeMember" type="button" id="delete_ok"> 확인</button>
	<!--         	<input type="button" id="delete_cancle" value="취소"> -->
	        </form>
	     	<button id="delete_cancle">취소</button>
       	</div>
    </div>
    
    <div id="footer">
        <ul>
            <li><a href="introBusiness.jsp">사업소개</a></li>
            <li><a href="#">이용약관</a></li>
            <li><a href="#">개인정보처리방침</a></li>
            <li><a href="#">운영정책</a></li>
            <li><a href="#">고객센터</a></li>
            <li><a href="#">사이트맵</a></li>
        </ul>
        <div>
            <img src="images/footer_log.jpg" alt="하단 로고 이미지입니다.">
        </div>
        <p>주식회사 아이언맨토토는 국민체육진흥공단의 체육진흥투표권발행사업을 효율적으로 수행하기 위하여 인터넷<br>발매사이트(www.ironman.co.kr)의 운영에 관한 일체의 개인정보처리 업무를 위탁받아 본 홈페이지를 운영하고 있습니다.<br>개인정보처리 업무의 위탁과 관련하여 더 자세한 사항은 홈페이지에 게재된 <span>개인정보처리방침</span>을 참고 하시기 바랍니다.</p>
        <p><br>체육진흥튜표권 합법 인터넷 발매사이트는 아이언맨 입니다.<br>이 외의 사이트를 통한 튜표권발행 유사행위는 법으로 금지되어 있습니다.<br><span>체육진흥투표권 상표권리는 등록상표로서 무단 사용할 경우 법적 제재를 받을 수 있습니다.</span></p>
        <p><br>즐거운 스포츠, 즐거운 토토, 소액으로 건전하게 즐기세요. 아이언맨에서는 회차당 1인 5만원까지 구매하실 수 있습니다.<br>청소년 및 발행대상 운동경기 관계자의 투표권 구매는 불법으로 어떠한 경우에도 투표권을 구매하거나 환급금을 수령할 수 없습니다.</p>
        <p><br>체육진흥투표권 인터넷 발매 수탁사업자 (주)아이언맨토토 | 대표자명 ${user.name} | 사업자등록번호 111-11-11111 | 통신판매번호 2019-서울강서-0000<br>문의 jung4102@naver.com | 서울특별시 강서구 더조은 아카데미 | <span>고객상담전화 1588-1588</span> | 팩스 02-1111-1111 <br>COPYRIGHT@ 국민체육진흥공단 ALL RIGHTS RESERVED</p>
        <img src="images/footer_right_logo.jpg" alt="정보보호관리체제인증 마크 이미지입니다.">
    </div>
</body>
</html>