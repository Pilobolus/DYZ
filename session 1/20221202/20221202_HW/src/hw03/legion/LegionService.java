package hw03.legion;

import hw03.troop.Troop;

public class LegionService {

	public static LegionType getLegionType(Troop[] troops) {
		if(troops[0].getColor()==troops[1].getColor() && troops[1].getColor()==troops[2].getColor()) {
			if(isStraight(troops[0].getStrength(), troops[1].getStrength(), troops[2].getStrength()))
				return LegionType.straightFlush;
			return LegionType.flush;
		}
		if(isStraight(troops[0].getStrength(), troops[1].getStrength(), troops[2].getStrength()))
			return LegionType.straight;
		if(troops[0].getStrength()==troops[1].getStrength() && troops[1].getStrength()==troops[2].getStrength())
			return LegionType.threeOfAKind;
		return LegionType.offsuit;
	}
	
	private static boolean isStraight(int strength1, int strength2, int strength3) {
		if(strength1 > strength2) {
			if(strength1 > strength3)
				return (strength1==strength2+1 && strength2==strength3+1) ||
						(strength1==strength3+1 && strength3==strength2+1);
			else
				return (strength3==strength1+1 && strength1==strength2+1);
		}else if(strength2 > strength1) {
			if(strength2 > strength3)
				return (strength2==strength1+1 && strength1==strength3+1) || 
						(strength2==strength3+1 && strength3==strength1+1);
			else
				return (strength3==strength2+1 && strength2==strength1+1);
		}
		
		return false;
	}
	
	public static int strengthSum(Legion legion) {
		int sum = 0;
		for(Troop troop : legion.getTroops()) {
			sum += troop.getStrength();
		}
		return sum;
	}
}
