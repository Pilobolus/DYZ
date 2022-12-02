package hw02.card;

import hw02.card.property.CardProperty;
import hw02.card.property.Color;
import hw02.card.property.FillUp;
import hw02.card.property.Number;
import hw02.card.property.Shape;

public class CardService {

	
	public static boolean isASet(Card card1, Card card2, Card card3) {
		
		Status[] propertyStatuses = new Status[4];
		
		
		propertyStatuses[0] = Status.getStatus(card1, card2, card3, Color.class);
		propertyStatuses[1] = Status.getStatus(card1, card2, card3, Number.class);
		propertyStatuses[2] = Status.getStatus(card1, card2, card3, Shape.class);
		propertyStatuses[3] = Status.getStatus(card1, card2, card3, FillUp.class);
		
		for(Status status : propertyStatuses) {
			if(status == Status.洽兩個相同)
				return false;
		}
		return true;
	}
	
	private static CardProperty getProperty(Card card, Class<? extends CardProperty> propertyClass) {
		
		switch(propertyClass.getName().intern()) {
			case "hw02.card.property.Number":
				return card.getNumber();
			case "hw02.card.property.Color":
				return card.getColor();
			case "hw02.card.property.Shape":
				return card.getShape();
			case "hw02.card.property.FillUp":
				return card.getFillUp();
			default :
				return null;
		}
	}
	private static boolean hasSameProperty(Card card1, Card card2, Class<? extends CardProperty> propertyClass) {
		return getProperty(card1, propertyClass).isTheSameAs(getProperty(card2, propertyClass));
	}
	
	
	private static enum Status{
		完全相同, 洽兩個相同, 完全不同;
		
		private static Status getStatus(Card card1, Card card2, Card card3, Class<? extends CardProperty> propertyClass) {
			
			boolean b12 = hasSameProperty(card1, card2, propertyClass);
			boolean b23 = hasSameProperty(card2, card3, propertyClass);
			
			if(b12 && b23)
				return 完全相同;
			else if(b12)
				return 洽兩個相同;
			else if(b23)
				return 洽兩個相同;
			else if(hasSameProperty(card1, card3, propertyClass))
				return 洽兩個相同;
			else
				return 完全不同;
		}
	}
}
