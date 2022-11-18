package bean.page;

import java.util.List;

import bean.Drink;

public abstract class DrinkPages <T extends DrinkPage> extends Pages<T, Drink> {

	public DrinkPages(List<T> pageList, boolean isSearchPages) {
		super(pageList, isSearchPages);
	}
	
}
