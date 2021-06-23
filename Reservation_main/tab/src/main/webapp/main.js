var tab = document.querySelector(".title");
var content = document.querySelector(".content");

function change(title, data) {
	var rstHTML = "";
	for(var i = 0; i < data.length; i++){
		if(data[i].name===title){
			for(var j = 0; j < data[i].content.length; j++){
				rstHTML += `<li>${data[i].content[j]}</li>`;
			}
		}	
	}
	content.innerHTML = rstHTML;
}

function sendAjax(e) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var data = JSON.parse(xhttp.responseText);
			change(e.target.innerText, data);
		}
	};
	xhttp.open("GET", "./json.txt", true);
	xhttp.send();
}

function init() {
	tab.addEventListener("click", sendAjax);
}

init();