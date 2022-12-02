package hw02;

import java.util.Arrays;
import java.util.List;

import hw02.card.Card;
import hw02.card.property.Color;
import hw02.card.property.FillUp;
import hw02.card.property.Number;
import hw02.card.property.Shape;

public class ThreeCardSetMain {

	public static void main(String[] args) {
		
		System.out.println("-----------------------------------ThreeCardSetLevel1------------------------------------\n");

		
		Card card1 = new Card("card1", Number.ONE, Color.綠, Shape.橢圓, FillUp.網底);
		Card card2 = new Card("card2", Number.TWO, Color.綠, Shape.蚯蚓, FillUp.網底);
		Card card3 = new Card("card3", Number.THREE, Color.綠, Shape.長方, FillUp.網底);
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		System.out.println(ThreeCardSetLevel1.isASet(card1, card2, card3));
		System.out.println("\n\n");
		
		
		Card[] cards = new Card[14];
		
		cards[0] = new Card("card_01", Number.THREE, Color.綠, Shape.橢圓, FillUp.網底);
		cards[1] = new Card("card_02", Number.THREE, Color.紫, Shape.蚯蚓, FillUp.空心);
		cards[2] = new Card("card_03", Number.THREE, Color.紅, Shape.橢圓, FillUp.空心);
		cards[3] = new Card("card_04", Number.THREE, Color.紅, Shape.蚯蚓, FillUp.實心);
		cards[4] = new Card("card_05", Number.ONE, Color.紫, Shape.橢圓, FillUp.網底);
		cards[5] = new Card("card_06", Number.THREE, Color.綠, Shape.長方, FillUp.網底);
		cards[6] = new Card("card_07", Number.TWO, Color.紫, Shape.蚯蚓, FillUp.實心);
		cards[7] = new Card("card_08", Number.TWO, Color.紫, Shape.長方, FillUp.實心);
		cards[8] = new Card("card_09", Number.ONE, Color.紫, Shape.橢圓, FillUp.空心);
		cards[9] = new Card("card_10", Number.THREE, Color.綠, Shape.蚯蚓, FillUp.實心);
		cards[10] = new Card("card_11", Number.THREE, Color.紅, Shape.橢圓, FillUp.網底);
		cards[11] = new Card("card_12", Number.TWO, Color.綠, Shape.橢圓, FillUp.空心);
		cards[12] = new Card("card_13", Number.THREE, Color.綠, Shape.橢圓, FillUp.空心);
		cards[13] = new Card("card_14", Number.THREE, Color.紫, Shape.長方, FillUp.網底);
		
		
		System.out.println(cards[0]);
		System.out.println(cards[5]);
		System.out.println(cards[9]);
		System.out.println(ThreeCardSetLevel1.isASet(cards[0], cards[5], cards[9]));
		System.out.println("\n\n");
		
		
		System.out.println(cards[3]);
		System.out.println(cards[12]);
		System.out.println(cards[13]);
		System.out.println(ThreeCardSetLevel1.isASet(cards[3], cards[12], cards[13]));
		System.out.println("\n\n");
		
		
		System.out.println("-----------------------------------ThreeCardSetLevel2------------------------------------\n");
		List<Card[]> sets = ThreeCardSetLevel2.getSets(cards);
		
		int count = 1;
		for(Card[] set : sets) {
			System.out.println(count++ + " : " + Arrays.toString(set));
		}
	}

}
