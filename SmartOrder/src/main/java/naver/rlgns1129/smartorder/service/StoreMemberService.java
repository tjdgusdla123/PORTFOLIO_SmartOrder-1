package naver.rlgns1129.smartorder.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//서비스의 메소드는 매개변수를 다양하게 만들 수 있습니다.
//모든 곳에서 사용가능하도록 만들고자 하면 HttpServletRequest 와 HttpServletResponse를 갖도록 하면 되고
//상황에 따라 다르게 만들 수도 있습니다.
public interface StoreMemberService {
	//전체 데이터를 가져오는 메소드
		public void allStoreMember(HttpServletRequest request, HttpServletResponse response);
		public Map<String, Object> register(HttpServletRequest request, HttpServletResponse response);
		public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response);
		public Map<String, Object> update(HttpServletRequest request , HttpServletResponse response);
		public Map<String, Object> secession(HttpServletRequest request , HttpServletResponse response);
		public void logout(HttpSession session);
		public String address(String loc);
}
