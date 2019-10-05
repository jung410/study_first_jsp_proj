package com.min0s.board.service;

import java.util.List;

import com.min0s.board.vo.Board;
import com.min0s.board.vo.Criteria;

public interface BoardService {
	boolean add(Board vo);
	int getCount();
	List<Board> getBoards(Criteria cri);
	Board getBoard(int boardno);
	boolean modify(Board vo);
	boolean remove(int boardno);
}
