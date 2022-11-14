package hw01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticSequence {

	public static List<Integer> solve(String seq){
		if(seq == null)
			throw new NullPointerException("sequence is null");
		
		List<Integer> ans = new ArrayList<>();
		if(seq.length() == 0)
			return ans;
		
		
		StringBuilder sb = new StringBuilder(seq);
		int count = 0;
		for(int i=0; i<sb.length(); i++) {
			char ch = sb.charAt(i);
			
			if(ch == ' ') {
				sb.deleteCharAt(i);
				i--;
			}else if(ch == ',') {
				if(i-1>=0 && sb.charAt(i-1)==',')
					throw new IllegalArgumentException("illegal comma");
				count++;
			}else if(ch=='0') {
				if(i-1>=0 && (sb.charAt(i-1)==',' || sb.charAt(i-1)=='+' || sb.charAt(i-1)=='-')) {
					sb.deleteCharAt(i);
					i--;
				}
			}else if(ch=='+' || ch=='-') {
				if(i-1 >= 0 && sb.charAt(i-1) != ',')
					throw new IllegalArgumentException("illegal sign");
				if(i+1<sb.length() && (sb.charAt(i+1)>'9'||sb.charAt(i+1)<'0'))
					throw new IllegalArgumentException("illegal sign");
			}else if((ch>'9'||ch<'0') && (ch!='x' && ch!='X')) {
				throw new IllegalArgumentException("illegal character : " + ch);
			}
			
		}
		seq = sb.toString();
		
		String[] strs = seq.split(",");
		List<BigDecimal> numbers = new ArrayList<>();
		List<BigDecimal> indices = new ArrayList<>();
		for(int i=0; i<strs.length; i++) {
			try {
				int num = Integer.parseInt(strs[i]);
				numbers.add(new BigDecimal(strs[i]));
				indices.add(new BigDecimal(Integer.toString(i)));
			}catch(Exception ex) {
				
			}
		}
		if(numbers.size() <= 1)
			throw new IllegalArgumentException("numbers are not enough");
		
		BigDecimal d = null;
		for(int i=1; i<numbers.size(); i++) {
			
			BigDecimal num = (numbers.get(i).subtract(numbers.get(i-1))).
					divide(indices.get(i).subtract(indices.get(i-1)), 2, RoundingMode.HALF_UP);

			
			
			if(i == 1) {
				BigDecimal test = num.subtract(num.divide(new BigDecimal("1"), 0, RoundingMode.DOWN));
				if(test.compareTo(new BigDecimal("0")) != 0)
					throw new IllegalArgumentException("tolerance is not integer");
				
				d = num;
			}else {
				if(d.compareTo(num) != 0)
					throw new IllegalArgumentException("the sequence is not arithmetic");
			}
		}
		
		int term = numbers.get(0).intValue();
		int dInt = d.intValue();
		term -= dInt*indices.get(0).intValue();
		ans.add(term);
		
		for(int i=1; i<=count; i++) {
			term += dInt;
			ans.add(term);
		}
		
		return ans;
	}
}
