# 예약

## Package

### Controller
  * ReserveController - /api/reservations로 데이터 받아옴
  * LoginController - 세션을 통해 로그인하였는지 확인<br>
  예약확인 클릭 시 session을 확인하여 bookinglogin.jsp 혹은 myreservation.jsp로 redirect
  로그인한 이메일을 세션에 저장
  
### Dao
  * ReservationDao - displayInfo를 제외한 Reservation list return 
  * ReserveDaoSql - 각 메소드에 필요한 sql문 작성

### Dto
  * Reservation - api 형식에 맞게 속성 작성

### Service 
  * ReserveService - Reservation list에 displayInfo를 채워 return

## Resource

### JavaScript
  * reserve - 생성자 패턴으로 동작, api로 데이터를 받아와 화면에 출력<br>
  정규표현식으로 전화번호,이메일 확인
  * myreservation - 취소 클릭시 취소된 예약으로 카드 이동

### JSP
  * reserve
  * bookinglogin
  * myreservation

## 기타
  * apicontroller package의 ApiController class 생성, api관련 메소드를 한 곳에 이동

