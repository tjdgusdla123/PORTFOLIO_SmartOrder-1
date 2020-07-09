var registerform = document.getElementById("registerform");
var registerbtn = document.getElementById("registerbtn");

var membernickname = document.getElementById("membernickname");
var memberemail = document.getElementById("memberemail");
var memberpassword = document.getElementById("memberpassword");
var memberphonenumber = document.getElementById("memberphonenumber");

var msg = document.getElementById("msg");



//memberemail을 작성하고 포커스가 떠나면 중복검사를 수행
memberemail.addEventListener("focusout", function(event){
	//입력한 내용이 없을 때는 검사하지 않음
	if (memberemail.value.trim().length < 1) {
		msg.innerHTML += '이메일은 필수 입력입니다.<br/>';
		msg.style.color = "red";
		return;
	} else {
		var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (!emailRegExp.test(memberemail.value.trim())) {
			msg.innerHTML += '잘못된 이메일 형식입니다.<br/>';
			msg.style.color = "red";
			return;
		}
	}
	//ajax 요청 객체를 생성
	var request = new XMLHttpRequest();
	//요청 생성
	request.open('get','emailcheck?memberemail='+memberemail.value, true);

	//요청을 전송
	request.send('');
	//결과를 받기 위한 부분 생성
	request.addEventListener('load', function(event){
		//결과를 파싱
		var data = JSON.parse(event.target.responseText);
		if(data.result == true){
			msg.innerHTML = "사용 가능한 이메일<br/>";
			msg.style.color = "green";
		}else{
			msg.innerHTML = "사용 불가능한 이메일<br/>";
			msg.style.color = "red";
			
		}
	})
});	

//닉네임을 작성하고 포커스를 옮길 때
membernickname.addEventListener("focusout", function(event){
	//입력한 내용이 없을 때는 검사하지 않음
		
	if (membernickname.value.trim().length < 1) {
		msg.innerHTML += '닉네임은 필수 입력입니다.<br/>';
		msg.style.color = "red";
		return;
	}else {
		var nicknameRegExp = /^[a-zA-z가-힣0-9]{2,10}$/;
		if (!nicknameRegExp.test(membernickname.value.trim())) {
			msg.innerHTML = '닉네임은 영문 한글 숫자로 2자 이상 10자 이하이어야 합니다.<br/>';
			msg.style.color = "red";
			return;
		}
	}
	
	//ajax 요청 객체를 생성
	var request = new XMLHttpRequest();
	//요청 생성
	request.open('get','nicknamecheck?membernickname='+membernickname.value, true);
	//요청을 전송
	request.send('');
	//결과를 받기 위한 부분 생성
	request.addEventListener('load', function(event){
		//결과를 파싱
		var data = JSON.parse(event.target.responseText);
		if(data.result == true){
			msg.innerHTML = "사용 가능한 닉네임<br/>";
			msg.style.color = "green";	
		}else{
			msg.innerHTML = "사용 불가능한 닉네임<br/>";
			msg.style.color = "red";
		}
	
	
})
});

registerbtn.addEventListener("click", function(event) {
					msg.innerHTML = '';

					//if (memberpassword.value.trim().length < 1) {
					//	msg.innerHTML += '비밀번호는 필수 입력입니다.<br/>';
					//	msg.style.color = "red";
					//	flag = true;
					//}
					
//					var flag = false;
//					if (memberphonenumber.value.trim().length < 1) {
//						msg.innerHTML += '핸드폰번호는 필수 입력입니다.<br/>';
//						msg.style.color = "red";
//						flag = true;
//					}
//					
//					if (flag == true) {
//							event.preventDefault();
//						}
					
					
					//ajax 요청 객체를 생성
					var request = new XMLHttpRequest();
					//요청 생성
					request.open('post','register', true);
					//폼의 데이터 생성
					var formData = new FormData(registerform);
					//요청을 전송
//					for(var pair in formData){
//						console.log(pair[0] + ":" + pair[1]);
//					}
//					formData.append("memberemail",memberemail.value)
					request.send(formData);
					
					
					//데이터를 전송하고 결과를 받아왔을 때
					request.addEventListener('load', function(event){
					var data = JSON.parse(event.target.responseText);	
					if(data.result == true){
						//메인으로 이동
						alert("회원가입이 성공하였습니다.");
						location.href = "../";
						
					}
					else{
						alert("웹사이트에 오류가 있습니다. 빠른 시일내에 복구하겠습니다.");
						return;
						
					}
				})

				});



