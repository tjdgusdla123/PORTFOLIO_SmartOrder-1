var insertMenuForm = document.getElementById("insertMenuForm");
var insertMenuBtn = document.getElementById("insertMenuBtn");

var menuName = document.getElementById("menuName");
var menuInfo = document.getElementById("menuInfo");
var menuSectionMain = document.getElementById("menuSectionMain");
var menuSectionDrink = document.getElementById("menuSectionDrink");
var menuSectionAlcohol = document.getElementById("menuSectionAlcohol");
var menuPrice = document.getElementById("menuPrice");
var menuImage = document.getElementById("menuImage");


var menuNameMsg = document.getElementById("menuNameMsg");
var menuInfoMsg = document.getElementById("menuInfoMsg");
var meneSectionMsg = document.getElementById("meneSectionMsg");
var menuPriceMsg = document.getElementById("menuPriceMsg");
var menuImageMsg = document.getElementById("menuPriceMsg");




insertMenuBtn.addEventListener("click", function(event){
	
		var flag = false;
		
		if (menuName.value.trim().length < 1) {
			menuNameMsg.innerHTML = '메뉴이름을 입력해주세요.';
			menuNameMsg.style.color = "red";
			flag = true;
		}else{
			menuNameMsg.innerHTML = '';
		}

		if (menuInfo.value.trim().length < 1) {
            menuInfoMsg.innerHTML = '메뉴설명을 입력해주세요.';
			menuInfoMsg.style.color = "red";
			flag = true;
		}else{
			menuInfoMsg.innerHTML = '';
		}

        if (menuPrice.value.trim().length < 1) {
			menuPriceMsg.innerHTML = '메뉴가격을 입력해주세요.';
			menuPriceMsg.style.color = "red";
			flag = true;
		}else{
			menuPriceMsg.innerHTML = '';
        }
        
		if (flag == true) {
			event.preventDefault();
			return;
		}
	
		console.log("boardWriteForm 안으로 들어옴")
		var url = "/admin/menu/insert";
	  	var request = new XMLHttpRequest();
		  	
		  request.open("post", url, true);
		  var formdata = new FormData(insertMenuForm);
		  request.send(formdata);
		  request.addEventListener('load', function(e){
		  var map = JSON.parse(e.target.responseText);
			 if(map.result == true){
                alert("메뉴삽입이 성공하였습니다.");
			 	location.href = "/admin/menu";
			 	
			 }else{
                alert("메뉴삽입이 실패하였습니다.");
			 }
		  });
	});
