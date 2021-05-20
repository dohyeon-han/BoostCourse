const whatText = document.querySelector('.what-text'),
	whoText = document.querySelector('.who-text'),
	eraseBtn = document.querySelector('.erase');


function eraseAll(){
	whatText.value="";
	whoText.value="";
}


function init(){
	eraseBtn.addEventListener("click", eraseAll);
}

init();