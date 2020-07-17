package naver.rlgns1129.smartorder.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import naver.rlgns1129.smartorder.service.StoreMemberService;

@RestController
public class StoreMemberRestController {
	@Autowired
	private StoreMemberService storeMemberService;
	
	//회원가입을 처리하는 메소드
	@RequestMapping(value="user/register", method=RequestMethod.POST)
	public Map<String, Object> join(HttpServletRequest request, HttpServletResponse response){
		
		//서비스의 메소드를 호출
		Map<String, Object> map = storeMemberService.register(request, response);
		return map;
		}
	
	@RequestMapping(value="user/login", method=RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response){
		System.out.println("StoreMemberRestController.login 데이터 오는지 확인" );
		//서비스의 메소드를 호출
		Map<String, Object> result = storeMemberService.login(request, response);
		return result;
		}
}
