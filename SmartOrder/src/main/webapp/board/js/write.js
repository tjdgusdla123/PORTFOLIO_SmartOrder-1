var boardWriteForm = document.getElementById("boardWriteForm");
var boardWriteBtn = document.getElementById("boardWriteBtn");

var boardTitle = document.getElementById("boardTitle");
var boardContent = document.getElementById("boardContent");

	boardWriteBtn.addEventListener("click", function(event){
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
