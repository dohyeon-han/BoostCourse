# 세부화면

<img src="https://user-images.githubusercontent.com/63232876/126861318-511ba977-4df6-40e5-ae68-4849ae68c8e0.gif" width="80%",height="80%">

<img src="https://user-images.githubusercontent.com/63232876/126861321-f28b699f-b006-4e98-8872-82887ed915c2.png" width="80%",height="80%">
<img src="https://user-images.githubusercontent.com/63232876/126861319-305852ee-9c7a-4c17-a34e-5b3256c8556c.png" width="80%",height="80%">



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
  * Comment - api에 맞게 속성을 갖고 각각의 getter와 setter를 갖는다.
  * CommentImage - ''
  * DisplayInfo - ''
  * DiaplayInfoImage - ''
  * ProductImage - ''
  * ProductPrice - ''

### Service
  * DetailServiceImpl - 각 DAO에서 구현한 메소드를 이용해 DTO를 완성하여 필요한 api형식으로 return, comment의 경우 object안에 list가 있으므로  그 형식을 완성한다.<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  리뷰를 출력하기 위해 필요한 정보를 가공하여 list return
  
### Controller
  * DetailApiController - @PathVariable로 displayInfoId를 받고 이에 맞는 api return<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  리뷰의 사용자 id 노출을 막기 위해 js에서 ajax을 사용하지 않고 서버에서 데이터 변경 후 addAttribute로 전달


## JavaScript
  * detail.js - url과 ajax를 통해 displayInfoId에 해당하는 내용 가져옴<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Pagination객체 리터럴, setTimeout을 이용해 화살표 클릭 시 움직이는 무한 슬라이드 구현<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Event delegation, handlebar를 이용해 tab 구현
  
  
## jsp, CSS
  * detail.jsp - 기존 base에서 css에 맞게 class 변경, 서버에서 리뷰정보를 받아와 jstl을 이용해 출력
  * reservation.css - image 크기에 맞게 좌표 변경
  * review.jsp - 서버에서 리뷰정보를 받아와 jstl을 이용해 출력
  
## 기타
  * Category, Product, PromitionApiController -> 코드량도 적은데 굳이 나눌 필요는 없다고 생각해서 MainApiController로 통합
