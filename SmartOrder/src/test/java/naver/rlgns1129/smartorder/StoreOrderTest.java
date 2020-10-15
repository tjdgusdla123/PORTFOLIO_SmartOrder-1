package naver.rlgns1129.smartorder;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import naver.rlgns1129.smartorder.domain.StoreCartList;
import naver.rlgns1129.smartorder.domain.StoreOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class StoreOrderTest {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
//	@Test
//	public void getMenuCode() {
//		StoreOrder storeOrder = new StoreOrder();
//		storeOrder.setMenuCode("기훈이네김밥천국닉네임m1");
//		storeOrder.setMenuCount(2);
//		storeOrder.setStoreNickname("기훈이네김밥천국닉네임");
//		storeOrder.setStoreTableName("1");
//		storeOrder.setMemberNickname("member");
//		
//		int row = sqlSession.insert("storeOrder.insertOrder", storeOrder);
//		System.out.println(row);
//	}
	
	@Test
	public void cartList() {
		String memberNickname = "member";
		
		List<StoreCartList> cartList = sqlSession.selectList("storeOrder.cartList", memberNickname);
		System.out.println(cartList);
	}
}
