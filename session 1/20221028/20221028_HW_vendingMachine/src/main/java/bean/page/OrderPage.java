package bean.page;

import java.util.List;

import bean.Order;

public class OrderPage extends Page<Order>{

	public OrderPage(List<Order> objectList, int pageId) {
		super(objectList, pageId);
	}
}
