package naver.rlgns1129.smartorder.domain;

import java.util.Date;

import lombok.Data;

@Data
public class StoreCartList {

	private String menuName;
	private int menuCount;
	private int menuPrice;
	private Date orderDate;
	private String memberNickname;
	
}
