package controller.servlet.backend;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drink;
import bean.dao.DrinkDAO;
import bean.page.BackendDrinkPage;
import bean.page.BackendDrinkPages;
import bean.service.DrinkService;

public class SearchDrinkServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("nameKey");
		
		List<Drink> drinkList = DrinkDAO.INSTANCE.search(key);
		BackendDrinkPages drinkPages = DrinkService.generateBackendDrinkPages(drinkList, 10, true);

		req.setAttribute("drinkPages", drinkPages);
		
		req.getRequestDispatcher("goodsList").forward(req, resp);
	}
}
