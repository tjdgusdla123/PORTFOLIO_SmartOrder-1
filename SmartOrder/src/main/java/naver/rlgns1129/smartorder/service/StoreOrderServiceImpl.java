package naver.rlgns1129.smartorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.rlgns1129.smartorder.dao.StoreOrderDAO;
import naver.rlgns1129.smartorder.domain.StoreCartList;
import naver.rlgns1129.smartorder.domain.StoreMenu;
import naver.rlgns1129.smartorder.domain.StoreOrder;

@Service
public class StoreOrderServiceImpl implements StoreOrderService {

	@Autowired
	private StoreOrderDAO storeOrderDAO;
	
	
	@Override
	public Map<String, Object> insertOrder(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		
		String menuCode = request.getParameter("menuCode");
		String menuCount = request.getParameter("menuCount");
			
		//주문자는 QR코드를 통해 홈페이지에 접속을 합니다.
		//QR코드에는 storeTableName, storeNickname이 파라미터로 들어가 있습니다.
		String storeTableName = (String)request.getSession().getAttribute("storeTableName");
		if(storeTableName == null) {
			map.put("storeTableName", false);
			return map;
		}
		String storeNickname = (String)request.getSession().getAttribute("storeNickname");
		Map<String, Object> storeMemberInfo = (Map<String, Object>) request.getSession().getAttribute("storememberinfo");
		String memberNickname = (String) storeMemberInfo.get("storemembernickname");
		
		StoreOrder storeOrder = new StoreOrder();
		storeOrder.setMenuCode(menuCode);
		storeOrder.setMenuCount(Integer.parseInt(menuCount));
		storeOrder.setStoreTableName(storeTableName);
		storeOrder.setStoreNickname(storeNickname);
		storeOrder.setMemberNickname(memberNickname);
		
		int row = storeOrderDAO.insertOrder(storeOrder);
		if (row > 0) {
			System.out.println("StoreOrderServiceImpl.insertOrder 주문 삽입 성공");

			map.put("result", true);
		}
		
		return map;
	}

	@Override
	public Map<String, Object> cartList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);	
		
		Map<String, Object> storeMemberInfo = (Map<String, Object>) request.getSession().getAttribute("storememberinfo");
		String memberNickname = (String) storeMemberInfo.get("storemembernickname");
		
		List<StoreCartList> list = storeOrderDAO.cartList(memberNickname);
		
		if(list != null) {
			map.put("list", list);
			map.put("result", true);	
		}
		
		return map;
	}

}
