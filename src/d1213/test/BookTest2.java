package d1213.test;

import java.sql.SQLException;
import java.util.List;

public class BookTest2 {
	public static void main(String[] args) {
		BookRentDao dao = BookRentDao.getInstance();
		System.out.println("---------모든 회원 조회---------");
		int mem_idx = 10002;
		String bcode = "C1101";
		try {
			if (!dao.isAvailableMember(mem_idx)) {

				System.out.println("대여중인 도서있어서 추가대여 불가");
			} else if (!dao.isAvailableBook(bcode)) {
				System.out.println("대여 중입니다.!!");
			} else {
				dao.rentBook(mem_idx, bcode);
				System.out.println(mem_idx + "회원" + bcode + "도서 대여처리 완료");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		
		}

	}
}