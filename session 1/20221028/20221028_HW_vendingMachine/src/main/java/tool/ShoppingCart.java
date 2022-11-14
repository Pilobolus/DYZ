package tool;

import java.util.HashMap;
import java.util.Map;

import bean.Drink;
import bean.dao.DrinkDAO;

public class ShoppingCart {
	private Map<Drink, Integer> cart;
	
	public ShoppingCart() {
		cart = new HashMap<>();
		
		for(Drink drink : DrinkDAO.INSTANCE.getDrinks()) {
			cart.put(drink, 0);
		}
	}
	
	public void setDrinkNumber(int drinkId, int number) {
		cart.put(DrinkDAO.INSTANCE.getDrinkById(drinkId), number);
	}
	public int getDrinkNumber(Drink drink) {
		return cart.get(drink);
	}
}
