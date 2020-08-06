package naver.rlgns1129.smartorder;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import naver.rlgns1129.smartorder.domain.StoreMenu;

//설정 파일을 읽어오는 코드
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class StoreMemuTest {
	@Autowired
	private DataSource dataSource;

	// MtBatis 사용 클래스를 주입
	@Autowired
	private SqlSession sqlSession;
	
//	@Test
//	public void getmainmenutest() {
//		StoreMenu storeMenu = new StoreMenu();
//		storeMenu.setMenuSection("메인");
//		storeMenu.setStoreNickname("기훈식당닉네임");
//		
//		System.out.println(sqlSession.selectList("storemenu.getmainmenu", storeMenu));
//		
//	}
	
//	@Test
//	public void menucheck() {
//		StoreMenu storeMenu = new StoreMenu();
//		storeMenu.setMenuName("바지락술찜");
//		storeMenu.setStoreNickname("기훈식당닉네임");
//		
//		System.out.println(sqlSession.selectOne("storemenu.menucheck", storeMenu));
//		
//	}
	
	//메뉴 상세보기 테스
//	@Test
//	public void detailMenu() {
//		String menuCode = "m1";
//	System.out.println(sqlSession.selectOne("storemenu.detailmenu", menuCode));
//	}
	
}
