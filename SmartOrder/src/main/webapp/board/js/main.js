

window.addEventListener("load", function () {
	var sharedBoardNo = "1";

	var getList = document.getElementById("getList");

	var url = "/board/getlist";
	var request = new XMLHttpRequest();

	request.open("get", url, true);
	request.send();
	request.addEventListener('load', function (e) {
		var map = JSON.parse(e.target.responseText);
		console.log(map);

		var msg = "<table class='table table-bordered table-striped table-hover table-responsive' border='1'>" +
			"<tr>" +
			"<th width='11%'>" + '글번호' + "</th>" +
			"<th width='46%'>" + '제목' + "</th>" +
			"<th width='16%'>" + '작성자' + "</th>" +
			"<th width='16%'>" + '작성일' + "</th>" +
			"<th width='11%'>" + '조회수' + "</th>" +
			"</tr>"

		for (let index = 0; index < map.list.length; index++) {
			var imsi = map.list[index];


			msg += "<tr>" +
				"<td  align='right' width='11%'>" + imsi.boardNo + "</td>" +

				"<td  align='right' width='46%'>" + "<input type='button' data-toggle='modal' data-target='#boardDetailModal' id = 'boardTitleBtn'" +
				"onclick='boardDetail(" + '"' + imsi.boardNo + '"' + ")'" + "value= '" + imsi.boardTitle + "'/>" + "</td>" +
				"<td width='16%'>" + imsi.memberNickname + "</td>" +
				"<td width='16%'>" + imsi.boardDispdate + "</td>" +
				"<td width='11%'>" + imsi.boardReadcnt + "</td>" +
				"</tr>"
		}

		msg += "</table>"
		msg += "<br/><br/>"

		getList.innerHTML = msg;

	});
})



//버튼을 누르면 메뉴코드를 가지고 메뉴상세정보 조회하는 함수
/*
게시글 상세정보 모달창에 있는 수정 및 삭제할때
본인아이디로 작성한 글이 아니면 모달창에 수정 및 삭제 버튼이 출력이 안되고
본인아이디로 작성한 글이면 수정 및 삭제가 가능하게 구현

로그인할때 자바스크립트 코드로 세션에 로그인한 아이디를 저장해놓고
게시판 상세보기 가져올때 게시글 작성자와 로그인한 아이디를 비교해서
동일하면 버튼을 출력해주고 동일하지 않으면 버튼을 출력해주지 않는다.
*/

function boardDetail(boardNo) {
	sharedBoardNo = boardNo;

	var boardDetail = document.getElementById("boardDetail");

	//alert(boardTitle);

	boardDetailURL = '/board/detail?boardno=' + boardNo;
	//console.log(boardDetailURL);

	var request = new XMLHttpRequest();

	request.open("GET", boardDetailURL);
	request.send('');

	request.onload = function () {
		var map = request.responseText;

		var list = JSON.parse(map);
		//이것이 정답!!!!
		//console.log(list);
		
		if (list['storeMemberBoardDetail'].boardFile.length > 0) {
			var msg = "<div style='text-align:center'>" + "<img src='../../board/img/" + list['storeMemberBoardDetail'].boardFile + "' width='350' height='250' class='img-responsive center-block' />" + '<br/>' + '<br/>' + "</div>" + '<br/>'
				+ "<div style='text-align:center'>" + '제목 : ' + list['storeMemberBoardDetail'].boardTitle + "</div>" + '<br/>'
				+ "<div style='text-align:center'>" + '내용 : ' + list['storeMemberBoardDetail'].boardContent + "</div>" + '<br/>'
		} else {
			var msg = "<div style='text-align:center'>" + '제목 : ' + list['storeMemberBoardDetail'].boardTitle + "</div>" + '<br/>'
				+ "<div style='text-align:center'>" + '내용 : ' + list['storeMemberBoardDetail'].boardContent + "</div>" + '<br/>'
		}

		boardDetail.innerHTML = msg;

		console.log('세션정보')
		console.log(sessionStorage.getItem('storeMemberNicknameSession'))		
		

		var updateModal = document.getElementById('updateModal')
		var deleteModal = document.getElementById('deleteModal')

		if(list['storeMemberBoardDetail'].memberNickname == sessionStorage.getItem('storeMemberNicknameSession')){
			console.log('닉네임 일치')			

			var boardUpdateModalDiv = '<div id=boardModalUpdateDiv><button type="button" id="boardUpdateBtn" data-dismiss="modal" data-toggle="modal" href="#boardUpdateModal" onclick="boardUpdateBtn()" class="btn btn-primary">글수정</button></div>'
			var boardDeleteModalDiv = '<div id=boardModalDeleteDiv><a data-dismiss="modal" data-toggle="modal" href="#boardDeleteModal" class="btn btn-primary">글삭제</a></div>'
			
			updateModal.innerHTML = boardUpdateModalDiv
			deleteModal.innerHTML = boardDeleteModalDiv

		}else if(sessionStorage.getItem('verifySession') == '9'){
			console.log('관리자 로그인')
			var boardDeleteModalDiv = '<div id=boardModalDeleteDiv><a data-dismiss="modal" data-toggle="modal" href="#boardDeleteModal" class="btn btn-primary">글삭제</a></div>'
			
			deleteModal.innerHTML = boardDeleteModalDiv
		}else{
			console.log('닉네임 불일치')
			updateModal.innerHTML = ""
			deleteModal.innerHTML = ""
		}

	}
}


