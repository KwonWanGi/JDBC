package d1213.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BookRentUnitTest {
	//아래의 DAO클래스 메소드를 테스트하는것이 목적입니다.
	private BookRentDao dao= BookRentDao.getInstance();
	@Order(1)
	@DisplayName("대여 중인 도서 목록의 크기는 count 함수값과 동일해야합니다.")
	@Test
	void selectRentBookTest() throws SQLException {
//		출력문 사용 가는ㅇ하지만 출력문이 핵심은 아닙니다.
		
			List<BookRentDto> list = dao.selectRentBook();
			for(BookRentDto br : list)
				System.out.println(br);
			assertEquals(1, list.size()); 	
			//assertXXX 검증메소드 :  기대가 일치하면 성공 ,그렇지않으면 실패
//	JUnit 실행결과 창에 Failures(실패) 숫자 1이면 테스트 메소드 오류		
//		fail("Not yet implemented"); fail 메소드는 검증실패
	}
	@Order(2)
	@DisplayName("회원번호 10004가 도서대여 가능여부.")
	@Test
	void isAvailableMemberTest() throws SQLException {
		boolean result =dao.isAvailableMember(10004);
		assertEquals(false, result);
//		assertTrue(result); 	위와 동일한 메소드
	}
	@Order(3)
	@DisplayName("도서코드 여러개 데이터에 대해 대여 가능여부- 기대값 false")
	@ParameterizedTest
	@ValueSource(strings= {"C1101"})
//	@Test
	void isAvailableBookTest(String bcode) throws SQLException {
		boolean result =dao.isAvailableBook(bcode);
		assertFalse(result);
	}
	@Order(4)
	@DisplayName("회원 여러개 데이터에 대해 대여 가능여부- 기대값 true")
	@ParameterizedTest
	@ValueSource(ints= {10005})
	void isAvailableMember(int mem_idx) throws SQLException {
		boolean result =dao.isAvailableMember(mem_idx);
		assertTrue(result);
	}
	@Order(5)
	@DisplayName("회원 10004의 대여정보가 있는지 -기대값 not null")
	@Test
	void rentMemberTest() throws SQLException {
		BookRentDto dto =dao.selectRentByMember(10004);
		assertNotNull(dto);
		
	}
	
	@DisplayName("회원 10009 ,도서 C1101대여 실행 -기대값 0")
	@Test
	void rentTest() {
		try {
			int cnt =dao.rentBook(10009, "C1101");
			assertEquals(0, cnt);
		} catch (Exception e) {
			System.out.println("대여오류 : 잘못된 회원 또는 도서 입니다.");
		}
	}
	@DisplayName("회원 10009 ,도서 C1101대여 실행 -기대값 0")
	@Test
	void rentTest2() {
		try {
			int cnt =dao.rentBook(10003, "B1102");
			assertEquals(1, cnt);
		} catch (Exception e) {
			System.out.println("대여오류 : 잘못된 회원 또는 도서 입니다.");
		}
	}
}














