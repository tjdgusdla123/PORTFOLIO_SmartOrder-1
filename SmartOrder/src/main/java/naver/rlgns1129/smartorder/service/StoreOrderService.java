package naver.rlgns1129.smartorder.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StoreOrderService {
	public Map<String, Object> insertOrder(HttpServletRequest request, HttpServletResponse response);
	public Map<String, Object> cartList(HttpServletRequest request, HttpServletResponse response);

}
