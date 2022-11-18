package controller.servlet.frontend.ajax;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JsonTool;
import tool.RequestInputStreamReader;
import tool.ShoppingCart;

public class ShoppingCartServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = RequestInputStreamReader.readInputStream(req);
		Map<Integer, Integer> map = JsonTool.dealingShoppingCartJson(json);
		
		ShoppingCart cart = (ShoppingCart)req.getSession().getAttribute("shoppingCart_session");
		
		for(int id : map.keySet()) {
			cart.setDrinkNumber(id, map.get(id));
		}
	}
}
