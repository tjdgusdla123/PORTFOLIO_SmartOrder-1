package naver.rlgns1129.smartorder.domain;

import java.util.Date;

import lombok.Data;
/*
	CREATE TABLE storememberboard(
	boardno number primary key, -- 글번호
	boardtitle varchar2(50) , -- 글제목
	boardcontent clob , -- 글 내용
	boardregdate date default sysdate, -- 작성일
	boardupdatedate date default sysdate, -- 수정일
	boardreadcnt number default 0, -- 조회수
	boardip varchar2(50) , -- 작성한 곳의 아이피
	boardfile varchar2(500), -- 첨부 파일
	membernickname VARCHAR2(200)references storemembertbl(membernickname));
 */

@Data
public class StoreMemberBoard {
	//회원게시판 테이블
	private Integer boarNo;  //글번
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
