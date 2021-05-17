package kr.or.connect.jdbcexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		RoleDao dao = new RoleDao();
		List<Role> list = new ArrayList<Role>();
		
		System.out.println("ID : ");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Description : ");
		String description = br.readLine();
		
		list = dao.insertRole(id, description);
		
		for(Role r : list) {
			System.out.println("id : " + r.getRoleId()+", Description : "+ r.getDescription());
		}
	}

}
