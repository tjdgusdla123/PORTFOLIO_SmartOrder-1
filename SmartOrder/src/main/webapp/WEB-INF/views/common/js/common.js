setInterval(function() {
	navigator.geolocation.getCurrentPosition(function(position) {
		var loc = position.coords.latitude + ":" + position.coords.longitude
		$.ajax({
			url:"address",
			data:{"loc":loc},
			dataType:"json",
			success:function(data){
				document.getElementById('addr').innerHTML= "현재위치:" + data.address			}
		});
	});
}, 10000)