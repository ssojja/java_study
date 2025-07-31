package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconn {
	// Field
	private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	protected Statement stmt;
	protected PreparedStatement pstmt; 
	protected ResultSet rs;

	// Constructor
	protected DBconn() {
		try {
			// 1단계
			connection = DriverManager.getConnection(url, user, password);
//			System.out.println("---->> 1단계 성공 !!");
			
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	// Method
	// 2단계 - PreparedStatement 객체 생성
	public void getPreparedStatement(String sql) {
		try {
			pstmt = connection.prepareStatement(sql);
//			System.out.println("---->> 2단계 성공 !!");			
		} catch (Exception e) { e.printStackTrace(); }		
	}
	
	// 2단계 - Statement 객체 생성
		public void getStatement() {
			try {
				stmt = connection.createStatement();
				System.out.println("---->> 2단계 성공 !!");			
			} catch (Exception e) { e.printStackTrace(); }
		}
			
	// close - 객체종료
	public void close() {
		try {
			if(rs != null) 			rs.close();
			if(stmt != null) 		stmt.close();
			if(connection != null) 	connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
