package controller.servlet.backend.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drink;
import bean.dao.DrinkDAO;
import bean.service.DrinkService;


public class ModifyChangeGoodsServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String drinkIdStr = req.getParameter("drinkId");
		
		try {
			Drink currentDrink  = DrinkDAO.INSTANCE.getDrinkById(Integer.parseInt(drinkIdStr));
			
			String jsonStr = DrinkService.getJson(currentDrink);
			resp.getWriter().append(jsonStr);
		}catch(NumberFormatException ex) {
			System.out.println(ex);
		}
		
	}
}
