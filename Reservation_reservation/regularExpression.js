var str = '123abc123';
var op = /\d/;
var result = str.match(op)[0];
console.log(result);

//***-*** or *****
//^,$로 자리수 제한
str = '123-456';
op = /^(\d{3}-[0-9]{3}|\d{5})$/
result = str.match(op)[0];
console.log(result);

//***-***(*)-**** 전화번호
str = '011-1234-5678';
op = /^01[0178]-\d{3,4}-\d{4}$/;
result = str.match(op)[0];
console.log(result);

str = '!@# happy_+_';
console.log(str.match(/[a-z]+/)[0]);
console.log(str.replace(/[^a-zA-Z]+/g,""));//특수문자, 공백 제거