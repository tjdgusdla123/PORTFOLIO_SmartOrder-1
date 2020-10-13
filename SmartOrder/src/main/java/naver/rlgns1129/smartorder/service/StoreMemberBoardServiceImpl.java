package naver.rlgns1129.smartorder.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.rlgns1129.smartorder.dao.StoreMemberBoardDAO;
import naver.rlgns1129.smartorder.dao.StoreMemberDAO;
import naver.rlgns1129.smartorder.domain.StoreMemberBoard;

@Service
public class StoreMemberBoardServiceImpl implements StoreMemberBoardService {
	@Autowired
	private StoreMemberBoardDAO storeMemberBoardDao;
	@Autowired
	private StoreMemberDAO storeMemberDao;
	
	
	
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
						//파일 업로드 하기 (맥과 윈도우의 운영체제에 따라 경로 \와 /차이가 있는데 이것을 File.separator가 해결해 준다. 
						File f = new File(filePath + File.separator + boardFile);
						
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
				
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yy.MM.dd HH:mm");
		Calendar cal = Calendar.getInstance();
		String today = simpleDateFormat.format(cal.getTime());
		System.out.println("toreMemberBoardServiceImpl.storeMemberBoardList.today : " + today.toString().substring(0, 8));

		for (StoreMemberBoard storeMemberBoard : list) {
			
			System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardList.storeMemberBoard.getBoardRegdate().toString() : " + storeMemberBoard.getBoardRegdate().toString());

			if (today.toString().substring(0, 8).equals(storeMemberBoard.getBoardRegdate().toString().substring(0, 8))) {
				storeMemberBoard.setBoardDispdate(storeMemberBoard.getBoardRegdate().toString().substring(9,14));
			} else {
				storeMemberBoard.setBoardDispdate(storeMemberBoard.getBoardRegdate().toString().substring(0, 8));
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
		storeMemberBoardDao.updateReadCnt(boardNo);
		
		
		map.put("storeMemberBoardDetail", storeMemberBoard);
		 
		return map;
	}

	@Override
	public Map<String, Object> storeMemberBoardUpdate(MultipartHttpServletRequest request, HttpServletResponse response) {
		/*
		   게시글을 수정하기 위한 조건.
		   1. 세션에 저장되어있는 아이디와 수정하기 전에 체크하는 비밀번호가 일치해야한다. (member pwcheck로 1차적으로 검사함.)
		   2. 게시글의 작성자와 로그인한 사람이 일치해야한다.
		   3. 위 조건이 만족하면 게시글을 수정 한다.	 
		 */	
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		
		Integer boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		Map<String, Object> storeMemberInfo = (Map<String, Object>) request.getSession().getAttribute("storememberinfo");
		String memberNickname = (String) storeMemberInfo.get("storemembernickname");
		MultipartFile boardImage =request.getFile("boardFile");

		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.boardNo 파라미터 : " + boardNo);
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.boardTitle 파라미터 : " + boardTitle);
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.boardContent 파라미터 : " + boardContent);
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.memberNickname 파라미터 : " + memberNickname);
		
		
		//나중에 수정해야할 사항.
		//boardNo를 받아서 상세보기 조회 후 파일 네임을 가져와야 한다.
//		StoreMemberBoard storeMemberBoardDetail = new StoreMemberBoard();	
//		storeMemberBoardDetail = storeMemberBoardDao.storeMemberBoardDetail(boardNo);
//		
		
				String boardFile = "";
					
					//파일이 존재하는 경우에만 
					if(boardImage != null && boardImage.isEmpty() == false) {
						//파일을 업로드할 디렉토리 경로를 설정
						String filePath = request.getServletContext().getRealPath("/board/img");
						System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.filePath : " + filePath);
						
						
						
						try {
							if(boardImage.getOriginalFilename().length()>0) {
								//파일이름 생성 - 중복된 파일이름을 업로드 할까봐서 수정
								boardFile = UUID.randomUUID() + boardImage.getOriginalFilename();
								//파일 업로드 하기 (맥과 윈도우의 운영체제에 따라 경로 \와 /차이가 있는데 이것을 File.separator가 해결해 준다. 
								File f = new File(filePath + File.separator + boardFile);
								
								boardImage.transferTo(f);
							}else {
								boardFile = "";
							}
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						} 

//						try(FileOutputStream fos = new FileOutputStream(f)){
//							fos.write(boardFile.getBytes());fos.flush();
//						}catch(Exception e) {
//							System.out.println("파일 업로드 예외:" + e.getMessage());
//						}
			 
					}
					
				

				if(boardFile.length()>0) {
					
					// 필요한 데이터를 생성
					StoreMemberBoard storeMemberBoard = new StoreMemberBoard();

					String boardIp = request.getRemoteAddr();
					storeMemberBoard.setBoardNo(boardNo);
					storeMemberBoard.setBoardFile(boardFile);
					storeMemberBoard.setBoardTitle(boardTitle);
					storeMemberBoard.setBoardContent(boardContent);
					storeMemberBoard.setMemberNickname(memberNickname);
					storeMemberBoard.setBoardIp(boardIp);

					System.out.println(
							"StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardTitle  : " + boardTitle);
					System.out.println(
							"StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardContent  : " + boardTitle);
					System.out.println(
							"StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setMemberNickname  : " + memberNickname);
					System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardIp  : " + boardIp);
					System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardFile  : " + boardFile);
					System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardFile.length  : " + boardFile.length());
					
					
					int row = storeMemberBoardDao.storeMemberBoardUpdateIncludeImage(storeMemberBoard);
					// 저장에 성공하면 map의 result에 true 저장
					if (row > 0) {
						System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate 게시글 저장 성공");

						map.put("result", true);
					}
				}else {
					// 필요한 데이터를 생성
					StoreMemberBoard storeMemberBoard = new StoreMemberBoard();

					String boardIp = request.getRemoteAddr();
					storeMemberBoard.setBoardNo(boardNo);
					storeMemberBoard.setBoardTitle(boardTitle);
					storeMemberBoard.setBoardContent(boardContent);
					storeMemberBoard.setMemberNickname(memberNickname);
					storeMemberBoard.setBoardIp(boardIp);

					System.out.println(
							"StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardTitle  : " + boardTitle);
					System.out.println(
							"StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardContent  : " + boardTitle);
					System.out.println(
							"StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setMemberNickname  : " + memberNickname);
					System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardIp  : " + boardIp);
					System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdate.storeMemberBoard.setBoardFile.length  : " + boardFile.length());
					
					int row = storeMemberBoardDao.storeMemberBoardUpdate(storeMemberBoard);
					// 저장에 성공하면 map의 result에 true 저장
					if (row > 0) {
						System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardUpdateIncludeImage 게시글 저장 성공");

						map.put("result", true);
					}
				}

				return map;

	}
	
	
	@Override
	public Map<String, Object> storeMemberBoardDelete(HttpServletRequest request, HttpServletResponse response) {
		/*
		   게시글을 삭제하기 위한 조건.
		   1. 세션에 저장되어있는 아이디와 지우기전에 체크하는 비밀번호가 일치해야한다. (member pwcheck로 1차적으로 검사함.)
		   2. 게시글의 작성자와 로그인한 사람이 일치해야한다.
		   3. 위 조건이 만족하면 삭제를 한다.	 
		 */		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", false);
		
		Integer boardNo = Integer.parseInt(request.getParameter("boardno"));
		
		StoreMemberBoard storeMemberBoardDetail = storeMemberBoardDao.storeMemberBoardDetail(boardNo);
		Map<String, Object> storeMemberInfo = (Map<String, Object>)request.getSession().getAttribute("storememberinfo");
		String storeMemberNickname = (String)storeMemberInfo.get("storemembernickname");
		String storememberverify = (String)storeMemberInfo.get("storememberverify");
		
		
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardDelete.storeMemberNickname 파라미터 : " + storeMemberNickname);
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardDelete.storeMemberBoardDetail.getMemberNickname() : " + storeMemberBoardDetail.getMemberNickname());

	
		
		if(storeMemberBoardDetail.getMemberNickname().equals(storeMemberNickname)) {
			storeMemberBoardDao.storeMemberBoardDelete(boardNo);
			resultMap.put("result", true);
		}
					
		if(storememberverify.equals("9")) {
			storeMemberBoardDao.storeMemberBoardDelete(boardNo);
			resultMap.put("result", true);
		}
		
		return resultMap;
		
	}

	//게시글 상세보기 닉네임과 boardNo으로 자신이 작성한 게시글 불러오기. 
	@Override
	public Map<String, Object> storeMemberBoardDetailUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer boardNo = Integer.parseInt(request.getParameter("boardno"));
		String storeMemberNickname = request.getParameter("storemembernickname");
		
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardDetailUpdate.boardNo 파라미터 : " + boardNo);
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardDetailUpdate.storeMemberNickname 파라미터 : " + storeMemberNickname);

		StoreMemberBoard sendStoreMemberBoard = new StoreMemberBoard();
		sendStoreMemberBoard.setBoardNo(boardNo);
		sendStoreMemberBoard.setMemberNickname(storeMemberNickname);
		
		
		StoreMemberBoard storeMemberBoard = storeMemberBoardDao.storeMemberBoardDetailUpdate(sendStoreMemberBoard);
		System.out.println("StoreMemberBoardServiceImpl.storeMemberBoardDetailUpdate.storeMemberBoard 파라미터 : " + storeMemberBoard);

		map.put("storeMemberBoardDetailUpdate", storeMemberBoard);
		 
		return map;
	}

	

}
