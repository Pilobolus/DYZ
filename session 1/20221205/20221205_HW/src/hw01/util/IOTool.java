package hw01.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IOTool {

	public static List<String> read(String pathName) {
		Path path = Paths.get(pathName);
		try {
			return Files.readAllLines(path);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean write(String pathName, List<String> statements) {
		Path path = Paths.get(pathName);
		try {
			Files.write(path, statements);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
