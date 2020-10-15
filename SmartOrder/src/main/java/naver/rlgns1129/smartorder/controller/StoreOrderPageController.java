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
		String storeTableName = request.getParameter("tablename");
		String storeNickname = request.getParameter("storenickname");
		
		request.getSession().setAttribute("storeTableName", storeTableName);
		request.getSession().setAttribute("storeNickname", storeNickname);
		
		Map<String, Object> storeMemberInfo = (Map<String, Object>) request.getSession().getAttribute("storememberinfo");
		
		if(storeMemberInfo == null ) {
			return "redirect:/user/login";
		}else {
			return "redirect:/orderinfo";
		}
		
	}
	
	@RequestMapping(value = {"orderinfo/cartlist"} , method = RequestMethod.GET)
	public String cartList(HttpServletRequest request, HttpServletResponse response) {
		
			return "order/cartList";
		
	}
	
}
