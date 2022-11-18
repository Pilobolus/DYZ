package hw01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Highway {

	public static void printCar(Car[] cars, int time) {
		List<Car> carList = new ArrayList<>();
		List<Integer> indices = new ArrayList<>();
		
		for(int i=0; i<cars.length; i++) {
			if(cars[i] != null) {
				carList.add(cars[i]);
				indices.add(i);
			}
		}
		
		for(int i=1; i<=time; i++) {
			indices = nextSecond(indices, carList, cars.length);
			print(indices, carList, cars.length, i);
		}
	}
	
	private static List<Integer> nextSecond(List<Integer> currentIndices, List<Car> carList, int highwayLen){
		Integer[] array = new Integer[currentIndices.size()];
		int lastIndex = highwayLen;
		for(int i=carList.size()-1; i>=0; i--) {
			int index = currentIndices.get(i) + carList.get(i).getSpeed();
			if(index >= lastIndex)
				index = lastIndex-1;
			lastIndex = index;
			array[i] = index;
		}
		return Arrays.<Integer>asList(array);
	}
	
	private static void print(List<Integer> indices, List<Car> carList, int highwayLen, int second) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(second);
		sb.append(". {");
		for(int i=0, index=0; i<highwayLen; i++) {
			if(index<indices.size() && indices.get(index)==i) {
				sb.append(carList.get(index).toString());
				sb.append(", ");
				index++;
			}
			else {
				sb.append("null, ");
			}
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append("}");
		
		System.out.println(sb.toString());
	}
}
