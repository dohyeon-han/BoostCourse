package kr.or.connect.daoexam.dao;

public class RoleDaoSqls {
	public static final String SELECT_ALL = "select * from role";
	public static final String UPDATE = "update role set description = :description where role_id = :roleId";
	public static final String SELECT = "select * from role where role_id = :roleId";
	public static final String DELETE = "delete from role where role_id = :roleId";
}
