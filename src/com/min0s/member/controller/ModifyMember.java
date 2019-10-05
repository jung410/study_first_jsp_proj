package com.min0s.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min0s.member.service.MemberServiceImpl;
import com.min0s.member.vo.Member;
import com.min0s.util.common.BeanPropertySetter;

@WebServlet("/updateMember")
public class ModifyMember extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member sessionMember = (Member)(req.getSession().getAttribute("user"));
		if(sessionMember != null) {	// 로그인 되어있는 상태
			System.out.println("로그인 돼있음");
			Member member = new MemberServiceImpl().getMember(sessionMember.getUserid());
			req.setAttribute("member", member);
			req.getRequestDispatcher("member/updateMember.jsp").forward(req, resp);
		} else {	// 세션이 만기된 상태 : 로그아웃 상태
			System.out.println("로그인 안돼있음");
			resp.sendRedirect("index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = new Member();
		Member sessionMember = (Member)(req.getSession().getAttribute("user"));
		BeanPropertySetter.setProps(req, member);
		member.setUserid(sessionMember.getUserid());
		System.out.println(member);
		if(new MemberServiceImpl().modify(member)) {	// 수정 성공
			req.getSession(true).setAttribute("user", member);
			resp.sendRedirect("logout");
			System.out.println("로그아웃까지 완료");
		}else {											// 수정 실패
			resp.sendRedirect("updateMember");
		}
	}
}
