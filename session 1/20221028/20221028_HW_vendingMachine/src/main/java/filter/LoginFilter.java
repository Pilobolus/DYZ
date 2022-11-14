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
		
		
		String account = httpReq.getParameter("account");
		String password = httpReq.getParameter("pwd");
		
		Customer customer = CustomerDAO.INSTANCE.getCustomerById(account);
		if(customer==null || customer.getPassword()==null) {
			httpReq.setAttribute("msg", "無此帳號");
			httpReq.getRequestDispatcher("error/login").forward(request, response);
		}else if(!customer.getPassword().equals(password)) {
			httpReq.setAttribute("msg", "密碼錯誤");
			httpReq.getRequestDispatcher("error/login").forward(request, response);
		}else {
			httpReq.getSession().setAttribute("customer_session", customer);
			chain.doFilter(request, response);
		}
		
	}
}
