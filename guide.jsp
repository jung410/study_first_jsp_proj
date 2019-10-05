<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset='utf-8'>
    <title>초보자 가이드</title>
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="css/guide.css">
    <script src="js/guide.js"></script>
</head>
<body>
    <div id="bg"></div>
    <div class="body">
        <div class="header">
            <img src="images/logo.jpg" alt="아이언맨 사이트의 메인 로고입니다.">
            <h3>초보자 가이드</h3>
        </div>
        <div class="main">
            <div class="search"><p>게임<br>검색</p></div>
            <div class="main_service"><p>주요 서비스 안내</p></div>
            <div class="info_toto"><p>토토 게임 안내</p><p>토토 게임방법을 종류<br>별로 알려드립니다.</p></div>
            <div class="info_buy"><p>게임 구매 안내</p><p>게임 구매 방법을 알려드립니다.</p></div>
            <div class="info_proto"><p>프로토 게임 안내</p><p>프로토 게임을 종류별로<br>알려드립니다.</p></div>
            <div class="dic"><p>용어<br>사전</p></div>
        </div>
        
        <!-- 용어사전 클릭시 -->
        <div id="tabs">
            <img src="images/question-sign.png" alt="">
            <h2>토토/프로토 게임 관련 용어를 설명해 드립니다.</h2>
            <div>
                <h3>용어 사전</h3>
                <input type="text" placeholder="검색어를 입력하세요">
                <input type="button" value="검색">
            </div>
            <ul>
                <li><a href="#tabs-1">ㄱ</a></li>
                <li><a href="#tabs-2">ㄴ</a></li>
                <li><a href="#tabs-3">ㄷ</a></li>
                <li><a href="#tabs-4">ㄹ</a></li>
                <li><a href="#tabs-5">ㅁ</a></li>
                <li><a href="#tabs-6">ㅂ</a></li>
                <li><a href="#tabs-7">ㅅ</a></li>
                <li><a href="#tabs-8">ㅇ</a></li>
                <li><a href="#tabs-9">ㅈ</a></li>
                <li><a href="#tabs-10">ㅊ</a></li>
                <li><a href="#tabs-11">ㅋ</a></li>
                <li><a href="#tabs-12">ㅌ</a></li>
                <li><a href="#tabs-13">ㅍ</a></li>
                <li><a href="#tabs-14">ㅎ</a></li>
            </ul>
            <div id="tabs-1">
                <h3>고정 배당률 게임</h3>
                <p>낙원을 장식하는 천자만홍이 어디 있으며 인생을 풍부하게 하는 온갖 과실이 어디 있으랴? 이상! 우리의 청춘이 가장 많이 품고 있는 이상! 이것이야말로 무한한 가치를 가진 것이다 사람은 크고 작고 간에 이상이 있음으로써 용감하고</p>
                <hr>
                <h3>고정 환급률 게임</h3>
                <p>풀이 없으면 인간은 사막이다 오아이스도 없는 사막이다 보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 이상의 꽃이 없으면 쓸쓸한 인간에 남는 것은 영락과 부패 뿐이다 낙원을 장식하는 천자만홍이</p>
                <hr>
                <h3>구매 투표지</h3>
                <p>풀이 없으면 인간은 사막이다 오아이스도 없는 사막이다 보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 이상의 꽃이 없으면 쓸쓸한 인간에 남는 것은 영락과 부패 뿐이다 낙원을 장식하는 천자만홍이</p>
            </div>
            <div id="tabs-2">
                <h3>검색결과가 없습니다.</h3>
            </div>
            <div id="tabs-3"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-4"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-5"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-6"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-7"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-8"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-9"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-10"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-11"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-12"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-13"><h3>검색결과가 없습니다.</h3></div>
            <div id="tabs-14"><h3>검색결과가 없습니다.</h3></div>
        </div>

        <div class="footer">
            <a href="javascript:windowclose()"><img src="images/guide_home.png" alt=""></a>
            <a href="javascript:windowclose()"><h3>가이드 종료</h3></a>
            <img src="images/guide_ironman.png" alt="">
        </div>
    </div>
</body>
</html>