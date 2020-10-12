package naver.rlgns1129.smartorder.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface StoreMenuService {
	public void getMenu(HttpServletRequest request, HttpServletResponse response);
	public void	detailMenu(HttpServletRequest request, HttpServletResponse response);
	public Map<String, Object> insertMenu(MultipartHttpServletRequest request, HttpServletResponse response);
	public Map<String, Object> updateMenu(MultipartHttpServletRequest request, HttpServletResponse response);
	public Map<String, Object> deleteMenu(HttpServletRequest request, HttpServletResponse response);

}
