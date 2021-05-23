# To Do List

## Main
  * MainServlet.java - todo, doing, done에 대하여 TodoDto.java로 부터 list를 받은 후 request scope를 이용해 main.jsp로 foward
  * main.jsp - MainServlet.java로 부터 todo, doing, done 3개의 list를 전달 받고 jstl과 el tag를 활용해 화면에 출력
               onclick="moveBtn(${list.getId}, this)"로 클릭한 todo 객체를 js로 전달
  * main.js - XMLHttpRequest() 사용한 Ajex
              open, setRequestHeader, send를 사용해 post 방식으로 TodoTypeServlet.java로 id, type 전달
              request 요청 완료 시 removeChild, appendChild를 이용해 todo 위치 변경
  * index.css - float, flex를 활용해 각 요소 배치

## New Todo 등록
  * 
