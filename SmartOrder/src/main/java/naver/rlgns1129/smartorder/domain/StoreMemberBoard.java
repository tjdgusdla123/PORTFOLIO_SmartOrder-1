package naver.rlgns1129.smartorder.domain;

import java.util.Date;

import lombok.Data;
/*
CREATE TABLE storememberboardtbl(
boardno INT primary key AUTO_INCREMENT, -- 글번호
boardtitle VARCHAR(50) , -- 글제목
boardcontent text , -- 글 내용
boardregdate Datetime DEFAULT NOW(), -- 작성일
boardupdatedate Datetime DEFAULT NOW(), -- 수정일
boardreadcnt INT default 0, -- 조회수
boardip VARCHAR(50) , -- 작성한 곳의 아이피
boardfile VARCHAR(500), -- 첨부 파일
membernickname VARCHAR(200) references storemembertbl(membernickname)
)engine=innodb default charset=utf8;
 */
@Data
public class StoreMemberBoard {
	//회원게시판 테이블
	private Integer boardNo;  //글번호
	private String  boardTitle; //글제목 
	private String  boardContent;//글내용
	private Date    boardRegdate; //작성일 
	private Date    boardUpdatedate;//수정일 
	private Integer boardReadcnt;//조회수 
	private String  boardIp;//작성한 곳의 아이피 
	private String  boardFile;//첨부파일  
	private String  memberNickname;//맴버 닉네임 
	private String  boardDispdate;
}
