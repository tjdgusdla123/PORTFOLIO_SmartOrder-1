package naver.rlgns1129.smartorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.rlgns1129.smartorder.dao.StoreMemberDAO;
import naver.rlgns1129.smartorder.dao.StoreMenuDAO;
import naver.rlgns1129.smartorder.domain.StoreMember;
import naver.rlgns1129.smartorder.domain.StoreMenu;

@Service
public class StoreMenuServiceImpl implements StoreMenuService {
	@Autowired
	private StoreMenuDAO storeMenuDao;

	@Override
	public void getMainMenu(HttpServletRequest request, HttpServletResponse response) {
		
//		// 결과를 저장할 객체를 생성
//		Map<String, Object> map = new HashMap<String, Object>();
//		//성공과 실패 여부를 확인할 데이터 생성
//		map.put("result", false);
//		map.put("menusection", false);
//		map.put("storenickname", false);
		
		String menuSection = request.getParameter("menusection");
		String storeNickname = request.getParameter("storenickname");
		System.out.println("StoreMenuServiceImpl.getMainmenu.menuSection 파라미터 : " + menuSection);
		System.out.println("StoreMenuServiceImpl.getMainmenu.storeNickname 파라미터 : " + storeNickname);
		
		StoreMenu storeMenu = new StoreMenu();
		storeMenu.setMenuSection(menuSection);
		storeMenu.setStoreNickname(storeNickname);
		System.out.println("StoreMenuServiceImpl.getMainmenu.storeMenu : " + storeMenu);
		
		List<StoreMenu> list = storeMenuDao.getMainMenu(storeMenu);
		System.out.println("StoreMenuServiceImpl.getMainmenu.list : " + list);

		request.setAttribute("list", list);
				
	}

	

	
	

}
