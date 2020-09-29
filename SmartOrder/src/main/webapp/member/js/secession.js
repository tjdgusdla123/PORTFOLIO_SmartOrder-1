var pwcheckform = document.getElementById("passwordcheckform");
var pwcheckbtn = document.getElementById("pwcheckbtn");
var memberpassword = document.getElementById("memberpassword");
var msg = document.getElementById("msg");


pwcheckbtn.addEventListener("click", function(event){
	var flag = false;
	if (memberpassword.value.trim().length < 1) {
			msg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			msg.style.color = "red";
			flag = true;
		}
	if(flag == true){
		return;
		}
	
	var url="secession";
	
	var request=new XMLHttpRequest();
	request.open("post", url, true);
	var formdata = new FormData(pwcheckform);
	request.send(formdata);
	console.log("load 진입 전")

	request.addEventListener('load', function(e){
		console.log("load 진입")
		
	var rText = e.target.responseText
	console.log(rText)
	

	//var map = JSON.parse(e.target.responseText);
	
	if(rText == 'redirect:/user/main'){
	console.log('rText 진입')
	
	alert('회원탈퇴에 성공했습니다')
	location.href = "../user/main";
	}else{
	console.log('rText else 구문 진입')
	alert('회원탈퇴에 실패했습니다.')
	msg.innerHTML = "잘못된  비밀번호입니다.";
}
});
});