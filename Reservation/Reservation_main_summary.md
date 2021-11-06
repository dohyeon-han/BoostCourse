# 예약 서비스

* main
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/124915522-99e47080-e02c-11eb-94af-e944f7b144d5.gif" width="90%" height="90%"></p>

## Package
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/124915479-8df8ae80-e02c-11eb-88d1-bb1a58a237ef.png" width="40%" height="40%"></p>
<p align="center"><img src="https://user-images.githubusercontent.com/63232876/124915486-8fc27200-e02c-11eb-99ff-4d1cacb57000.png" width="40%" height="40%"></p>

### Config
  * ApplicationConfiguration - DB관련 이벤트 처리, dao와 service를 scan
  
  * DBConfiguration - web.xml의 ContextLoaderListener에 의해 동작
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  DataSource를 bean에 등록
  
  * WebMvcContextConfigurtion - dispatcher servlet를 위한 추가적인 설정 파일, controller를 scan
  
### Controller
  * PromotionApiController - /api/promotions로 promotion list를 api 형식에 맞게 map 객체로 바꿔 return
  * CategoryApiController - /api/categories로 category list를 ''
  * ProductApiController - /api/products로 product list를 ''

### Dao
  * DaoSql - db query문을 상수로 선언, 다른 파일에서 import static으로 사용
  * PromotionDao - 전체조회 구현
  * CategoryDao - 전체조회 구현
  * ProductDao - 전체조회, id에 따른 조회, 선택된 product 수 구현

### Dto
  * Promotion - id, productId, productImageUrl를 변수로 선언
  * Category - id, name, count를 변수로 선언
  * Product - displayInfoId, productId, productDescription, placeName, productContent, productImageUrl를 변수로 선언


### Service.impl
  * PromotionServiceImpl - PromotionDao를 통해 얻은 promotion list를 그대로 return
  * CategoryServiecImpl - CategoryDao를 통해 얻은 category list를 그대로 return
  * PrductServiceImpl - ProductDao를 통해 얻은 count, list를 return

## Resouces

### JavaScript
  * main.js - DOMContentLoaded를 eventlistener에 등록하고 해당 listener가 동작 후 PromotionApiController가 보낸 promotion 정보를 
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  api를 통해 ajax로 받는다.
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  받은 promotion 정보를 이용해 DOM을 추가, requestAnimationFrame를 이용해 무한 슬라이드 구현
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Ajax와 api를 이용해 category 및 클릭 동작 구현
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  tab을 이동할 때마다 ajax를 통해 4개 단위로 product를 받아 구현, 더보기 클릭 시 마다 4개씩 추가
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  생성자 패턴 적용
  
### CSS
  * reservation.css - 기존 형식에서 각 상황에 맞게 변환

## 
![image](https://user-images.githubusercontent.com/63232876/140599335-3f51ab1d-be2b-4a9f-b250-c3292f9b91d5.png)
