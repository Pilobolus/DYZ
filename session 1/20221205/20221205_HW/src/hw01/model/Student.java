package hw01.model;

import java.util.List;
import java.util.stream.Collectors;

public class Student{

	private int no;
	private String name;
	private List<Integer> scores;
	private int sum;
	private double average;
	
	
	public Student(int no, String name, List<Integer> scores) {
		this.no = no;
		this.name = name;
		this.scores = scores;
		this.sum = scores.stream().mapToInt(i -> i).sum();
		this.average =  scores.stream().mapToInt(i -> i).average().getAsDouble();
	}


	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public int getSum() {
		return sum;
	}
	public double getAverage() {
		return average;
	}


	@Override
	public String toString() {
		return no + "," + name 
				+ scores.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(",", ",", ","))
				+ sum + "," + String.format("%.2f", average);
	}
}
