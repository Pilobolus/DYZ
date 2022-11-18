package controller.servlet.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drink;
import bean.dao.DrinkDAO;
import bean.page.FrontendDrinkPage;
import bean.page.FrontendDrinkPages;
import bean.service.DrinkService;

public class SearchDrinksServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("searchKeyword");

		List<Drink>	drinkList = DrinkDAO.INSTANCE.searchOnSale(keyword);


		req.setAttribute("drinkPages", DrinkService.generateFrontendDrinkPages(drinkList, 6, true));
		
		
		req.getRequestDispatcher("vending_machine").forward(req, resp);
	}
}
