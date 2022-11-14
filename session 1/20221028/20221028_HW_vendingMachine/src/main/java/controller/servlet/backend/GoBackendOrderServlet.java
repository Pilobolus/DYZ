package controller.servlet.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.service.OrderService;

public class GoBackendOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Map<Integer, List<Order>> orderGroups = (Map<Integer, List<Order>>)req.getAttribute("orderGroups");
		if(orderGroups == null)
			orderGroups = OrderService.groupingOrder(10);
		
		String pageIdStr = req.getParameter("pageId");
		int pageId = 1;
		
		if(pageIdStr!=null && !pageIdStr.equals("")) {
			try {
				pageId = Integer.parseInt(pageIdStr);
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		List<Order> orderList = orderGroups.get(pageId - 1);
		if(orderList == null)
			orderList = new ArrayList<>();
		
		
		int maxPage = orderGroups.size();
		int baseId = (pageId-1)/3*3;
		
		
		String startDate = (String)req.getAttribute("startDate");
		String endDate = (String)req.getAttribute("endDate");
		
		req.setAttribute("orderList", orderList);
		req.setAttribute("pageId", pageId);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("baseId", baseId);
		if(startDate == null)
			req.setAttribute("startDate", "");
		if(endDate == null)
			req.setAttribute("endDate", "");
		
		
		req.getRequestDispatcher("VM_Backend_GoodsSaleReport.jsp").forward(req, resp);
	}
}
