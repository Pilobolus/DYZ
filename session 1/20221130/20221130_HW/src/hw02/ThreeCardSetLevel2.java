package hw02;

import java.util.ArrayList;
import java.util.List;

import hw02.card.Card;
import hw02.card.CardService;

public class ThreeCardSetLevel2 {

	public static List<Card[]> getSets(Card... cards){
		
		int len = cards.length;
		
		
		List<Card[]> sets = new ArrayList<>();
		for(int i=0; i<len-2; i++) {
			for(int j=i+1; j<len-1; j++) {
				for(int k=j+1; k<len; k++) {
					if(CardService.isASet(cards[i], cards[j], cards[k])) {
						Card[] set = {cards[i], cards[j], cards[k]};
						sets.add(set);
					}
				}
			}
		}
		
		return sets;
	}
}
