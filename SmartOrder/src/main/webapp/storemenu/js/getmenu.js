
var getmainmenu = document.getElementById("getmainmenu");
var getalcohol = document.getElementById("getalcohol");
var getdrink = document.getElementById("getdrink");
var menudata = document.getElementById("menudata");
var menuform = document.getElementById("menuform");
var menudiv = document.getElementById("menudiv");
var menubtn = document.getElementById("menubtn");
var dialog = document.getElementById("dialog");


window.addEventListener("load", function () {
	var sharedMenuCode = "";
})


//원하는 조건에 맞는 메뉴를 가지고 오는 함수
function getmenu(where, menusection, storenickname) {
	
	var url = "/orderinfo/" + where + "?menusection=" + menusection + "&storenickname=" + storenickname

	var request = new XMLHttpRequest();

	request.open("GET", url);
	request.send('');

	request.onload = function () {
		var map = request.responseText;
		console.log("getmenu.map : " + map);

		var list = JSON.parse(map);
		//console.log("getmenu.list : " + list);

		var msg = "<div class='container'>" +
			"<table class='table table-bordered table-striped table-hover table-responsive' border='1'>" +
			"<tr>" +
			"<th width='80'>" + '메뉴명' + "</th>" +
			"<th width='300'>" + '설명' + "</th>" +
			"<th width='100'>" + '가격' + "</th>" +
			"</tr>"

		for (var i = 0; i < list.list.length; i++) {
			var imsi = list.list[i];
			
			
			msg += "<tr>" +
				"<td  width='80'>" + "<input type='button' data-toggle='modal' data-target='#menuModal' id = 'menubtn'" +
				"onclick='getmenucode(" + '"' + imsi.menuCode + '"' + ")'" + "value= '" + imsi.menuName + "'/>" + "</td>" +
				"<td  width='300'>" + imsi.menuInfo + "</td>" +
				"<td  width='100' align='right'>" +
				imsi.menuPrice + '원' + "</td>" +
				"</tr>"


		};

		msg += "</table>"

		msg += "<br/><br/>"
		menudata.innerHTML = msg;


	};


}


//버튼을 누르면 메뉴코드를 가지고 메뉴상세정보 조회하는 함수
function getmenucode(menucode) {
	//alert(menucode);

	menudetailurl = '/orderinfo/detail?menucode=' + menucode;
	//console.log(menudetailurl);

	var request = new XMLHttpRequest();

	request.open("GET", menudetailurl);
	request.send('');

	request.onload = function () {
		var map = request.responseText;
		console.log("getmenucode.storemenu.map : " + map);

		var list = JSON.parse(map);

		sharedMenuCode = list['storemenu'].menuCode
		//이것이 정답!!!!
		console.log(list['storemenu'].menuPhoto);

		//var msg = list['storemenu'].menuPhoto;

		//var msg = "<img src='../../storemenu/img/" + list['storemenu'].menuPhoto + "' width='450' height='250' />" + '<br/>' + '<br/>'
		//var msg = "<img src='../../storemenu/img/" + list['storemenu'].menuPhoto + "' width='350' height='250' class='img-responsive center-block' />" + '<br/>' + '<br/>'

		var msg = "<div id='menuimage' style='text-align:center'>" + "<img src='../../storemenu/img/" + list['storemenu'].menuPhoto + "' width='350' height='250' class='img-responsive center-block' />" + '<br/>' + '<br/>' + "</div>" + '<br/>'

			+ "<div id='menuName' style='text-align:center'>" + list['storemenu'].menuName + "</div>" + '<br/>'
			+ "<div id='menuName' style='text-align:center'>" + list['storemenu'].menuInfo + "</div>" + '<br/>'
			+ "<div id='menuName' style='text-align:center'>" + '가격 : ' + list['storemenu'].menuPrice + "</div>" + '<br/>'


		menudiv.innerHTML = msg;
		
		var updateModal = document.getElementById('updateModal')
		var deleteModal = document.getElementById('deleteModal')
		
		if(sessionStorage.getItem('verifySession') == '9'){
			console.log('세션 일치')
			
			var menuUpdateModalDiv = '<div id=menuModalUpdateDiv><button type="button" id="menuUpdateBtn" data-dismiss="modal" data-toggle="modal" href="#menuUpdateModal" onclick="menuUpdateBtn(menucode)" class="btn btn-primary">메뉴수정</button></div>'
			var menuDeleteModalDiv = '<div id=menuModalDeleteDiv><a data-dismiss="modal" data-toggle="modal" href="#menuDeleteModal" class="btn btn-primary">메뉴삭제</a></div>'
			
			updateModal.innerHTML = menuUpdateModalDiv
			deleteModal.innerHTML = menuDeleteModalDiv

		}
		
		
		
		var menuCount = document.getElementById('menuCount');
		var addToCart = document.getElementById('addToCart');
				
		addToCart.addEventListener("click", function (event) {
		console.log('addToCart 클릭 성공')
		
			$.ajax({ 
					url :'/orderinfo/order',
					type : 'post', 
						 
					data : { 'menuCode' : sharedMenuCode, 'menuCount' : menuCount.value }, 
					success: function(e){ 
							
							if (e.result == true) {
								alert('카트 담기 성공')
								console.log('카트 담기 성공')
								location.href = "/orderinfo"
							} else {
								alert('카트 담기 실패하였습니다. QR코드로 접속 후 로그인해주세요.')
								location.href = "/user/signout";
							}
						} 
					});
		
		})
		//menuCount.value = null;

		if(sessionStorage.getItem('verifySession') == '9'){
			console.log('세션 일치')
			
			var menuUpdateModalDiv = '<div id=menuModalUpdateDiv><button type="button" id="menuUpdateBtn" data-dismiss="modal" data-toggle="modal" href="#menuUpdateModal" onclick="menuUpdateBtn(menucode)" class="btn btn-primary">메뉴수정</button></div>'
			var menuDeleteModalDiv = '<div id=menuModalDeleteDiv><a data-dismiss="modal" data-toggle="modal" href="#menuDeleteModal" class="btn btn-primary">메뉴삭제</a></div>'
			
			updateModal.innerHTML = menuUpdateModalDiv
			deleteModal.innerHTML = menuDeleteModalDiv

		}
		
	}
	//부트 스트랩 적용 전 제이쿼리를 이용하여 모달창 띄울때 위치
	//제이쿼리 시작

	//제이쿼리끝.
}


