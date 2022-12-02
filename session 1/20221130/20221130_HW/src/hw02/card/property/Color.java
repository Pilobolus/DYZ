package hw02.card.property;

public enum Color implements CardProperty{
	紅, 綠, 紫;
	
	@Override
	public boolean isTheSameAs(CardProperty otherCP) {
		if(!(otherCP instanceof Color))
			return false;
		
		return this==(Color)otherCP;
	}
}
