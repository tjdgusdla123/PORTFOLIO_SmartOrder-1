package naver.rlgns1129.smartorder.domain;

import java.util.Date;

import lombok.Data;

/*
CREATE TABLE orderinfotblImsi (
	ordernumber   Int  primary key auto_increment, -- 주문번호
	menucode  VARCHAR(30)    references storemenu(menucode), -- 메뉴코드
	menucount Int         not NULL, -- 주문수량
	storetablename VARCHAR(20), -- 가게좌석
	storenickname  VARCHAR(30) references storeinfotbl(storenickname),      -- 가게닉네임
	orderdate	DATE   not NULL -- 주문날짜및시간
)engine=innodb default charset=utf8;

*/

@Data
public class StoreOrder {
	private int orderNumber;
	private String menuCode;
	private int menuCount;
	private String storeTableName;
	private String storeNickname;
	private Date orderDate;
	private String memberNickname;
}
