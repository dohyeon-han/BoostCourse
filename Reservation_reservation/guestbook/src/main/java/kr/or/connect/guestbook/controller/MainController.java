package kr.or.connect.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

@Controller
public class MainController {
	@Autowired
	GuestbookService guestbookService;

	@GetMapping("/list")
	public String list(@RequestParam(name = "start", required = false, defaultValue = "0") int start, ModelMap model,
			/*HttpServletRequest request*/
			@CookieValue(name="visit", required = false, defaultValue = "0") String value
			, HttpServletResponse response) {
		
//		String value = "1";
//		
//		Cookie[] cookies = request.getCookies();
//		if(cookies!=null) {
//			for(Cookie cookie : cookies) {
//				if("visit".equals(cookie.getName())) {
//					value = cookie.getValue();
//					int intValue = Integer.parseInt(value);
//					value = Integer.toString(intValue + 1);
//					break;
//				}
//			}
//		}		
		
		int intValue = Integer.parseInt(value);
		value = Integer.toString(intValue + 1);
		
		Cookie cookie = new Cookie("visit", value);
		cookie.setMaxAge(60*60*24*365);//������ Ŭ���̾�Ʈ ������� ����, �� ���� ����
		cookie.setPath("/");//��� ���� ��ο� ����
		response.addCookie(cookie);
		
		List<Guestbook> list = guestbookService.getGuestbooks(start);

		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if (count % GuestbookService.LIMIT > 0)
			pageCount++;


		List<Integer> pageStartList = new ArrayList<>();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}

		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("visit", value);
		return "list";
	}

	@PostMapping(path = "/write")
	public String write(@ModelAttribute Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
}
