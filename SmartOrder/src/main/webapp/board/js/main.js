

window.addEventListener("load", function () {
	var getList = document.getElementById("getList");
	
	var url = "/board/getlist";
	var request = new XMLHttpRequest();

	request.open("get", url, true);
	request.send();
	request.addEventListener('load', function (e) {
		var map = JSON.parse(e.target.responseText);
		console.log(map);

		var msg = "<div class='container'>"+
				  "<table class='table table-bordered table-striped table-hover table-responsive' border='1'>"+
				  "<tr>"+
				  		"<th width='11%'>"+'글번호'+"</th>"+
				  		"<th width='46%'>"+'제목'+"</th>"+
				  		"<th width='16%'>"+'작성자'+"</th>"+
				  		"<th width='16%'>"+'작성일'+"</th>"+
				  		"<th width='11%'>"+'조회수'+"</th>"+
				  "</tr>"

		for (let index = 0; index < map.list.length; index++) {
			var imsi = map.list[index];
			

			msg +=  "<tr>" + 
    						"<td  align='right'>"+imsi.boardNo+"</td>"+
    						    					
    						"<td  align='right'>"+ "<input type='button' data-toggle='modal' data-target='#menuModal' id = 'boardTitleBtn'" +
    				"onclick='boardDetail(" + '"'+ imsi.boardNo + '"' + ")'"+  "value= '"+ imsi.boardTitle+ "'/>"+"</td>"+
    						
    						
							
							"<td>"+ imsi.memberNickname+"</td>"+
    						"<td>"+ imsi.boardDispdate+"</td>"+
    						"<td>"+ imsi.boardReadcnt+"</td>"+

    				"</tr>"
		}

		msg += "</table>"
			
		msg += "<br/><br/>"

		getList.innerHTML = msg;

	});
})

	//버튼을 누르면 메뉴코드를 가지고 메뉴상세정보 조회하는 함수
	function boardDetail(boardNo){
	
		var boardDetail = document.getElementById("boardDetail");
		
		//alert(boardTitle);
	
		boardDetailURL = '/board/detail?boardno=' + boardNo;
		//console.log(boardDetailURL);
		
		var request = new XMLHttpRequest();
	
		request.open("GET", boardDetailURL);
		request.send('');
		
		request.onload = function() {
		var map = request.responseText;
		
		var list = JSON.parse(map);
		
		
		//이것이 정답!!!!
		//console.log(list);
		 	
		
		if(list['storeMemberBoardDetail'].boardFile != null){
			var msg =	  "<div style='text-align:center'>"+ "<img src='../../board/img/" + list['storeMemberBoardDetail'].boardFile + "' width='350' height='250' class='img-responsive center-block' />" + '<br/>' + '<br/>' + "</div>" + '<br/>'
					+ "<div style='text-align:center'>"+ list['storeMemberBoardDetail'].boardTitle + "</div>" + '<br/>'
					+ "<div style='text-align:center'>"+ list['storeMemberBoardDetail'].boardContent + "</div>" + '<br/>'	
		}else{
			var msg = "<div style='text-align:center'>"+ list['storeMemberBoardDetail'].boardTitle + "</div>" + '<br/>'
					+ "<div style='text-align:center'>"+ list['storeMemberBoardDetail'].boardContent + "</div>" + '<br/>'
		}
		
		boardDetail.innerHTML = msg;
		
		
		
		
		
		}
	}
