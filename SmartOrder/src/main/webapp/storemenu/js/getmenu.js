
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

		var msg = "<h2>"+'상품 목록'+"</h2>"+
				  "<table border='1'>"+
				  "<tr>"+
				  "<th width='80'>"+'메뉴명'+"</th>"+
				  "<th width='300'>"+'설명'+"</th>"+
				  "<th width='100'>"+'가격'+"</th>"+
				  "</tr>"
				  				 
		for (var i=0; i<list.list.length; i++) {
    		var imsi = list.list[i];
    	
    		msg +=  "<tr>" + 
    				"<td  width='80'>"+ "<input type='button' id = 'menubtn'" +
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
		
		var msg = list['storemenu'].menuPhoto;
		
		
		menudiv.innerHTML = msg;
			
		}
		//제이쿼리 시작
  
    $( "#menudiv" ).dialog({
	     autoOpen: false,	
      resizable: false,
      height: "auto",
      width: 400,
      modal: true,
      buttons: {
        "메뉴 추가": function() {
          $( this ).dialog( "close" );
        },
        "뒤로가기": function() {
          $( this ).dialog( "close" );
        }
      }
    });
    
      $( "#menudiv" ).dialog( "open" );
   

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

