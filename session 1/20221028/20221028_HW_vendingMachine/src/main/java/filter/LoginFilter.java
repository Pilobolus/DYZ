package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Customer;
import bean.dao.CustomerDAO;
import tool.ShoppingCart;


public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpResp = (HttpServletResponse)response;
		String url  = httpReq.getServletPath();
		

		if(url.startsWith("/frontend/") || url.startsWith("/backend/") || url.startsWith("/WEB-INF/") || url.equals("/nav")) {
			if(httpReq.getSession().getAttribute("customer_session") != null)
				chain.doFilter(request, response);
			else
				httpResp.sendRedirect(httpReq.getContextPath() + "/web_error.html");
		}else {
			chain.doFilter(request, response);
		}

	}
}
