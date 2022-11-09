package hw01;

public class StockProblemMain {

	public static void main(String[] args) {
		int[] prices = {30, 18, 23, 14, 17, 16, 25, 24, 19};
		
		
		int[] ans = StockProblem.maxBenefit(prices);
		System.out.println("買 : " + ans[0] + " 賣 : " + ans[1] + 
				" 受益 : " + prices[ans[1]] + "-" + prices[ans[0]] + " = " + ans[2]);
		System.out.println("=========================================");
		
		
		ans = StockProblem2.maxBenefit(prices);
		System.out.println("買 : " + ans[0] + " 賣 : " + ans[1] + 
				" 受益 : " + prices[ans[1]] + "-" + prices[ans[0]] + " = " + ans[2]);
		System.out.println("=========================================");
		
		
		ans = StockProblem3.maxBenefit(prices);
		System.out.println("買 : " + ans[0] + " 賣 : " + ans[1] + 
				" 受益 : " + prices[ans[1]] + "-" + prices[ans[0]] + " = " + ans[2]);
	}

}
