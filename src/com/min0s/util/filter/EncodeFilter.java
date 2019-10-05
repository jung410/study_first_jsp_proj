package com.min0s.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodeFilter implements Filter{
	// <Filter>
	String encode;
	FilterConfig fc;
	
	// 객체 생성시 단 한번만 할 내용
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		fc = filterConfig;
		encode = "utf-8";
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 아래와 같이 해놓으면 모든 servlet에 적용된다.
		request.setCharacterEncoding(encode);
		/*response.setContentType("text/html; charset=" + encode);*/
		// 여기 있는건 전처리
		chain.doFilter(request, response);	// 얘를 기준으로
		// 여기 있는건 후처리
	}
	
	// 객체 자원 해제
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		encode = null;
		fc = null;
	}
	
}
