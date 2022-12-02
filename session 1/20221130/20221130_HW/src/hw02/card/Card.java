package hw02.card;

import hw02.card.property.Color;
import hw02.card.property.FillUp;
import hw02.card.property.Number;
import hw02.card.property.Shape;

public class Card {

	private String name;
	private Number number;
	private Color color;
	private Shape shape;
	private FillUp fillUp;
	
	public Card(String name, Number number, Color color, Shape shape, FillUp fillUp) {
		this.name = name;
		this.number = number;
		this.color = color;
		this.shape = shape;
		this.fillUp = fillUp;
	}

	
	public String getName() {
		return name;
	}
	public Number getNumber() {
		return number;
	}
	public Color getColor() {
		return color;
	}
	public Shape getShape() {
		return shape;
	}
	public FillUp getFillUp() {
		return fillUp;
	}


	@Override
	public String toString() {
		return name + " : number=" + number + ", color=" + color + ", shape=" + shape + ", fillUp="
				+ fillUp;
	}
	
	
	
}
