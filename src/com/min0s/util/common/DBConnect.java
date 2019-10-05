package com.min0s.util.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() {
		// oracle class 위치 추가(load)시키기 <class load>
		// 안하면 class 적재가 안되는 오류 발생
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SAMPLE01", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
