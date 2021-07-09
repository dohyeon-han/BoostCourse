var dataObj = {
        data : [{title : "hello",content : "간지철철", price : 12000},
            {title : "crong",content : "괜춘한 상품", price : 5500},
            {title : "codesquad",content : "쩌는상품", price : 1200}],
        getData(){
            console.log(this.data);
        }
}

dataObj.data.forEach(v=>{//for 사용 안해도 됨, 실수 줄임, 짧다
    console.log(v.title,v.content);
});

var priceData = dataObj.data.map(v=>{
    return v.price;
});
console.table(priceData);

var bigPriceData = dataObj.data.filter(v=>{//연속해서 사용가능
    return v.price>5000;
}).map(v=>{
    var obj = {title:v.title,content:v.content,price:v.price*2};
    return obj;
})

console.log(bigPriceData);
dataObj.getData();
