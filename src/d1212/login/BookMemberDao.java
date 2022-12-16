package d1212.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.util.OracleUtil;

public class BookMemberDao {
	
	
		
		public boolean login() throws SQLException {
			Connection conn =OracleUtil.getConnection();

			String sql = "SELECT*from book_member\r\n" + "where trim(email)=trim(?) and password =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);
			System.out.println("아이디 입력>>>");
			String id = sc.nextLine();

			System.out.println("패스워드 입력>>>");
			String password = sc.nextLine();

			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.execute();
			pstmt.close();
			conn.close();
			return false;
		}
		public void UpdatePassword(String id ,String pass) throws SQLException {
			
	 		Connection conn =OracleUtil.getConnection();
			String sql="update book_member set mem_idx=\r\n"
					+ "where password=";
			PreparedStatement pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			pstmt.execute();
			pstmt.close();
			conn.close();
		}
		
		public void insert() {
			int Mem_IDX;
			String name;
			String email;
			String password;
		}
		
}
