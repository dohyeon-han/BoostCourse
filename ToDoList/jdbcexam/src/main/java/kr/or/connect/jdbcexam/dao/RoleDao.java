package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "c##scott";
	private static String pw = "tiger";
			
	
	
	public Role getRole(int roleId) {
		Role role = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,id,pw);
			String sql = "select * from role where role_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,roleId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String description = rs.getString(2);
				role = new Role(id,description);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		
		return role;
	}
	public List<Role> insertRole(int roleId, String d){
		List<Role> list = new ArrayList<Role>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String inSql = "insert into role values (?,?)";
		String seSql = "select * from role";
		try(Connection con = DriverManager.getConnection(url,id,pw);
			PreparedStatement pstmt1 = con.prepareStatement(inSql);
			PreparedStatement pstmt2 = con.prepareStatement(seSql);){
			
			pstmt1.setInt(1, roleId);
			pstmt1.setString(2, d);
			pstmt1.executeUpdate();
			
			System.out.println("입력되었습니다.");
			try(ResultSet rs = pstmt2.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("role_id");
					String description = rs.getString("description");
					Role role = new Role(id,description);
					list.add(role);
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
		return list;
	}
}
