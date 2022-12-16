package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.OracleUtil;

//DAO 클래스 : Data Access Object . SQL실행하는 메소드를 모아놓은 클래스
public class MemberDao {
	private static MemberDao dao =new MemberDao();	//private static 멤버변수가 참조하는것은 자기자신객체
	private MemberDao() {};							//생성자 private (이클래스외에는 사용못함.)
	public static MemberDao getMemberDao() {		// 생성된객체를 리턴해주는 public 메소드 -항상동일한 객체를 리턴.
		return dao;
	}
	
	public void update(Member member) throws SQLException {
		String sql="update member_tbl_02\r\n"
				+ "set phone =?,address=?,city =?\r\n"
				+ "where custno =?";
		Connection conn= OracleUtil.getConnection();
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, member.getPhone());
		pstmt.setString(2, member.getAddress());
		pstmt.setString(3, member.getCity());
		pstmt.setInt(4, member.getCustno());
		
		pstmt.execute();	
		pstmt.close();	//pstmt에 지정된 sql 실행종료.(close:자원해제)
		conn.close();		
	}
	
	
	public void delete(int custno) throws SQLException {
		String sql ="delete from member_tbl_02 where custno =?";
		Connection conn= OracleUtil.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, custno);
		
		
	}
	
	public void insert(Member member) throws SQLException {
//		Member객체를 인자로 받아서 insert 할 값으로 SQL에 전달.
		Connection conn= OracleUtil.getConnection();
		String sql= "INSERT INTO MEMBER_TBL_02 (custno ,custname,phone,address,joindata,grade,city)\r\n"
				+ "VALUES (seq_menber_tbl_02.nextval, ?, ?, ?, sysdate, ?, ?\r\n"
				+ ")";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, member.getCustname());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getGrade());
		pstmt.setString(5, member.getCity());
		
		pstmt.execute();			//select SQL은 executeQuery 메소드,나머지는 execute 메소드
		pstmt.close();	//pstmt에 지정된 sql 실행종료.(close:자원해제)
//		conn.commit();//autocommit 이 false일때 필요
//		conn.rollback(); 하나의 트랜잭션을 구성하는 여러 SQL중 일부를
		conn.close();
	}
	
	
	public List<Member> selectList() throws SQLException{
		 
		Connection conn= OracleUtil.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs =null;	
		String sql= "select * from member_tbl_02";
		
		pstmt =conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<Member> memberList =new ArrayList<Member>();
		while(rs.next()) {
			Member m =new Member(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDate(5),
					rs.getString(6),
					rs.getString(7)
					);
			memberList.add(m);
		}
		pstmt.execute();			//select SQL은 executeQuery 메소드,나머지는 execute 메소드
		pstmt.close();	//pstmt에 지정된 sql 실행종료.(close:자원해제)
		conn.close();
		return memberList;
	}
	
	public Member selectOne(int custno) throws SQLException{
//		pk값 custno 를 인자로 전달받아서 해당되는 조회결과를 Member 객체로 리턴
		Member member =null;
		Connection conn= OracleUtil.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs =null;	
		String sql= "select * from member_tbl_02 ";
		
		pstmt =conn.prepareStatement(sql);
		pstmt.setInt(1, custno);
		rs = pstmt.executeQuery();
		
		List<Member> memberList =new ArrayList<Member>();
		int cnt =0;
		if(rs.next()) {
			member =new Member(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDate(5),
					rs.getString(6),
					rs.getString(7)
					);
		}
		
		pstmt.execute();			//select SQL은 executeQuery 메소드,나머지는 execute 메소드
		pstmt.close();	//pstmt에 지정된 sql 실행종료.(close:자원해제)
		conn.close();
		return member;
	}
	public void update(int i) {
		// TODO Auto-generated method stub
		
	}
}
