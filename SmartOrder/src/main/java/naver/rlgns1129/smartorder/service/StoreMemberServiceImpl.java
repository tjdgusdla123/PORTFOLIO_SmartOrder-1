package naver.rlgns1129.smartorder.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.rlgns1129.smartorder.dao.StoreMemberDAO;
import naver.rlgns1129.smartorder.domain.StoreMember;

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
}
