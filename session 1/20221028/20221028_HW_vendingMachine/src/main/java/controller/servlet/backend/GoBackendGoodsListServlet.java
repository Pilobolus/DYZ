package controller.servlet.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drink;
import bean.service.DrinkService;

public class GoBackendGoodsListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<Integer, List<Drink>> drinkGroups = (Map<Integer, List<Drink>>)req.getSession().getAttribute("drinkGroupsBackend_session");
		
		if(drinkGroups == null)
			drinkGroups = DrinkService.groupingDrinks(10);
		
		int groupSize = drinkGroups.size();
		
		String pageIdStr = req.getParameter("pageId");
		int pageId = 1;
		if(pageIdStr!=null && !pageIdStr.equals(""))
			try {
				pageId = Integer.parseInt(pageIdStr);
			}catch(NumberFormatException ex) {
				ex.printStackTrace();
			}
		List<Drink> drinkList = drinkGroups.get(pageId-1);
		if(drinkList == null)
			drinkList = new ArrayList<>();
		
		int basePage = (pageId-1)/3*3;
		
		
		
		req.setAttribute("groupSize", groupSize);
		req.setAttribute("pageId", pageId);
		req.setAttribute("drinkList", drinkList);
		req.setAttribute("basePage", basePage);
		
		req.getRequestDispatcher("VM_Backend_GoodsList.jsp").forward(req, resp);
	}
}
