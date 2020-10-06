package naver.rlgns1129.smartorder.controller;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.rlgns1129.smartorder.service.StoreMemberBoardService;


@RestController
public class StoreMemberBoardRestController {
	
	@Autowired
	private StoreMemberBoardService storeMemberBoardService;
	
	//게시글 작성
	@RequestMapping(value ="board/write", method = RequestMethod.POST)
	public Map<String,Object> storeMemberBoardWrite(MultipartHttpServletRequest request, HttpServletResponse response){
		//서비스 메소드 호출
		System.out.println("StoreMemberBoardRestController.storeMemberBoardList 도착");
		Map<String,Object> map = storeMemberBoardService.storeMemberBoardWrite(request, response);
		
		return map;
		
	}

	//게시글 조회
	@RequestMapping(value ="board/getlist", method = RequestMethod.GET)
	public Map<String,Object> storeMemberBoardList(HttpServletRequest request, HttpServletResponse response){
		System.out.println("StoreMemberBoardRestController.storeMemberBoardList 도착");

		Map<String,Object> map = storeMemberBoardService.storeMemberBoardList(request, response);
		System.out.println("StoreMemberBoardRestController.storeMemberBoardList.map : " + map);
		return map;
		
	}
	
	//게시글 상세보기 조회
	@RequestMapping(value ="board/detail", method = RequestMethod.GET)
	public Map<String,Object> storeMemberBoardDetail(HttpServletRequest request, HttpServletResponse response){
		System.out.println("StoreMemberBoardRestController.storeMemberBoardDetail 도착");
		
		Map<String,Object> map = storeMemberBoardService.storeMemberBoardDetail(request, response);
		System.out.println("StoreMemberBoardRestController.storeMemberBoardList.map : " + map);
		return map;
			
	}
	
		
	}
	

