# 한 줄 평

* 리뷰 남기기
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/132319609-ceab06ca-b253-4c22-841e-a714233e4930.gif" width="40%" height="40%"></p>
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/132319428-2139818b-376b-4f0a-80f0-567c68c61de6.gif" width="40%" height="40%"></p>

## Pakage 
<img src="https://user-images.githubusercontent.com/63232876/132315597-8d3d0688-294f-4459-bbc1-99a36a4b0d15.png" width="40%" height="40%">
<img src="https://user-images.githubusercontent.com/63232876/132315602-57878361-1b34-4c69-911a-a0a02dee4034.png" width="40%" height="40%">

### Config
  * WebMvcContextConfiguration - addInterceptors를 override하여 logInterceptor 등록

### ApiController
  * CommentController - form 값과 reservationInfoId을 @RequestParam으로 받는다.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ReviewWriteServiceImpl를 호출하여 ReviewWrite 타입의 결과 return

### Interceptor
  * LogInterceptor - logback을 이용해 preHandle메소드에 logger.info로 각 요청마다 url, ip, 시간 콘솔에 출력

### ExceptionController
  * ExceptionController - view 요청과 ajax 요청이 모두 거쳐갈 수 있으므로 각 요청에 맞는 타입의 return 값을 반환해야 한다.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HttpServletRequest를 받아 header의 값에 따라 json 혹은 페이지를 return 해준다.

### Controller
  * ReviewWriteController - 만약 로그인 세션이 만료되면 다시 로그인 창으로 리다이렉트,<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@PathVariable로 reservationInfoId, displayInfoId를 받고,<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주소가 유효한 주소인지 email을 받아 session의 email과 비교 후 다르면 에러 페이지 띄우기<br>
  
### Dao
  * ReviewWriteDao - reservationInfoId, displayInfoId를 이용해 이용 완료한 email을 db에서 찾아 return<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;apicontroller로부터 받은 파라미터 map 객체로 reservation_user_comment 테이블에 입력<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;detail package의 commentImage 타입을 받아 DB의 file_info, reservation_user_comment_image 테이블에 입력<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SimpleJdbcInsert로 DB에 저장 후 id return

### Dto
  * ReviewWrite - ajax형식에 맞게 구현

### Service.impl
  * ReviewWriteServiceImpl - getReservationEmail 메서드로 ReviewWriteDao로부터 eamil을 return 받는다<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;파일이 있다면 폴더에 업로드, 중복 방지를 위해 현재의 시간값을 파일 이름 앞에 추가<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;insertReview 메서드로 DB에 입력한 각각 reservation_user_comment, file_info에 입력 후,<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;pk를 받아 reservation_user_comment_image에 입력
  

## JS
  * reviewWrite - Score class를 작성하여 클릭에 따라 평정 조작<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ajax로 리뷰를 작성할 공연 정보 받음<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;textarea의 글자 수 addEventListener("input")을 사용해 확인 밎 제한, 글자 수가 0이면 다시 info 띄움<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;file 썸네일 올리기, 삭제 시 input value를 없애야 같은 파일 다시 올리기 가능<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사진 파일 선택 시 확장자 확인<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ajax로 form 저장, response가 성공하면 예약확인 페이지로 이동, 실패 시 alert창을 띄운다<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DB 저장을 위해 정규표현식으로 textarea의 앞뒤 엔터, 연속된 엔터를 제거, 엔터는 br태그로 변경<br>

## 기타
  * server.xml - 프로젝트 외부로 옮긴 img의 외부 img 경로 설정
  * pom.xml - logback 관련 의존성 추가

## DB
![image](https://user-images.githubusercontent.com/63232876/140599198-98f45bdd-5408-4580-8803-bd08d257a0d1.png)
