# 예약 서비스

## Config
  * ApplicationConfiguration - DB관련 이벤트 처리, dao와 service를 scan
  
  * DBConfiguration - web.xml의 ContextLoaderListener에 의해 동작
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  DataSource를 bean에 등록
  
  * WebMvcContextConfigurtion - dispatcher servlet를 위한 추가적인 설정 파일, controller를 scan
  
## Controller

## DAO
  * DaoSql - db query문을 상수로 선언, 다른 파일에서 import static으로 사용
  * PromotionDao - promotion table과 product table을 join하여 list 반환
  
## Service
  * PromotionServiceImpl - PromotionDao를 통해 얻은 promotion list를 파일 이름의 string list로 변환
