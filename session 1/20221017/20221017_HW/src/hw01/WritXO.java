package hw01;

public class WritXO {

	public static String[][] writeOX(int number){
		if(number <= 0)
			throw new IllegalArgumentException("number <= 0");
		
		String[][] ans = new String[number][];
		for(int i=0; i<number; i++) {
			int numX = number - i - 1;
			int numO = 2 * i + 1;
			
			int colNum = numX + numO;
			
			ans[i] = new String[colNum];
			
			for(int j=0; j<numX; j++) {
				ans[i][j].equals("X");
			}
			for(int j=numX; j<colNum; j++) {
				ans[i][j].equals("O");
			}
		}
		
		return ans;
	}
}
