package controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.ShoppingCart;

public class NavServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String destination = req.getParameter("destination");
		

		if(destination.equals("goods_list")) {
			resp.sendRedirect("backend/goodsList?pageId=1");
		}else if(destination.equals("create"))
			resp.sendRedirect("backend/create");
		else if(destination.equals("modify"))
			resp.sendRedirect("backend/modify");
		else if(destination.equals("order"))
			resp.sendRedirect("backend/ordersList?pageId=1");
		else if(destination.equals("frontend")) {
			req.getSession().setAttribute("shoppingCart_session", new ShoppingCart());
			resp.sendRedirect("frontend/vending_machine?pageId=1");
		}
	}
}
