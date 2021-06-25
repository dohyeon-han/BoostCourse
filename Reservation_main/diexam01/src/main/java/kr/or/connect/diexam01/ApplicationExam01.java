package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//spring context di 생성 - applicationContext.xml로 객체 생성 - 생성된 객체 가져와서 쓰기
public class ApplicationExam01 {
	public static void main(String[] args) {
		//해당 xml의 bean에 생성된 객체를 전부 메모리로 올린다
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화");
		
		UserBean userBean =  (UserBean)ac.getBean("UserBean");
		userBean.setName("김");
		System.out.println(userBean.getName());
	}
	
}
