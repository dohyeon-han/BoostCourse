package kr.or.connect.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginAdminController {
	@GetMapping("/loginform")
	public String loginform(HttpSession session) {
		if(session.getAttribute("login")==null) return "loginform";
		return "redirect:/guess";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(name="password", required = false) String password,
			HttpSession session,
			RedirectAttributes redirect) {
		if("1234".equals(password)) {
			session.setAttribute("login", true);
			return "redirect:/guess";
		}
		else {
			//errorMsg�� �ѹ��� �ʿ��ϱ� ������ redirect
			redirect.addFlashAttribute("errorMsg", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			return "redirect:/loginform";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/loginform";
	}
}
