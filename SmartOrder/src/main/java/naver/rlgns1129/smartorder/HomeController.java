package naver.rlgns1129.smartorder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "index.html" ,"user/main"}, method = RequestMethod.GET)
	public String home() {
		return "order/orderinfo";
	}
	
	@RequestMapping(value = "smartorder/about", method = RequestMethod.GET)
	public String smartOrderAbout() {
		return "smartOrder/about";
	}
	
}