//메뉴 삭제 함수
function boardDelete() {

	var deleteBtn = document.getElementById('deleteBtn')
	var memberpassword = document.getElementById('memberpassword')
	var pwcheckmsg = document.getElementById('pwcheckmsg')
	var pwcheckform = document.getElementById('passwordcheckform')

	deleteBtn.addEventListener("click", function (event) {

		var flag = false;
		if (memberpassword.value.trim().length < 1) {
			pwcheckmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			pwcheckmsg.style.color = "red";
			flag = true;
		}
		if (flag == true) {
			return;
		}

		var url = "/user/pwcheck";

		var request = new XMLHttpRequest();
		request.open("post", url, true);
		var formdata = new FormData(pwcheckform);
		request.send(formdata);
		request.addEventListener('load', function (e) {
			var map = JSON.parse(e.target.responseText);
			if (map.result == true) {
				console.log('비밀번호 체크 성공')

				$.ajax({ url :'/board/delete',
						 type : 'post', 
						 
						 data : { 'boardno' : sharedBoardNo }, 
						 success: function(e){ 
							
							if (e.result == true) {
								console.log('게시글 삭제 성공')
								location.href = "/board/list";
							} else {
								console.log('게시글 삭제 실패')
							}
							 } 
						});

			} else {
				console.log('비밀번호 체크 실패')
				msg.innerHTML = "잘못된  비밀번호입니다.";
			}
		});
	});
}

//수정버튼을 누르면 글번호와 세션에 저장된 닉네임을 가지고 메뉴상세정보를 조회해서 모달창으로 가져오는 함수
function boardUpdateBtn() {
	console.log('boardUpdateBtn 클릭했습니다.')
	var boardUpdateBtn = document.getElementById('boardUpdateBtn')
	var storeMemberNickname = sessionStorage.getItem('storeMemberNicknameSession')
	var boardNo = document.getElementById('boardNo')
	var boardTitle = document.getElementById('boardTitle')
	var boardContent = document.getElementById('boardContent')
	var boardFile = document.getElementById('boardFile')
	
	
		
		console.log('boardUpdateBtn.addEventListener 함수 진입.')
		//http://localhost:8080/board/detailupdate?boardno=1&storemembernickname=s12800
		var url = "/board/detailupdate?boardno=" + sharedBoardNo + "&storemembernickname=" + storeMemberNickname;
	
		var request = new XMLHttpRequest();
		request.open("get", url, true);
		
		request.send('');
		
		request.onload = function () {
		var map = request.responseText;

		var list = JSON.parse(map);
		//이것이 정답!!!!
		console.log(list);
		
		boardTitle.value = list['storeMemberBoardDetailUpdate'].boardTitle
		boardContent.value = list['storeMemberBoardDetailUpdate'].boardContent
		boardNo.value = list['storeMemberBoardDetailUpdate'].boardNo
		};
	
}

//게시글 업데이트 함수
function boardUpdate() {
	console.log('boardUpdate 함수를 클릭했습니다.')
	var updateBtn = document.getElementById('updateBtn')
	var storeMemberNickname = sessionStorage.getItem('storeMemberNicknameSession')
	var boardTitle = document.getElementById('boardTitle')
	var boardContent = document.getElementById('boardContent')
	var updatePasswordcheckform = document.getElementById('updatePasswordcheckform')
	var updatePasswordCheckmsg = document.getElementById('updatePasswordCheckmsg')
	var boardUpdateForm = document.getElementById('boardUpdateForm')


	
	updateBtn.addEventListener("click", function (event) {

		var flag = false;
		if (boardUpdatePassword.value.trim().length < 1) {
			updatePasswordCheckmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			updatePasswordCheckmsg.style.color = "red";
			flag = true;
		}
		if (flag == true) {
			return;
		}

		var url = "/user/pwcheck";

		var request = new XMLHttpRequest();
		request.open("post", url, true);
		var formdata = new FormData(updatePasswordcheckform);
		request.send(formdata);
		request.addEventListener('load', function (e) {
			var map = JSON.parse(e.target.responseText);
			if (map.result == true) {
				console.log('비밀번호 체크 성공')

					var url = "/board/update";
					  var request = new XMLHttpRequest();
						  
					  request.open("post", url, true);
					  var formdata = new FormData(boardUpdateForm);
					  request.send(formdata);
					  request.addEventListener('load', function(e){
					  var map = JSON.parse(e.target.responseText);
						 if(map.result == true){
							console.log('게시글 수정 성공')
							 location.href = "/board/list";
							 
						 }else{
							console.log('게시글 수정 실패')
						 }
					  });

			} else {
				console.log('비밀번호 체크 실패')
				msg.innerHTML = "잘못된  비밀번호입니다.";
			}
		});
	});

}
