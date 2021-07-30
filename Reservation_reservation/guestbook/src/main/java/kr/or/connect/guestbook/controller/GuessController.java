package kr.or.connect.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.connect.guestbook.argumentresolver.HeaderInfo;

@Controller
public class GuessController {
	// 클라이언트가 서버로 요청을 보내면 서버는 클라이언트 별 session id를 자동으로 생성한다.
	// 클라이언트는 id를 쿠키로 저장한고 서버는 id로 클라이언트 별 session을 구분한다.
	// 쿠키는 클라이언트, session은 서버, stateless를 보완
	// controller에서 session을 따로 생성할 필요가 없다.
	// 원래는 request.getSession()이 필요하지만 spring은 자동으로 해준다.
	@GetMapping("/guess")
	public String guess(@RequestParam(name = "number", required = false) Integer num,
			HttpSession session, ModelMap modelMap, RedirectAttributes redirect,
			HeaderInfo headerInfo) {
		
		System.out.println("-----------------------------------------------------");
		System.out.println(headerInfo.get("user-agent"));
		System.out.println("-----------------------------------------------------");
		
		if(session.getAttribute("login") == null) {
			redirect.addFlashAttribute("errorMsg", "로그인이 필요합니다.");
			return "redirect:/loginform";
		}
		
		String msg = null;
		if(num==null) {
			session.setAttribute("count", 0);
			session.setAttribute("randomNum", (int)(Math.random()*100+1));
			msg = "1~100 사이의 수를 입력해 정답을 맞춰보세요.";
		}
		else {
			int count = (int)session.getAttribute("count");
			int randomNum = (int)session.getAttribute("randomNum");
			session.setAttribute("count", ++count);
			if(randomNum>num) {
				msg = "입력한 숫자가 작습니다.";
			}
			else if(randomNum<num) {
				msg = "입력한 숫자가 큽니다.";
			}
			else {
				msg = num+", 정답입니다! "+count+"번만에 맞췄습니다.";
				session.removeAttribute("count");
				session.removeAttribute("randomNum");
			}
		}
		modelMap.addAttribute("msg",msg);
		return "guess";
	}
}
