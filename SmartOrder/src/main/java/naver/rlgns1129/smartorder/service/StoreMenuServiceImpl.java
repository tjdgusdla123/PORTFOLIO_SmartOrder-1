package naver.rlgns1129.smartorder.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
	public Map<String, Object> insertMenu(MultipartHttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		String menuName = request.getParameter("menuName");
		String menuInfo = request.getParameter("menuInfo");
		String menuPrice = request.getParameter("menuPrice");
		String menuSection = request.getParameter("menuSection");
		Map<String, Object> storeMemberInfo = (Map<String, Object>) request.getSession().getAttribute("storememberinfo");
		String storeNickname = (String) storeMemberInfo.get("storenickname");

		System.out.println("StoreMenuServiceImpl.insertMenu.menuName 파라미터 : " + menuName);
		System.out.println("StoreMenuServiceImpl.insertMenu.menuInfo 파라미터 : " + menuInfo);
		System.out.println("StoreMenuServiceImpl.insertMenu.menuPrice 파라미터 : " + menuPrice);
		System.out.println("StoreMenuServiceImpl.insertMenu.menuSection 파라미터 : " + menuSection);
		System.out.println("StoreMenuServiceImpl.insertMenu.storeNickname 파라미터 : " + storeNickname);
		
		MultipartFile menuImage = request.getFile("menuImage");
		
		StoreMenu getMenuCode = new StoreMenu();
		getMenuCode.setMenuSection(menuSection);
		getMenuCode.setStoreNickname(storeNickname);
		
		String menuCode = storeMenuDao.getMenuCode(getMenuCode);
		System.out.println("StoreMenuServiceImpl.insertMenu.menuCode 파라미터 : " + menuCode);

		String menuCodeSubstring = menuCode.substring(storeNickname.length()+1);
		int menuCodeSubstring1 = Integer.parseInt(menuCodeSubstring);
		menuCodeSubstring1 = menuCodeSubstring1 + 1;
		
		String menuCodeSubstring2 = menuCode.substring(0, storeNickname.length()+1);
		System.out.println("StoreMenuServiceImpl.insertMenu.menuCodeSubstring2 파라미터 : " + menuCodeSubstring2);

		String realMenuCode = menuCodeSubstring2 + menuCodeSubstring1;
		System.out.println("StoreMenuServiceImpl.insertMenu.menuCode 파라미터 : " + realMenuCode);
		

		//기본값이 없는 경우는 null
		String menuFile = "";
					
		//파일이 존재하는 경우에만 
		if(menuImage != null && menuImage.isEmpty() == false) {
			//파일을 업로드할 디렉토리 경로를 설정
			String filePath = request.getServletContext().getRealPath("/storemenu/img");
			System.out.println("StoreMenuServiceImpl.insertMenu.filePath : " + filePath);
			
			
			
			try {
				if(menuImage.getOriginalFilename().length()>0) {
					//파일이름 생성 - 중복된 파일이름을 업로드 할까봐서 수정
					menuFile = UUID.randomUUID() + menuImage.getOriginalFilename();
					//파일 업로드 하기 (맥과 윈도우의 운영체제에 따라 경로 \와 /차이가 있는데 이것을 File.separator가 해결해 준다. 
					File f = new File(filePath + File.separator + menuFile);
					
					menuImage.transferTo(f);
				}else {
					menuFile = "";
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} 		
		}
		
		StoreMenu storeMenu = new StoreMenu();
		storeMenu.setMenuCode(realMenuCode);
		storeMenu.setMenuName(menuName);
		storeMenu.setMenuInfo(menuInfo);
		storeMenu.setMenuPrice(Integer.parseInt(menuPrice));
		storeMenu.setMenuPhoto(menuFile);
		storeMenu.setMenuSection(menuSection);
		storeMenu.setStoreNickname(storeNickname);
		
		int row = storeMenuDao.insertMenu(storeMenu);
		// 저장에 성공하면 map의 result에 true 저장
		if (row > 0) {
			System.out.println("StoreMenuServiceImpl.insertMenu 메뉴 삽입 성공");

			map.put("result", true);
		}
		
		return map;
	}

	@Override
	public void detailMenu(HttpServletRequest request, HttpServletResponse response) {
		
		// 요청 주소의 마지막 부분을 가져오기
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

	@Override
	public Map<String, Object> updateMenu(MultipartHttpServletRequest request, HttpServletResponse response) {
		System.out.println("StoreMenuServiceImpl.insertMenu 도착");

		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		
		String menuCode = request.getParameter("menuCode");
		String menuName = request.getParameter("menuName");
		String menuInfo = request.getParameter("menuInfo");
		String menuPrice = request.getParameter("menuPrice");
		String menuSection = request.getParameter("menuSection");
		MultipartFile menuImage = request.getFile("menuImage");
		
		System.out.println("StoreMenuServiceImpl.updateMenu.menuCode 파라미터 : " + menuCode);
		System.out.println("StoreMenuServiceImpl.updateMenu.menuName 파라미터 : " + menuName);
		System.out.println("StoreMenuServiceImpl.updateMenu.menuInfo 파라미터 : " + menuInfo);
		System.out.println("StoreMenuServiceImpl.updateMenu.menuPrice 파라미터 : " + menuPrice);
		System.out.println("StoreMenuServiceImpl.updateMenu.menuSection 파라미터 : " + menuSection);
		
		//기본값이 없는 경우는 null
				String menuFile = "";
							
				//파일이 존재하는 경우에만 
				if(menuImage != null && menuImage.isEmpty() == false) {
					//파일을 업로드할 디렉토리 경로를 설정
					String filePath = request.getServletContext().getRealPath("/storemenu/img");
					System.out.println("StoreMenuServiceImpl.insertMenu.filePath : " + filePath);
					
					
					
					try {
						if(menuImage.getOriginalFilename().length()>0) {
							//파일이름 생성 - 중복된 파일이름을 업로드 할까봐서 수정
							menuFile = UUID.randomUUID() + menuImage.getOriginalFilename();
							//파일 업로드 하기 (맥과 윈도우의 운영체제에 따라 경로 \와 /차이가 있는데 이것을 File.separator가 해결해 준다. 
							File f = new File(filePath + File.separator + menuFile);
							
							menuImage.transferTo(f);
						}else {
							menuFile = "";
						}
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					} 		
				}
				System.out.println("menuFile.length : " + menuFile.length());
				if(menuFile.length()>0) {
					StoreMenu storeMenu = new StoreMenu();

					storeMenu.setMenuCode(menuCode);
					storeMenu.setMenuName(menuName);
					storeMenu.setMenuInfo(menuInfo);
					storeMenu.setMenuPrice(Integer.parseInt(menuPrice));
					storeMenu.setMenuPhoto(menuFile);
					storeMenu.setMenuSection(menuSection);
					
					int row = storeMenuDao.updateMenuIncludeImage(storeMenu);
					System.out.println("파일이 0보다 크고 row의 값은? : " + row);
					// 저장에 성공하면 map의 result에 true 저장
					if (row > 0) {
						System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate 게시글 저장 성공");

						map.put("result", true);
					}
					
				}else {
					
					StoreMenu storeMenu = new StoreMenu();
					
					storeMenu.setMenuCode(menuCode);
					storeMenu.setMenuName(menuName);
					storeMenu.setMenuInfo(menuInfo);
					storeMenu.setMenuPrice(Integer.parseInt(menuPrice));
					storeMenu.setMenuSection(menuSection);

		
					int row = storeMenuDao.updateMenu(storeMenu);
					System.out.println("파일이 0보다 작고 row의 값은? : " + row);

					// 저장에 성공하면 map의 result에 true 저장
					if (row > 0) {
						System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate 게시글 저장 성공");

						map.put("result", true);
					}
				}
				
				return map;
		
	}
	
	@Override
	public Map<String, Object> deleteMenu(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StoreMenuServiceImpl.deleteMenu 도착");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		
		String menuCode = request.getParameter("menuCode");
		System.out.println("StoreMenuServiceImpl.deleteMenu.menuCode : " +  menuCode);

		
		int row = storeMenuDao.deleteMenu(menuCode);
		// 저장에 성공하면 map의 result에 true 저장
		if (row > 0) {
			System.out.println("StoreMenuServiceImpl.deleteMenu 메뉴 삭제 성공");

			map.put("result", true);
		}
		
		return map;

	}
	
	
	
	
}
