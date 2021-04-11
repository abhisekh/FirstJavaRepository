package core.java.ExcelUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import core.java.utils.ReadFile;

public class CreateExcel {

	private static Sheet sheet;
	private static Row headerRow;
	

	public static void main(String[] args) throws IOException {

		Workbook wb= new HSSFWorkbook();
		OutputStream fout= new FileOutputStream(new File(".//src//main//resources//Details.xls"));
		
		
		
		sheet = wb.createSheet("2021-02-26");		
		headerRow = sheet.createRow(0);		
		headerRow.createCell(0).setCellValue("Owner");
		List<String> testSubjects = ReadFile.readFile();

		for(int i=0;i<testSubjects.size();i++) {			
		headerRow.createCell(i+1).setCellValue(testSubjects.get(i));
		sheet.autoSizeColumn(i+1);
		}
		Map<String, List<String>> data = ReadFile.createData();
		List<String> individualData = data.get("U673734");
		for(int j=0;j<data.size();j++) {
			Row dataRow = sheet.createRow(j+1);
		for(int i=1;i<individualData.size();i++) {
			dataRow.createCell(0).setCellValue(individualData.get(0));
			System.out.println(individualData.get(i).split(testSubjects.get(i-1)+":")[1]);
			
			dataRow.createCell(i).setCellValue(individualData.get(i).split(testSubjects.get(i-1)+":")[1]);
		}
		
		}
		
		
		
		
		  wb.write(fout); 
		  System.out.println("Excel Sheet Created Successfully");
		 
		
	}

}
