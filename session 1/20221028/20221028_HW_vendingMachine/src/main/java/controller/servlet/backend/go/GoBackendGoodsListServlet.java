package controller.servlet.backend.go;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.page.BackendDrinkPage;
import bean.page.BackendDrinkPages;
import bean.service.DrinkService;

public class GoBackendGoodsListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		BackendDrinkPages drinkPages = (BackendDrinkPages)req.getAttribute("drinkPages");
		if(drinkPages == null)
			drinkPages = DrinkService.generateBackendDrinkPages(10, false);
		
		String pageIdStr = req.getParameter("pageId");
		int pageId = 1;
		if(pageIdStr!=null && !pageIdStr.equals("")) {
			try {
				pageId = Integer.parseInt(pageIdStr);
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
		

		req.setAttribute("drinkPage", drinkPages.getPageByPageId(pageId));
		req.setAttribute("maxPageId", drinkPages.getMaxPageId());
		req.setAttribute("isSearchPage", drinkPages.isSearchPages());
		
		
		req.getRequestDispatcher("../WEB-INF/backend/VM_Backend_GoodsList.jsp").forward(req, resp);
	}
}
