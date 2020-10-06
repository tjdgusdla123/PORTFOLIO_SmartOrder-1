package naver.rlgns1129.smartorder;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import naver.rlgns1129.smartorder.domain.StoreMemberBoard;

//설정 파일을 읽어오는 코드
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class StoreMemberBoardTest {
	@Autowired
	private DataSource dataSource;

	// MtBatis 사용 클래스를 주입
	@Autowired
	private SqlSession sqlSession;
	
//	@Test
//	//게시글 작성
//	public void memberBoardWrite() {
//		StoreMemberBoard storeMemberBoard = new StoreMemberBoard();
//		storeMemberBoard.setBoardTitle("write junit test");
//		storeMemberBoard.setBoardContent("spring junit testing");
//		storeMemberBoard.setBoardIp("192.168.0.5");
//		storeMemberBoard.setMemberNickname("s12800");
//
//		System.out.println(sqlSession.insert("storeMemberBoard.write", storeMemberBoard));
//	}
	
	@Test
	//게시글 조회
	public void memberBoardList() {

		System.out.println(sqlSession.selectList("storeMemberBoard.list"));
	}
}
