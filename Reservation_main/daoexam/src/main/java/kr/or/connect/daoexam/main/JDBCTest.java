package kr.or.connect.daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JDBCTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
				
		
		//bean으로 등록된 RoleDao 사용
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		//insert할 role 객체
		Role r = new Role();
		r.setRoleId("111");
		r.setDescription("OOO");

		//roleDao.insert(r);
		//roleDao.update(r);
		//roleDao.delete("111");
		System.out.println(roleDao.select("123"));
		
		List<Role> list = roleDao.selectAll();
		
		for (Role role : list) {
			System.out.println(role);
		}
	}

}
