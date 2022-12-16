package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest2 {
	public static void main(String[] args) {
		
		Connection conn =OracleUtil.getConnection();
		System.out.println("연결확인");
		System.out.println(conn);
//		SQL select 실행해봅시다. - 새로운 객체 2가지 ->인터페이스를 통해서
//		DBMS종류에 따라 구현체의 객체가 생성
		PreparedStatement pstmt =null;	//sql을 실행할 객체를 참조
		ResultSet rs =null;				//select 쿼리결과 객체를 참조
		String sql= "select * from member_tbl_02";
		try {
			pstmt =conn.prepareStatement(sql);	//sql 명령을 인자로 받아 실행할 객체를 생성하여 pstmt가 참조변수
			rs = pstmt.executeQuery();			//쿼리 실행하고 그 결과를 객체로 생성하여 rs 참조
		int cnt=0;
		while(rs.next()) {
			System.out.println("첫번째 컬럼의 값 :"+ rs.getInt(1));
			System.out.println("두번째 컬럼의 값 :"+ rs.getNString(2));
			System.out.println("세번째 컬럼의 값 :"+ rs.getNString(3));
			System.out.println("네번째 컬럼의 값 :"+ rs.getNString(4));
			System.out.println("다섯번째 컬럼의 값 :"+ rs.getDate(5));
			System.out.println("여섯번째 컬럼의 값 :"+ rs.getNString(6));
			System.out.println("일곱번째 컬럼의 값 :"+ rs.getNString(7));
			
			System.out.println(rs.getInt(1)+rs.getNString(2)+rs.getNString(3)
			+rs.getNString(4)
			+rs.getDate(5)
			+rs.getNString(6)
			+rs.getNString(7));
			cnt++;
		}
		System.out.println("조회된 행의 개수 : "+cnt);
		} catch (SQLException e) {
			e.printStackTrace();	//??
		}
		
		
		
		
		
		
		
		
		
		
		
		
		OracleUtil.close(conn);
	}
}
