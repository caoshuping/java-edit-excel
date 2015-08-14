package cn.edu.cqu.csp.main;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author caoshuping
 * @created 2015.8.14 15:19
 * 
 */
public class InfoProcess {
	public List<String> infoFilter(List<String> info)
	{
		List<String> processedInfo = new ArrayList<String>();
		String tempString = "";
		for(int i = 0; i < info.size(); i++)
		{
			tempString = info.get(i);
			if(tempString.indexOf("ÖÁ") == 5)
			{
				if(tempString.substring(0, 2).equals("08")||tempString.substring(0, 2).equals("09"))
					processedInfo.add("08:00");
				if(tempString.substring(0, 2).equals("10")||tempString.substring(0, 2).equals("11"))
					processedInfo.add("10:00");
				if(tempString.substring(0, 2).equals("12")||tempString.substring(0, 2).equals("13"))
					processedInfo.add("12:00");
				if(tempString.substring(0, 2).equals("14")||tempString.substring(0, 2).equals("15"))
					processedInfo.add("14:00");
				if(tempString.substring(0, 2).equals("16")||tempString.substring(0, 2).equals("17"))
					processedInfo.add("16:00");
				if(tempString.substring(0, 2).equals("18")||tempString.substring(0, 2).equals("19"))
					processedInfo.add("18:00");
				if(tempString.substring(0, 2).equals("20")||tempString.substring(0, 2).equals("21"))
					processedInfo.add("20:00");
				
				tempString = info.get(i+2);
				//System.out.println(i);
				processedInfo.add("D"+tempString.substring(0, tempString.indexOf("£¨")));
				//i = i + 2;
			}
		}
		
		for(int i = 0; i < processedInfo.size(); i++)
		{
			System.out.println(processedInfo.get(i));
		}
		System.out.println(processedInfo.size());
		return processedInfo;
		
	}
}
