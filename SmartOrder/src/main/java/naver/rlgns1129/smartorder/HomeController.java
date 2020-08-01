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
	//레이어팝업 연습을 위해 만든 컨트롤러
	@RequestMapping(value = "rayer", method = RequestMethod.GET)
	public String test() {
		return "practice/rayer";
	}
	
	//모달 jQuery 연습을 위해 만든 컨트롤러
	@RequestMapping(value = "modal", method = RequestMethod.GET)
	public String modal() {
		return "practice/modal";
	}
}