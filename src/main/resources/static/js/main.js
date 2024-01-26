window.onload = function() {
	let name = document.getElementById("buyaoshow").value;
	document.getElementById("show").innerHTML = name;
	if (document.getElementById("username") != null)
		document.getElementById("username").innerHTML = name;
	let nowd = new Date();
	let nowh = nowd.getHours();

	if (nowh >= 5 && nowh <= 11) {
		document.getElementById("sayhi").innerHTML = "Chào buổi sáng";
	}
	else if (nowh >= 12 && nowh <= 18) {
		document.getElementById("sayhi").innerHTML = "Chào buổi chiều";
	}
	else if (nowh >= 19 & nowh <= 22) {
		document.getElementById("sayhi").innerHTML = "Chào buổi tối";
	}
	else if (nowh == 23 || nowh <= 4) {
		document.getElementById("sayhi").innerHTML = "Đến lúc đi ngủ rồi!";
	}
}
