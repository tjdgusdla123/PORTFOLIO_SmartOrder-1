package naver.rlgns1129.smartorder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.rlgns1129.smartorder.service.StoreMemberService;

@Controller
public class StoreMemberController {
	@Autowired
	private StoreMemberService storeMemberService;
	
	@RequestMapping(value = {"/", "index.html"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
		storeMemberService.allStoreMember(request, response);
		return "home";
	}
}
