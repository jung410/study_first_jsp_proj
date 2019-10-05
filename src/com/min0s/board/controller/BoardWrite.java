package com.min0s.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min0s.board.service.BoardServiceImpl;
import com.min0s.board.vo.Board;
import com.min0s.member.vo.Member;
import com.min0s.util.common.BeanPropertySetter;

@WebServlet("/boardWrite")
public class BoardWrite extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("board/board-write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = (Member)req.getSession().getAttribute("user");
		System.out.println(member);
		if(member != null) {
			Board board = new Board();
			BeanPropertySetter.setProps(req, board);
			board.setWriter(member.getUserid());
			
			new BoardServiceImpl().add(board);
//			System.out.println(board);
			resp.sendRedirect("boardList");
		}
	}
	
}
