# 예약

## Package

### Controller
  * ReserveController - /api/reservations로 데이터 받아옴
  * MyReservationController - 세션을 통해 로그인하였는지 확인, 예약확인 클릭 시 session을 확인하여 bookinglogin.jsp 혹은 myreservation.jsp로 redirect

### Dao
  * ReservationDao - displayInfo를 제외한 Reservation list return 
  * ReserveDaoSql - 각 메소드에 필요한 sql문 작성

### Dto
  * Reservation - api 형식에 맞게 속성 작성

### Service 
  * ReserveService - Reservation list에 displayInfo를 채워 return

## Resource

### JavaScript
  * reserv - 생성자 패턴으로 동작, api로 데이터를 받아와 화면에 출력
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  정규표현식으로 전화번호,이메일 확인

### JSP
  * reserve
  * bookinglogin
  * myreservation

