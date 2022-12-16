package d1212.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import jdbc.util.OracleUtil;



public class LoginTest {
	public static void main(String[] args) throws SQLException {
		Connection conn =OracleUtil.getConnection();

		String sql = "SELECT*from book_member\r\n" + "where trim(email)=trim(?) and password =?";
		// email 컬럼은 unique
		PreparedStatement pstmt = conn.prepareStatement(sql);

		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력>>>");
		String id = sc.nextLine();

		System.out.println("패스워드 입력>>>");
		String password = sc.nextLine();

		pstmt.setString(1, id);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next())
			System.out.println("사용자 인증 - 로그인 성공");
		else
			System.out.println("사용자 인증 - 로그인 실패");

		rs.close();
		pstmt.close();
		conn.close();

	}

}
