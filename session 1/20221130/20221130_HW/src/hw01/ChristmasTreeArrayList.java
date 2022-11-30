package hw01;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTreeArrayList {

	
	public static List<List<String>> create(int number){
		
		List<List<String>> tree = new ArrayList<>();
		
		for(int i=1; i<=number; i++) {
			List<String> list = new ArrayList<>();
			for(int j=0; j<(number-i); j++) {
				list.add("X");
			}
			for(int j=0; j<(2*i-1); j++) {
				list.add("O");
			}
			
			tree.add(list);
		}
		
		return tree;
	}
}
