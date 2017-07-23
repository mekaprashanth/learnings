package com.prash.java.sample.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMainMC2 {

	public static final String mc_id = "abcdefghijklmnopqrstuvwxyz";

	public static final String[] mc_cd = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };

	public static ArrayList<String> possibleAltCodes = new ArrayList<String>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the word:");
		String text = in.nextLine();
		int txtLength = text.length();

		String strMorseCd = getMorseCode(text);
		long start = System.currentTimeMillis();
		alternateMorseTexts(txtLength, strMorseCd, "", "");
		long end = System.currentTimeMillis();
		System.out.println("Time Taken :"+(end-start) +" ms");
		
		System.out.println("Morse Code :" + strMorseCd);
		System.out.println("Total : " + possibleAltCodes.size());
		
		if (in != null)
			in.close();

	}

	private static String getMorseCode(String text) {
		StringBuilder sb = new StringBuilder();
		int txtLength = text.length();

		for (int i = 0; i < txtLength; i++) {
			int pos = mc_id.indexOf(text.charAt(i));
			sb.append(mc_cd[pos]);
		}
		return sb.toString();
	}
	
	private static void alternateMorseTexts(int textLength, String textToMatch, String altText, String PrevTextToMatch)
	{
		PrevTextToMatch = textToMatch;
        if(textToMatch == null || textToMatch.length() == 0) {
        	if(altText.length() == textLength)
        	{
        		System.out.println("MATCHED TEXT :"+altText);
        		possibleAltCodes.add(altText);
        	}
        } else {
            for(int i = 0; i < mc_cd.length; i++) {
            	String tmp = mc_cd[i];
            	if(textToMatch.indexOf(tmp)==0)
            	{
            		String nextText = altText + mc_id.charAt(i);
            		alternateMorseTexts(textLength, textToMatch.substring(tmp.length()),nextText,PrevTextToMatch);
            		textToMatch = PrevTextToMatch;
            	}
            }
        }
	}
	
}
