package naver.rlgns1129.smartorder.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface StoreMenuService {
	public void getMenu(HttpServletRequest request, HttpServletResponse response);
	public void	detailMenu(HttpServletRequest request, HttpServletResponse response);
	public void insertMenu(MultipartHttpServletRequest request, MultipartHttpServletRequest response);
	public void updateMenu(MultipartHttpServletRequest request, MultipartHttpServletRequest response);
	public void deleteMenu(HttpServletRequest request, HttpServletResponse response);

}
