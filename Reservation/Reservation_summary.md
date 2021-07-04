# 예약 서비스

## Package

### Config
  * ApplicationConfiguration - DB관련 이벤트 처리, dao와 service를 scan
  
  * DBConfiguration - web.xml의 ContextLoaderListener에 의해 동작
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  DataSource를 bean에 등록
  
  * WebMvcContextConfigurtion - dispatcher servlet를 위한 추가적인 설정 파일, controller를 scan
  
### Controller
  * PromotionApiController - /api/promotions로 promotion list를 api 형식에 맞게 map 객체로 바꿔 return

### Dao
  * DaoSql - db query문을 상수로 선언, 다른 파일에서 import static으로 사용
  * PromotionDao - 전체조회, 삽입, 삭제, 수정 구현
  * CategoryDao - 전체조회, 삽입, 삭제, 수정 구현

### Dto
  * Promotion - id, productId, productImageUrl를 변수로 선언
  * Category - id, name, count를 변수로 선언

### Service
  * ResercationService - business logic을 위한 interface  

### Service.impl
  * PromotionServiceImpl - PromotionDao를 통해 얻은 promotion list를 그대로 return


## Resouces

### JavaScript
  * slide.js - DOMContentLoaded를 eventlistener에 등록하고 해당 listener가 동작 후 PromotionApiController가 보낸 promotion 정보를 
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  api를 통해 ajax로 받는다.
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  받은 promotion 정보를 이용해 DOM을 추가, requestAnimationFrame를 이용해 무한 슬라이드 구현
  
### CSS
  * reservation.css - 기존 형식에서 각 상황에 맞게 변환
  
