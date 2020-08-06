package naver.rlgns1129.smartorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.rlgns1129.smartorder.dao.StoreMemberDAO;
import naver.rlgns1129.smartorder.dao.StoreMenuDAO;
import naver.rlgns1129.smartorder.domain.StoreMember;
import naver.rlgns1129.smartorder.domain.StoreMenu;

@Service
public class StoreMenuServiceImpl implements StoreMenuService {
	@Autowired
	private StoreMenuDAO storeMenuDao;

	@Override
	public void getMenu(HttpServletRequest request, HttpServletResponse response) {
		
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
		
		List<StoreMenu> list = storeMenuDao.getMenu(storeMenu);

		System.out.println("StoreMenuServiceImpl.getMainmenu.list : " + list);
		
		request.setAttribute("list", list);
				
	}

	@Override
	public void insertMenu(MultipartHttpServletRequest request, MultipartHttpServletRequest response) {
		String menuCode = request.getParameter("menucode");
		String menuName = request.getParameter("menuname");
		String menuInfo = request.getParameter("menuinfo");
		String menuPrice = request.getParameter("menuprice");
		String menuSection = request.getParameter("menusection");
		String storeNickname = request.getParameter("storenickname");
		MultipartFile menuPhoto = request.getFile("menuphoto");
		
	}

	@Override
	public void updateMenu(MultipartHttpServletRequest request, MultipartHttpServletRequest response) {
		String menuName = request.getParameter("menuname");
		String menuInfo = request.getParameter("menuinfo");
		String menuPrice = request.getParameter("menuprice");
		String menuSection = request.getParameter("menusection");
		MultipartFile menuPhoto = request.getFile("menuphoto");
		
	}

	@Override
	public void deleteMenu(HttpServletRequest request, HttpServletResponse response) {
		String menuName = request.getParameter("menuname");
		String storeNickname = request.getParameter("storenickname");
		
		StoreMenu storeMenu = new StoreMenu();
		storeMenu.setMenuName(menuName);
		storeMenu.setStoreNickname(storeNickname);
				
		StoreMenu menuCheckMenuCode = storeMenuDao.menuCheck(storeMenu);
		String menuCode = menuCheckMenuCode.getMenuCode();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		
		storeMenuDao.deleteMenu(menuCode);
		
	}

	@Override
	public void detailMenu(HttpServletRequest request, HttpServletResponse response) {
		//요청 주소의 마지막 부분을 가져오기
//		//localhost/detail/menucode
//		System.out.println("StoreMenuServiceImpl.detailMenu 요청 도달");
//		String requestURI = request.getRequestURI();
//		System.out.println("StoreMenuServiceImpl.detailMenu.requestURI : " + requestURI);
//		String [] ar = requestURI.split("/");
//		System.out.println("StoreMenuServiceImpl.detailMenu.ar : " + ar);
//		String menuCode = ar[ar.length-1];
//		System.out.println("StoreMenuServiceImpl.detailMenu.menuCode : " + menuCode);
//		StoreMenu storeMenu = storeMenuDao.detailMenu(menuCode);
//		System.out.println("StoreMenuServiceImpl.detailMenu.storeMenu : " + storeMenu);
		
		String menuCode = request.getParameter("menucode");
		System.out.println("StoreMenuServiceImpl.detailMenu.menuCode 파라미터 : " + menuCode);
		StoreMenu storeMenu = storeMenuDao.detailMenu(menuCode);
		
		request.setAttribute("storemenu", storeMenu);
	}

	

	
	

}
