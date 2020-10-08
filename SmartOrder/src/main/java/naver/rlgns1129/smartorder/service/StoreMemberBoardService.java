package naver.rlgns1129.smartorder.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface StoreMemberBoardService {
    //게시물 글쓰기 
	public Map<String,Object> storeMemberBoardWrite(MultipartHttpServletRequest request, HttpServletResponse response);
	
	//게시판 목록보기
	public Map<String,Object> storeMemberBoardList(HttpServletRequest request, HttpServletResponse response);
	
	//게시글 상세보기 
	public Map<String,Object> storeMemberBoardDetail(HttpServletRequest request , HttpServletResponse response);
	
    //게시글 상세보기 닉네임과 boardNo으로 자신이 작성한 게시글 불러오기. 
	public Map<String,Object> storeMemberBoardDetailUpdate(HttpServletRequest request , HttpServletResponse response);

	//게시글 수정
	public Map<String, Object> storeMemberBoardUpdate(MultipartHttpServletRequest request , HttpServletResponse response);
	
	//게시글 삭제
	public Map<String, Object> storeMemberBoardDelete(HttpServletRequest request , HttpServletResponse response);

	
	
}