function menuUpdate() {
	console.log('menuUpdate 함수를 클릭했습니다.')
	var updateBtn = document.getElementById('updateBtn')
	var storeMemberNickname = sessionStorage.getItem('storeMemberNicknameSession')
	var menuCode = document.getElementById('menuCode')
	var updatePasswordcheckform = document.getElementById('updatePasswordcheckform')
	var updatePasswordCheckmsg = document.getElementById('updatePasswordCheckmsg')
	var menuUpdateForm = document.getElementById('menuUpdateForm')

	
	
	updateBtn.addEventListener("click", function (event) {

		var flag = false;
		if (menuUpdatePassword.value.trim().length < 1) {
			updatePasswordCheckmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			updatePasswordCheckmsg.style.color = "red";
			flag = true;
		}else{
			updatePasswordCheckmsg.innerHTML = '';
			
		}
		if (flag == true) {
			return;
		}

		var url = "/user/pwcheck";

		var request = new XMLHttpRequest();
		request.open("post", url, true);
		var formdata = new FormData(updatePasswordcheckform);
		request.send(formdata);
		request.addEventListener('load', function (e) {
			var map = JSON.parse(e.target.responseText);
			if (map.result == true) {
				console.log('비밀번호 체크 성공')
					menuCode.value = sharedMenuCode
					var url = "/admin/menu/update";
					  var request = new XMLHttpRequest();
						  
					  request.open("post", url, true);
					  var formdata = new FormData(menuUpdateForm);
					  request.send(formdata);
					  request.addEventListener('load', function(e){
					  var map = JSON.parse(e.target.responseText);
						 if(map.result == true){
							console.log('메뉴 수정 성공')
							 location.href = "/admin/menu";
							 
						 }else{
							console.log('메뉴 수정 실패')
						 }
					  });

			} else {
				console.log('비밀번호 체크 실패')
				msg.innerHTML = "잘못된  비밀번호입니다.";
			}
		});
	});

}




//메뉴 삭제하는 함수
function menuDelete() {
	var deleteBtn = document.getElementById('deleteBtn')
	var memberpassword = document.getElementById('memberpassword')
	var pwcheckmsg = document.getElementById('pwcheckmsg')
	var pwcheckform = document.getElementById('passwordcheckform')

	deleteBtn.addEventListener("click", function (event) {

		var flag = false;
		if (memberpassword.value.trim().length < 1) {
			pwcheckmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			pwcheckmsg.style.color = "red";
			flag = true;
		}
		if (flag == true) {
			return;
		}

		var url = "/user/pwcheck";

		var request = new XMLHttpRequest();
		request.open("post", url, true);
		var formdata = new FormData(pwcheckform);
		request.send(formdata);
		request.addEventListener('load', function (e) {
			var map = JSON.parse(e.target.responseText);
			if (map.result == true) {
				console.log('비밀번호 체크 성공')

				$.ajax({ url :'/admin/menu/delete',
						 type : 'post', 
						 
						 data : { 'menuCode' : sharedMenuCode }, 
						 success: function(e){ 
							
							if (e.result == true) {
								console.log('메뉴 삭제 성공')
								location.href = "/admin/menu";
							} else {
								console.log('메뉴 삭제 실패')
							}
							 } 
						});

			} else {
				console.log('비밀번호 체크 실패')
				msg.innerHTML = "잘못된  비밀번호입니다.";
			}
		});
	});
}


//getmainmenu 버튼을 눌렀을때 성현식당에 있는 메인메뉴섹션 불러오기
getmainmenu.addEventListener("click", function (event) {
	getmenu("mainmenu", "menuSectionMain", "기훈이네김밥천국닉네임");
});

getalcohol.addEventListener("click", function (event) {
	getmenu("alcohol", "menuSectionDrink", "기훈이네김밥천국닉네임");
});

getdrink.addEventListener("click", function (event) {
	getmenu("drink", "menuSectionAlcohol", "기훈이네김밥천국닉네임");
});
