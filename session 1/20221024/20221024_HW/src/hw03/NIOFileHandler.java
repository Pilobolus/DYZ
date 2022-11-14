package hw03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIOFileHandler {

	public static List<String> readFile(String pathName){
		Path path = Paths.get(pathName);
		
		try {
			return Files.readAllLines(path);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		return null;
	}
	
	public static void writeFile(List<String> lines, String toPathName) {
		Path path = Paths.get(toPathName);
		
		try {
			Files.write(path, lines);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
