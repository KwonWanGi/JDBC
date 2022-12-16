package d1212.test;

import java.util.ArrayList;
import java.util.List;

//싱글턴
public class SaleDao {
	
	private static SaleDao dao = new SaleDao();
	private SaleDao() {}
	public static SaleDao getSaleDao() {		//프로젝트 할때에는 getInstance() 이름으로 하세요.
		return dao;
	}
	
	public List<SaleDto> salesTotal() {
		String sql = "SELECT mt.custno,custname,decode(grade,'A','VIP','B','일반','C','직원') agrade,psum \r\n"
				+ "FROM MEMBER_TBL_02 mt\r\n"
				+ "JOIN\r\n"
				+ "(	\r\n"
				+ "	SELECT custno , sum(price) psum     \r\n"
				+ "	FROM MONEY_TBL_02 \r\n"
				+ "	GROUP BY custno\r\n"
				+ ") sale  \r\n"
				+ "ON mt.custno = sale.custno\r\n"
				+ "ORDER BY psum desc";
		//조회되는 결과 컬럼 : custno, custname, agrade ,psum  4개는 member와 money 한 곳에 있는 데이터가 아니므로
		//				   ㄴ 새로운 DTO 를 만듭니다. 
		
		List<SaleDto> list = new ArrayList<SaleDto>();
		
		
		
		
		return list;
	}
	

}