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
	// Ŭ���̾�Ʈ�� ������ ��û�� ������ ������ Ŭ���̾�Ʈ �� session id�� �ڵ����� �����Ѵ�.
	// Ŭ���̾�Ʈ�� id�� ��Ű�� �����Ѱ� ������ id�� Ŭ���̾�Ʈ �� session�� �����Ѵ�.
	// ��Ű�� Ŭ���̾�Ʈ, session�� ����, stateless�� ����
	// controller���� session�� ���� ������ �ʿ䰡 ����.
	// ������ request.getSession()�� �ʿ������� spring�� �ڵ����� ���ش�.
	@GetMapping("/guess")
	public String guess(@RequestParam(name = "number", required = false) Integer num,
			HttpSession session, ModelMap modelMap, RedirectAttributes redirect,
			HeaderInfo headerInfo) {
		
		System.out.println("-----------------------------------------------------");
		System.out.println(headerInfo.get("user-agent"));
		System.out.println("-----------------------------------------------------");
		
		if(session.getAttribute("login") == null) {
			redirect.addFlashAttribute("errorMsg", "�α����� �ʿ��մϴ�.");
			return "redirect:/loginform";
		}
		
		String msg = null;
		if(num==null) {
			session.setAttribute("count", 0);
			session.setAttribute("randomNum", (int)(Math.random()*100+1));
			msg = "1~100 ������ ���� �Է��� ������ ���纸����.";
		}
		else {
			int count = (int)session.getAttribute("count");
			int randomNum = (int)session.getAttribute("randomNum");
			session.setAttribute("count", ++count);
			if(randomNum>num) {
				msg = "�Է��� ���ڰ� �۽��ϴ�.";
			}
			else if(randomNum<num) {
				msg = "�Է��� ���ڰ� Ů�ϴ�.";
			}
			else {
				msg = num+", �����Դϴ�! "+count+"������ ������ϴ�.";
				session.removeAttribute("count");
				session.removeAttribute("randomNum");
			}
		}
		modelMap.addAttribute("msg",msg);
		return "guess";
	}
}
