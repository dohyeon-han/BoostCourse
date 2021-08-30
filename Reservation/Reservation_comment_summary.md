# 한 줄 평

## Package

### Apicontriller
  * CommentController - displayInfoId를 @PathVariable로 받아 myreservation.jsp에서 reviewWrite.jsp로 view return

### Controller
  * ReviewWriteController - @PathVariable로 id를 받고, 만약 로그인 세션이 만료되면 다시 로그인 창으로 리다이렉트
  
### Dao
  * ReviewWriteDao - 

### Dto
  * ReviewWrite - 
  * CommentImage -

### Service.impl
  * ReviewWriteServiceImpl -  


## JS
  * reviewWrite - Score class를 작성하여 클릭에 따라 평정 조작<br>
  ajax로 리뷰를 작성할 공연 정보 받음<br>
  textarea의 글자 수 addEventListener("input")을 사용해 확인 밎 제한, 글자 수가 0이면 다시 info 띄움<br>
  file 썸네일 올리기, 삭제 시 input value를 없애야 같은 파일 다시 올리기 가능<br>
  사진 파일 선택 시 확장자 확인

## 기타
  * server.xml - 프로젝트 외부로 옮긴 img의 외부 img 경로 설정
