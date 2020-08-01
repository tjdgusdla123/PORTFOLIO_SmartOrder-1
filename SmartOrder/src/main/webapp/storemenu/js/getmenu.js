
var getmainmenu = document.getElementById("getmainmenu");
var getalcohol = document.getElementById("getalcohol");
var getdrink = document.getElementById("getdrink");
var menudata = document.getElementById("menudata");
var menuform = document.getElementById("menuform");

	function getmenu(where, menusection, storenickname){
		
	var url = "orderinfo/"+ where + "?menusection=" + menusection + "&storenickname=" + storenickname
		
	var request = new XMLHttpRequest();
	
	request.open("GET", url);
	request.send('');
	
	request.onload = function() {
		var map = request.responseText;
		console.log(map);
		
		var list = JSON.parse(map);
		console.log(list);

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
    				"<td class='trigger' width='80'>"+"<a href='#'>" + imsi.menuName+"</a>"+"</td>"+
    				"<td class='trigger' width='300'>"+imsi.menuInfo+"</td>"+
    				"<td class='trigger' width='100' align='right'>"+
    				imsi.menuPrice+'원'+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			menudata.innerHTML = msg;
	};
	
	}

getmainmenu.addEventListener("click", function(event){
	getmenu("mainmenu" , "메인" , "기훈식당닉네임");
});

getalcohol.addEventListener("click", function(event){
	getmenu("alcohol", "술", "기훈식당닉네임");
});

getdrink.addEventListener("click", function(event){
	getmenu("drink", "음료" , "기훈식당닉네임");
});