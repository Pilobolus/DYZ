package hw02;

import java.util.ArrayList;
import java.util.List;

public class PascaTriangle {

	public static List<List<Integer>> create(int layer){
		
		List<List<Integer>> triangle = new ArrayList<>();
		
		for(int i=1; i<=layer; i++) {
			List<Integer> list = new ArrayList<>();
			
			if(i == 1) {
				list.add(1);
			}else {
				for(int j=1; j<=i; j++) {
					if(j==1 || j==i) {
						list.add(1);
					}else {
						list.add(triangle.get(i-2).get(j-2)+triangle.get(i-2).get(j-1));
					}
				}
			}
			
			
			triangle.add(list);
		}
		
		return triangle;
	}
}
