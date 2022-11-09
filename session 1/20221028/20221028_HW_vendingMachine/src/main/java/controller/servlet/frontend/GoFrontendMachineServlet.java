package controller.servlet.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drink;
import bean.dao.DrinkDAO;
import bean.service.DrinkService;
import tool.JsonTool;
import tool.ShoppingCart;

public class GoFrontendMachineServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Map<Integer, List<Drink>> drinkGroups = (Map<Integer, List<Drink>>)req.getSession().getAttribute("drinkGroups_session");
		String resetDrinks = req.getParameter("resetDrinks");
		if(resetDrinks!=null && resetDrinks.equals("true")) {
			req.getSession().removeAttribute("drinkGroups_session");
			drinkGroups = DrinkService.groupingDrinks(DrinkDAO.INSTANCE.getDrinkOnSale(), 3);
		}
		if(drinkGroups == null)
			drinkGroups = DrinkService.groupingDrinks(DrinkDAO.INSTANCE.getDrinkOnSale(), 3);
		
		String pageIdStr = req.getParameter("pageId");
		int pageId = 1;
		
		if(pageIdStr!=null || !pageIdStr.equals("")) {
			try {
				pageId = Integer.parseInt(pageIdStr);
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
		int basePageId = (pageId-1)/3*3;
		int maxPage = (drinkGroups.size()+1)/2;
		
		List<Drink> drink1List = null;
		List<Drink> drink2List = null;
		int pageDrinkCount = 0;
		if((pageId*2-2) < drinkGroups.size()) {
			drink1List = drinkGroups.get(pageId*2-2);
			pageDrinkCount += drink1List.size();
		}
		if((pageId*2-1) < drinkGroups.size()) {
			drink2List = drinkGroups.get(pageId*2-1);
			pageDrinkCount += drink2List.size();
		}
		
		if(drink1List == null)
			drink1List = new ArrayList<>();
		if(drink2List == null)
			drink2List = new ArrayList<>();
		
		
		String drink1IdListJson = DrinkService.toIdsJson(drink1List);
		String drink2IdListJson = DrinkService.toIdsJson(drink2List);
		String drink1NameListJson = DrinkService.toNamesJson(drink1List);
		String drink2NameListJson = DrinkService.toNamesJson(drink2List);
		
		
		Boolean hasCheckout = (Boolean)req.getAttribute("hasCheckout");
		String checkoutMsg = "{}";
		int checkoutMsgNum = 0;
		if(hasCheckout!=null && hasCheckout==true) {
			checkoutMsg = (String)req.getAttribute("checkoutMsg");
			checkoutMsgNum = 3;
			if(checkoutMsg != null)
				checkoutMsgNum = (int)req.getAttribute("checkoutMsgNum");
		}
		
		
		req.setAttribute("pageId", pageId);
		req.setAttribute("basePageId", basePageId);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("drink1List", drink1List);
		req.setAttribute("drink2List", drink2List);
		req.setAttribute("drink1IdListJson", drink1IdListJson);
		req.setAttribute("drink2IdListJson", drink2IdListJson);
		req.setAttribute("drink1NameListJson", drink1NameListJson);
		req.setAttribute("drink2NameListJson", drink2NameListJson);
		req.setAttribute("pageDrinkCount", pageDrinkCount);
		req.setAttribute("checkoutMsg", checkoutMsg);
		req.setAttribute("checkoutMsgNum", checkoutMsgNum);
		
		
		req.getRequestDispatcher("VendingMachine.jsp").forward(req, resp);
	}
}
