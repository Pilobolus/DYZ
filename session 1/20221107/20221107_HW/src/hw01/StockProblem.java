package hw01;

public class StockProblem {

	public static int[] maxBenefit(int[] prices){
		
		int[] ans = {0, 1, prices[1]-prices[0]};
	
		
		for(int i=0; i<prices.length-1; i++){
			for(int j=i+1; j<prices.length; j++){
				if(i==0 && j==1){
					continue;
				}
				int num = prices[j]-prices[i];
				if(ans[2] < num){
					ans[2] = num;
					ans[0] = i;
					ans[1] = j;
				}
			}
		}
		return ans;
	}
}
