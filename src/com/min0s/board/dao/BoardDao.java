package com.min0s.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.min0s.board.vo.Board;
import com.min0s.board.vo.Criteria;
import com.min0s.util.common.DBConnect;

public class BoardDao {
	public boolean add(Board vo) {
		boolean retVal = false;
		
		System.out.println("SQL 게시판 데이터 추가 시작");
		try {
			String sql = "INSERT INTO BOARD(BOARDNO, TITLE, CONTENT, WRITER) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)";
			// 제목, 내용, 작성자
			PreparedStatement pstmt = DBConnect.getConnection().prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, vo.getTitle());
			pstmt.setString(idx++, vo.getContent());
			pstmt.setString(idx++, vo.getWriter());
			retVal = pstmt.executeUpdate() != 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (retVal) {
			System.out.println("SQL 게시판 데이터 추가 정상 완료");
		} else {
			System.out.println("SQL 게시판 데이터 추가 실패");
		}
		
		return retVal;
	}

	public int getCount() {
		int cnt = 0;
		try {
			ResultSet rs = DBConnect.getConnection().prepareStatement("SELECT MAX(ROWNUM) FROM BOARD").executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public List<Board> getBoards(Criteria cri) {
		List<Board> boards = new ArrayList<>();
		
		System.out.println("게시판 목록 가져오기 시작");
		try {
			String sql = "SELECT * FROM(\r\n" + 
					"    SELECT A.*, ROWNUM RN FROM(\r\n" + 
					"        SELECT\r\n" + 
					"            BOARDNO, \r\n" + 
					"            TITLE, \r\n" + 
					"            WRITER, \r\n" + 
					"            (SELECT NAME FROM MEMBER M WHERE BOARD.WRITER = M.USERID) AS WRITER_NAME,\r\n" + 
					"            TO_CHAR(REGDATE, 'YYYY-MM-DD HH24:MI:SS') REGDATE,\r\n" + 
					"            HITCOUNT\r\n" + 
					"        FROM BOARD\r\n" + 
					"        ORDER BY BOARDNO DESC\r\n" + 
					"    ) A\r\n" + 
					"    WHERE ROWNUM <= ? * ?\r\n" + 
					")\r\n" + 
					"WHERE RN > (? - 1) * ?";
			PreparedStatement pstmt = DBConnect.getConnection().prepareStatement(sql);
			pstmt.setInt(1, cri.getPage());
			pstmt.setInt(2, cri.getAmout());
			pstmt.setInt(3, cri.getPage());
			pstmt.setInt(4, cri.getAmout());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				int idx = 1;
				board.setBoardno(rs.getInt(idx++));
				board.setTitle(rs.getString(idx++));
				board.setWriter(rs.getString(idx++));
				board.setWriterName(rs.getString(idx++));
				board.setRegDate(rs.getString(idx++));
				board.setHitCount(rs.getInt(idx++));
				boards.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("게시판 목록 가져오기 실패");
		}
		System.out.println("게시판 목록 가져오기 완료");
		System.out.println(boards);
		return boards;
	}

	public Board getBoard(int boardno) {
		Board board = null;
		
		try {
			System.out.println("조회수 1 증가 시작");
			// 조회수 증가
			String sql = "UPDATE BOARD SET HITCOUNT = (SELECT HITCOUNT FROM BOARD WHERE BOARDNO = ?) + 1 WHERE BOARDNO = ?";
			PreparedStatement pstmt = DBConnect.getConnection().prepareStatement(sql);
			pstmt.setInt(1, boardno);
			pstmt.setInt(2, boardno);
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("조회수 1 증가 완료");
			
			System.out.println("게시판 내용 가져오기 시작");
			sql = "SELECT\r\n" + 
					"    BOARDNO, \r\n" + 
					"    TITLE,\r\n" + 
					"    WRITER,\r\n" + 
					"    CONTENT,\r\n" + 
					"    (SELECT NAME FROM MEMBER M WHERE BOARD.WRITER = M.USERID) AS WRITER_NAME,\r\n" + 
					"    TO_CHAR(REGDATE, 'YYYY-MM-DD HH24-MI-SS') REGDATE,\r\n" + 
					"    HITCOUNT\r\n" + 
					"FROM BOARD\r\n" + 
					"WHERE BOARDNO = ?";
			pstmt = DBConnect.getConnection().prepareStatement(sql);
			pstmt.setInt(1, boardno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new Board();
				int idx = 1;
				board.setBoardno(rs.getInt(idx++));
				board.setTitle(rs.getString(idx++));
				board.setWriter(rs.getString(idx++));
				board.setContent(rs.getString(idx++));				
				board.setWriterName(rs.getString(idx++));
				board.setRegDate(rs.getString(idx++));
				board.setHitCount(rs.getInt(idx++));
			}
			
			// 조회수 증가
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("게시판 내용 가져오기 실패");
		}
		System.out.println("게시판 내용 가져오기 완료");
		return board;
	}

	public boolean modify(Board vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(int boardno) {
		// TODO Auto-generated method stub
		return false;
	}
}
