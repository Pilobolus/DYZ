package hw01;

import java.util.List;

public class ChristmasTreeArrayListMain {

	public static void main(String[] args) {
		List<List<String>> tree = ChristmasTreeArrayList.create(7);
		
		for(int i=0; i<tree.size(); i++) {
			List<String> list = tree.get(i);
			for(int j=0; j<list.size(); j++) {
				System.out.print(list.get(j));
			}
			System.out.println();
		}

	}

}
