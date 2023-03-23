package day09;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class program01 {

	public static void main(String[] args) {
		System.out.println(readXpath("FirstName"));
		System.out.println(readXpath("LastName"));
		System.out.println(readDataValue("LastName"));
		System.out.println(readDataValue("Skill"));
	}
		// TODO Auto-generated method stub
		
		public static String readXpath(String fieldName)
				{
					try {
					File src = new File(".\\src\\test\\resources\\TestDataSheet.xlsx");
					FileInputStream ip = new FileInputStream(src);
					XSSFWorkbook wb = new XSSFWorkbook(ip);
					XSSFSheet sh = wb.getSheetAt(0);
					DataFormatter format = new DataFormatter();
										
					for(int i=1; i<=sh.getLastRowNum();i++)
					{
						if(format.formatCellValue(sh.getRow(i).getCell(0)).equals("Skill"))
						{
							return(format.formatCellValue(sh.getRow(i).getCell(1)));
						}
						}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			
				}
		
		public static String readDataValue(String dataValue)
		{
			try {
			File src = new File(".\\src\\test\\resources\\TestDataSheet.xlsx");
			FileInputStream ip = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(ip);
			XSSFSheet sh = wb.getSheetAt(0);
			DataFormatter format = new DataFormatter();
								
			for(int i=1; i<=sh.getLastRowNum();i++)
			{
				
				if(format.formatCellValue(sh.getRow(i).getCell(0)).equals("Skill"))
				{
					return(format.formatCellValue(sh.getRow(i).getCell(2)));
				}
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		}	
		
}
