package hw01;

public class StockProblem2 {

	public static int[] maxBenefit(int[] prices){
		int[] subs = new int[prices.length-1];
		for(int i=0; i<subs.length; i++){
			subs[i] = prices[i+1] - prices[i];
		}
		
		int[] max = maxBenefitRecur(subs, 0, subs.length-1);
		
		int[] ans = {max[0], max[1]+1, prices[max[1]+1] - prices[max[0]]};
		return ans;
	}
	
	private static int[] maxBenefitRecur(int[] subs, int sIndex, int eIndex){

		if(eIndex-sIndex+1 == 1)
			return new int[]{sIndex, eIndex, subs[sIndex]};
		if(eIndex-sIndex+1 == 2)
			return new int[]{sIndex, eIndex, subs[sIndex]+subs[eIndex]};
		
		int middle = (sIndex+eIndex)/2;
		
		int[] leftMax = maxBenefitRecur(subs, sIndex, middle);
		int[] rightMax = maxBenefitRecur(subs, middle+1, eIndex);
		
		int[] middleMax = merge(subs, sIndex, eIndex, middle);
		
		int[] ans = leftMax;
		
		if(rightMax[2] > leftMax[2])
			ans = rightMax;
		if(middleMax[2] > ans[2])
			ans = middleMax;
		
		return ans;
	}
	private static int[] merge(int[] subs, int sIndex, int eIndex, int middle){
		int[] ans = new int[3];
		ans[0] = middle-1;
		ans[1] = middle;
		
		int max = 0;
		int sum = 0;
		for(int i=middle; i>=sIndex; i--){
			sum += subs[i];
			if(sum > max){
				max = sum;
				ans[0] = i;
			}
		}
		
		sum = max;
		for(int i=middle+1; i<=eIndex; i++){
			sum += subs[i];
			if(sum > max){
				max = sum;
				ans[1] = i;
			}
		}
		
		ans[2] = max;
		return ans;
	}
}
