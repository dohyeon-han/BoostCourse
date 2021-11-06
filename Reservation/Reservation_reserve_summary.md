# 예약

  * 예약 화면
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/130392882-20cc1c79-feb5-49ca-9034-c4269ae2ed5f.gif" width="40%" height="40%"></p>
  * 예약하기
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/130392978-94e1d233-41de-4a09-9f72-233e57c7d477.gif" width="40%" height="40%"></p>
  * 로그인
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/130392989-3a1363f4-2843-4345-9525-a7b7c79eacfd.gif" width="40%" height="40%"></p>
  * 예약 취소
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/130393008-52cdfd70-cb00-42dc-bbd4-fe7e83a73a99.gif" width="40%" height="40%"></p>

## Package
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/130393424-5a88f9f7-66ef-4469-b3fa-16fdc3e41f3c.png" width="40%" height="40%"></p>
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/130393427-911c9487-5e8f-403d-841d-8de898b68bcd.png" width="40%" height="40%"></p>

### Controller
  * ReserveController - 예약 화면 return, 현재 날짜, 랜덤 예약 날짜(Math.random), 예약 마지막 날짜(현재 + 4) 전달
  * LoginController - 세션을 통해 로그인하였는지 확인<br>
  예약확인 클릭 시 session을 확인하여 bookinglogin.jsp 혹은 myreservation.jsp로 redirect
  로그인한 이메일을 세션에 저장
  * ApiContorller - post 방식으로 예약 정보를 받아 ReserveService로부터 예약된 값을 받아 return 한다
  
### Dao
  * ReservationDao - displayInfo를 제외한 Reservation list return<br>
  DB 사용자 정보를 저장하고 executeAndReturnKey로 pk를 받아 각 가격 정보 저장<br>
  reservationId를 받아 예약 정보 취소
  * ReserveDaoSql - 각 메소드에 필요한 sql문 작성

### Dto
  * Reservation - api 형식에 맞게 속성 작성
  * PersonalReservation -  api 형식에 맞게 속성 작성
  * Price - PersonalReservation의 List<> 속성

### Service 
  * ReserveService - Reservation list에 displayInfo를 채워 return<br>
  사용자 예약 정보를 ApiController로부터 받아 PersonalReservation으로 변환, 각  정보를 ReservationDao로 전달<br>
  reservationId를  ApiController로부터 받아 DAO로 전달

## Resource

### JavaScript
  * reserve - 생성자 패턴으로 동작, api로 데이터를 받아와 화면에 출력<br>
  정규표현식으로 전화번호,이메일 확인<br>
  fetch를 사용해 현재 예약자의 입력 정보 json으로 controller에 전송
  * myreservation - 취소 클릭시 취소된 예약으로 카드 이동<br>
  handlebar를 이용해여 이용 완료, 예약, 취소 상태 bind<br>
  api로 받은 cancelYn = false 이면 취소, true일 경우 현재 시간을 기준으로 완료, 예약 상태 구분<br>
  취소 클릭 시 fetch로 api를 이용해 예약 취소 후 배열을 변경하여 카드가 이동
  

### JSP
  * reserve - 공연 예약 화면
  * bookinglogin - 단순한 로그인 화면, 정규 표현식으로 이메일 입력 확인
  * myreservation - 자신의 예약 현황 출력

## 기타
  * apicontroller package의 ApiController class 생성, api관련 메소드를 한 곳에 이동

## DB
![image](https://user-images.githubusercontent.com/63232876/140598647-f0ea431a-1241-4bfd-8696-12d180449543.png)


