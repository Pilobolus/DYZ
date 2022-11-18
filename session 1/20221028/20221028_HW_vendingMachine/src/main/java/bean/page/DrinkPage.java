package bean.page;

import java.util.List;

import bean.Drink;

public abstract class DrinkPage extends Page<Drink>{
	
	public DrinkPage(List<Drink> drinkList, int pageId) {
		super(drinkList, pageId);
	}
}
