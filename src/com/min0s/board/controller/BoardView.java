package com.min0s.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min0s.board.service.BoardServiceImpl;

@WebServlet("/boardView")
public class BoardView extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		req.setAttribute("board", new BoardServiceImpl().getBoard(boardno));
		req.getRequestDispatcher("board/board-view.jsp").forward(req, resp);
	}
	
}
