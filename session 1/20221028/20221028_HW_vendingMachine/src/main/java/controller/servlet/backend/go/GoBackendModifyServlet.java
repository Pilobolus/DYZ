package controller.servlet.backend.go;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drink;
import bean.dao.DrinkDAO;

public class GoBackendModifyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Drink> allDrinksList = DrinkDAO.INSTANCE.getDrinks();
		boolean hasDrinks = allDrinksList.size() > 0;
		int drink1Price = 0;
		int drink1Quantity = 0;
		
		if(hasDrinks) {
			drink1Price = allDrinksList.get(0).getPrice();
			drink1Quantity = allDrinksList.get(0).getQuantity();
		}
		
		req.setAttribute("allDrinksList", allDrinksList);
		req.setAttribute("hasDrinks", hasDrinks);
		req.setAttribute("drink1Price", drink1Price);
		req.setAttribute("drink1Quantity", drink1Quantity);
		
		req.getRequestDispatcher("../WEB-INF/backend/VM_Backend_GoodsReplenishment.jsp").forward(req, resp);
	}
}
