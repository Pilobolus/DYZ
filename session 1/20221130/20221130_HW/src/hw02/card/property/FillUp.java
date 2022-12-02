package hw02.card.property;

public enum FillUp implements CardProperty {
	空心, 實心, 網底;
	
	@Override
	public boolean isTheSameAs(CardProperty otherCP) {
		if(!(otherCP instanceof FillUp))
			return false;
		
		return this==(FillUp)otherCP;
	}
}
