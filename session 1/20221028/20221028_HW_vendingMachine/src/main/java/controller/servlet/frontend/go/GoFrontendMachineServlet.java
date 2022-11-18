package controller.servlet.frontend.go;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.page.FrontendDrinkPage;
import bean.page.FrontendDrinkPages;
import bean.service.DrinkService;

public class GoFrontendMachineServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		FrontendDrinkPages drinkPages = (FrontendDrinkPages)req.getAttribute("drinkPages");
		if(drinkPages == null)
			drinkPages = DrinkService.generateFrontendDrinkPages(6, false);
		
		String pageIdStr = req.getParameter("pageId");
		
		int pageId = 1;
		if(pageIdStr!=null && !pageIdStr.equals("")) {
			try {
				pageId = Integer.parseInt(pageIdStr);
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
		Boolean hasCheckout = (Boolean)req.getAttribute("hasCheckout");
		String checkoutMsg = "{}";
		int checkoutMsgNum = 0;
		if(hasCheckout!=null && hasCheckout==true) {
			checkoutMsg = (String)req.getAttribute("checkoutMsg");
			checkoutMsgNum = 3;
			if(checkoutMsg != null)
				checkoutMsgNum = (int)req.getAttribute("checkoutMsgNum");
		}
		

		req.setAttribute("drinkPage", drinkPages.getPageByPageId(pageId));
		req.setAttribute("maxPageId", drinkPages.getMaxPageId());
		req.setAttribute("isSearchPage", drinkPages.isSearchPages());
		req.setAttribute("checkoutMsg", checkoutMsg);
		req.setAttribute("checkoutMsgNum", checkoutMsgNum);
		
		
		req.getRequestDispatcher("../WEB-INF/frontend/VendingMachine.jsp").forward(req, resp);
	}
}
