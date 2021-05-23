function moveTodo(type, node){
	const li = node.parentNode;
	const from_ul = li.parentNode;
	const to_ul = document.querySelector((type==="todo"?".doing":".done"));//todo->doing,doing->done
	if(type==="doing"){
		li.removeChild(node);//done이면 버튼도 삭제
	}
	from_ul.removeChild(li);
	to_ul.appendChild(li);
}

function moveBtn(id, node) {
	var xhr = new XMLHttpRequest();
	var type = node.parentNode.parentNode.getAttribute("class");//todo,done,doing 중 어떤 상태인지 확인 
	
	xhr.onreadystatechange = function() { // 요청에 대한 콜백
		if (xhr.readyState === xhr.DONE) { // 요청이 완료되면
			if (xhr.responseText === "success") {
				moveTodo(type, node);//옮기기
			} 
		}
	};
	xhr.open('post', './todotype'); // post방식으로 TodoTypeServlet.java로전송
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	xhr.send("id=" + id + "&type=" + type);
}