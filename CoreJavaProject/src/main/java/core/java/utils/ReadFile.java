package core.java.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {

	public static void main(String[] args) {

		System.out.println(createData().get("U673734"));
	}
	
	
	public static Map<String, List<String>> createData() {
		List<String>details= new ArrayList<String>();
		details.add("3ADAM");
		details.add("Design:80");
		details.add("Regression:80");
		details.add("Smoke:80");
		Map<String, List<String>>records= new HashMap<String, List<String>>();
		records.put("U673734",details);
		
			
		return records;
	}
	
	
	
	public static List<String> readFile() {
		File file= new File(".//src/main//resources//TestSubject.txt");
		BufferedReader br = null;
		List<String>options= new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String st="";
		try {
			while((st=br.readLine())!=null) {				
				System.out.println(st);
				options.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return options;
	}
	

	
	 
}

