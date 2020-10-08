package naver.rlgns1129.smartorder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.rlgns1129.smartorder.domain.StoreMember;
import naver.rlgns1129.smartorder.domain.StoreMemberBoard;



@Repository
public class StoreMemberBoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//게시글 작성
	public int storeMemberBoardWrite(StoreMemberBoard storeMemberBoard) {
		System.out.println("StoreMemberBoardDAO.storeMemberBoardWrite 도착 " + storeMemberBoard);
		return sqlSession.insert("storeMemberBoard.write",storeMemberBoard);
	}
	
   //게시글 목록 
	public List<StoreMemberBoard> storeMemberBoardList(){
		System.out.println("StoreMemberBoardDAO.storeMemberBoardWrite 도착 ");
		return sqlSession.selectList("storeMemberBoard.list");
		
		
	}
	//게시글 상세보기 
    public StoreMemberBoard storeMemberBoardDetail(int boardNo) {
		System.out.println("StoreMemberBoardDAO.storeMemberBoardDetail 도착 ");
    	return sqlSession.selectOne("storeMemberBoard.detail",boardNo);
   	
    }
    
    //게시글 상세보기 닉네임과 boardNo으로 자신이 작성한 게시글 불러오기. 
    public StoreMemberBoard storeMemberBoardDetailUpdate(StoreMemberBoard storeMemberBoard) {
		System.out.println("StoreMemberBoardDAO.storeMemberBoardDetailUpdate 도착 ");
    	return sqlSession.selectOne("storeMemberBoard.detailUpdate", storeMemberBoard);
   	
    }
   
    //게시글 수정
  	public int storeMemberBoardUpdate(StoreMemberBoard storeMemberBoard) {
		System.out.println("StoreMemberBoardDAO.storeMemberBoardUpdate 도착 ");
  		return sqlSession.update("storeMemberBoard.update", storeMemberBoard);
  	}
  	
    //게시글 수정 이미지포함
  	public int storeMemberBoardUpdateIncludeImage(StoreMemberBoard storeMemberBoard) {
		System.out.println("StoreMemberBoardDAO.storeMemberBoardUpdate 도착 ");
  		return sqlSession.update("storeMemberBoard.updateIncludeImage", storeMemberBoard);
  	}
  	
  	//게시글 삭제
  	public int storeMemberBoardDelete(int boardNo) {
		System.out.println("StoreMemberBoardDAO.storeMemberBoardDelete 도착 ");
  		return sqlSession.delete("storeMemberBoard.delete", boardNo);
  	}
	
  	//게시글 조회수를 1증가
  	public void updateReadCnt(int boardNo) {
  		sqlSession.update("storeMemberBoard.updateReadCnt", boardNo);
  	}
  	
  	
  	
}
