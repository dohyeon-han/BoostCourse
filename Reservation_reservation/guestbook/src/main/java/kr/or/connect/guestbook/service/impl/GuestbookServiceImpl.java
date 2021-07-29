package kr.or.connect.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.guestbook.dao.GuestbookDao;
import kr.or.connect.guestbook.dao.LogDao;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.dto.Log;
import kr.or.connect.guestbook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;

	@Override
	@Transactional//read-only
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> list = guestbookDao.selectAll(start, LIMIT);
		return list;
	}

	@Override
	@Transactional(readOnly = false)//해당 메서드가 실패하면 메서드 자체가 rollback
	public int deleteGuestbook(int id, String ip) {
		int delete = guestbookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return delete;
	}

	@Override
	@Transactional(readOnly = false)
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		int id = guestbookDao.insert(guestbook);
		guestbook.setId(id);
	
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		return guestbook;
	}

	@Override
	@Transactional
	public int getCount() {
		return guestbookDao.selectCount();
	}
}
