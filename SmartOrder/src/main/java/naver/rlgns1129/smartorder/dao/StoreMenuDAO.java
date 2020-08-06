package naver.rlgns1129.smartorder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.rlgns1129.smartorder.domain.StoreMember;
import naver.rlgns1129.smartorder.domain.StoreMenu;

@Repository
public class StoreMenuDAO {
	@Autowired
	// MyBatis를 xml로 이용할 때 사용하는 클래스
	private SqlSession sqlSession;
	
	//전체 메뉴 가져오기
	public List<StoreMenu> allStoreMember(String storeNickname){
		return sqlSession.selectList("storemenu.allstoremenu");	
	}
	// StoreMemu 테이블의 파라미터 2개로 데이터를 가져오는 메소드
	public List<StoreMenu> getMenu(StoreMenu storeMenu) {
		return sqlSession.selectList("storemenu.getmenu", storeMenu);
	}
	
	// StoreMemu 테이블의 메뉴코드로 상세정보를 가져오는 메소드
	public StoreMenu detailMenu(String menuCode) {
		return sqlSession.selectOne("storemenu.detailmenu", menuCode);
		}

	//  한 가게에서 동일한 메뉴명이 있는지 메뉴 삽입 전 중복검사 
	//  그리고 메뉴를 수정 삭제할때 기본키를 가져올 SQL 
	//  이 SQL 하나로 Insert의 한가게에 동일한 메뉴명이 있는지 중복검사가 가능하다. 
	//  메뉴코드(기본키)를 같이 리턴하기 때문에 메뉴코드(기본키)를 가지고 메뉴 수정 및 삭제를 할 수 있다. 
	public StoreMenu menuCheck(StoreMenu storeMenu) {
		return sqlSession.selectOne("storemenu.menucheck", storeMenu);
	}
	// 메뉴 추가
	public void insertMenu(StoreMenu storeMenu) {
		sqlSession.insert("storemenu.insertmenu", storeMenu);
	}
	// 메뉴 수정
	public void updateMenu(String menuCode) {
		 sqlSession.update("storemenu.updatemenu", menuCode);
	}
	// 메뉴 삭제
	public void deleteMenu(String menuCode) {
		sqlSession.delete("storemenu.deletemenu", menuCode);
	}
	
	
	
	
}
