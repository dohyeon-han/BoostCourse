package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class HomeController {
	@GetMapping("/plusform")
	public String plusform() {
		//view이름만 넘기면 된다
		///WEB-INF/views/plusForm.jsp로 변경된다 
		return "plusForm";
	}
	
	@PostMapping("/plus")
	public String plus(@RequestParam(name="value1", required=true) int value1,
			@RequestParam(name="value2", required=true) int value2, ModelMap modelMap) {
		int rst = value1 + value2;
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", rst);
		return "plusResult";
	}

	@RequestMapping(path = "/userform", method = RequestMethod.GET )
	public String userForm() {
		return "userForm";
	}
	//spring이 알아서 setter를 통해 넣는다
	@RequestMapping(path = "/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute User user) {
		System.out.println(user);
		return "regist";
	}
}
