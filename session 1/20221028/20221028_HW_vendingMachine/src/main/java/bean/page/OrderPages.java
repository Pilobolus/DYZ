package bean.page;

import java.util.List;

import bean.Order;


public class OrderPages extends Pages<OrderPage, Order> {

	public OrderPages(List<OrderPage> pageList, boolean isSearchPages) {
		super(pageList, isSearchPages);
	}
	
	
}
