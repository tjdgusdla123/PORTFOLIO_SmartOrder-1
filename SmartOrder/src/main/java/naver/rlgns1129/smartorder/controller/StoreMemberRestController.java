package naver.rlgns1129.smartorder.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
		System.out.println("StoreMemberRestController.join.map 파라미터 : " + map);
		return map;
		}
	
	@RequestMapping(value="user/login", method=RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response){
		System.out.println("StoreMemberRestController.login 데이터 오는지 확인" );
		//서비스의 메소드를 호출
		Map<String, Object> result = storeMemberService.login(request, response);
		System.out.println("StoreMemberRestController.login.result : " + result  );
		
		return result;
		}
	
	@RequestMapping(value="address")
	public Map<String, Object> address(@RequestParam("loc")String loc){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("address", storeMemberService.address(loc));
		//System.out.println(map);
		return map;
	}
	
	//비밀번호 확인 요청을 처리하는 메소드
	@RequestMapping(value = "user/pwcheck", method = RequestMethod.POST)
	public Map<String, Object> pwcheck(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StoreMemberRestController.pwcheck 도착");
		
		Map<String, Object> result = storeMemberService.login(request, response);
		System.out.println("StoreMemberRestController.pwcheck.result : " + result  );
		
		return result;
	}

	@RequestMapping(value="user/update", method=RequestMethod.POST)
	public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response){
		System.out.println("StoreMemberRestController.update.post 도착");
		//서비스의 메소드를 호출
		Map<String, Object> map = storeMemberService.update(request, response);
		System.out.println("StoreMemberRestController.update.map 파라미터 : " + map);
		
		return map;
		
		}

	@RequestMapping(value = "user/secession", method = RequestMethod.POST)
	public String secession(HttpServletRequest request, HttpServletResponse response , RedirectAttributes attr) {
		
		Map<String, Object> resultMap = storeMemberService.secession(request,response);
		if((Boolean)resultMap.get("result")==true) {
			request.getSession().removeAttribute("storememberinfo");
			System.out.println("if 구문 진입");
			//attr.addFlashAttribute("result", true);
			return "redirect:/user/main";
		}else {
			System.out.println("else 구문 진입");
			//attr.addFlashAttribute("result", false);
			
			return "redirect:/user/secession";
		}
		
	}
	
	


}
