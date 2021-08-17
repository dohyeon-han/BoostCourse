# 예약

## Package

### Controller
  * ReserveController - 예약 화면 return
  * LoginController - 세션을 통해 로그인하였는지 확인<br>
  예약확인 클릭 시 session을 확인하여 bookinglogin.jsp 혹은 myreservation.jsp로 redirect
  로그인한 이메일을 세션에 저장
  * ApiContorller - post 방식으로 예약 정보를 받아 ReserveService로부터 예약된 값을 받아 return 한다
  
### Dao
  * ReservationDao - displayInfo를 제외한 Reservation list return<br>
  DB 사용자 정보를 저장하고 executeAndReturnKey로 pk를 받아 각 가격 정보 저장
  * ReserveDaoSql - 각 메소드에 필요한 sql문 작성

### Dto
  * Reservation - api 형식에 맞게 속성 작성

### Service 
  * ReserveService - Reservation list에 displayInfo를 채워 return<br>
  사용자 예약 정보를 ApiController로부터 받아 Map으로 변환, 각  정보를 ReservationDao로 전달

## Resource

### JavaScript
  * reserve - 생성자 패턴으로 동작, api로 데이터를 받아와 화면에 출력<br>
  정규표현식으로 전화번호,이메일 확인<br>
  fetch를 사용해 현재 예약자의 입력 정보 json으로 controller에 전송
  * myreservation - 취소 클릭시 취소된 예약으로 카드 이동<br>
  handlebar를 이용해여 이용 완료, 예약, 취소 상태 bind<br>
  api로 받은 cancelYn = false 이면 취소, true일 경우 현재 시간을 기준으로 완료, 예약 상태 구분<br>
  취소 클릭 시 배열을 변경하여 카드가 이동하도록 수정 중

### JSP
  * reserve
  * bookinglogin
  * myreservation

## 기타
  * apicontroller package의 ApiController class 생성, api관련 메소드를 한 곳에 이동

