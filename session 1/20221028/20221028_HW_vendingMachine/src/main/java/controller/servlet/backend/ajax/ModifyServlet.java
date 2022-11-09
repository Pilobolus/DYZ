package controller.servlet.backend.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Drink;
import bean.dao.DrinkDAO;

public class ModifyServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("goodsID");
		String modiPriceStr = req.getParameter("goodsPrice");
		String modiQuantityStr = req.getParameter("goodsQuantity");
		String status = req.getParameter("status");
		
		try {
			int id = Integer.parseInt(idStr);
			int modiPrice = Integer.parseInt(modiPriceStr);
			int modiQuantity = Integer.parseInt(modiQuantityStr);
			DrinkDAO.INSTANCE.update(
					id,
					modiPrice, 
					modiQuantity+DrinkDAO.INSTANCE.getDrinkById(id).getQuantity(),
					status);
		}catch(NumberFormatException ex) {
			ex.printStackTrace();
		}
		
	}
}
