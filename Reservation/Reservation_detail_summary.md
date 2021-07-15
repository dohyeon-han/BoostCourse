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
