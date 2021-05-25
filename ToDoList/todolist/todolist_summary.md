# To Do List
![todolist_project](https://user-images.githubusercontent.com/63232876/119270137-32b65c80-bc36-11eb-883b-959a93cf7df4.png)
## Main
  * MainServlet.java - todo, doing, done에 대하여 TodoDto.java로 부터 list를 받은 후 request scope를 이용해 main.jsp로 foward
  * main.jsp - MainServlet.java로 부터 todo, doing, done 3개의 list를 전달 받고 jstl과 el tag를 활용해 화면에 출력
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;onclick="moveBtn(${list.getId}, this)"로 클릭한 todo 객체를 js로 전달
  * main.js - XMLHttpRequest() 사용한 Ajex<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;open, setRequestHeader, send를 사용해 post 방식으로 TodoTypeServlet.java로 id, type 전달<br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;request 요청 완료 시 removeChild, appendChild를 이용해 todo 위치 변경
  * index.css - float, flex를 활용해 각 요소 배치

## New Todo 등록
  * TodoFormServlet.java - forward를 통해 newtodo.jsp로 이동
  * newtodo.jsp - div, placeholder, button 등을 이용해 각 요소 생성<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'내용 지우기' 버튼을 누르면 newtodo.js로 placeholder의 내용 삭제<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'제출' 버튼을 누르면 TodoAddServlet.java로 post방식으로 전달
  * newtodo.css - 요소들 꾸미기
  * newtodo.js - '내용 지우기' 버튼을 누르면 placeholder의 내용 삭제
  * TodoAddServlet.java - 객체를 전달 받아 TodoDto객체를 만든 후 TodoDao.java로 TodoDto객체 전달
