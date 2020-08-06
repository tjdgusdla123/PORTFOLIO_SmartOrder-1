package naver.rlgns1129.smartorder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import naver.rlgns1129.smartorder.domain.StoreMenu;
import naver.rlgns1129.smartorder.service.StoreMenuService;


@RestController
public class StoreMenuRestController {
	@Autowired
	private StoreMenuService storeMenuService;
	
	@RequestMapping(value = {"/orderinfo/mainmenu" , "/orderinfo/alcohol", "/orderinfo/drink"} , method = RequestMethod.GET)
	public Map<String, Object> mainmenu(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Controller 도착");
		storeMenuService.getMenu(request, response);
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreMenu> storeMenu = (List<StoreMenu>)request.getAttribute("list");
		map.put("list", storeMenu);
		
		
		return map;
	}
	
	@RequestMapping(value = "/orderinfo/detail" , method = RequestMethod.GET)
	public Map<String, Object> detailmenu(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StoreMenuRestController.detailmenu 도착");
		storeMenuService.detailMenu(request, response);
		StoreMenu storeMenu = (StoreMenu)request.getAttribute("storemenu");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("storemenu", storeMenu);
		return map;
	}
	
	
}
