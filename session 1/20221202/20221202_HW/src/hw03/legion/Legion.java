package hw03.legion;

import java.util.Arrays;

import hw03.exception.TroopsEqualException;
import hw03.troop.Troop;

public class Legion {

	private String name;
	private Troop[] troops = new Troop[3];
	private LegionType type;
	
	public Legion(String name, Troop troop1, Troop troop2, Troop troop3) {
		if(troop1.equals(troop2))
			throw new TroopsEqualException(troop1.getName() + " cannot be the same as " + troop2.getName());
		if(troop2.equals(troop3))
			throw new TroopsEqualException(troop2.getName() + " cannot be the same as " + troop3.getName());
		if(troop1.equals(troop3))
			throw new TroopsEqualException(troop1.getName() + " cannot be the same as " + troop3.getName());
		
		this.name = name;
		troops[0] = troop1;
		troops[1] = troop2;
		troops[2] = troop3;
		type = LegionService.getLegionType(troops);
	}

	
	public Troop[] getTroops() {
		return troops;
	}
	public LegionType getType() {
		return type;
	}


	@Override
	public String toString() {
		return "Legion [name=" + name + ", troops=" + Arrays.toString(troops) + ", type=" + type + "]";
	}
}
