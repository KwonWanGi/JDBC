package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest4Where {
	public static void main(String[] args) {
		
		Connection conn =OracleUtil.getConnection();
		System.out.println("연결확인");
//		SQL select 실행해봅시다. - 새로운 객체 2가지 ->인터페이스를 통해서
//		DBMS종류에 따라 구현체의 객체가 생성
		PreparedStatement pstmt =null;	//sql을 실행할 객체를 참조
		ResultSet rs =null;				//select 쿼리결과 객체를 참조
//		String sql= "select * from member_tbl_02 where custno =100005";
		String sql= "select * from member_tbl_02 where custno =?";	//? 는 조건식 값, 인자.
		try {														
			pstmt =conn.prepareStatement(sql);	//sql 명령을 인자로 받아 실행할 객체를 생성하여 pstmt가 참조변수
			pstmt.setInt(1, 100001);		//1번째 ? 기호 인자에 절달될 값은 100001
			rs = pstmt.executeQuery();			//쿼리 실행하고 그 결과를 객체로 생성하여 rs 참조
		
			int cnt=0;
		if(rs.next()) {		//조건식의 컬럼 custno Pk->조회결과가 0또는1개
			System.out.println(rs.getInt(1)+"\t"+rs.getNString(2)+"\t"+rs.getNString(3)+"\t"
			+rs.getNString(4)+"\t"
			+rs.getDate(5)+"\t"
			+rs.getNString(6)+"\t"
			+rs.getNString(7));
			cnt++;
		}
//		System.out.println("조회된 행의 개수 : "+cnt);
		if(cnt==0)
			System.out.println("조회한 회원번호가 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();	//??
		}
		
		
		
		
		OracleUtil.close(conn);
	}
}
