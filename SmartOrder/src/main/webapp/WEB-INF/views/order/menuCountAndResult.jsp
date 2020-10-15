<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
		수량 : <input type=hidden id="sell_price" name="sell_price" value="7000">
		<input type="text" id="amount" name="amount" value="1" size="3" onchange="change();">
		<input type="button" value=" + " onclick="add();" /><input type="button" value=" - " onclick="del();"><br>

		금액 : <input type="text" id="sum" size="11" readonly>원
</body>

<script>
	
	var sell_price = document.getElementById("sell_price");
	var amount = document.getElementById("amount");
	var sum = document.getElementById("sum");
	
	function init() {
		sum.value = sell_price.value;
		change()
	}

	function add() {
		amount.value++;
		console.log(sum.value)
		sum.value = amount.value * sell_price.value; 
		console.log(sum.value)

	}

	function del() {
		if (amount.value > 1) {
			amount.value--;
			sum.value = amount.value * sell_price.value;
		}
	}

	function change() {
		if (amount.value < 0) {
			amount.value = 0;
		}
		sum.value = amount.value * sell_price.value;
		console.log("change 함수 끝")
	}  
</script>

</html>