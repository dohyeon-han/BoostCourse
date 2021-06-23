var log = document.querySelector(".log");

/*var lists = document.querySelectorAll("ul > li");

for(var i = 0; i<lists.length; i++){
	lists[i].addEventListener("click", (t)=>{
		log.innerHTML = t.currentTarget.innerText;
		console.log(t.currentTarget);
	})
}*/

var ul = document.querySelector("ul");
//ul로 한꺼번에 이벤트를 등록하면 간단히 할 수 있다.
ul.addEventListener("click", (t)=>{
	//target은 현재 클릭한 object
	//currenttarger은 event를 등록한 object
	
	console.log(t.target, t.currentTarget);
})

//event delegtion - 상위 엘리먼트에 이벤트를 위임해서 추가적인 이벤트 등록을 하지 않아도 된다.