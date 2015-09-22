package cn.edu.cqu.csp.main;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author caoshuping
 * @created 2015.8.29
 *
 */
public class LessonCount {

	public ArrayList<ArrayList<String>> lessonCount(List<String> originData)
	{
		ArrayList<ArrayList<String>> processedInfo = new ArrayList<ArrayList<String>>();
		//ArrayList<String> teacherInfo = new ArrayList<String>();
		ArrayList<String> lessonInfo = new ArrayList<String>();
		//List<ArrayList<String>> info = new ArrayList<ArrayList<String>>();
		int[] count = new int[31];
		String tempString = "";
		String teacherName = "";
		
		for(int i = 0; i <originData.size(); i = i + 2)
		{
			tempString = originData.get(i);
			
			///×¢ÊÍ×ÅÕâÒ»¾ä
			tempString = tempString.substring(0, tempString.indexOf("£¨"));
			//System.out.println(tempString);
			if(teacherName.equals(tempString))
			{
				System.out.println(originData.get(i+1).substring(8,10));
				tempString = originData.get(i+1).substring(8,10);
				count[Integer.valueOf(tempString)-1]++;
				
			}
			else
			{
				//System.out.println(teacherName);
				//System.out.println(tempString);
				if(lessonInfo.size() != 0)
				{
					for(int k = 0; k < 31; k++)
					{
						lessonInfo.add(String.valueOf(count[k]));
					}
					processedInfo.add(lessonInfo);
					lessonInfo = new ArrayList<String>();
				}
				teacherName = tempString;
				lessonInfo.add(teacherName);
				for(int j = 0; j < 31; j++)
				{
					count[j] = 0;
				}
				//System.out.println(lessonInfo.get(0));
				tempString = originData.get(i+1).substring(8,10);
				count[Integer.valueOf(tempString)-1]++;
				System.out.println(tempString);
			}
			
		}
		if(lessonInfo.size() != 0)
		{
			for(int k = 0; k < 31; k++)
			{
				lessonInfo.add(String.valueOf(count[k]));
			}
			processedInfo.add(lessonInfo);
			lessonInfo = new ArrayList<String>();
		}
		return processedInfo;
	}
}
