package hw01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PresidentSortMain {

	public static void main(String[] args) {
		
		President p1 = new President(1, "吼友宜", "A123456789", 165, 10000);
		President p2 = new President(2, "賴清得", "B123456789", 175, 10000);
		President p3 = new President(3, "柯文折", "C123456789", 166, 8000);
		President p4 = new President(4, "郭台名", "D123456789", 180, 6000);
		President p5 = new President(5, "李昱賞", "E123456789", 177, 30);
		
		List<President> presidents = new ArrayList<>();
		presidents.add(p1);
		presidents.add(p2);
		presidents.add(p3);
		presidents.add(p4);
		presidents.add(p5);
		
		comparePresident(presidents);
		
		for(President president : presidents){
			System.out.println(president);
		}

	}

	private static void comparePresident(List<President> presidents) {
		// 實作比較邏輯
		// 主排序:numberOfVotes(票數多)
		// 次排序:height(身高矮)
		// 次次排序:idNumber(字母愈後面的贏)
		
		
		Comparator<President> comp = Comparator.<President, Integer>comparing(p -> p.getNumberOfVotes());
		comp = comp.thenComparing(p -> p.getHeight(), (h1, h2) -> h2.compareTo(h1));
		comp = comp.thenComparing(p -> p.getIdNumber(), (id1, id2) -> id1.charAt(0)-id2.charAt(0));
		
		Collections.sort(presidents, comp);
	}

}


class President {
	
	private Integer candidateNo;
	
	private String name;
	
	private String idNumber;
	
	private Integer height;
	
	// 得票數
	private Integer numberOfVotes;
	
	public President(Integer candidateNo, String name, String idNumber,
			Integer height, Integer numberOfVotes) {
		this.candidateNo = candidateNo;
		this.name = name;
		this.idNumber = idNumber;
		this.height = height;
		this.numberOfVotes = numberOfVotes;
	}

	@Override
	public String toString() {
		return "President [candidateNo=" + candidateNo + ", name=" + name
				+ ", idNumber=" + idNumber + ", height=" + height
				+ ", numberOfVotes=" + numberOfVotes + "]";
	}

	public Integer getCandidateNo() {
		return candidateNo;
	}

	public String getName() {
		return name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}
	
	
}