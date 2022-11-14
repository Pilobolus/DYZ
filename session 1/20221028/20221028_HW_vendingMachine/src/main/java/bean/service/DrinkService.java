package bean.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Drink;
import bean.dao.DrinkDAO;
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
	
	public static Map<Integer, List<Drink>> groupingDrinks(List<Drink> drinks, int memberNum){
		Map<Integer, List<Drink>> groups = new HashMap<>();
		
		int drinkNum = drinks.size();
		int index = 0;
		int groupIndex = 0;
		
		while(index < drinkNum) {
			List<Drink> group = new ArrayList<>();
			
			for(int i=0; i<memberNum && index<drinkNum; i++, index++) {
				group.add(drinks.get(index));
			}
			groups.put(groupIndex, group);
			groupIndex++;
		}
		
		return groups;
	}
	public static Map<Integer, List<Drink>> groupingDrinks(int memberNum){
		return groupingDrinks(DrinkDAO.INSTANCE.getDrinks(), memberNum);
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
}
