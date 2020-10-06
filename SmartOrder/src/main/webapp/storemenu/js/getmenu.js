
var getmainmenu = document.getElementById("getmainmenu");
var getalcohol = document.getElementById("getalcohol");
var getdrink = document.getElementById("getdrink");
var menudata = document.getElementById("menudata");
var menuform = document.getElementById("menuform");
var menudiv =  document.getElementById("menudiv");		
var menubtn = document.getElementById("menubtn");
var dialog = document.getElementById("dialog");	
	
	//원하는 조건에 맞는 메뉴를 가지고 오는 함수
	function getmenu(where, menusection, storenickname){
		
	var url = "orderinfo/"+ where + "?menusection=" + menusection + "&storenickname=" + storenickname
		
	var request = new XMLHttpRequest();
	
	request.open("GET", url);
	request.send('');
	
	request.onload = function() {
		var map = request.responseText;
		console.log("getmenu.map : " + map);
		
		var list = JSON.parse(map);
		//console.log("getmenu.list : " + list);

		var msg = "<div class='container'>"+
				  "<table class='table table-bordered table-striped table-hover table-responsive' border='1'>"+
				  "<tr>"+
				  "<th width='80'>"+'메뉴명'+"</th>"+
				  "<th width='300'>"+'설명'+"</th>"+
				  "<th width='100'>"+'가격'+"</th>"+
				  "</tr>"
				  				 
		for (var i=0; i<list.list.length; i++) {
    		var imsi = list.list[i];
    	
    		msg +=  "<tr>" + 
    				"<td  width='80'>"+ "<input type='button' data-toggle='modal' data-target='#menuModal' id = 'menubtn'" +
    				"onclick='getmenucode(" + '"'+ imsi.menuCode + '"' + ")'"+  "value= '"+ imsi.menuName+ "'/>"+"</td>"+
    				"<td  width='300'>"+imsi.menuInfo+"</td>"+
    				"<td  width='100' align='right'>"+
    				imsi.menuPrice+'원'+"</td>"+
    				"</tr>"
    	
    		
    	};
    	
			msg += "</table>"
			
			msg += "<br/><br/>"
			menudata.innerHTML = msg;

	
	};

	
}

	
	//버튼을 누르면 메뉴코드를 가지고 메뉴상세정보 조회하는 함수
	function getmenucode(menucode){
		//alert(menucode);
	
		menudetailurl = 'orderinfo/detail?menucode=' + menucode;
		//console.log(menudetailurl);
		
		var request = new XMLHttpRequest();
	
		request.open("GET", menudetailurl);
		request.send('');
		
		request.onload = function() {
		var map = request.responseText;
		console.log("getmenucode.storemenu.map : " + map);
		
		var list = JSON.parse(map);
		
		
		//이것이 정답!!!!
		console.log(list['storemenu'].menuPhoto);
		
		//var msg = list['storemenu'].menuPhoto;
		
		//var msg = "<img src='../../storemenu/img/" + list['storemenu'].menuPhoto + "' width='450' height='250' />" + '<br/>' + '<br/>'
		//var msg = "<img src='../../storemenu/img/" + list['storemenu'].menuPhoto + "' width='350' height='250' class='img-responsive center-block' />" + '<br/>' + '<br/>'
		
		var msg = "<div id='menuimage' style='text-align:center'>"+ "<img src='../../storemenu/img/" + list['storemenu'].menuPhoto + "' width='350' height='250' class='img-responsive center-block' />" + '<br/>' + '<br/>' + "</div>" + '<br/>'
					
					+ "<div id='menuName' style='text-align:center'>"+ list['storemenu'].menuName + "</div>" + '<br/>'
					+ "<div id='menuName' style='text-align:center'>"+ list['storemenu'].menuInfo + "</div>" + '<br/>'
					+ "<div id='menuName' style='text-align:center'>"+'가격 : '+list['storemenu'].menuPrice + "</div>" + '<br/>'
					
		
		menudiv.innerHTML = msg;
			
		}
		//부트 스트랩 적용 전 제이쿼리를 이용하여 모달창 띄울때 위치
		//제이쿼리 시작
  
  		//제이쿼리끝.
	}

//getmainmenu 버튼을 눌렀을때 성현식당에 있는 메인메뉴섹션 불러오기
getmainmenu.addEventListener("click", function(event){
	getmenu("mainmenu" , "메인" , "성현식당닉네임");
});

getalcohol.addEventListener("click", function(event){
	getmenu("alcohol", "술", "성현식당닉네임");
});

getdrink.addEventListener("click", function(event){
	getmenu("drink", "음료" , "성현식당닉네임");
});

