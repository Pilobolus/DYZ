package controller.servlet.backend;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drink;
import bean.dao.DrinkDAO;
import bean.service.DrinkService;

public class SearchDrinkServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("nameKey");
		
		List<Drink> drinkList = DrinkDAO.INSTANCE.searchOnSale(key);
		Map<Integer, List<Drink>> drinkGroups = DrinkService.groupingDrinks(drinkList, 10);
		req.getSession().setAttribute("drinkGroupsBackend_session", drinkGroups);
		
		req.getRequestDispatcher("goodsList?pageId=1").forward(req, resp);
	}
}
