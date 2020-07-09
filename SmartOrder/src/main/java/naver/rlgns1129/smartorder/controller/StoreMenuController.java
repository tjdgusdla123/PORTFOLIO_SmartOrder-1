package naver.rlgns1129.smartorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import naver.rlgns1129.smartorder.service.StoreMemberService;
import naver.rlgns1129.smartorder.service.StoreMenuService;

@Controller
public class StoreMenuController {
	@Autowired
	private StoreMenuService storeMenuService;
}
