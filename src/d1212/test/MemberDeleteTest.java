package d1212.test;

import java.sql.SQLException;

import d1208.test.MemberDao;

public class MemberDeleteTest {
public static void main(String[] args) throws SQLException {
//	트랜잭션관리를 위해서는try~catch 를이용하여 try 안아에는commit ,catch 안에는 rollbaack
//	-> Dao메소드에서합니다.(메소드는 하나의 트랜잭션이 실행되도록 작성)
	MemberDao dao =MemberDao.getMemberDao();
	dao.delete(100122);
}
}
