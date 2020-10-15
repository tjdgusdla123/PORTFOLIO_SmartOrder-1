window.addEventListener("load", function () {

    var getList = document.getElementById("getList");

	var url = "/orderinfo/getcartlist";
	var request = new XMLHttpRequest();

	request.open("get", url, true);
	request.send();
	request.addEventListener('load', function (e) {
		var map = JSON.parse(e.target.responseText);
		console.log(map);

		var msg = "<table class='table table-bordered table-striped table-hover table-responsive' border='1'>" +
			"<tr>" +
			"<th width='50%'>" + '메뉴이름' + "</th>" +
            "<th width='30%'>" + '수량' + "</th>" +
			"<th width='15%'>" + '금액' + "</th>"
			"</tr>"

		for (let index = 0; index < map.list.length; index++) {
			var imsi = map.list[index];


			msg += "<tr>" +
				"<td  width='50%'>" + imsi.menuName + "</td>" +
				"<td  align='right' width='30%'>" + imsi.menuCount + "</td>" +
				"<td width= '15%'>" + imsi.menuCount * imsi.menuPrice + "</td>"
				"</tr>"
		}

		msg += "</table>"
		msg += "<br/><br/>"

		getList.innerHTML = msg;

	});
})