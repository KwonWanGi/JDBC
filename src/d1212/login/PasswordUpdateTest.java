package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class PasswordUpdateTest {
	public static void main(String[] args) throws SQLException {
		Connection conn =OracleUtil.getConnection();
		String sql="update book_member set email=?\r\n"
				+ "where mem_idx=?";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일 입력>>>>");
		String id = sc.nextLine();
		System.out.println("변경할 패스워드 입력>>>");
		String pass= sc.nextLine();
		
		String hval =Hashing.sha256()
				.hashString(pass, StandardCharsets.UTF_8)
				.toString();
		pstmt.setString(1, hval);
		
		System.out.println("입력한 패스워드를 sha256함수로 해시값 만들면?");
		System.out.println(hval);
		
		pstmt.execute();
		pstmt.close();
		conn.close();
		System.out.println("패스워드가 변경되었습니다.");
	}
}

