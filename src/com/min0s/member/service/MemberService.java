package com.min0s.member.service;

import java.util.List;

import com.min0s.member.vo.Member;

public interface MemberService {
	// 서비스를 뭘 만들어볼까
	// 일단 가입.
	boolean regist(Member vo);
	// 그리고 로그인
	Member login(Member vo);
	// 수정하자
	boolean modify(Member vo);
	// 탈퇴도 해야되고
	boolean remove(String userid, String password);
	
	// 그리고 조회
	// 로그인한 유저, 한명만 조회할 경우
	Member getMember(String userid);
	// 관리자 측에서 여러명을 조회할 경우
	// 일단 나는 관리자 페이지가 없으니까
	// 할지말지 나중에 정하고 만들어만 놓자.
	List<Member> getMembers();
}
