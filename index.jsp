<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>인생은 아이언맨 처럼 - IRONMAN</title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="js/guideOpen.js"></script>
    <script src="js/index.js"></script>
</head>

<body>
    <div id="dialog" style="display: none;">
        <p>로그인 후 이용가능합니다</p>
    </div>
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
                <li><a href="boardList">자유게시판</a></li>
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
   
    <div id="container">
<!--        <img src="images/mainimg.jpg" alt="">-->
        <div class="slider">
            <img src="images/slider1.jpg" alt="첫번째 슬라이더 이미지 입니다.">
            <img src="images/slider2.jpg" alt="두번째 슬라이더 이미지 입니다.">
            <img src="images/slider3.jpg" alt="세번째 슬라이더 이미지 입니다.">
            <img src="images/slider4.jpg" alt="네번째 슬라이더 이미지 입니다.">
        </div>
        <div class="close_seller">
            <h2><a href="#">가까운 판매점 찾기</a></h2>
            <!-- <img src="images/map.jpg" alt=""> -->
            <div id="map"></div>
        </div>
        <div class="game_result">
            <h2><a href="resultGame.jsp">GAME RESULT <span>게임적중결과</span></a></h2>
            <table>
                <tr>
                    <th>게임 종류</th>
                    <th>발매 회차</th>
                    <th>발표일</th>
                    <th>적중결과</th>
                </tr>
                <tr>
                    <td><a href="resultGamedetail.jsp">프로토 승부식</a></td>
                    <td>19년 63회차</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td><a href="resultGamedetail.jsp">프로토 기록식 A게임</a></td>
                    <td>19년 32회차</td>
                    <td>19-08-06</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td><a href="resultGamedetail.jsp">프로토 승부식</a></td>
                    <td>19년 63회차</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td><a href="resultGamedetail.jsp">프로토 기록식 K게임</a></td>
                    <td>19년 31회차</td>
                    <td>19-08-06</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td><a href="resultGamedetail.jsp">토토언더오버</a></td>
                    <td>19년 28회차</td>
                    <td>19-08-06</td>
                    <td>-</td>
                </tr>
            </table>
            <!-- <img src="images/gameresult.jpg" alt=""> -->
        </div>
        <div class="free_board">
            <h2><a href="board-list.jsp">자유게시판</a></h2>
            <table>
                <tr>
                    <th>제목</th>
                    <th>날짜</th>
                </tr>
                <tr>
                    <td><a href="board-list.jsp">이렇게</a></td>
                    <td>16:25</td>
                </tr>
                <tr>
                    <td><a href="board-list.jsp">게시판이</a></td>
                    <td>14:28</td>
                </tr>
                <tr>
                    <td><a href="board-list.jsp">지나요????</a></td>
                    <td>09:20</td>
                </tr>
                <tr>
                    <td><a href="board-list.jsp">abcdefg</a></td>
                    <td>19/08/07 21:20</td>
                </tr>
                <tr>
                    <td><a href="board-list.jsp">가나다라마바사아자차카</a></td>
                    <td>19/08/07 17:55</td>
                </tr>
                <tr>
                    <td><a href="board-list.jsp">어그로다 어그로</a></td>
                    <td>19/08/07 12:02</td>
                </tr>
            </table>
            <!-- <img src="images/board.jpg" alt=""> -->
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
            <img src="images/footer_log.jpg" alt="하단부 로고입니다.">
        </div>
        <p>주식회사 아이언맨토토는 국민체육진흥공단의 체육진흥투표권발행사업을 효율적으로 수행하기 위하여 인터넷<br>발매사이트(www.ironman.co.kr)의 운영에 관한 일체의 개인정보처리 업무를 위탁받아 본 홈페이지를 운영하고 있습니다.<br>개인정보처리 업무의 위탁과 관련하여 더 자세한 사항은 홈페이지에 게재된 <span>개인정보처리방침</span>을 참고 하시기 바랍니다.</p>
        <p><br>체육진흥튜표권 합법 인터넷 발매사이트는 아이언맨 입니다.<br>이 외의 사이트를 통한 튜표권발행 유사행위는 법으로 금지되어 있습니다.<br><span>체육진흥투표권 상표권리는 등록상표로서 무단 사용할 경우 법적 제재를 받을 수 있습니다.</span></p>
        <p><br>즐거운 스포츠, 즐거운 토토, 소액으로 건전하게 즐기세요. 아이언맨에서는 회차당 1인 5만원까지 구매하실 수 있습니다.<br>청소년 및 발행대상 운동경기 관계자의 투표권 구매는 불법으로 어떠한 경우에도 투표권을 구매하거나 환급금을 수령할 수 없습니다.</p>
        <p><br>체육진흥투표권 인터넷 발매 수탁사업자 (주)아이언맨토토 | 대표자명 ${user.name} | 사업자등록번호 111-11-11111 | 통신판매번호 2019-서울강서-0000<br>문의 jung4102@naver.com | 서울특별시 강서구 더조은 아카데미 | <span>고객상담전화 1588-1588</span> | 팩스 02-1111-1111 <br>COPYRIGHT@ 국민체육진흥공단 ALL RIGHTS RESERVED</p>
        <img src="images/footer_right_logo.jpg" alt="정보보호관리체제인증 마크 이미지입니다.">
    </div>
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5de415f69c80956aabe62e730552ebd4&libraries=services"></script>
    <script>
        var container = document.getElementById('map');
        var options = {
            center: new kakao.maps.LatLng(33.450701, 126.570667),
            level: 3
        };
        var map = new kakao.maps.Map(container, options);

        // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
        var mapTypeControl = new kakao.maps.MapTypeControl();

        // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
        // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
        map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

        // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
        var zoomControl = new kakao.maps.ZoomControl();

        map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

        // 장소 검색 객체를 생성합니다
        var ps = new kakao.maps.services.Places(); 

        // 키워드로 장소를 검색합니다
        ps.keywordSearch('화곡역 복권', placesSearchCB); 

        // 키워드 검색 완료 시 호출되는 콜백함수 입니다
        function placesSearchCB (data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {

                // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
                // LatLngBounds 객체에 좌표를 추가합니다
                var bounds = new kakao.maps.LatLngBounds();

                for (var i=0; i<data.length; i++) {
                    displayMarker(data[i]);    
                    bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
                }       

                // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
                map.setBounds(bounds);
            } 
        }

        // 지도에 마커를 표시하는 함수입니다
        function displayMarker(place) {
            // 마커를 생성하고 지도에 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: new kakao.maps.LatLng(place.y, place.x) 
            });

            // 마커에 클릭이벤트를 등록합니다
            kakao.maps.event.addListener(marker, 'click', function() {
                // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
                infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
                infowindow.open(map, marker);
            });
        }
    </script>
</body>
</html>