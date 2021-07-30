package kr.or.connect.guestbook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {
	//controller�� ���� ��� ��û�� ����ä �α׸� �����ش�.
	//controller�� ���� �޼��带 �ۼ��� �� �ִ�.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(handler.toString() + " �� ����Ǿ����ϴ�.  " + modelAndView.getViewName() + "�� view�� ����մϴ�.");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler.toString() + " �� ȣ���߽��ϴ�.");
		return true;
	}
}
