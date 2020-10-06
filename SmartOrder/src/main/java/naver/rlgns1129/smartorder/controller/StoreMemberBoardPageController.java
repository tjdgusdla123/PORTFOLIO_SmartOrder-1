package naver.rlgns1129.smartorder.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import naver.rlgns1129.smartorder.domain.StoreMemberBoard;
import naver.rlgns1129.smartorder.service.StoreMemberBoardService;


@Controller

public class StoreMemberBoardPageController {

	@Autowired
	private StoreMemberBoardService storeMemberBoardService;
	//게시판 메인 
	@RequestMapping(value ="board/list", method = RequestMethod.GET)
	public String board(Model model) {
		System.out.println("StoreMemberBoardPageController.board controller 도착"); 
		model.addAttribute("time", new java.util.Date());
		return "board/main";
}
	//게시글 작성
	@RequestMapping(value ="board/write", method = RequestMethod.GET)
	public String boardwrite() {
		System.out.println("StoreMemberBoardPageController.boardwrite controller 도착");
		return "board/write";
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value ="boardlist", method = RequestMethod.GET)
//   public String memberBoardList(HttpServletRequest request, HttpServletResponse response) {
//		////System.out.println("페이지controller도착-list"); 
//		storeMemberBoardService.memberBoardList(request, response);
//	return "user/boardlist";
//	
//		
//}
//	@RequestMapping(value ="boardlist", method = RequestMethod.GET)
//	   public String memberBoardList(Model model) {
//			System.out.println("페이지controller도착-list");
//			List<StoreMemberBoard> list = storeMemberBoardService.storeMemberBoardList();
//			model.addAttribute("list",list);
//		return "user/boardlist";	
//			
//	}	
//	//게시판 상세보기 
//	@RequestMapping(value ="boarddetail/{boardBno}", method = RequestMethod.GET)
//	public String memberBoardDetail(@PathVariable("boardBno") int boardBno,Model model) {
//		//서비스 메소드 호출 
//		System.out.println("페이지controller-memberBoardDetail도착-상세보기");
//		model.addAttribute("storeMemberBoard",storeMemberBoardService.memberBoardDetail(boardBno));
//		return "user/boarddetail";
//		
//	}

}