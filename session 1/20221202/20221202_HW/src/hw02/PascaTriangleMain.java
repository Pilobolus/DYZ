package hw02;

import java.util.List;

public class PascaTriangleMain {

	public static void main(String[] args) {
		List<List<Integer>> triangle = PascaTriangle.create(8);
		
		for(int i=0; i<triangle.size(); i++) {
			for(int j=0; j<triangle.get(i).size(); j++) {
				System.out.print(triangle.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

}
