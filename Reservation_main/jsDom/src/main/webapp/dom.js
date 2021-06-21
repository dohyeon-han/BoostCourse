//strawberry 아래 melon 추가
var melon = document.createElement("li");
melon.innerText = "melon";

var parent = document.querySelector("ul");
parent.appendChild(melon);

//insertBefore을 이용해 orange, banana 사이 새 과일 삽입

var banana = document.querySelector("li:nth-child(3)");//class나 id를 이용해는 것이 더 좋다
parent.insertBefore(melon, banana);

//insertAdjacentHTML을 이용해 orange, banana 사이 새 과일 삽입
banana.insertAdjacentHTML("beforebegin","<li>멜론</li>");

//apple을 grape와 strawberry 사이로
var apple = document.querySelector("li:nth-child(1)");
var strawberry = document.querySelector("li:nth-child(7)");

parent.insertBefore(apple,strawberry);

//class가 red 노드 삭제
var red = document.querySelectorAll(".red");

red.forEach(function(node){
	var redParent = node.parentNode;
	redParent.removeChild(node);
})

//section 태그의 자손 중에 blue라는 클래스를 가지고 있는 노드가 있다면, 그 하위에 있는 h2 노드를 삭제
var blue = document.querySelectorAll("section .blue");

blue.forEach(function(node){
	var section = node.closest("section");
	section.removeChild(section.querySelector("h2"));
})

