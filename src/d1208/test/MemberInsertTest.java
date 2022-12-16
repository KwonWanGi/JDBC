package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class MemberInsertTest {
	public static void main(String[] args) throws SQLException {
//		String sql = "INSERT INTO MEMBER_TBL_02 (custno ,custname,phone,address,joindata,grade,city)\r\n"
//				+ "VALUES (seq_menber_tbl_02.nextval,'나행복','010-7777-2222','서울시 강남구 역삼동','2022-12-08','A','01'\r\n"
//				+ ")";
		Connection conn = OracleUtil.getConnection();
		String sql = "INSERT INTO MEMBER_TBL_02 (custno ,custname,phone,address,joindata,grade,city)\r\n"
				+ "VALUES (seq_menber_tbl_02.nextval, ?, ?, ?, sysdate, ?, ?\r\n"
				+ ")";
		
		PreparedStatement pstmt =conn.prepareStatement(sql);
//	insert/update/delete 는 ResulstSet
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "나행복");
		pstmt.setString(2, "010-7777-2299");
		pstmt.setString(3, "서울시 강남구 청담동");
		pstmt.setString(4, "B");
		pstmt.setString(5, "02");
		
		pstmt.execute();			
		conn.close();
	}
}

