package day08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class program01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		try {
			File src = new File(".\\src\\test\\resources\\DataSheet.xlsx");
			FileInputStream ip = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(ip);
			XSSFSheet sh = wb.getSheetAt(0);
			DataFormatter format = new DataFormatter();
			
			System.out.println(format.formatCellValue(sh.getRow(0).getCell(0)));
			System.out.println(format.formatCellValue(sh.getRow(1).getCell(0)));
			System.out.println(format.formatCellValue(sh.getRow(2).getCell(0)));
			
			
			System.out.println(format.formatCellValue(sh.getRow(0).getCell(1)));
			System.out.println(format.formatCellValue(sh.getRow(0).getCell(2)));
			System.out.println(format.formatCellValue(sh.getRow(0).getCell(3)));
			System.out.println(format.formatCellValue(sh.getRow(1).getCell(1)));
			
			System.out.println(sh.getLastRowNum());
			System.out.println(sh.getRow(0).getLastCellNum());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
