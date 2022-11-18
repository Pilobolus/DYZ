package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Customer;
import bean.Drink;
import bean.Order;
import bean.dao.DrinkDAO;
import bean.dao.OrderDAO;
import tool.MyDateTimeTool;
import tool.ShoppingCart;

public class CheckoutService {

	public static Map<String, Object> checkout(int payMoney, ShoppingCart cart, Customer customer) {
		
		List<Drink> allDrinks = DrinkDAO.INSTANCE.getDrinks();
		
		
		int total = 0;
		for(Drink drink : allDrinks) {
			total += drink.getPrice() * cart.getDrinkNumber(drink);
		}
		
		Map<String, Object> msg = new HashMap<>();
		
		
		msg.put("msg_0", "投入金額：" + payMoney);
		msg.put("msg_1", "購買金額：" + total);
		
		int payback = payMoney-total;
		if(payback < 0) {
			msg.put("msg_2", "找零金額：" + payMoney);
			return msg;
		}
		
		
		total = changeDrinkQuantity(cart, allDrinks);
		payback = payMoney - total;
		
		
		addOrders(cart, customer, allDrinks);
		
		msg.put("msg_2", "找零金額：" + payback);
		String formatStr = "%s %d * %d";
		int count = 3;
		for(Drink drink : allDrinks) {
			if(cart.getDrinkNumber(drink) > 0) {
				msg.put("msg_" + count, 
						String.format(formatStr, drink.getName(), drink.getPrice(), cart.getDrinkNumber(drink)));
				count++;
				DrinkDAO.INSTANCE.update(drink);
			}
		}
		
		return msg;
	}
	
	private static int changeDrinkQuantity(ShoppingCart cart, List<Drink> allDrinks) {
		int total = 0;
		
		for(Drink drink : allDrinks) {
			if(cart.getDrinkNumber(drink) > 0) {
				int q = drink.getQuantity() - cart.getDrinkNumber(drink);
				
				if(q < 0) {
					cart.setDrinkNumber(drink.getId(), drink.getQuantity());
					q = 0;
				}
				
				total += (drink.getQuantity()-q) * drink.getPrice();
				drink.setQuantity(q);
			}
		}
		return total;
	}
	
	private static void addOrders(ShoppingCart cart, Customer customer, List<Drink> allDrinks) {
		for(Drink drink : allDrinks) {
			if(cart.getDrinkNumber(drink) > 0) {
				Order order = new Order();
				order.setDate(MyDateTimeTool.now());
				order.setCustomerId(customer.getId());
				order.setGoodsId(drink.getId());
				order.setGoodsBuyPrice(drink.getPrice());
				order.setBuyQuantity(cart.getDrinkNumber(drink));
				
				OrderDAO.INSTANCE.addOrder(order);
			}
		}
	}
}
