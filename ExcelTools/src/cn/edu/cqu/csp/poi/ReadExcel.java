package cn.edu.cqu.csp.poi;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author caoshuping
 * @created 2015.8.14
 */
public class ReadExcel {

	public List<String> readXlsx(String filePath) throws IOException
	{
		List<String> sheetContent = new ArrayList<String>();
		InputStream is = new FileInputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		
		//Read the sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++)
		{
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			
			if(xssfSheet == null)
				continue;
			
			//read content of sheet
			for (int numRow = 0; numRow <= xssfSheet.getLastRowNum(); numRow++)
			{
				XSSFRow xssfRow = xssfSheet.getRow(numRow);
				if(xssfRow == null)
					continue;
				
				//String cellContent = "";
				XSSFCell cell = xssfRow.getCell(0);
				String cellContent = cell.getStringCellValue();
				System.out.println(cellContent);
				sheetContent.add(cellContent);
			}
			
		}
		xssfWorkbook.close();
		is.close();
		return  sheetContent;
	}
}
