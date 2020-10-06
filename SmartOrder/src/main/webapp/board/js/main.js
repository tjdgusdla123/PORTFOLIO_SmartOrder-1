

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
							"<td>"+ imsi.boardTitle+"</td>"+
							"<td>"+ imsi.memberNickname+"</td>"+
    						"<td>"+ imsi.boardDispdate+"</td>"+
    						"<td>"+ imsi.boardReadcnt+"</td>"+

    				"</tr>"
		}

		msg += "</table>"
			
		msg += "<br/><br/>"

		console.log(msg)
		getList.innerHTML = msg;

	});
})

	// getList.addEventListener("load", function(event){
	// 	console.log("boardWriteForm 안으로 들어옴")
	// 	var url = "/board/getlist";
	//   	var request = new XMLHttpRequest();
		  	
	// 	  request.open("get", url, true);
	// 	  request.send();
	// 	  request.addEventListener('load', function(e){
	// 	  var map = JSON.parse(e.target.responseText);
	// 		 console.log(map);
	// 	  });
	// });
