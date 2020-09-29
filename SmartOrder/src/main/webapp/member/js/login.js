var loginform = document.getElementById("loginform");
var loginbtn = document.getElementById("loginbtn");
var membernickname = document.getElementById("membernickname");
var memberpassword = document.getElementById("memberpassword");
var msg = document.getElementById("msg");


loginbtn.addEventListener("click", function(event){
	var flag = false;
	if (membernickname.value.trim().length < 1) {
			msg.innerHTML = '닉네임은 필수 입력입니다.<br/>';
			msg.style.color = "red";
			flag = true;
		}
	
	if (memberpassword.value.trim().length < 1) {
			pwmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			msg.style.color = "red";
			flag = true;
		}
	if(flag == true){
		return;
		}
	
	var url="login";
	
	var request=new XMLHttpRequest();
	request.open("post", url, true);
	var formdata = new FormData(loginform);
	request.send(formdata);
	request.addEventListener('load', function(e){
	var map = JSON.parse(e.target.responseText);
	if(map.result == true){
	alert('로그인에 성공했습니다')
	location.href = "/orderinfo";
	}else{
	alert('로그인에 실패했습니다.')
	msg.innerHTML = "잘못된 닉네임이거나 비밀번호가 틀렸습니다.";
}
});
});