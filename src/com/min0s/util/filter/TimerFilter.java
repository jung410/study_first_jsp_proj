package com.min0s.util.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// servlet의 처리 시간을 측정
// 나중에 DAO에 묶어서 실제 DB 연동 시간을 check하는 용도로 많이 쓰인다.
@WebFilter("/*")
public class TimerFilter implements Filter{
	FilterConfig fc;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		fc = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 전처리
		long start = new Date().getTime();
//		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		// 후처리
		long end = new Date().getTime();
		// ip주소 출력
		System.out.println(request.getRemoteAddr() + " :: " + (end - start) + "ms");
		// sevlet 이름 출력
		System.out.println(((HttpServletRequest)request).getRequestURI() + " :: " + (end - start) + "ms");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
