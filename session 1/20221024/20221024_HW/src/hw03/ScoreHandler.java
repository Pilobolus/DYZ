package hw03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ScoreHandler {

	public static void scoreHandleIO(String pathName, String toPathName) {
		if(pathName==null || toPathName==null)
			throw new NullPointerException("pathName is null");
		
		List<String> lines = IOFileHandler.readFile(pathName);
		lines = dataDealing(lines);

		IOFileHandler.writeFile(lines, toPathName);
		System.out.println("success");
	}
	public static void scoreHandleNIO(String pathName, String toPathName) {
		if(pathName==null || toPathName==null)
			throw new NullPointerException("pathName is null");
		
		List<String> lines = NIOFileHandler.readFile(pathName);
		lines = dataDealing(lines);

		NIOFileHandler.writeFile(lines, toPathName);
		System.out.println("success");
	}
	
	
	private static List<String> dataDealing(List<String> lines) {
		int stuNum = lines.size()-1;
		Student[] stus = new Student[stuNum];
		
		for(int i=0; i<stuNum; i++) {
			String[] datas = lines.get(i+1).split(",");
			
			List<Integer> scores = new ArrayList<>();
			for(int j=2; j<datas.length; j++) {
				try {
					scores.add(Integer.parseInt(datas[j]));
				}catch(NumberFormatException ex) {
					System.out.println(ex);
				}
			}
			
			try {
				Student stu = new Student(Integer.parseInt(datas[0]), datas[1], scores);
				stus[i] = stu;
			}catch(NumberFormatException ex) {
				System.out.println(ex);
			}
		}
		
		
		Map<Integer, List<Student>> groups = groupingStudents(stus);
		List<String> outputLines = makeOutputLines(groups, lines.get(0)+",總分,平均,名次");
	
		return outputLines;
	}
	
	private static Map<Integer, List<Student>> groupingStudents(Student[] stus){
		Map<Integer, List<Student>> groups = new HashMap<>();
		for(int i=0; i<stus.length; i++) {
			Student student = stus[i];
			
			int key = (int)student.getAverage()/10;
			
			key = (key<5) ? 5 : key;
			List<Student> group = groups.get(key);
			
			if(group == null) {
				group = new ArrayList<>();
				group.add(student);
				groups.put(key, group);
			}else {
				group.add(student);
			}
			
			
		}
		
		int rank = 1;
		for(int i=10; i>=5; i--) {
			List<Student> group = groups.get(i);
			if(group != null) {
				group.sort((stu1, stu2) -> -stu1.compareTo(stu2));
				
				for(int j=0; j<group.size(); j++) {
					Student student = group.get(j);
					student.setRanking(rank++);
				}
			}else{
				group = new ArrayList<>();
				groups.put(i, group);
			}
		}
		
		return groups;
	}
	
	private static List<String> makeOutputLines(Map<Integer, List<Student>> stuGroups, String header){
		List<String> outputLines = new ArrayList<>();
		
		outputLines.add(header);
		
		Map<Integer, Integer> groupCount = new HashMap<>();
		
		for(int i=10; i>=5; i--) {
			
			List<Student> group = stuGroups.get(i);
			
			for(int j=0; j<group.size(); j++) {
				outputLines.add(group.get(j).toString());
			}
			if(group.size() > 0)
				outputLines.add("");
			
			
			if(i >= 6) {
				groupCount.put(i*10, group.size());
			}else{
				groupCount.put(59, group.size());
			}
			
		}
		outputLines.remove(outputLines.size()-1);
		
		outputLines = addGroupingToOutputLines(outputLines, groupCount);
		return outputLines;
		
	}
	
	private static List<String> addGroupingToOutputLines(List<String> outputLines, Map<Integer, Integer> groupCount) {
	
		Map<Integer, String> groupingStrings = new HashMap<>();
		
		
		String str = ",,100," + groupCount.get(100);
		groupingStrings.put(100, str);
		
		StringBuilder sb = new StringBuilder(",,");
		for(int i=9; i>=6; i--) {
			sb.append(i).append("0-").append(i).append("9,").append(groupCount.get(i*10));
			groupingStrings.put(i*10, sb.toString());
			sb.replace(0, sb.length(), ",,");
		}
		str = ",,0-59," + groupCount.get(59);
		groupingStrings.put(50, str);// 為了迴圈方便
		
		
		int commaCount = outputLines.get(0).split(",").length-1;
		sb = new StringBuilder();
		for(int i=0; i<commaCount; i++) {
			sb.append(",");
		}
		
		
		int len = outputLines.size();
		for(int i=6; i>=1; i--) {
			str = outputLines.get(len-i);
			if(str.equals("")) 
				str = sb.toString();
			
			str += groupingStrings.get((i+4)*10);
			outputLines.set(len-i, str);
		}
		
		return outputLines;
	}
	
}
