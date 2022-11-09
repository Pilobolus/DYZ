package controller.servlet.backend;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Order;
import bean.dao.OrderDAO;
import bean.service.OrderService;


public class SearchOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String startDate = req.getParameter("queryStartDate");
		String endDate = req.getParameter("queryEndDate");
		
		String sDateTime = startDate + " 00:00:00";
		String eDateTime = endDate + " 23:59:59";
		List<Order> orderList = OrderDAO.INSTANCE.getOrderByDate(sDateTime, eDateTime);
		Map<Integer, List<Order>> orderGroups = OrderService.groupingOrder(orderList, 10);
		
		
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate", endDate);
		req.setAttribute("orderGroups", orderGroups);
		
		req.getRequestDispatcher("go_order?pageId=1").forward(req, resp);
	}
	
	
}
