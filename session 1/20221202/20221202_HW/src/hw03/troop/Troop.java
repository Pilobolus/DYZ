package hw03.troop;

import java.util.Objects;

import hw03.exception.TroopStrengthOutOfBoundsException;

public class Troop {

	private String name;
	private Color color;
	private int strength;
	
	
	public Troop(String name, Color color, int strength) {
		this.name = name;
		this.color = color;
		
		if(strength>10 || strength<=0)
			throw new TroopStrengthOutOfBoundsException("strength should be between 1 to 10 not " + strength + ".");
		this.strength = strength;
	}


	
	public String getName() {
		return name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}


	@Override
	public String toString() {
		return "Troop [name=" + name + ", color=" + color + ", strength=" + strength + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(color, strength);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Troop other = (Troop) obj;
		return color == other.color && strength == other.strength;
	}
}
