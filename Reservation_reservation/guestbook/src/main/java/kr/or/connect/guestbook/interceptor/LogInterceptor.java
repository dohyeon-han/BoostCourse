package kr.or.connect.guestbook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {
	//controller로 가는 모든 요청을 가로채 로그를 보여준다.
	//controller의 공통 메서드를 작성할 수 있다.
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("{} 가종료되었습니다. {} 를 view로 사용합니다.", handler.toString(), modelAndView.getViewName());
		//System.out.println(handler.toString() + " 가 종료되었습니다.  " + modelAndView.getViewName() + "을 view로 사용합니다.");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("{} 를 호출했습니다.", handler.toString());
		//System.out.println(handler.toString() + " 를 호출했습니다.");
		return true;
	}
}
