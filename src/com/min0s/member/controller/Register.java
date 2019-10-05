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

@WebServlet("/register")
public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("member/registMember.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = new Member();
		BeanPropertySetter.setProps(req, member);
		System.out.println(member);
		if(new MemberServiceImpl().regist(member)) {
			resp.sendRedirect("index.jsp");
		} else {
			req.getRequestDispatcher("member/registMember.jsp").forward(req, resp);
		}
	}
	
}
