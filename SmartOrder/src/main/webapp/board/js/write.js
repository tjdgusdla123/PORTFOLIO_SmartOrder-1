var boardWriteForm = document.getElementById("boardWriteForm");
var boardWriteBtn = document.getElementById("boardWriteBtn");

var boardTitle = document.getElementById("boardTitle");
var boardContent = document.getElementById("boardContent");

var boardTitleMsg = document.getElementById("boardTitleMsg");
var boardContentMsg = document.getElementById("boardContentMsg");

	boardWriteBtn.addEventListener("click", function(event){
	
		var flag = false;
		
		if (boardTitle.value.trim().length < 1) {
			boardTitleMsg.innerHTML = '제목은 필수 입력입니다';
			boardTitleMsg.style.color = "red";
			flag = true;
		}else{
			boardTitleMsg.innerHTML = '';
		}

		if (boardContent.value.trim().length < 1) {
			boardContentMsg.innerHTML = '내용은 필수 입력입니다';
			boardContentMsg.style.color = "red";
			flag = true;
		}else{
			boardContentMsg.innerHTML = '';
		}

		if (flag == true) {
			
			event.preventDefault();
			return;
		}
	
		console.log("boardWriteForm 안으로 들어옴")
		var url = "/board/write";
	  	var request = new XMLHttpRequest();
		  	
		  request.open("post", url, true);
		  var formdata = new FormData(boardWriteForm);
		  request.send(formdata);
		  request.addEventListener('load', function(e){
		  var map = JSON.parse(e.target.responseText);
			 if(map.result == true){
				alert("글쓰기 성공하였습니다.");
			 	location.href = "/board/list";
			 	
			 }else{
			 	alert("글쓰기 실패하였습니다.");
			 }
		  });
	});
