package cn.edu.cqu.csp.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public boolean writeExcel(String filePath, List<String> content) throws IOException
	{
		int row = 0;
		int col = -1;
		String tempString = "";
		OutputStream os = new FileOutputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		
		XSSFSheet xssfSheet = xssfWorkbook.createSheet();
		XSSFRow xssfRow = xssfSheet.createRow(row); 
		
		//XSSFCell cell = xssfRow.createCell(col);
		//cell.setCellValue(tempString);
		
		for(int i = 0; i < content.size(); i++)
		{
			if(tempString.equals(content.get(i)))
			{
				row++;
				if(xssfSheet.getRow(row) != null)
					xssfSheet.getRow(row).createCell(col).setCellValue(content.get(i+1));
				else
					xssfSheet.createRow(row).createCell(col).setCellValue(content.get(i+1));
				//xssfSheet.createRow(row).createCell(col).setCellValue(content.get(i+1));
				i++;
			}
			else
			{
				tempString = content.get(i);
				row = 0;
				col++;
				//for(int )
				if(xssfSheet.getRow(row) != null)
					xssfSheet.getRow(row).createCell(col).setCellValue(content.get(i));
				else
					xssfSheet.createRow(row).createCell(col).setCellValue(content.get(i));
				row++;
				//System.out.println(i);
				if(xssfSheet.getRow(row) != null)
					xssfSheet.getRow(row).createCell(col).setCellValue(content.get(i+1));
				else
					xssfSheet.createRow(row).createCell(col).setCellValue(content.get(i+1));
				//xssfSheet.createRow(row).createCell(col).setCellValue(content.get(i+1));
				i++;
			}
		}
		
		xssfWorkbook.write(os);
		xssfWorkbook.close();
		os.close();
		return true;
	}
}
