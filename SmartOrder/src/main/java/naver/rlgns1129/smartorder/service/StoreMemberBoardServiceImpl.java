package naver.rlgns1129.smartorder.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.rlgns1129.smartorder.dao.StoreMemberBoardDAO;
import naver.rlgns1129.smartorder.domain.StoreMemberBoard;

@Service
public class StoreMemberBoardServiceImpl implements StoreMemberBoardService {
	@Autowired
	private StoreMemberBoardDAO storeMemberBoardDao;

	// 게시판 글 작성
	@Override
	
	public Map<String, Object> storeMemberBoardWrite(MultipartHttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		// 파라미터 읽기
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		Map<String, Object> storeMemberInfo = (Map<String, Object>) request.getSession().getAttribute("storememberinfo");
		String memberNickname = (String) storeMemberInfo.get("storemembernickname");
		MultipartFile boardImage =request.getFile("boardFile");

		System.out.println("StoreMemberBoardServiceImpl.memberBoardWrite.boardTitle 파라미터 : " + boardTitle);
		System.out.println("StoreMemberBoardServiceImpl.memberBoardWrite.boardContent 파라미터 : " + boardContent);
		System.out.println("StoreMemberBoardServiceImpl.memberBoardWrite.memberNickname 파라미터 : " + memberNickname);
		

		//기본값이 없는 경우는 null
		String boardFile = "";
			
			//파일이 존재하는 경우에만 
			if(boardImage != null && boardImage.isEmpty() == false) {
				//파일을 업로드할 디렉토리 경로를 설정
				String filePath = request.getServletContext().getRealPath("/board/img");
				System.out.println("StoreMemberBoardServiceImpl.memberBoardWrite.filePath : " + filePath);
				
				
				
				try {
					if(boardImage.getOriginalFilename().length()>0) {
						//파일이름 생성 - 중복된 파일이름을 업로드 할까봐서 수정
						boardFile = UUID.randomUUID() + boardImage.getOriginalFilename();
						//파일 업로드 하기 
						File f = new File(filePath + "/" + boardFile);
						boardImage.transferTo(f);
					}else {
						boardFile = "";
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} 

//				try(FileOutputStream fos = new FileOutputStream(f)){
//					fos.write(boardFile.getBytes());fos.flush();
//				}catch(Exception e) {
//					System.out.println("파일 업로드 예외:" + e.getMessage());
//				}
	 
			}
			
		// 필요한 데이터를 생성
		StoreMemberBoard storeMemberBoard = new StoreMemberBoard();

		String boardIp = request.getRemoteAddr();
		storeMemberBoard.setBoardFile(boardFile);
		storeMemberBoard.setBoardTitle(boardTitle);
		storeMemberBoard.setBoardContent(boardContent);
		storeMemberBoard.setMemberNickname(memberNickname);
		storeMemberBoard.setBoardIp(boardIp);

		System.out.println(
				"StoreMemberBoardServiceImpl.memberBoardWrite.storeMemberBoard.setBoardTitle  : " + boardTitle);
		System.out.println(
				"StoreMemberBoardServiceImpl.memberBoardWrite.storeMemberBoard.setBoardContent  : " + boardTitle);
		System.out.println(
				"StoreMemberBoardServiceImpl.memberBoardWrite.storeMemberBoard.setMemberNickname  : " + memberNickname);
		System.out.println("StoreMemberBoardServiceImpl.memberBoardWrite.storeMemberBoard.setBoardIp  : " + boardIp);
		System.out.println("StoreMemberBoardServiceImpl.memberBoardWrite.storeMemberBoard.setBoardFile  : " + boardFile);

		int row = storeMemberBoardDao.storeMemberBoardWrite(storeMemberBoard);
		// 저장에 성공하면 map의 result에 true 저장
		if (row > 0) {
			System.out.println("StoreMemberBoardServiceImpl.memberBoardWrite 게시글 저장 성공");

			map.put("result", true);
		}

		return map;
		
	}

	// 게시글 전체 목록보기
	@Override
	public Map<String,Object> storeMemberBoardList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<StoreMemberBoard> list = storeMemberBoardDao.storeMemberBoardList();
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardList.list : " + list);
		
		Calendar cal = Calendar.getInstance();
		Date today = new Date(cal.getTimeInMillis());
		
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardList.today : " + today);


		for (StoreMemberBoard storeMemberBoard : list) {
			
			System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardList.storeMemberBoard.getBoardRegdate().toString() : " + storeMemberBoard.getBoardRegdate().toString());

			if (today.toString().substring(0, 10).equals(storeMemberBoard.getBoardRegdate().toString().substring(0, 10))) {
				storeMemberBoard.setBoardDispdate(storeMemberBoard.getBoardRegdate().toString().substring(11,16));
				System.out.println("substring(11) : " + storeMemberBoard.getBoardRegdate().toString().substring(11,16));
			} else {
				storeMemberBoard.setBoardDispdate(storeMemberBoard.getBoardRegdate().toString().substring(0, 10));
				System.out.println("substring(10) : " + storeMemberBoard.getBoardRegdate().toString().substring(0, 10));

			}
		}
		
		map.put("list", list);
		
		return map;

	}
	
	//게시글 상세보기
	@Override
	public Map<String,Object> storeMemberBoardDetail(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer boardNo = Integer.parseInt(request.getParameter("boardno"));

		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardDetail.boardNo 파라미터 : " + boardNo);

		StoreMemberBoard storeMemberBoard = storeMemberBoardDao.storeMemberBoardDetail(boardNo);
		
		map.put("storeMemberBoardDetail", storeMemberBoard);
		
		return map;
	}

	

}
