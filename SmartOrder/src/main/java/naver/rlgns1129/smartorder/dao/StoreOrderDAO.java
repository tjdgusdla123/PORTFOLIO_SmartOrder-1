package naver.rlgns1129.smartorder.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.rlgns1129.smartorder.domain.StoreOrder;

@Repository
public class StoreOrderDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//주문
	public int insertOrder(StoreOrder storeOrder) {
		System.out.println("StoreMemberDAO.login 진입");
		return sqlSession.insert("storeOrder.insertOrder" , storeOrder);
	}

	
}
