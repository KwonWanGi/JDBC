package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleUtil {
	public static Connection getConnection() {

		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "iclass10";
		String password = "1234";

		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 드라이버 로드에 문제가 생겼습니다. : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 및 사용에 문제가 생겼습니다. : " + e.getMessage());
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("연결종료!");
			}else {
				System.out.println("Connection 이 null 입니다.");
			}
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결종료오류" + e.getMessage());
		}
	}

// rs ,pstmt ,conn 모두 close 할때
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if(pstmt !=null) pstmt.close();
			if (conn != null) {
				conn.close();
				System.out.println("연결종료!");
			}else {
				System.out.println("Connection 이 null 입니다.");
			}
		} catch (SQLException e) {
			System.out.println("데이터 베이스 연결종료오류" + e.getMessage());
		}
	}

}
