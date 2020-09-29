var registerform = document.getElementById("registerform");
var registerbtn = document.getElementById("registerbtn");

var membernickname = document.getElementById("membernickname");
var memberemail = document.getElementById("memberemail");
var memberpassword = document.getElementById("memberpassword");
var memberpasswordcheck = document.getElementById("memberpasswordcheck");
var memberphonenumber = document.getElementById("memberphonenumber");

var msg = document.getElementById("msg");

	var flag = false;
	registerbtn.addEventListener("click", function(event){
		if (memberemail.value.trim().length < 1) {
			msg.innerHTML += '이메일은 필수 입력입니다.<br/>';
			msg.style.color = "red";
			flag = true;
		} else {
			var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			if (!emailRegExp.test(memberemail.value.trim())) {
				msg.innerHTML += '잘못된 이메일 형식입니다.<br/>';
				msg.style.color = "red";
		
			}
		}
		if (memberpassword.value.trim().length < 1) {
			pwmsg.innerHTML += '비밀번호는 필수 입력입니다.<br/>';
			msg.style.color = "red";
			flag = true;
		} else {
			var pwRegExp = /^.*(?=^.{1,15}$)(?=.*\d)(?=.*[a-z])(?=.*[!@#$%^&+=]).*$/;
			if (!pwRegExp.test(memberpassword.value.trim())) {
					msg.innerHTML += '비밀번호는 숫자와 영문 소문자 그리고 특수문자가 포함되어야 합니다.<br/>';
					msg.style.color = "red";
					flag = true;
			} else {
				if (memberpassword.value.trim() !== memberpasswordcheck.value.trim()) {
					msg.innerHTML += '2개의 비밀번호는 같아야 합니다.<br/>';
					msg.style.color = "red";
					flag = true;
				}
			}
		}
		if (membernickname.value.trim().length < 1) {
			msg.innerHTML += '닉네임은 필수 입력입니다.<br/>';
			msg.style.color = "red";
			flag = true;
		} else {
			var nicknameRegExp = /^[a-zA-z가-힣0-9]{2,8}$/;
			if (!nicknameRegExp.test(membernickname.value.trim())) {
				msg.innerHTML = '닉네임은 영문 한글 숫자로 2자 이상 8자 이하이어야 합니다.<br/>';
				msg.style.color = "red";
				flag = true;
			}
		}
		
		if (flag == true) {
			
			event.preventDefault();
			return;
		}
		var url = "register";
	  	var request = new XMLHttpRequest();
		  	
		  request.open("post", url, true);
		  var formdata = new FormData(registerform);
		  request.send(formdata);
		  request.addEventListener('load', function(e){
		  var map = JSON.parse(e.target.responseText);
			 if(map.result == true){
				alert("회원가입이 성공하였습니다.");
			 	location.href = "/user/login";
			 	
			 }else{
			 	if(map.memberemailcheck == false){
			 		alert("사용 불 가능한 이메일입니다.");
			 		//emailmsg.innerHTML = "사용 불 가능한 이메일입니다.";
			 	}
			 	if(map.membernicknamecheck == false){
			 		alert("사용 불 가능한 닉네임입니다.");
			 		//nicknamemsg.innerHTML = "사용 불 가능한 닉네임입니다.";
			 	}
			 }
		  });
	});
