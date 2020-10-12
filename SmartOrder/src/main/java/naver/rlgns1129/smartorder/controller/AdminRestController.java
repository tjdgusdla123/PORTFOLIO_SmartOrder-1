package naver.rlgns1129.smartorder.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import naver.rlgns1129.smartorder.service.StoreMemberService;

@RestController
public class AdminRestController {
	
	@Autowired
	private StoreMemberService storeMemberService;
	
		
	
	
}
