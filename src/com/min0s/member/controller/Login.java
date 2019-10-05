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

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member bean = new Member();
		BeanPropertySetter.setProps(req, bean);
		System.out.println(bean);
		Member member = new MemberServiceImpl().login(bean);
		System.out.println(member);
		if(member == null) {	// 로그인 실패
			System.out.println("로그인 실패");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {				// 로그인 성공
			System.out.println("로그인 성공");
			req.getSession(true).setAttribute("user", member);
			resp.sendRedirect("index.jsp");
		}
	}
}
