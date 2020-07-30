
var getmainmenu = document.getElementById("getmainmenu");
var getalcohol = document.getElementById("getalcohol");
var getdrink = document.getElementById("getdrink");
var menudata = document.getElementById("menudata");
var menuform = document.getElementById("menuform");

getmainmenu.addEventListener("click", function(event){
	
	
	var url = "orderinfo/mainmenu?menusection=메인&storenickname=기훈식당닉네임";

		
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
    				"<td width='80'>"+imsi.menuName+"</td>"+
    				"<td width='300'>"+imsi.menuInfo+"</td>"+
    				"<td width='100' align='right'>"+
    				imsi.menuPrice+'원'+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			menudata.innerHTML = msg;
	};

});


getalcohol.addEventListener("click", function(event){
	
	
	var url = "orderinfo/alcohol?menusection=술&storenickname=기훈식당닉네임";

		
	var request = new XMLHttpRequest();
	request.open("GET", url);
	request.send();
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
    				"<td width='80'>"+imsi.menuName+"</td>"+
    				"<td width='300'>"+imsi.menuInfo+"</td>"+
    				"<td width='100' align='right'>"+
    				imsi.menuPrice+'원'+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			menudata.innerHTML = msg;
	};
});


getdrink.addEventListener("click", function(event){
	
	
	var url = "orderinfo/drink?menusection=음료&storenickname=기훈식당닉네임";

		
	var request = new XMLHttpRequest();
	request.open("GET", url);
	request.send();
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
    				"<td width='80'>"+imsi.menuName+"</td>"+
    				"<td width='300'>"+imsi.menuInfo+"</td>"+
    				"<td width='100' align='right'>"+
    				imsi.menuPrice+'원'+"</td>"+
    				"</tr>"
    	};
    	
			msg += "</table>"
			
			menudata.innerHTML = msg;
	};
});


