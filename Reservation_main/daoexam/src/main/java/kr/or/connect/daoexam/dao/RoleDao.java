package kr.or.connect.daoexam.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;
import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;

@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;//binding시 문자열로 맵핑, 기존의 ? 대신 :~~를 통해 바인딩
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
	//@ComponentScan을 통해 사용시 명시하지 않아도 자동으로 dataSource 입력됨
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(Role role) {
		//role의 값을 map 객체로 바꿔줌 
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		//객체를 DB에 insert
		return insertAction.execute(params);
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	
	public int delete(String roleId) {
//		Role role = new Role();
//		role.setRoleId(roleId);
//		role.setDescription("");
//		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		
		Map<String, ?> params = Collections.singletonMap("roleId", roleId); //role객체->map 말고, 바로 map을 만들어 사용가 능
		return jdbc.update(DELETE, params);
	}
	
	public Role select(String roleId) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", roleId);
			return jdbc.queryForObject(SELECT, params, rowMapper);//1건만 select
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("오류");
			return null;
		}
		
	}
}
