package naver.rlgns1129.smartorder.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.rlgns1129.smartorder.dao.StoreMemberDAO;
import naver.rlgns1129.smartorder.dao.StoreMenuDAO;

@Service
public class StoreMenuServiceImpl implements StoreMenuService {
	@Autowired
	private StoreMenuDAO storeMenuDao;

	
	

}
