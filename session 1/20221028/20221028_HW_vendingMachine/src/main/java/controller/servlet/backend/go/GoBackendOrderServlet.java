package controller.servlet.backend.go;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.page.OrderPages;
import bean.service.OrderService;

public class GoBackendOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		OrderPages orderPages = (OrderPages)req.getAttribute("orderPages");
		if(orderPages == null)
			orderPages = OrderService.generateOrderPages(10, false);
		
		
		String pageIdStr = req.getParameter("pageId");
		int pageId = 1;
		if(pageIdStr!=null && !pageIdStr.equals("")) {
			try {
				pageId = Integer.parseInt(pageIdStr);
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
		req.setAttribute("orderPage", orderPages.getPageByPageId(pageId));
		req.setAttribute("maxPageId", orderPages.getMaxPageId());
		req.setAttribute("isSearchPage", orderPages.isSearchPages());

		req.getRequestDispatcher("../WEB-INF/backend/VM_Backend_GoodsSaleReport.jsp").forward(req, resp);
	}
}
