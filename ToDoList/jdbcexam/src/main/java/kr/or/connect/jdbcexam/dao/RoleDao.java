package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
}
