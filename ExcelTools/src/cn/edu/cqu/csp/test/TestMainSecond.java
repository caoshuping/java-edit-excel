package cn.edu.cqu.csp.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqu.csp.main.LessonCount;
import cn.edu.cqu.csp.poi.ReadData;
import cn.edu.cqu.csp.poi.WriteData;
import cn.edu.cqu.csp.poi.WriteExcel;


public class TestMainSecond {

	public static void main(String[] args) throws IOException
	{
		ReadData readData = new ReadData();
		LessonCount infoProcess = new LessonCount();
		WriteData wExcel = new WriteData();
		
		List<String> pocessedInfo = readData.readXlsx("D:\\1.xlsx");
		System.out.println(pocessedInfo.size());
		ArrayList<ArrayList<String>> result = infoProcess.lessonCount(pocessedInfo);
		ArrayList<String> tempList;
		System.out.println(result.size());
		for(int i = 0;  i < result.size(); i++)
		{
			tempList = result.get(i);
			for(int j = 0; j < tempList.size(); j++)
			{
				System.out.print(tempList.get(j)+" ");
			}
			System.out.println(" ");
		}
		
		wExcel.writeExcel("D:\\2.xlsx", result);
			
	}
}
