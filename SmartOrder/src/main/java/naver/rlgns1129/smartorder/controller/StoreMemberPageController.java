package naver.rlgns1129.smartorder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.rlgns1129.smartorder.service.StoreMemberService;

@Controller
public class StoreMemberPageController {
	@Autowired
	private StoreMemberService storeMemberService;
	
	//회원가입
	@RequestMapping(value = "user/register", method = RequestMethod.GET)
	public String register() {
		
		return "member/register";
	}
	
	//회원 로그인
	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public String login() {
		
		return "member/login";
	}
	
	//회원 로그아웃
	@RequestMapping(value = "user/signout", method = RequestMethod.GET)
	public String signout(HttpSession session) {
	 storeMemberService.logout(session);   
	 return "redirect:/";
	}
	
	//회원정보 수정에 들어갔을때 회원정보가 저장된것이 없으면 로그인창으로 보내고,
	//회원정보가 있으면 회원정보 수정창으로 보내기.
	@RequestMapping(value = "user/update", method = RequestMethod.GET)
	public String update(Model model, HttpSession session){
		System.out.println("StoreMemberRestController.update 도착");
		if(session.getAttribute("storememberinfo") == null) {
			return "redirect:user/login";
		}else {
			System.out.println("StoreMemberRestController.update.else 구문 도착");
			return "member/pwcheck";
		}
	}
	
	//회원정보수정
	@RequestMapping(value = "user/updateform", method = RequestMethod.GET)
	public String updatefrom() {
		
		System.out.println("StoreMemberRestController.updatefrom.get 도착");
			return "member/updateform";
	}
	
	//회원탈퇴
	@RequestMapping(value = "user/secession", method = RequestMethod.GET)
	public String secession(){
	
			return "member/secession";
		
	}


}

	

