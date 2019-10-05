package com.min0s.member.service;

import java.util.List;

import com.min0s.member.dao.MemberDao;
import com.min0s.member.vo.Member;

public class MemberServiceImpl implements MemberService{
	MemberDao dao = new MemberDao();
	@Override
	public boolean regist(Member vo) {
		// TODO Auto-generated method stub
		return dao.regist(vo);
	}

	@Override
	public Member login(Member vo) {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

	@Override
	public boolean modify(Member vo) {
		// TODO Auto-generated method stub
		return dao.modify(vo);
	}

	@Override
	public boolean remove(String userid, String password) {
		// TODO Auto-generated method stub
		return dao.remove(userid, password);
	}

	@Override
	public Member getMember(String userid) {
		// TODO Auto-generated method stub
		return dao.getMember(userid);
	}

	@Override
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return dao.getMembers();
	}
}
