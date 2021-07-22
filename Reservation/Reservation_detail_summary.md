# 세부화면

## pakage

### DAO
  * CommentDao - productId에 따라 값 선택, comment의 score을 더해 평균 계산
  * CommentImageDao - InfoId, UserCommentId에 따라 값 선택
  * DisplayInfoDao - displayInfoId에 따라 값 선택
  * DisplayInfoImageDao - reservationInfoId, reservationUserCommentId를 이용해 필요한 값 선택
  * ProductImageDao - productId를 이용해 필요한 값 선택
  * ProductPriceDao - productId를 이용해 필요한 값 선택
  * DetailDaoSql - 각 DAO에서 사용할 SQL문을 작성

### DTO
  * Comment - api에 맞게 속성을 갖는다.
  * CommentImage - ''
  * DisplayInfo - ''
  * DiaplayInfoImage - ''
  * ProductImage - ''
  * ProductPrice - ''

### Service
  * DetailServiceImpl - 각 DAO에서 구현한 메소드를 이용해 DTO를 완성하여 필요한 api형식으로 return, comment의 경우 object안에 list가 있으므로  그 형식을 완성한다.

### Controller
  * DetailApiController - displayInfoId에 맞는 api return
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  사용자 정보 노출을 막기 위해 js에서 ajax을 사용하지 않고 서버에서 데이터 변경 후 jstl을 이용

## JavaScript
  * detail.js - url과 ajax를 통해 displayInfoId에 해당하는 내용 가져옴<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Pagination객체 리터럴, setTimeout을 이용해 화살표 클릭 시 움직이는 무한 슬라이드 구현
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Event delegation, handlebar를 이용해 tab 구현
  
  
## HTML, CSS
  * detail.html - 기존 base에서 css에 맞게 class 변경
  * reservation.css - image 크기에 맞게 좌표 변경
  
## 기타
  * Category, Product, PromitionApiController -> 코드량도 적은데 굳이 나눌 필요는 없다고 생각해서 MainApiController로 통합
