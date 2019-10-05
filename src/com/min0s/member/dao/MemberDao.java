package com.min0s.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.min0s.member.vo.Member;
import com.min0s.util.common.DBConnect;

public class MemberDao {
	public boolean regist(Member vo) {
		boolean retVal = false;
		System.out.println("SQL 회원 정보 추가 시작");
		try {
			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = DBConnect.getConnection().prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, vo.getName());
			pstmt.setString(idx++, vo.getUserid());
			pstmt.setString(idx++, vo.getPassword());
			pstmt.setString(idx++, vo.getPostcode());
			pstmt.setString(idx++, vo.getRoadAddr());
			pstmt.setString(idx++, vo.getDetailAddr());
			pstmt.setString(idx++, vo.getEmail());
			pstmt.setBoolean(idx++, vo.isRefundType());
			pstmt.setBoolean(idx++, vo.isReciveEmail());
			retVal = pstmt.executeUpdate() != 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("SQL 회원 정보 추가 종료");
		
		return retVal;
	}

	public Member login(Member vo) {
		Member member = null;
		System.out.println("SQL 회원 정보 로드 시작");
		try {
			String sql = "SELECT NAME, USERID, PASSWORD, POSTCODE, ROADADDR, DETAILADDR, EMAIL, REFUNDTYPE, RECIVEEMAIL FROM MEMBER WHERE USERID = ? AND PASSWORD = ?";
			PreparedStatement pstmt = DBConnect.getConnection().prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {	// 해당하는 유저가 존재 할 때!
				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getBoolean(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("SQL 회원 정보 로드 종료");
		
		return member;
	}

	public boolean modify(Member vo) {
		boolean retVal = false;
		System.out.println("SQL 데이터 변경 시작");
		try {
			String sql = "UPDATE MEMBER SET NAME = ?, PASSWORD = ?, POSTCODE = ?, ROADADDR = ?, DETAILADDR = ?, EMAIL = ?, REFUNDTYPE = ?, RECIVEEMAIL = ? WHERE USERID = ?";
			PreparedStatement pstmt = DBConnect.getConnection().prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, vo.getName());
			pstmt.setString(idx++, vo.getPassword());
			pstmt.setString(idx++, vo.getPostcode());
			pstmt.setString(idx++, vo.getRoadAddr());
			pstmt.setString(idx++, vo.getDetailAddr());
			pstmt.setString(idx++, vo.getEmail());
			pstmt.setBoolean(idx++, vo.isRefundType());
			pstmt.setBoolean(idx++, vo.isReciveEmail());
			pstmt.setString(idx++, vo.getUserid());
			retVal = pstmt.executeUpdate() != 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (retVal) {
			System.out.println("SQL 데이터 변경 정상 완료");
		} else {
			System.out.println("SQL 데이터 변경 실패");
		}
		return retVal;
	}

	public boolean remove(String userid, String password) {
		boolean retVal = false;
		System.out.println("SQL 데이터 삭제 시작");
		try {
			String sql = "DELETE FROM MEMBER WHERE USERID = ? AND PASSWORD = ?";
			PreparedStatement pstmt = DBConnect.getConnection().prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, userid);
			pstmt.setString(idx++, password);
			retVal = pstmt.executeUpdate() != 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (retVal) {
			System.out.println("SQL 데이터 삭제 정상 완료");
		} else {
			System.out.println("SQL 데이터 삭제 실패");
		}
		return retVal;
	}

	public Member getMember(String userid) {
		Member member = null;
		
		try {
			String sql = "SELECT NAME, USERID, PASSWORD, POSTCODE, ROADADDR, DETAILADDR, EMAIL, REFUNDTYPE, RECIVEEMAIL FROM MEMBER WHERE USERID = ?";
			PreparedStatement pstmt = DBConnect.getConnection().prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {	// 해당하는 유저가 존재 할 때!
				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getBoolean(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}

	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}
}
