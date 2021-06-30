package kr.or.connect.guestbook.dao;

public class GuestbookDaoSql {
	public static final String SELECT_PAGING = "SELECT * FROM (SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC) WHERE ROWNUM >= :start AND ROWNUM <= :limit";
	public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";
}
