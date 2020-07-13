var loginform = document.getElementById("loginform");
var loginbtn = document.getElementById("loginbtn");
var membernickname = document.getElementById("membernickname");
var memberpassword = document.getElementById("memberpassword");
var msg = document.getElementById("msg");

	loginform.addEventListener("submit", function(event) {
					msg.innerHTML = '';
					
					var flag = false;
					
					if (membernickname.value.trim().length < 1) {
						msg.innerHTML += '닉네임은 필수 입력입니다.<br/>';
						flag = true;
						
					}else {
						var nicknameRegExp = /^[a-zA-z가-힣0-9]{2,5}$/;
						if (!nicknameRegExp.test(membernickname.value.trim())) {
							msg.innerHTML += '닉네임은 영문 한글 숫자로 2자 이상 5자 이하이어야 합니다.<br/>';
							flag = true;
							
						}
					}
					if (memberpassword.value.trim().length < 1) {
						msg.innerHTML += '비밀번호는 필수 입력입니다.<br/>';
						flag = true;
					}

					if (flag == true) {
						event.preventDefault();
					}
				});

loginbtn.addEventListener("click", function(event){
		
		//loginbtn을 클릭할 때 email 과 password를 서버로 보내서 로그인을 처리
		//ajax 이용
		//1.ajax 객체 생성
		var request = new XMLHttpRequest();
		//2.ajax 요청 설정
		request.open("post","login", true);
		//3.ajax 파라미터 설정
		//GET 방식이면 open 의 URL 뒤에 붙이고
		//POST 방식이면 FormData 객체를 생성하고 send
		var formdata = new FormData(loginform);
		request.send(formdata);
		
		//4.ajax 응답이 온 경우 처리할 콜백함수 등록
		request.addEventListener("load", function(event){
			//로그인 실패한 경우
			if(event.target.responseText.trim().length ==0){
				alert("없는 email이거나 잘못된 비밀번호입니다.")
			}
			//로그인 성공한 경우
			else{
				//location.href = "../";
				alert("실패실패실패")
			}
			
		})
		
		
		
	});
	