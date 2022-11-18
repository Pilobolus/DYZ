package controller.servlet.backend;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.dao.OrderDAO;
import bean.page.OrderPages;
import bean.service.OrderService;


public class SearchOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sDateTime = req.getParameter("queryStartDate") + " 00:00:00";
		String eDateTime = req.getParameter("queryEndDate") + " 23:59:59";
		
		List<Order> orderList = OrderDAO.INSTANCE.getOrderByDate(sDateTime, eDateTime);
		OrderPages orderPages = OrderService.generateOrderPages(orderList, 10, true);
		
		req.setAttribute("orderPages", orderPages);
		
		req.getRequestDispatcher("ordersList").forward(req, resp);
	}
	
	
}
