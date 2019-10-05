package com.min0s.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min0s.board.service.BoardService;
import com.min0s.board.service.BoardServiceImpl;
import com.min0s.board.vo.Criteria;
import com.min0s.board.vo.PageDTO;

@WebServlet("/boardList")
public class BoardList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria();
		if(req.getParameter("page") != null) {
			cri.setPage(Integer.parseInt(req.getParameter("page")));
		}
		if(req.getParameter("amount") != null) {
			cri.setAmout(Integer.parseInt(req.getParameter("amount")));
		}
		BoardService service = new BoardServiceImpl();
		req.setAttribute("list", service.getBoards(cri));
		req.setAttribute("pagination", new PageDTO(cri, service.getCount()));
		
		req.getRequestDispatcher("board/board-list.jsp").forward(req, resp);
	}
}
