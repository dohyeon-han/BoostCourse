var obj = {
    name:"달리기",
    time:"PM10:00",
    showObj : function(){
        setTimeout(function(){//this는 function에 있기 때문에 bind를 하지 않으면 window을 가리킨다
            console.log(this.name+"를 "+this.time);
        }.bind(this),100);

        setTimeout(()=>{//arrow function은 bind를 자동으로 해준다.
            console.log(this.name+"를 "+this.time);
        },100);
    }
}

obj.showObj();