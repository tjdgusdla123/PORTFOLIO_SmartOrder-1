package naver.rlgns1129.smartorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminPageController {
		//관리자 메인페이지 이동 
		@RequestMapping(value ="admin", method = RequestMethod.GET)
		public String adminMain() {
			System.out.println("AdminPageController.adminMain 도착"); 
			return "admin/main";
		}
		//관리자 게시판페이지 이동
		@RequestMapping(value ="admin/board", method = RequestMethod.GET)
		public String adminBoard() {
			System.out.println("AdminPageController.adminBoard 도착"); 
			return "board/main";
		}
		//관리자 메뉴페이지 이동
		@RequestMapping(value ="admin/menu", method = RequestMethod.GET)
		public String adminMenu() {
			System.out.println("AdminPageController.adminMenu 도착"); 
			return "admin/manageMenu";
		}
		//관리자 메뉴 삽입페이지 이동
		@RequestMapping(value ="admin/menu/insert", method = RequestMethod.GET)
		public String adminMenuInsert() {
			System.out.println("AdminPageController.adminMenuInsert 도착"); 
			return "admin/manageMenu/insert";
		}
		
		//관리자 정보관리페이지 이동
		@RequestMapping(value ="admin/info", method = RequestMethod.GET)
		public String adminInfo() {
			System.out.println("AdminPageController.adminInfo 도착"); 
			return "admin/manageAdminInfo";
		}
		
		//관리자 정보수정페이지 이동
		@RequestMapping(value ="admin/info/update", method = RequestMethod.GET)
		public String adminInfoUpdate() {
			System.out.println("AdminPageController.adminInfoUpdate 도착"); 
			return "member/pwcheck";
		}		
		
		//관리자 회원탈퇴페이지 이동
		@RequestMapping(value ="admin/info/delete", method = RequestMethod.GET)
		public String adminInfoDelete() {
			System.out.println("AdminPageController.adminInfoDelete 도착"); 
			return "member/secession";
		}		
		
		
	
}
