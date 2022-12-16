package d1213.test;

import java.sql.SQLException;
import java.util.List;

public class BookTest1 {
	public static void main(String[] args) {
		BookRentDao dao = BookRentDao.getInstance();
		System.out.println("---------모든 회원 조회---------");
		try {
			List<Integer> mem = dao.selectAllMember();
			System.out.println(mem);
		} catch (SQLException e) {
			System.out.println("모든 회원번호 조회 실패!!");

			e.printStackTrace();
		}
		System.out.println("---------모든 도서 조회---------");
		try {
			List<String> book = dao.selectAllBook();
			System.out.println(book);
			
		} catch (SQLException e) {
			System.out.println("모든 도서코드 조회 실패!!");

			e.printStackTrace();
		}

	}
}