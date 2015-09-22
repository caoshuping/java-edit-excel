package cn.edu.cqu.csp.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	public boolean writeExcel(String filePath, ArrayList<ArrayList<String>> content) throws IOException
	{
		int row = 1;
		int col = 0;
		String tempString = "";
		OutputStream os = new FileOutputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		
		XSSFSheet xssfSheet = xssfWorkbook.createSheet("°¡¹þ");
		XSSFRow xssfRow = xssfSheet.createRow(0); 
		xssfSheet.getRow(0).createCell(0).setCellValue("TRÐÕÃû");
		for(int i = 0; i < 31; i++)
		{
			//xssfSheet.getRow(0).createCell(i+1).setCellValue(String.valueOf(i+1));
			xssfSheet.getRow(0).createCell(i+1).setCellValue(i+1);;
		}
		
		ArrayList<String> lessonInfo;
		for(int i = 0; i < content.size(); i++)
		{
			lessonInfo = new ArrayList<String>();
			lessonInfo =  content.get(i);
			//System.out.println(lessonInfo.size());
			if(xssfSheet.getRow(row) != null)
				xssfSheet.getRow(row).createCell(0).setCellValue(lessonInfo.get(0));
			else
				xssfSheet.createRow(row).createCell(0).setCellValue(lessonInfo.get(0));
			for(int j = 1; j < lessonInfo.size(); j++)
			{
				//System.out.println(lessonInfo.get(j));
				if(Integer.valueOf(lessonInfo.get(j)) != 0)
					xssfSheet.getRow(row).createCell(j).setCellValue(Integer.valueOf(lessonInfo.get(j)));
				
			}
			row++;
			col = 0;
		}
		
		xssfWorkbook.write(os);
		xssfWorkbook.close();
		os.close();
		return true;
	}
}
