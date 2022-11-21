package hw01;

public class NumberDonut {

	public static int[][] build(int n){
		
		if(n <= 0)
			return new int[][]{};
		
		int len = 2*n - 1;
		int[][] ans = new int[len][len];
		
		
		int rowFirst = 0;
		int rowLast = len-1;
		int colFirst = 0;
		int colLast = len-1;
		
		
		for(int i=n; i>=1; i--){
			if(i == 1){
				ans[rowFirst][colFirst] = 1;
				break;
			}
			for(int j=rowFirst; j<=rowLast; j++){
				ans[j][colFirst] = i;
				ans[j][colLast] = i;
			}
			for(int j=colFirst; j<=colLast; j++){
				ans[rowFirst][j] = i;
				ans[rowLast][j] = i;
			}
			
			rowFirst++;
			rowLast--;
			colFirst++;
			colLast--;
		}
		
		return ans;
		
	}
}
