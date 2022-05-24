package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class GarbageCreator {
	public static void main(String[] args) {
		String filename = "test.exe";
		Path path = FileSystems.getDefault().getPath("");
		String filepath = path.toAbsolutePath().toString() + "\\src\\hust\\soict\\dsai\\garbage\\" + filename;
		filepath = filepath.replace("\\", "\\\\");
		
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		try {
			inputBytes = Files.readAllBytes(Paths.get(filepath));
		} catch (IOException e) {
			//e.printStackTrace();
		}
		System.out.println("String concatenation running time");
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b: inputBytes) {
			outputString += (char) b;
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		
	}
	
}
