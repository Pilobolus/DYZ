package controller.servlet.frontend;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import bean.dao.DrinkDAO;
import service.CheckoutService;
import tool.JsonTool;
import tool.ShoppingCart;

public class CheckoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int payMoney = Integer.parseInt(req.getParameter("inputMoney"));
		HttpSession session = req.getSession();
		
		
		Map<String, Object> msg = CheckoutService.checkout(payMoney,
				(ShoppingCart)session.getAttribute("shoppingCart_session"), 
				((Customer)session.getAttribute("customer_session")));
		
		
		req.setAttribute("checkoutMsg", JsonTool.objsToJson(msg));
		req.setAttribute("checkoutMsgNum", msg.size());
		req.setAttribute("hasCheckout", true);
		session.setAttribute("shoppingCart_session", new ShoppingCart());
		
		req.getRequestDispatcher("go_front?pageId=1").forward(req, resp);
	}
}
