package hw04;

public class Direction {
	
	public static String direction(String[][] map, String directions) {
		if(map == null)
			throw new NullPointerException("map is null");
		if(directions == null)
			throw new NullPointerException("directions is null");
		if(directions.length() == 0)
			return map[0][0];
		
		int[] indices = {0, 0};
		int[] lengths = new int[map.length];
		for(int i=0; i<map.length; i++) {
			if(map[i] == null)
				throw new NullPointerException(String.format("map[%d] is null", i));
			lengths[i] = map[i].length;
		}
		
		StringBuilder sb = new StringBuilder(map[0][0]);
		for(int i=0; i<directions.length(); i++) {
			char ch = directions.charAt(i);
			indicesCount(indices, lengths, ch);
			sb.append(map[indices[0]][indices[1]]);
		}
		
		return sb.toString();
	}

	private static int[] indicesCount(int[] indices, int[] lengths, char direction) {
		int rowIndex = indices[0];
		int colIndex = indices[1];
		
		switch(direction) {
			case '←':
				colIndex--;
				break;
			case '→':
				colIndex++;
				break;
			case '↑':
				rowIndex--;
				break;
			case '↓':
				rowIndex++;
				break;
			case '↖':
				rowIndex--;
				colIndex--;
				break;
			case '↗':
				rowIndex--;
				colIndex++;
				break;
			case '↘':
				rowIndex++;
				colIndex++;
				break;
			case '↙':
				rowIndex++;
				colIndex--;
				break;
			default :
				throw new IllegalArgumentException("illegal direction");
		}
		
		
		if(rowIndex<0 || rowIndex>=lengths.length || colIndex<0 || colIndex>=lengths[rowIndex])
			return indices;
		
		indices[0] = rowIndex;
		indices[1] = colIndex;
		
		return indices;
	}
}
