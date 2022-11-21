package hw01;

public class NumberDonutMain {

	public static void main(String[] args) {
		int[][] ans = NumberDonut.build(7);
		
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<ans[i].length; j++){
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}

	}

}
