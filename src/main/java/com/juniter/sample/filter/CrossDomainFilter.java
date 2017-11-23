package com.juniter.sample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossDomainFilter implements Filter {
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
		//HttpServletResponse res = (HttpServletResponse) response;
		//HttpServletRequest req = (HttpServletRequest) request;
		//res.addHeader("Access-Control-Allow-Origin", "*");
		//res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		//res.addHeader("Access-Control-Allow-Headers", "Content-Type");
		//res.setCharacterEncoding("UTF-8");
		//req.setCharacterEncoding("UTF-8");
		//res.setHeader("Content-Type", "application/json;charset=UTF-8");
		filter.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
