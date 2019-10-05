package com.min0s.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min0s.member.service.MemberServiceImpl;
import com.min0s.member.vo.Member;

@WebServlet("/removeMember")
public class RemoveMember extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("member/deleteMember.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = (Member)(req.getSession().getAttribute("user"));
		System.out.println(member);
		if(member != null) {
			if(new MemberServiceImpl().remove(member.getUserid(), req.getParameter("password"))){
				resp.sendRedirect("logout");
			} else {	// 비밀번호 오류시
				// 다시 회원탈퇴 페이지로 돌아간다.
				req.getRequestDispatcher("member/deleteMember.jsp").forward(req, resp);
			}
		}		
	}
	
}
