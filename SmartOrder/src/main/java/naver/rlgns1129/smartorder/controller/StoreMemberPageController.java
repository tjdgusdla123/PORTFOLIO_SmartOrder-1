package naver.rlgns1129.smartorder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.rlgns1129.smartorder.service.StoreMemberService;

@Controller
public class StoreMemberPageController {
	@Autowired
	private StoreMemberService storeMemberService;
	
	
//	@RequestMapping(value = {"/", "index.html" ,"user/main"}, method = RequestMethod.GET)
//	public String home(HttpServletRequest request, HttpServletResponse response) {
//		storeMemberService.allStoreMember(request, response);
//		return "member/main";
//	}
	
	
	@RequestMapping(value = "user/register", method = RequestMethod.GET)
	public String register() {
		
		return "member/register";
	}
	
//	@RequestMapping(value = "user/register", method = RequestMethod.POST)
//	public String register1(HttpServletRequest request, HttpServletResponse response) {
//		storeMemberService.register(request, response);
//		return "member/main";
//	}
	
	
	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public String login() {
		
		return "member/login";
	}

	
	
	
}
