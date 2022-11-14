package bean.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Order;
import bean.dao.OrderDAO;

public class OrderService {

	public static Map<Integer, List<Order>> groupingOrder(List<Order> allOrders, int memberNum){
		Map<Integer, List<Order>> groups = new HashMap<>();
		
		int size = allOrders.size();
		int index = 0;
		int groupNum = 0;
		while(index < size) {
			List<Order> group = new ArrayList<>();
			
			for(int i=0; i<memberNum && index<size; i++, index++) {
				group.add(allOrders.get(index));
			}
			
			groups.put(groupNum++, group);
		}
		return groups;
	}
	
	public static Map<Integer, List<Order>> groupingOrder(int memberNum){
		return groupingOrder(OrderDAO.INSTANCE.getOrders(), memberNum);
	}
	
	
}
