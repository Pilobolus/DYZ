package hw01;

public class StockProblem3 {

	public static int[] maxBenefit(int[] prices) {
		int[] subs = new int[prices.length-1];
		
		for(int i=0; i<subs.length; i++) {
			subs[i] = prices[i+1] - prices[i];
		}
		
		int[] max = maxSubarray(subs);
		
		int[] ans = {max[0], max[1]+1, prices[max[1]+1] - prices[max[0]]};
		return ans;
	}
	
	private static int[] maxSubarray(int[] array) {
		
		
		int[] max = {0, 0, array[0]};
		int[] middleMax = {0, 0, array[0]};
		
		for(int i=1; i<array.length; i++) {
			
			if(middleMax[2] < 0) {
				middleMax[0] = middleMax[1] = i;
				middleMax[2] = array[i];
			}else {
				middleMax[1] = i;
				middleMax[2] += array[i];
			}
			
			if(middleMax[2] > max[2]) {
				max[0] = middleMax[0];
				max[1] = middleMax[1];
				max[2] = middleMax[2];
			}
		}
		
		return max;
	}
}
