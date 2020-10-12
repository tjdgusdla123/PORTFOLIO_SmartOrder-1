package naver.rlgns1129.smartorder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.rlgns1129.smartorder.domain.StoreMember;
import naver.rlgns1129.smartorder.domain.StoreMemberBoard;
import naver.rlgns1129.smartorder.domain.StoreMenu;

@Repository
public class StoreMenuDAO {
	@Autowired
	// MyBatis를 xml로 이용할 때 사용하는 클래스
	private SqlSession sqlSession;
	
	//전체 메뉴 가져오기
	public List<StoreMenu> allStoreMember(String storeNickname){
		return sqlSession.selectList("storeMenu.allstoremenu");	
	}
	// StoreMemu 테이블의 파라미터 2개로 데이터를 가져오는 메소드
	public List<StoreMenu> getMenu(StoreMenu storeMenu) {
		return sqlSession.selectList("storeMenu.getmenu", storeMenu);
	}
	
	// StoreMemu 테이블의 메뉴코드로 상세정보를 가져오는 메소드
	public StoreMenu detailMenu(String menuCode) {
		return sqlSession.selectOne("storeMenu.detailmenu", menuCode);
	}
	
	// 두개의 파라미터(storeNickname, menuName)로 메뉴코드 가져오기
	public String getMenuCode(StoreMenu storeMenu) {
		System.out.println("StoreMenuDAO.getMenuCode 진입");
		return sqlSession.selectOne("storeMenu.getMenuCode", storeMenu);
	}
	

	//  한 가게에서 동일한 메뉴명이 있는지 메뉴 삽입 전 중복검사 
	//  그리고 메뉴를 수정 삭제할때 기본키를 가져올 SQL 
	//  이 SQL 하나로 Insert의 한가게에 동일한 메뉴명이 있는지 중복검사가 가능하다. 
	//  메뉴코드(기본키)를 같이 리턴하기 때문에 메뉴코드(기본키)를 가지고 메뉴 수정 및 삭제를 할 수 있다. 
	public StoreMenu menuCheck(StoreMenu storeMenu) {
		return sqlSession.selectOne("storeMenu.menucheck", storeMenu);
	}
	// 메뉴 추가
	public int insertMenu(StoreMenu storeMenu) {
		return sqlSession.insert("storeMenu.insertMenu", storeMenu);
	}
	// 메뉴 수정
	public int updateMenu(StoreMenu storeMenu) {
		System.out.println("StoreMenuDAO.updateMenu 도착");
		return sqlSession.update("storeMenu.updateMenu", storeMenu);
	}
	// 메뉴 수정(이미지 포함)
	public int updateMenuIncludeImage(StoreMenu storeMenu) {
		System.out.println("StoreMenuDAO.updateMenuIncludeImage 도착");
		return sqlSession.update("storeMenu.updateMenuIncludeImage", storeMenu);
	}
	// 메뉴 삭제
	public int deleteMenu(String menuCode) {
		return sqlSession.delete("storeMenu.deleteMenu", menuCode);
	}
	
	
	
	
}
