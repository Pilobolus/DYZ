package hw03;

import hw03.legion.Legion;
import hw03.troop.Color;
import hw03.troop.Troop;

public class LegionCardsMain {

	public static void main(String[] args) {
		Legion legion1 = new Legion("legion1",
				new Troop("legion1_troop1", Color.yellow, 1), 
				new Troop("legion1_troop2", Color.yellow, 2),
				new Troop("legion1_troop3", Color.yellow, 3));
		
		Legion legion2 = new Legion("legion2",
				new Troop("legion2_troop1", Color.red, 7), 
				new Troop("legion2_troop2", Color.red, 8),
				new Troop("legion2_troop3", Color.red, 9));
		
		System.out.println("-------------LegionCardsLevel01----------------");
		System.out.println("legion1 is straight : " + LegionCardsLevel01.isStraight(legion1));
		System.out.println("legion2 is straight : " + LegionCardsLevel01.isStraight(legion2));

		System.out.println("\n-------------LegionCardsLevel02----------------");
		System.out.println("legion1 is of type : " + LegionCardsLevel02.typeOf(legion1));
		System.out.println("legion2 is of type : " + LegionCardsLevel02.typeOf(legion2));
		
		System.out.println("\n-------------LegionCardsLevel03----------------");
		int compareResult = LegionCardsLevel03.compare(legion1, legion2);
		
		System.out.println("legion1 :　" + legion1);
		System.out.println("legion2 :　" + legion2);
		System.out.println("the winning legion is : " + (compareResult>0 ? "legion1" : "legion2"));
	}

}
