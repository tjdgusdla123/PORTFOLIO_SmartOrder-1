package naver.rlgns1129.smartorder.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import naver.rlgns1129.smartorder.service.StoreOrderService;



@RestController
public class StoreOrderRestController {
	
	@Autowired
	private StoreOrderService storeOrderService;
	
	@RequestMapping(value = {"orderinfo/order"} , method = RequestMethod.POST)
	public Map<String, Object> insertOrder(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StoreOrderRestController.saveTableName 진입");
		
		Map<String, Object> map = storeOrderService.insertOrder(request, response);
		
		return map;
	}
	
	@RequestMapping(value = {"orderinfo/getcartlist"} , method = RequestMethod.GET)
	public Map<String, Object> getcartList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("StoreOrderRestController.getcartList 진입");
		
		Map<String, Object> map = storeOrderService.cartList(request, response);
		System.out.println("StoreOrderRestController.getcartList.map : " + map);

		return map;
	}
	
}
