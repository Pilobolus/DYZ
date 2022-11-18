package hw01;

import java.math.BigDecimal;

public class NumberReverse {

	public static BigDecimal reverse(String numberStr) {
		if(numberStr == null)
			throw new NullPointerException();
		if(numberStr.length() == 0)
			return null;
		
		
		int pointIndex = numberStr.indexOf('.');

		BigDecimal ans = new BigDecimal(0);
		
		int index = 0;
		
		while((pointIndex>=0) ? (index<pointIndex) : (index<numberStr.length())) {
			
			BigDecimal bd = new BigDecimal(numberStr.charAt(index)-'0').multiply(new BigDecimal(Math.pow(10, index)));
			
			ans = ans.add(bd);
			index++;
		}
		
		
		
		if(pointIndex >= 0) {
			index = pointIndex+1;
			
			while(index < numberStr.length()) {
				BigDecimal bd = new BigDecimal(numberStr.charAt(index)-'0').multiply(new BigDecimal(Math.pow(10, index-numberStr.length())));
				ans = ans.add(bd);
				index++;
			}
		}
		
		return ans;
	}
}
