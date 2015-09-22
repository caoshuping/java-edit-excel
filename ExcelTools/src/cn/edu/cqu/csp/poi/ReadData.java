package cn.edu.cqu.csp.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author caoshuping
 * @created 2015.8.29
 *
 */
public class ReadData {

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
				String teacherName="";
				//String cellContent = "";
				//将1改成了2
				XSSFCell cell = xssfRow.getCell(2);
				if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING)
					continue;
				String cellContent = cell.getStringCellValue();
				if(cellContent == null || cellContent.length() < 10)
					continue;
					
				///////////////////////////
				if(!cellContent.contains("（"))
					continue;	
				/////////////////////////////*
				
				//System.out.println(cellContent);
				sheetContent.add(cellContent);
				cell = xssfRow.getCell(5);
				/*if(cell.getCellType() != XSSFCell.CELL_TYPE_STRING)
					continue;
				String cellContent1 = cell.getStringCellValue();*/
				
				//if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
					//continue;
				String cellContent1 = cell.getDateCellValue().toString();
				if(cellContent1 == null || cellContent1.length() == 0)
					continue;
				System.out.println(cellContent1);
				sheetContent.add(cellContent1);
			}
			
		}
		xssfWorkbook.close();
		is.close();
		return  sheetContent;
	}
}
