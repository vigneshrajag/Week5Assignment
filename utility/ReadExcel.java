package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcelValue(String excelName) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook("./data/"+excelName+".xlsx");
		
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		
		int colCount = sheet.getRow(0).getLastCellNum();
		
		String[][] array = new String[rowCount][colCount];
		
		for (int i = 1; i <=rowCount ; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j <colCount ; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				String data = cell.getStringCellValue();
				
				array[i-1][j] = data;
				System.out.println(data);
			}
		}
		
		book.close();
		return array;
	}

}
