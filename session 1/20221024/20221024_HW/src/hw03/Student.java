package hw03;

import java.util.List;

public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private List<Integer> scores;
	private int total;
	private float average;
	private int ranking = 0;
	
	
	public Student() {
	}
	public Student(int id, String name, List<Integer> scores) {
		this.id = id;
		this.name = name;
		this.scores = scores;
		
		total = totalCalculate();
		average = averageCalculate(total);
	}
	private int totalCalculate() {
		int num = 0;
		for(int i=0; i<scores.size(); i++) {
			num += scores.get(i);
		}
		return num;
	}
	private float averageCalculate(int totalScore) {
		return (float)totalScore/scores.size();
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append(id).append(",").append(name);
		
		for(int i=0; i<scores.size(); i++) {
			sb.append(",").append(scores.get(i));
		}
		
		sb.append(",").append(total).append(",").append(String.format("%.2f", average)).append(",").append(ranking);
		return sb.toString();
	}
	
	@Override
	public int compareTo(Student stu) {
		int n = Integer.compare(this.total, stu.total);
		if(n != 0)
			return n;
		
		for(int i=0; i<scores.size(); i++) {
			if((n=Integer.compare(this.scores.get(i), stu.scores.get(i))) != 0)
				return n;
		}
		
		return -Integer.compare(this.id, stu.id);
	}
	
	public boolean isRanked() {
		return ranking!=0;
	}
}
