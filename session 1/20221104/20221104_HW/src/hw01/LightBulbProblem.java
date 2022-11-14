package hw01;

import java.util.ArrayList;
import java.util.List;

public class LightBulbProblem {
	
	public static void lightUp(LightBulb[] bulbs, int endTime) {
		int product = 1;
		
		for(LightBulb bulb : bulbs) {
			product *= bulb.getLightTime();
		}
		
		List<Integer> factors = getFactors(product);
		
		int lcm = 0;
		for(int i=0; i<factors.size(); i++) {
			for(LightBulb bulb : bulbs) {
				if(factors.get(i) < bulb.getLightTime()) {
					factors.remove(i);
					i--;
					break;
				}else if(factors.get(i)%bulb.getLightTime() != 0) {
					factors.remove(i);
					i--;
					break;
				}
			}
		}
		lcm = factors.get(0);
		
		int curNum = lcm;
		while(curNum <= endTime) {
			System.out.println(curNum);
			for(LightBulb bulb : bulbs) {
				StringBuilder sb = new StringBuilder(bulb.getName());
				sb.append(" : ");
				sb.append(bulb.getLightTime());
				sb.append("*");
				sb.append(curNum/bulb.getLightTime());
				sb.append(" = ");
				sb.append(curNum);
				System.out.println(sb.toString());
			}
			System.out.println();
			curNum += lcm;
		}
		
	}
	
	private static List<Integer> getFactors(int n) {
		List<Integer> factorList = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			if(n%i == 0)
				factorList.add(i);
		}
		return factorList;
	}
}
