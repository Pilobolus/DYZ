package controller.servlet.backend.ajax;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.Drink;
import bean.dao.DrinkDAO;
import tool.ImageTool;
import tool.ShoppingCart;

@MultipartConfig
public class CreateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("goodsName");
		String priceStr = req.getParameter("goodsPrice");
		String quantityStr = req.getParameter("goodsQuantity");
		Part image = req.getPart("goodsImage");
		String imageName =  image.getSubmittedFileName();
		String status = req.getParameter("status");
		
		
		try {
			Drink drink = new Drink();
			drink.setName(name);
			drink.setDescription("new drink");
			drink.setPrice(Integer.parseInt(priceStr));
			drink.setQuantity(Integer.parseInt(quantityStr));
			drink.setImage(imageName);
			drink.setStatus(status);
			
			
			int id = DrinkDAO.INSTANCE.addDrink(drink);
			ImageTool.uploadImage(image, (String)req.getServletContext().getAttribute("imageDir_context"), imageName);
			
			req.getSession().setAttribute("shoppingCart_session", new ShoppingCart());
			resp.getWriter().append(String.format("{\"id\" : %d}", id));
		}catch(NumberFormatException ex) {
			ex.printStackTrace();
		}

	}
}
