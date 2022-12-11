package hw01.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hw01.model.Student;

public class StudentService {

	private static Comparator<Student> getStudentComparator(){
		
		return Comparator.comparing(Student::getSum, (n1, n2) -> -n1.compareTo(n2))
				.thenComparing(Student::getScores, (l1, l2) -> {
					int ans = 0;
					for(int i=0; i<l1.size(); i++) {
						if((ans = (-l1.get(i).compareTo(l2.get(i)))) != 0)
							return ans;
					}
					return 0;
				})
				.thenComparing(Student::getNo, (n1, n2) -> n1.compareTo(n2));
	}
	
	public static Map<Integer, List<Student>> getStudentAfterGrouping(List<Student> students){
		return students.stream()
				.collect(Collectors.groupingBy(stu -> (int)stu.getAverage()/10)).entrySet().stream()
				.collect(Collectors
						.toMap(entry -> {
							int key = entry.getKey();
							if(key <= 5)
								return 5;
							return key;
						}, entry -> entry.getValue(), (l1, l2) -> {
								l1.addAll(l2);
								return l1;
							})).entrySet().stream()
				.peek(entry -> entry.getValue().sort(getStudentComparator()))
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
	}
	
	public static List<Student> stringToStudent(List<String> studentStrings){
		return studentStrings.stream()
				.skip(1)
				.map(str -> {
					String[] tokens = str.split(",");
					return new Student(Integer.valueOf(tokens[0]), tokens[1], 
						Arrays.asList(tokens).stream().skip(2).map(Integer::valueOf).collect(Collectors.toList()));
				})
				.collect(Collectors.toList());
	}
	
	public static List<String> studentGroupsToString(Map<Integer, List<Student>> studentGroups, String headers, StringBuilder sb){
		List<String> ans = studentGroups.entrySet().stream()
				.sorted((e1, e2) -> -e1.getKey().compareTo(e2.getKey()))
				.map(entry -> entry.getValue())
				.map(list -> list.stream().map(Student::toString).collect(Collectors.toList()))
				.peek(list -> list.add(""))
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());
		
		if(ans.size() > 0)
			ans.remove(ans.size()-1);
		
		return appendGroupCount(studentGroups, ans, headers, sb);
	}
	
	private static List<String> appendGroupCount(Map<Integer, List<Student>> studentGroups, List<String> resultStrings, String headers, StringBuilder sb){
		Map<Integer, String> groupCountStr = getGroupCountString(studentGroups, sb);
		
		int size = resultStrings.size();
		for(int i=1; i<=6; i++) {
			sb.delete(0, sb.length());
			sb.append(resultStrings.get(size-i));
			
			if(sb.toString().equals("")) {
				int num = headers.split(",").length;
				for(int j=1; j<=num+1; j++) {
					sb.append(",");
				}
			}
			
			sb.append(",,,").append(groupCountStr.get(i+4));
			resultStrings.set(size-i, sb.toString());
		}
		
		return resultStrings;
	}
	
	private static Map<Integer, Integer> getGroupCount(Map<Integer, List<Student>> studentGroups){
		Map<Integer, Integer> groupCount = studentGroups.entrySet().stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(), 
						entry -> (int)(entry.getValue().stream().count())));
		
		for(int i=5; i<=10; i++) {
			if(groupCount.get(i) == null)
				groupCount.put(i, 0);
		}
		
		return groupCount;
	}
	
	private static Map<Integer, String> getGroupCountString(Map<Integer, List<Student>> studentGroups, StringBuilder sb){
		Map<Integer, Integer> groupCount = getGroupCount(studentGroups);
		
		return groupCount.entrySet().stream()
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> {
					int key = entry.getKey();
					int count = entry.getValue();
					
					sb.delete(0, sb.length());
					if(key == 10)
						return sb.append("100,").append(count).toString();
					if(key == 5)
						return sb.append("59以下,").append(count).toString();
					return sb.append(String.valueOf(key*10)).append("-")
							.append(String.valueOf(key*10+9)).append(",")
							.append(count).toString();
				}));
	}
}
