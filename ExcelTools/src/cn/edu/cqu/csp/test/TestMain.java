package cn.edu.cqu.csp.test;

import java.io.IOException;
import java.util.List;

import cn.edu.cqu.csp.main.InfoProcess;
import cn.edu.cqu.csp.poi.ReadExcel;
import cn.edu.cqu.csp.poi.WriteExcel;

public class TestMain {

	public static void main(String[] args) throws IOException
	{
		ReadExcel readExcel = new ReadExcel();
		InfoProcess infoProcess = new InfoProcess();
		WriteExcel wExcel = new WriteExcel();
		
		List<String> excelContent = readExcel.readXlsx("D:\\html.xlsx");
		List<String> processedInfo = infoProcess.infoFilter(excelContent);
		wExcel.writeExcel("D:\\result.xlsx", processedInfo);
		System.out.println("this is a test main");
	}
	
}