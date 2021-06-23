const html = document.querySelector("#templating-item").innerHTML;
var data = [
	{
		title: "hello",
		content: "book",
		price: 2000
	},
	{
		title: "world",
		content: "book",
		price: 5000
	}
];

//html templating
var rst = "";
for (var i = 0; i < data.length; i++) {
	rst += html.replace("{title}", data[i].title)
		.replace("{content}", data[i].content)
		.replace("{price}", data[i].price);
}
ul.innerHTML += rst;


//template literal
//html코드를 js에서 직접 치는 건 안좋다고 했는데 다른 방법이 있는지 모르겠다.
rst = "";
for (var i = 0; i < data.length; i++) {
	rst += `<li>
				<h3>${data[i].title}</h3><p>${data[i].content}<div>${data[i].price}</div>
			</li> `
}
ul.innerHTML += rst;
