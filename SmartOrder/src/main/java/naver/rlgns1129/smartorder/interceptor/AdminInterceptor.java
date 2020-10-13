package naver.rlgns1129.smartorder.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		Map<String, Object> storeMemberInfo = (Map<String, Object>) request.getSession().getAttribute("storememberinfo");
		String storeMemberVerify = (String)storeMemberInfo.get("storememberverify");
			
			if (!storeMemberVerify.equals("9")) {
				response.sendRedirect("/");
				return false;
			}
			
		return true;	
	}
}	