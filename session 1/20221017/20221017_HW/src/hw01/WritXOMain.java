package hw01;

public class WritXOMain {

	public static void main(String[] args) {
		int num = 10;
		
		
		String[][] ans = WritXO.writeOX(num);
		
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}

	}

}
