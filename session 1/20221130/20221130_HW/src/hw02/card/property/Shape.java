package hw02.card.property;

public enum Shape implements CardProperty {
	橢圓, 長方, 蚯蚓;
	
	@Override
	public boolean isTheSameAs(CardProperty otherCP) {
		if(!(otherCP instanceof Shape))
			return false;
		
		return this==(Shape)otherCP;
	}
}
