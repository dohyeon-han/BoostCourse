package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Car c = (Car)ac.getBean("c");
		c.run();
		
		//@Configuration을 이용
		ApplicationContext ac2 = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Car c2 = (Car)ac2.getBean(Car.class);//class 타입으로 얻을 수 있다
		c2.run();
		
		//@Configuration,@ComponentScan("kr.or.connect")을 이용
		//setter을 사용하지 않고 @Autowired를 사용할 수 있다.
		ApplicationContext ac3 = new AnnotationConfigApplicationContext(ApplicationConfigScan.class);
		Car c3 = (Car)ac3.getBean(Car.class);
		c3.run();
	}

}
