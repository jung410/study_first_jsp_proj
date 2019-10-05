package com.min0s.board.service;

import java.util.List;

import com.min0s.board.dao.BoardDao;
import com.min0s.board.vo.Board;
import com.min0s.board.vo.Criteria;

public class BoardServiceImpl implements BoardService{
	BoardDao dao = new BoardDao();
	@Override
	public boolean add(Board vo) {
		// TODO Auto-generated method stub
		return dao.add(vo);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}

	@Override
	public List<Board> getBoards(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.getBoards(cri);
	}

	@Override
	public Board getBoard(int boardno) {
		// TODO Auto-generated method stub
		return dao.getBoard(boardno);
	}

	@Override
	public boolean modify(Board vo) {
		// TODO Auto-generated method stub
		return dao.modify(vo);
	}

	@Override
	public boolean remove(int boardno) {
		// TODO Auto-generated method stub
		return dao.remove(boardno);
	}

}
