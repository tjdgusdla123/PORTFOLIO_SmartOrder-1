package naver.rlgns1129.smartorder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.rlgns1129.smartorder.domain.StoreMember;

@Repository
public class StoreMemberDAO {
	@Autowired
	//MyBatis를 xml로 이용할 때 사용하는 클래스
	private SqlSession sqlSession;
	
	//StoreMember 테이블의 전체 데이터를 가져오는 메소드
	public List<StoreMember> allStoreMember(){
		return sqlSession.selectList("storemember.allstoremember");
		
	}
	//회원 가입
	public int register(StoreMember storeMember){
		return sqlSession.insert("storemember.insertstoremember", storeMember);
	}
	
	//이메일 중복 체크 메소드
	public String memberEmailCheck(String memberEmail) {
		return sqlSession.selectOne("storemember.storememberemailcheck", memberEmail);
	}
	
	//닉네임 중복 체크 메소드
	public String memberNicknameCheck(String memberNickname) {
		return sqlSession.selectOne("storemember.storemembernicknamecheck", memberNickname);
	}
	
	//로그인
	public StoreMember login(String memberNickname) {
		return sqlSession.selectOne("storemember.storememberlogin" , memberNickname);
	}
	
	//회원수정
	public int update(StoreMember storeMember) {
		return sqlSession.update("storemember.updatestoremember", storeMember);
	}
	
	//회원삭제
	public int secession(String memberNickname) {
		return sqlSession.delete("storemember.deletestoremember", memberNickname);
	}
	
	
}
