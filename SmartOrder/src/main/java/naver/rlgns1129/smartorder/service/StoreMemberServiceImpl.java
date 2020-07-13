package naver.rlgns1129.smartorder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.rlgns1129.smartorder.dao.StoreMemberDAO;
import naver.rlgns1129.smartorder.domain.StoreMember;
import naver.rlgns1129.smartorder.util.CryptoUtil;

@Service
public class StoreMemberServiceImpl implements StoreMemberService {
	@Autowired
	private StoreMemberDAO storeMemberDao;

	@Override
	public void allStoreMember(HttpServletRequest request, HttpServletResponse response) {
		// 1. 파라미터 읽기

		// 2. 필요한 처리 수행

		// 3. DAO 메소드의 매개변수 생성

		// 4. DAO 메소드를 호출
		List<StoreMember> list = storeMemberDao.allStoreMember();
		// 5. 결과를 가공

		// 6. 결과를 저장 - REST API Server의 경우는 request에 저장
		request.setAttribute("list", list);

	}

	@Override
	public Map<String, Object> register(HttpServletRequest request, HttpServletResponse response) {
		// 결과를 저장할 객체를 생성
		Map<String, Object> map = new HashMap<String, Object>();
		//성공과 실패 여부를 확인할 데이터 생성
		map.put("result", false);
		//실패했을 때 왜 실패헀는지 이유를 저장하기 위한 데이터 생성
		map.put("memberemailcheck", false);
		map.put("membernicknamecheck", false);
		
		String memberNickname = request.getParameter("membernickname");
		String memberEmail = request.getParameter("memberemail");
		String memberPassword = request.getParameter("memberpassword");
		String memberPhoneNumber = request.getParameter("memberphonenumber");
		
		//email 중복 검사 수행
		String emailResult = storeMemberDao.memberEmailCheck(memberEmail);
		if (emailResult == null) {
			map.put("memberemailcheck", true);
		} 
		
		//nickname 중복 검사 수행
		String nicknameResult = storeMemberDao.memberNicknameCheck(memberNickname);
		if (nicknameResult == null) {
			map.put("membernicknamecheck", true);
		}
		
		//암호화에 사용할 키를 생성
		//실무에서 이 키를 데이터베이스에서 불러옵니다.
		String key = "rlgns1129@naver.com";
		//저장할 데이터 생성
		try {
		StoreMember storeMember = new StoreMember();
			
			storeMember.setMemberNickname(memberNickname);
			storeMember.setMemberEmail(memberEmail);
			storeMember.setMemberPassword(BCrypt.hashpw(memberPassword, BCrypt.gensalt()));
			storeMember.setMemberPhoneNumber(memberPhoneNumber);
			
			//데이터베이스에 저장
			int row = storeMemberDao.register(storeMember);
			//저장에 성공하면 map의 result에 true 저장
			if(row > 0) {
				map.put("result", true);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return map;
//		try {
//			request.setCharacterEncoding("utf-8");
//			//System.out.println("인코딩 설정");
//			System.out.println("StoreMemberService.insert 요청확인  ");
//			String memberNickname = request.getParameter("membernickname");
//			String memberEmail = request.getParameter("memberemail");
//			String memberPassword = request.getParameter("memberpassword");
//			String memberPhoneNumber = request.getParameter("memberphonenumber");
//			System.out.println("StoreMemberService.insert.storeMember 파라미터확인 : " + memberNickname);
//			System.out.println("StoreMemberService.insert.storeMember 파라미터확인 : " + memberEmail);
//			System.out.println("StoreMemberService.insert.storeMember 파라미터확인 : " + memberPassword);
//			System.out.println("StoreMemberService.insert.storeMember 파라미터확인 : " + memberPhoneNumber);
//			
//			//3.호출할 DAO 메소드의 매개변수를 생성
//			StoreMember storeMember = new StoreMember();
//			storeMember.setMemberNickname(memberNickname);
//			storeMember.setMemberEmail(memberEmail);
//			storeMember.setMemberPassword(memberPassword);
//			storeMember.setMemberPhoneNumber(memberPhoneNumber);
//			System.out.println("StoreMemberService.insert.storeMember 매개변수 : " + storeMember);
//
//			//4.DAO 메소드를 호출
//			int result = storeMemberDao.register(storeMember);
//			
//			
//			//5.결과를 저장
//			JSONObject object = new JSONObject();
//			if(result>0) {
//				object.put("result", true);
//			}else {
//				object.put("result", false);
//			}
//			System.out.println("StoreMemberService.insert.object : " + object);
//			request.setAttribute("result", object);
//			
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
		
		
	}
}
