package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bean.dao.DrinkDAO;
import bean.service.DrinkService;
import tool.DBTool;

@WebListener
public class ContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		

		sce.getServletContext().setAttribute("imageDir_context", System.getProperty("catalina.base") + "\\..\\..\\..\\..\\20221028_HW_vendingMachine\\src\\main\\webapp\\drinks_image");
	}

	
}
