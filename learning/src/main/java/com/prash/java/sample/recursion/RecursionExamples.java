package com.prash.java.sample.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RecursionExamples {

	public static Map<Character, String> loadMorseCode() {
		@SuppressWarnings("serial")
		Map<Character, String> morseMap = new HashMap<Character, String>() {
			{
				put('a', ".-");
				put('h', "....");
				put('o', "---");
				put('v', "...-");
				put('b', "-...");
				put('i', "..");
				put('p', ".--.");
				put('w', ".--");
				put('c', "-.-.");
				put('j', ".---");
				put('q', "--.-");
				put('x', "-..-");
				put('d', "-..");
				put('k', "-.-");
				put('r', ".-.");
				put('y', "-.--");
				put('e', ".");
				put('l', ".-..");
				put('s', "...");
				put('z', "--..");
				put('f', "..-.");
				put('m', "--");
				put('t', "-");
				put('g', "--.");
				put('n', "-.");
				put('u', "..-");
			}
		};
		return morseMap;
	}
	public static void findCombination(String s, int i, String temp, int n, Map<String, Character> reverseMap, int maxChars)	{
		temp = temp+s.charAt(i);
		if(i == n-1)	{
			printPossibleMorseCodes(temp, maxChars, reverseMap);
			return;
		}
		findCombination(s, i+1, temp,n, reverseMap, maxChars);
		temp = temp+" ";
		findCombination(s, i+1, temp,n, reverseMap, maxChars);
	}
	
	public static void printPossibleMorseCodes(final String code, final int maxChars, final Map<String, Character> reverseMap){
		String[] tempArr = code.split("\\s");
		if(tempArr.length != maxChars)	{
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(String s : tempArr)	{
			Character c = reverseMap.get(s);
			if(c == null)	{
				sb.setLength(0);
				break;
			}
			sb.append(c);
		}
		if(sb.length() > 0)	{
			System.out.println(sb.toString());
		}
	}
	public static void main(String[] args) {
		Map<Character, String> morseMap = loadMorseCode();
		Map<String, Character> reverseMap = morseMap.entrySet()
				.stream()
				.collect(Collectors.toMap(c->c.getValue(), c->c.getKey()));
		String inputStr = "prashanth";
		String symbols="";
		for(char c:inputStr.toCharArray())	{
			symbols+=morseMap.get(c);
		}
		System.out.println("Morse code for given input "+inputStr+" is "+symbols);
		
		findCombination(symbols, 0, "", symbols.length(), reverseMap, inputStr.length());
	}
}
