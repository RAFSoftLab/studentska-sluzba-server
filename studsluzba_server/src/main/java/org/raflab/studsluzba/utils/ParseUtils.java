package org.raflab.studsluzba.utils;

public class ParseUtils {
	
	/*
	 * dobija indeks oblika rn1923 i vraca niz stringova [RN,19,23]
	 */
	public static String[] parseIndeks(String indeksShort) {	
		if(indeksShort.length()<5) return null;
		String[] retVal = new String[3];		
		indeksShort = indeksShort.toUpperCase();
		StringBuilder sb = new StringBuilder();
		// stud program
		int i = 0;
		while(Character.isAlphabetic(indeksShort.charAt(i))){
			sb.append(indeksShort.charAt(i++));
		}
		if(i>=indeksShort.length()) return null;
		retVal[0] = sb.toString();
		sb.setLength(0);		
		// godina
		sb.append(indeksShort.charAt(i++));
		sb.append(indeksShort.charAt(i++));		
		retVal[1] = sb.toString();
		sb.setLength(0);		
		while(i<indeksShort.length()) {
			sb.append(indeksShort.charAt(i++));			
		}		
		retVal[2] = sb.toString();		
		return retVal;		
	}

}
