package naver.rlgns1129.smartorder.controller;

import java.util.Map;

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
	
	//게시물작성 
	@RequestMapping(value ="boardwrite", method = RequestMethod.POST)
	public Map<String,Object> memberBoard(MultipartHttpServletRequest request, HttpServletResponse response){
		//서비스 메소드 호출
		System.out.println("StoreMemberBoardController-memberBoard-도착-map");
		//request.getSession().getAttribute("storememberinfo");
		//System.out.println("StoreMemberBoardController-memberBoard-도착 후 : " + request.getSession().getAttribute("storememberinfo"));
		Map<String,Object> map = storeMemberBoardService.memberBoard(request, response);
		//System.out.println("StoreMemberBoardController-memberBoard-도착-map:"+map);
		return map;
		
	}


		
		
	}
	

