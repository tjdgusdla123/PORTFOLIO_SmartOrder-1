package naver.rlgns1129.smartorder.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreOrderPageController {
	//http://localhost:8080/orderinfo/table?tablename=1&storenickname=기훈이네김밥천국닉네임
	@RequestMapping(value = {"orderinfo/table"} , method = RequestMethod.GET)
	public String saveTableName(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StoreOrderPageController.saveTableName 진입");
		String storeTableName = request.getParameter("tablename");
		String storeNickname = request.getParameter("storenickname");
		
		request.getSession().setAttribute("storeTableName", storeTableName);
		request.getSession().setAttribute("storeNickname", storeNickname);
		
		Map<String, Object> storeMemberInfo = (Map<String, Object>) request.getSession().getAttribute("storememberinfo");
		System.out.println("세션에 저장된 storeMemberInfo : " + storeMemberInfo);
		
		
		
		if(storeMemberInfo == null ) {
			return "redirect:/user/login";
		}else {
			return "redirect:/orderinfo";
		}
		
	}
}
