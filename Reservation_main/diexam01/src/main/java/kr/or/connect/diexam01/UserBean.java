package kr.or.connect.diexam01;

//bean은 일종의 객체를 만드는 공장(class)
//priave로 변수를 만들기 때문에 프로퍼티로 변수 접근
public class UserBean {
	private String name;
	private int age;
	private boolean gender;
	
	public UserBean() {}
	public UserBean(String name, int age, boolean gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
}
