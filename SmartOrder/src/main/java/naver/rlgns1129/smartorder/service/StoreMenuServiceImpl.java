package naver.rlgns1129.smartorder.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.rlgns1129.smartorder.dao.StoreMemberDAO;
import naver.rlgns1129.smartorder.dao.StoreMenuDAO;
import naver.rlgns1129.smartorder.domain.StoreMember;

@Service
public class StoreMenuServiceImpl implements StoreMenuService {
	@Autowired
	private StoreMenuDAO storeMenuDao;

	@Override
	public void getMainMenu(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			
			String mainMenu = request.getParameter("메인");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	
	

}
