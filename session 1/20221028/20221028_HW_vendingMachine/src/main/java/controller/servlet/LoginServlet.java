package controller.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import bean.dao.CustomerDAO;
import bean.dao.DrinkDAO;
import tool.JsonTool;
import tool.ShoppingCart;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String account = req.getParameter("account");
		String password = req.getParameter("pwd");
		
		Customer customer = CustomerDAO.INSTANCE.getCustomerById(account);
		if(customer==null || customer.getPassword()==null) {
			req.setAttribute("msg", "無此帳號");
			req.getRequestDispatcher("error/login").forward(req, resp);
		}else if(!customer.getPassword().equals(password)) {
			req.setAttribute("msg", "密碼錯誤");
			req.getRequestDispatcher("error/login").forward(req, resp);
		}else {
			
			req.getSession().setAttribute("customer_session", customer);
			
			Map<String, Object> myRespMap = new HashMap<>();
			myRespMap.put("mystatus", "success");
			myRespMap.put("msg", "登入成功");
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().append(JsonTool.objsToJson(myRespMap));
		}


		
	}
}
