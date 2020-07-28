
var getmainmenu = document.getElementById("getmainmenu");
var getalcohol = document.getElementById("getalcohol");
var getdrink = document.getElementById("getdrink");
var menudata = document.getElementById("menudata");
var menuform = document.getElementById("menuform");

getmainmenu.addEventListener("click", function(event){
	
	
	var url = "orderinfo/mainmenu?menusection=메인&storenickname=기훈식당닉네임";

		
	var request = new XMLHttpRequest();
	request.open("GET", url);
	request.onload = function() {
		menudata.innerHTML = request.responseText;
	};
	request.send();
	

});


getalcohol.addEventListener("click", function(event){
	
	
	var url = "orderinfo/alcohol?menusection=술&storenickname=기훈식당닉네임";

		
	var request = new XMLHttpRequest();
	request.open("GET", url);
	request.onload = function() {
		menudata.innerHTML = request.responseText;
	};
	request.send();
	

});


getdrink.addEventListener("click", function(event){
	
	
	var url = "orderinfo/drink?menusection=음료&storenickname=기훈식당닉네임";

		
	var request = new XMLHttpRequest();
	request.open("GET", url);
	request.onload = function() {
		menudata.innerHTML = request.responseText;
	};
	request.send();
	

});


