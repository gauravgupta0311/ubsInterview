package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.Collections;

public class BerlinTime implements TimeConverter{

	
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	
	@Override
	public String convertTime(String aTime) {
		
		String[] times = aTime.split(":");
		int hours =  Integer.parseInt(times[0]);
		int minutes = Integer.parseInt(times[1]);
        int seconds = Integer.parseInt(times[2]);
		
        String firstRow = seconds % 2 == 0 ? "Y" : "0";
        String secondRow = getBerlinFormatTime(hours / 5, 4, "R");
        String thirdRow = getBerlinFormatTime(hours % 5, 4, "R");
        String fourthRow = getBerlinFormatTime(minutes / 5, 11, "Y").replaceAll("YYY", "YYR");
        String fifthRow = getBerlinFormatTime(minutes % 5, 4, "Y");
		
		return String.join(NEW_LINE, Arrays.asList(firstRow, secondRow, thirdRow, fourthRow, fifthRow));
	}
	
	private String getBerlinFormatTime(int count, int totalLamps, String symbol){
		int remainingLamps = totalLamps - count;
		
        String on = String.join("", Collections.nCopies(count, symbol));
        String off = String.join("", Collections.nCopies(remainingLamps, "0"));
        return on + off;
	}
	
}
