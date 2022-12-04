package hw03;

import hw03.legion.Legion;
import hw03.legion.LegionType;

public class LegionCardsLevel01 {

	public static boolean isStraight(Legion legion) {
		return (legion.getType()==LegionType.straight || legion.getType()==LegionType.straightFlush);
	}
}
