package controller.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dao.DrinkDAO;
import tool.JsonTool;
import tool.ShoppingCart;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, Object> myRespMap = new HashMap<>();
		myRespMap.put("mystatus", "success");
		myRespMap.put("msg", "登入成功");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().append(JsonTool.objsToJson(myRespMap));
	}
}
