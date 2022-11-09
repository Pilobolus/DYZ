package hw01;

public class MirrorMain {

	public static void main(String[] args) {
		
		String [][] array = new String[][]{
		{"O","O","O","O","O","O","O","O","O","O"},
		{"O","X","X","X","X","O","O","O","O","O"},
		{"O","X","O","O","O","O","O","O","O","O"},
		{"O","X","O","O","O","O","O","O","O","O"},
		{"O","X","O","O","O","O","O","O","O","O"},
		{"O","X","O","O","O","O","O","O","O","O"},
		{"O","X","O","O","O","O","O","O","O","O"},
		{"O","X","O","O","O","O","O","O","O","O"},
		{"O","X","X","X","X","O","O","O","O","O"},
		{"O","O","O","O","O","O","O","O","O","O"},
		};
		String [][] array2 = new String[][]{
				{"O","O","O","O","X","O","O","O","O","O"},
				{"O","O","O","X","O","O","O","O","O","O"},
				{"O","O","X","X","O","O","O","O","O","O"},
				{"O","X","X","X","O","O","O","O","O","O"},
				{"X","X","X","X","O","O","O","O","O","O"},
				{"O","X","X","X","O","O","O","O","O","O"},
				{"O","O","X","X","O","O","O","O","O","O"},
				{"O","O","O","X","O","O","O","O","O","O"},
				{"O","O","O","X","O","O","O","O","O","O"},
				{"O","O","O","X","O","O","O","O","O","O"},
			};
		
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				System.out.print(Mirror.mirror(array)[i][j]);
			}
			System.out.println();
		}

	}

}
