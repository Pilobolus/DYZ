package hw02.card.property;

public enum Number implements CardProperty {
	ONE, TWO, THREE;
	
	@Override
	public boolean isTheSameAs(CardProperty otherCP) {
		if(!(otherCP instanceof Number))
			return false;
		
		return this==(Number)otherCP;
	}
}
