function data(name){
    this.name = name;
}
//객체가 생성될 때 여러 객체에서 중복된 함수를 갖는 것을 막는다
data.prototype.showName = function(){
    console.log(this.name);
}

var o = new data("han");
o.showName();
var o2 = new data("kim");
o2.showName();

console.log(o.showName===o2.showName);