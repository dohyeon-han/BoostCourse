//비동기적으로 다른 함수에 의해 밀릴 수 있다.
const interval = window.setInterval(()=>{
	console.log("1번", new Date());
},1000);

//재귀를 이용해 지연 없이 호출 가능
//c와는 다르게 호출이 끝난 함수는 stack에서 비워짐
let cnt = 0;
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

var cnt = 0;
function animate() {
	cnt++;
	if (cnt % 60 == 0) {
		box.style.left = parseInt(box.style.left) + cnt + "px";
	}
	requestAnimationFrame(animate);
}

requestAnimationFrame(animate);