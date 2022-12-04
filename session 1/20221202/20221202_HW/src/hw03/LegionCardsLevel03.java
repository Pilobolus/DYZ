package hw03;

import hw03.legion.Legion;
import hw03.legion.LegionService;

public class LegionCardsLevel03 {

	public static int compare(Legion legion1, Legion legion2) {
		int n = legion1.getType().compareTo(legion2.getType());
		
		if(n == 0)
			return LegionService.strengthSum(legion1) - LegionService.strengthSum(legion2);
		
		return n;
	}
}
