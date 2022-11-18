package bean.page;

import java.util.ArrayList;
import java.util.List;

import bean.Drink;
import bean.service.DrinkService;

public class FrontendDrinkPage extends DrinkPage {

	private List<Drink> drink1List;
	private List<Drink> drink2List;
	private String drink1IdListJson;
	private String drink2IdListJson;
	private String drink1NameListJson;
	private String drink2NameListJson;
	private int drink1ListCount;
	private int drink2ListCount;
	
	

	public FrontendDrinkPage(List<Drink> drinkList, int pageId) {
		super(drinkList, pageId);
		this.drink1List = generateDrink1List(drinkList);
		this.drink2List = generateDrink2List(drinkList);
		this.drink1IdListJson = DrinkService.toIdsJson(drink1List);
		this.drink2IdListJson = DrinkService.toIdsJson(drink2List);
		this.drink1NameListJson = DrinkService.toNamesJson(drink1List);
		this.drink2NameListJson = DrinkService.toNamesJson(drink2List);
		this.drink1ListCount = drink1List.size();
		this.drink2ListCount = drink2List.size();
	}
	private List<Drink> generateDrink1List(List<Drink> drinkList){
		List<Drink> list = new ArrayList<>();
		for(int i=1; i<=3 && i<=this.getPageDrinkCount(); i++) {
			list.add(drinkList.get(i-1));
		}
		return list;
	}
	private List<Drink> generateDrink2List(List<Drink> drinkList){
		List<Drink> list = new ArrayList<>();
		for(int i=4; i<=6 && i<=this.getPageDrinkCount(); i++) {
			list.add(drinkList.get(i-1));
		}
		return list;
	}
	
	
	
	public List<Drink> getDrink1List() {
		return drink1List;
	}
	public List<Drink> getDrink2List() {
		return drink2List;
	}
	public String getDrink1IdListJson() {
		return drink1IdListJson;
	}
	public String getDrink2IdListJson() {
		return drink2IdListJson;
	}
	public String getDrink1NameListJson() {
		return drink1NameListJson;
	}
	public String getDrink2NameListJson() {
		return drink2NameListJson;
	}

	public int getDrink1ListCount() {
		return drink1ListCount;
	}
	
	public int getDrink2ListCount() {
		return drink2ListCount;
	}
	
	
	@Override
	public String toString() {
		return "FrontendDrinkPage [drink1List=" + drink1List + ", drink2List=" + drink2List + ", getPageId()="
				+ getPageId() + "]";
	}

}
