package bean.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import bean.Drink;
import bean.dao.DrinkDAO;
import bean.page.BackendDrinkPage;
import bean.page.BackendDrinkPages;
import bean.page.DrinkPage;
import bean.page.DrinkPages;
import bean.page.FrontendDrinkPage;
import bean.page.FrontendDrinkPages;
import tool.JsonTool;

public class DrinkService {

	public static String getJson(Drink drink) {
		String formatStr = "{"
				+ "\"id\" : \"%d\", "
				+ "\"name\" : \"%s\", "
				+ "\"description\" : \"%s\", "
				+ "\"price\" : \"%d\", "
				+ "\"quantity\" : \"%d\", "
				+ "\"image\" : \"%s\", "
				+ "\"status\" : \"%s\""
				+ "}";
		
		String json = String.format(formatStr, 
				drink.getId(), 
				drink.getName(), 
				drink.getDescription(), 
				drink.getPrice(), 
				drink.getQuantity(), 
				drink.getImage(), 
				drink.getStatus());
		return json;
	}
	
	

	public static String toIdsJson(List<Drink> drinkList) {
		List<Object> drinkIdList = new ArrayList<>();
		for(int i=0; i<drinkList.size(); i++) {
			drinkIdList.add(drinkList.get(i).getId());
		}
		
		List<String> drinkIdJsonStr = new ArrayList<>();
		drinkIdJsonStr.add(JsonTool.objsToArrayJson("ids", drinkIdList));
		
		return JsonTool.jsonMerge(drinkIdJsonStr);
	}
	
	public static String toNamesJson(List<Drink> drinkList) {
		List<Object> drinkIdList = new ArrayList<>();
		for(int i=0; i<drinkList.size(); i++) {
			drinkIdList.add(drinkList.get(i).getName());
		}
		
		List<String> drinkIdJsonStr = new ArrayList<>();
		drinkIdJsonStr.add(JsonTool.objsToArrayJson("names", drinkIdList));
		
		return JsonTool.jsonMerge(drinkIdJsonStr);
	}
	
	
	public static <T extends DrinkPage, S extends DrinkPages<T>> S generateDrinkPages(List<Drink> drinks, int memberNum, boolean isSearchPage, BiFunction<List<Drink>, Integer, T> drinkPageGenerator, BiFunction<List<T>, Boolean, S> drinkPagesGenerator){
		List<T> drinkPageList = new ArrayList<>();
		
		int drinkNum = drinks.size();
		int index = 0;
		int pageId = 1;
		
		while(index < drinkNum) {
			List<Drink> drinkList = new ArrayList<>();
			
			for(int i=0; i<memberNum && index<drinkNum; i++, index++) {
				drinkList.add(drinks.get(index));
			}
			
			drinkPageList.add(drinkPageGenerator.apply(drinkList, pageId));
			pageId++;
		}
		
		return drinkPagesGenerator.apply(drinkPageList, isSearchPage);
	}
	public static <T extends DrinkPage, S extends DrinkPages<T>> S generateDrinkPages(int memberNum, boolean isSearchPage, BiFunction<List<Drink>, Integer, T> drinkPageGenerator, BiFunction<List<T>, Boolean, S> drinkPagesGenerator){
		return generateDrinkPages(DrinkDAO.INSTANCE.getDrinks(), memberNum, isSearchPage, drinkPageGenerator, drinkPagesGenerator);
	}
	
	
	public static BackendDrinkPages generateBackendDrinkPages(List<Drink> drinks, int memberNum, boolean isSearchPage) {
		return generateDrinkPages(drinks, memberNum, isSearchPage, BackendDrinkPage::new, BackendDrinkPages::new);
	}
	public static BackendDrinkPages generateBackendDrinkPages(int memberNum, boolean isSearchPage) {
		return generateDrinkPages(memberNum, isSearchPage, BackendDrinkPage::new, BackendDrinkPages::new);
	}
	public static FrontendDrinkPages generateFrontendDrinkPages(List<Drink> drinks, int memberNum, boolean isSearchPage) {
		return generateDrinkPages(drinks, memberNum, isSearchPage, FrontendDrinkPage::new, FrontendDrinkPages::new);
	}
	public static FrontendDrinkPages generateFrontendDrinkPages(int memberNum, boolean isSearchPage) {
		return generateDrinkPages(memberNum, isSearchPage, FrontendDrinkPage::new, FrontendDrinkPages::new);
	}

}
