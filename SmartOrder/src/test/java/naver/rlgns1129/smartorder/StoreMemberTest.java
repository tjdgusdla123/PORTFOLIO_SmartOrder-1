package naver.rlgns1129.smartorder;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import naver.rlgns1129.smartorder.domain.StoreMember;

//설정 파일을 읽어오는 코드
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class StoreMemberTest {
	@Autowired
	private DataSource dataSource;

	// MtBatis 사용 클래스를 주입
	@Autowired
	private SqlSession sqlSession;

//	// MyBatis 설정 정보를 테스트
//	@Test
//	public void mybatisTest() {
//		System.out.println(sqlSession);
//	}
//
//	// 데이터베이스 연결을 테스트
//	@Test
//	public void connectTest() {
//
//		try {
//			System.out.println(dataSource.getConnection());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void emailckeck1() {
//		//email 중복검사
//		System.out.println(sqlSession.selectOne("storemember.storememberemailcheck", "rlgns1129@naver.com"));
//		System.out.println(sqlSession.selectOne("storemember.storememberemailcheck", "rlgns0610@naver.com"));
//	}
//	
//	@Test
//	public void nicknamecheck1() {
//		//nickname 중복검사
//		System.out.println(sqlSession.selectOne("storemember.storemembernicknamecheck", "s12800"));
//		System.out.println(sqlSession.selectOne("storemember.storemembernicknamecheck", "배기훈짱"));
//	}
	
//	@Test
//	public void registertest1() {
//		//데이터 삽입 확인
//		
//		StoreMember storeMember = new StoreMember();
//		storeMember.setMemberEmail("springinserttest1@naver.com");
//		storeMember.setMemberNickname("springinserttest1");
//		storeMember.setMemberPassword("123456");
//		storeMember.setMemberPhoneNumber("1234567890");
//		
//		System.out.println(sqlSession.insert("storemember.insertstoremember", storeMember));
//	}
	
//	@Test
//	public void logintest() {
//		System.out.println(sqlSession.selectOne("storemember.storememberlogin", "배기훈짱"));
//		System.out.println(sqlSession.selectOne("storemember.storememberlogin", "안배기훈짱"));
//		System.out.println(sqlSession.selectOne("storemember.storememberlogin", "임성현짱"));
//	}
	
	@Test
	//데이터 수정 확인
	public void updatemember() {
		
		StoreMember storeMember = new StoreMember();
		storeMember.setMemberEmail("rlgns1129@naver.com");
		storeMember.setMemberNickname("rlgns0610");
		storeMember.setMemberPassword("test1");
		storeMember.setMemberPhoneNumber("01020065555");
		
		System.out.println(sqlSession.update("storemember.updatestoremember", storeMember));
	}
	
}
