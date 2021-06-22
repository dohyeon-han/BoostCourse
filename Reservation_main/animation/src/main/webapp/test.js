//비동기적으로 다른 함수에 의해 밀릴 수 있다.
const interval = window.setInterval(()=>{
	console.log("1번", new Date());
},1000);

//재귀를 이용해 지연 없이 호출 가능
//c와는 다르게 호출이 끝난 함수는 stack에서 비워짐
var cnt = 0;
function animate(){
	setTimeout(()=>{
		if(cnt===10) return;
		console.log("2번", new Date());
		cnt++;
		animate();
	},1000);
};
animate();

//settimeout 대신 최적화한 함수 requestAnimationFrame을 이용한 애니메이션
const box = document.querySelector(".box");
box.style.left = "0px";
box.style.transform = "scale(2)";

var cnt2 = 0;
function animate() {
	if(cnt2>300) return;
	if (cnt2 % 60 == 0) {
		box.style.left = parseInt(box.style.left) + cnt2 + "px";
	}
	cnt2++;
	requestAnimationFrame(animate);
}

//버튼을 누르면 오른쪽으로 이동
const btn = document.querySelector("button");
btn.addEventListener("click", right);

function right(){
	box.style.left = parseInt(box.style.left) - 50 + "px";
}