package bean.service;

import java.util.ArrayList;
import java.util.List;

import bean.Order;
import bean.dao.OrderDAO;
import bean.page.OrderPage;
import bean.page.OrderPages;

public class OrderService {

	public static OrderPages generateOrderPages(List<Order> orders, int memberNum, boolean isSearchPage){
		
		List<OrderPage> orderPageList = new ArrayList<>();
		
		int size = orders.size();
		int index = 0;
		int pageId = 1;
		while(index < size) {
			List<Order> orderList = new ArrayList<>();
			
			for(int i=0; i<memberNum && index<size; i++, index++) {
				orderList.add(orders.get(index));
			}
			
			orderPageList.add(new OrderPage(orderList, pageId));
			pageId++;
		}
		return new OrderPages(orderPageList, isSearchPage);
	}
	
	public static OrderPages generateOrderPages(int memberNum, boolean isSearchPage){
		return generateOrderPages(OrderDAO.INSTANCE.getOrders(), memberNum, isSearchPage);
	}
	
	
}
