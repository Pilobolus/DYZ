package hw02;

import hw02.card.Card;
import hw02.card.CardService;

public class ThreeCardSetLevel1 {

	public static boolean isASet(Card card1, Card card2, Card card3) {
		return CardService.isASet(card1, card2, card3);
	}
}
