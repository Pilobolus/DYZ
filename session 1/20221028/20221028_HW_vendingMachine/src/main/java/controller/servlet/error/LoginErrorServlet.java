package controller.servlet.error;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.JsonTool;

public class LoginErrorServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Map<String, Object> myRespMap = new HashMap<>();
		myRespMap.put("mystatus", "error");
		myRespMap.put("msg", (String)req.getAttribute("msg"));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().append(JsonTool.objsToJson(myRespMap));
	}
}
