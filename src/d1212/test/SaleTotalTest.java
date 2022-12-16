package d1212.test;

import java.util.List;

public class SaleTotalTest {

	public static void main(String[] args) {
		SaleDao dao = SaleDao.getSaleDao();
		
		List<SaleDto> list = dao.salesTotal();
		System.out.println("회원매출조회");
		System.out.println("::::::::::::::::::::::::::::::::::"); 
		
		for(SaleDto sale : list)
			System.out.println(sale.getCustno() + "\t" +
					sale.getCustname() +"\t"+
					sale.getAgrade() + "\t"+
					sale.getPsum()
					);

	}

}