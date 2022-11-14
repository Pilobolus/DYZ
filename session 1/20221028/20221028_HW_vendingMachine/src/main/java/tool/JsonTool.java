package tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTool {

	private static StringBuilder sb = new StringBuilder();
	public static String objsToJson(Map<String, Object> objs) {
		sb.append("{");
		
		for(String key : objs.keySet()) {
			sb.append("\"");
			sb.append(key);
			sb.append("\" : \"");
			sb.append(objs.get(key).toString());
			sb.append("\", ");
		}
		if(objs.size() > 0)
			sb.delete(sb.length()-2, sb.length());
		sb.append("}");
		
		String ans = sb.toString();
		sb.delete(0, sb.length());
		return ans;
	}
	public static String jsonMerge(List<String> jsonList) {
		sb.append("{");
		
		for(String json : jsonList) {
			sb.append(json);
			sb.append(", ");
		}
		if(jsonList.size() > 0)
			sb.delete(sb.length()-2, sb.length());
		sb.append("}");
		
		String ans = sb.toString();
		sb.delete(0, sb.length());
		return ans;
	}
	
	
	
	public static String objsToArrayJson(String name, List<Object> objList) {
		sb.append("\"");
		sb.append(name);
		sb.append("\" : [");
		
		for(Object obj : objList) {
			sb.append("\"");
			sb.append(obj.toString());
			sb.append("\", ");
		}
		if(objList.size() > 0)
			sb.delete(sb.length()-2, sb.length());
		sb.append("]");
		
		String ans = sb.toString();
		sb.delete(0, sb.length());
		return ans;
	}
	
	public static Map<Integer, Integer> dealingShoppingCartJson(String json){
		json = json.substring(1, json.length()-1);
		
		Map<Integer, Integer> map = new HashMap<>();
		String[] strs = json.split(",");
		
		for(String str : strs) {
			String[] obj = str.split(":");
			int id = Integer.parseInt(obj[0].substring(obj[0].indexOf("_")+1, obj[0].length()-1));
			int num = Integer.parseInt(obj[1].substring(1, obj[1].length()-1));
			map.put(id, num);
		}

		return map;
	}
	
	
}
