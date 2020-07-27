package naver.rlgns1129.smartorder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "index.html" ,"user/main"}, method = RequestMethod.GET)
	public String home() {
		return "member/main";
	}
	
	@RequestMapping(value = "orderinfo", method = RequestMethod.GET)
	public String orderinfo(HttpServletRequest request, HttpServletResponse response) {
		//storeMemberService.allStoreMember(request, response);
		return "order/orderinfo";
	}
}
