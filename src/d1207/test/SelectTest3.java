package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest3 {
	public static void main(String[] args) {
		Connection conn=OracleUtil.getConnection();
		PreparedStatement pstmt =null;	
		
		ResultSet rs =null;	
		
		String sql="SELECT mt.CUSTNO,\r\n"
				+ "CUSTNAME,DECODE(grade,'A','VIP','B','일반','C','직원'),psum\r\n"
				+ "FROM MEMBER_TBL_02 mt\r\n"
				+ "join\r\n"
				+ " 	(SELECT custno,sum(price) psum\r\n"
				+ "	 FROM MONEY_TBL_02 mt2 \r\n"
				+ "	GROUP BY CUSTNO \r\n"
				+ "	)sale\r\n"
				+ "ON mt.CUSTNO =sale.custno\r\n"
				+ "ORDER BY psum  deSC";
	
		try {
			pstmt =conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			int cnt=0;
			while(rs.next()) {
				System.out.println("첫번째 컬럼의 값 :"+ rs.getInt(1));
				System.out.println("두번째 컬럼의 값 :"+ rs.getNString(2));
				System.out.println("세번째 컬럼의 값 :"+ rs.getNString(3));
				System.out.println("네번째 컬럼의 값 :"+ rs.getInt(4));
					cnt++;
			}
			System.out.println("조회된 행의 개수 : "+cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		OracleUtil.close(conn);
	}
}
