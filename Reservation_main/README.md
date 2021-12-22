<h1>메인</h1>

https://www.boostcourse.org/web316/joinLectures/12956?isDesc=false

<h3>Container</h3>

* 인스턴스의 생명 주기를 관리한다.
* WAS의 web container를 통해 servlet을 생성, 관리한다.
* Spring도 container를 이용해 객체들을 관리하는데 이 객체를 bean이라 한다.

<h3>IoC(Inversion of container)</h3>

* 프로그램의 흐름을 개발자가 아닌 다른 프로그램이 제어한다.

<h3>DI(Dependency injection)</h3>

* spring이 생성한 인스턴스를 주입한다.
```JAVA
public class A {

    private B b;

    public A(){
        b = new B();
    }
}
```
* 개발자가 직접 class B의 인스턴스 생성
```JAVA
public class A {

    @Autowired
    private B b;

}
```
* spring이 인스턴스 생성하여 주입한다. IoC와 DI가 발생


<h3>Spring JDBC</h3>

![image](https://user-images.githubusercontent.com/63232876/141403172-1be39544-0867-4724-91ef-aac844d7a8cc.png)

* JDBC의 연결, statement 준비 및 실행, 예외 처리와 같은 반복되는 작업을 알아서 처리해준다.

![image](https://user-images.githubusercontent.com/63232876/141403526-984fd012-6151-4864-bc0b-6d078eb7d9a9.png)


* Spring JDBC는 기존의 아래와 같은 작업을 대신 처리해준다.
```JAVA
Connection connection = null;
    try {
        connection = dataSource.getConnection();
        if(connection != null) {
            System.out.println("DB 연결");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if(connection != null) {
            try {
                connection.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
```

<h3>JDBC Template</h3>

* org.springframework.jdbc.core에서 가장 중요한 클래스이다.
* Statement의 생성과 실행을 처리한다.
* query, update 명령어 등을 통해 SQL 조회, 업데이트, 저장 프로시저 호출, ResultSet 반복호출 등을 실행한다.

<h3>Spring MVC</h3>

* MVC는 Model-View-Controller의 약자로 spring 뿐만 아니라 SW공학에서 사용하는 디자인 패턴이다.
* Model은 view를 화면에 나타내기 위해 필요한 데이터이다
* View는 웹 어플리케이션에서 화면에 짠 하고 보이는 부분으로 JSP, PDF로 표현할 수 있다.
* Controller는 사용자의 요청에 응답하여 작업의 흐름을 처리하고 view로 데이터를 전달한다.

<h3>MVC Model</h3>

* MVC Model1
![image](https://user-images.githubusercontent.com/63232876/141404908-ba51b12a-3abb-40a7-84d3-c0a1c3eda4f6.png)

* MVC Model2
![image](https://user-images.githubusercontent.com/63232876/141404968-ccb8e824-aadf-4366-8a7e-b55abce978a4.png)

* Model1은 구조가 간단하지만 JSP page에서 모든 응답과 요청을 처리하기 때문에 spring에서 사용한다면 HTML코드와 java코드와 뒤섞여 유지 보수에 어려움이 있다.

* Model2는 servlet과 JSP page가 역할을 나눠 처리를 하기 때문에 설계에 난이도는 있지만 분업과 유지 보수에 유리하다.

<h3>Spring MVC 구성</h3>

![image](https://user-images.githubusercontent.com/63232876/141414853-086ac60f-0e94-4193-8df9-bddda835de37.png)

* Client로부터 오는 모든 요청은 dispatcher servlet이 받는다.
* Dispatcher servlet은 handler mapping으로부터 어떤 controller나 method를 사용해야하는지 알아낸다.
* 알아낸 정보로 handler adapter로 실행을 요청한다.
* Controller는 실행 후 model과 view name을 반환한다.
* Dispatcher servlet은 view resolver를 통해 view name에 맞는 view를 찾고, view가 출력된다.

<h3>Layered architecture</h3>

![image](https://user-images.githubusercontent.com/63232876/141419317-f283eeab-a7bf-4f04-8f9e-750582d5bf52.png)

* Spring MVC에서 controller method는 presentation layer, service method는 business layer, DAO method persistence layer에 위치하게 된다.
* 각 controller는 부분적으로 같은 작업을 수행 할 수도 있다. 이때 공통된 작업을 controller 각각에 작성하는 것은 비효율적이다.
* 이런 공통된 작업을 service 객체에 만들고 이 객체들은 하나의 layer를 만든다.
* Service 객체는 business logic을 수행하고, 보통 하나의 business logic은 transaction으로 동작한다.

<h3>Transaction</h3>

* Transaction을 간단히 말하자면 한 번에 업데이트하거나 아님 실패하는 것이다.
* 은행의 계좌 이체를 생각하면 쉽다. 이체를 하면 내 통장의 돈이 상대방 통장으로 가지만 실패하면 내 통장의 돈은 그대로 있다. 이체 도중에 실패한다고 통장의 돈이 사라지지는 않는다.
* Transaction은 4가지 특징을 가지고 있다.
    * 원자성
    * 일관성
    * 독립성
    * 지속성
* 원자성
    * 작업은 한 번에 수행되야 한다.<br> 중간에 실패하면 이전에 성공했던 작업들은 rollback되고 시작점으로 돌아간다.
* 일관성
    * 작업 처리 결과가 항상 일관성이 있어야 한다.<br> 작업 수행 중 원래의 데이터가 변경되어도 변경된 데이터가 아니라 처음 작업을 수행했을 때의 데이터로 진행한다.
* 독립성
    * 하나의 transaction 실행되는 동안 다른 transaction이 끼어들 수 없다.
* 지속성
    * Transaction이 성공적으로 수행되면 결과는 계속 유지되어야 한다.

* Spring에서는 @EnableTransactionManagement을 config파일에 사용하여 활성화할 수 있다.


