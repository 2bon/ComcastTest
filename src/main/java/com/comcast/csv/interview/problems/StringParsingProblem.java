package com.comcast.csv.interview.problems;

import java.util.ArrayList;

/**
 * The following methods operate on street addresses in a particular format. The
 * format contains the following components:
 * 
 * 1. Number of miles from the center of the city 2. Primary direction from the
 * city as a single lower-case letter 3. Street number 4. Street name (always a
 * single word) 5. An abbreviation for either a Street or Avenue with a period
 * 
 * </h2>Example Valid Addresses</h2> 25w873 Apple St. 3n17 Special Ave. 0e34800
 * Main St.
 */
public class StringParsingProblem {
	private static ArrayList<String> regexPattern = new ArrayList<String>(5);
	private static String regex = "^\\d+(e|w|s|n){1}[1-9]\\d* [A-Za-z]+ (?i)(St|Ave)\\.$";

	public StringParsingProblem() {
		// * 1. Number of miles from the center of the city
		regexPattern.add("^\\d+$");// positive integers + 0
		// * 2. Primary direction from the city as a single lower-case letter
		regexPattern.add("^(e|w|s|n){1}$");// single letter of 4 candidates
		// * 3. Street number
		regexPattern.add("^[1-9]\\d*$");// positive integers
		// * 4. Street name (always a single word)
		regexPattern.add("^ [A-Za-z]+ $");
		// * 5. An abbreviation for either a Street or Avenue with a period
		regexPattern.add("^(?i)(St|Ave)\\.$");// case insensitive, period !=Any
												// character
	}

	public static void main(String[] args) {
		ArrayList<String> tList = new ArrayList<String>();
		tList.add("-25w8_7@m3 Apple St._@#");
		tList.add("  3n17 Special Ave.");
		tList.add("s");
		tList.add("23ew");
		tList.add("");
		tList.add("25w8_7@m3 Apple St._@#");
		tList.add("3n17 Special Ave.");
		tList.add("0e34800 Main St.");
		// * 1. Number of miles from the center of the city
		tList.add("-0e34800 Main St.");
		tList.add("-10e34800 Main St.");
		// * 2. Primary direction from the city as a single lower-case letter
		tList.add("0ew34800 Main St.");
		tList.add("0q34800 Main St.");
		// * 3. Street number
		tList.add("0e0 Main St.");
		tList.add("0e-34800 Main St.");
		// * 4. Street name (always a single word)
		tList.add("0e34800 Main da St.");
		tList.add("0e34800 Main_ca St.");
		// * 5. An abbreviation for either a Street or Avenue with a period
		tList.add("0e34800 Main Sta");
		tList.add("25w873 Apple St..");
		tList.add("0e34800 Main Avea.");
		tList.add("0e34800 Main Ave. ");
		tList.add("0e34800 Main avE.");
		tList.add("0e34800 Main ST.");
		tList.add("25w873 Apple AVE.");
		for (String t : tList) {
			System.out.println(" =" + isAddressValid(t) + " d="
					+ getDistanceFromCityCenter(t));
		}
	}

	/**
	 * Returns true if the address is valid, otherwise false.
	 * 
	 * @param address
	 *            the address to validate
	 * @return true if the address is valid
	 */

	public static boolean isAddressValid(String address) {
		System.out.println(address);
		return address.matches(regex);
		// String[] alphaParts = address.split("( |\\d)+");
		// String[] digitParts = address.split("\\D+");
		// if (alphaParts.length != 4) {
		// System.out.println(" Wrong:  alphaParts.length="
		// + alphaParts.length);
		// return false;
		// } else {
		// if (digitParts.length != 3) {
		// System.out.println(" Wrong:	digitParts.length="
		// + digitParts.length);
		// return false;
		// } else {
		// return digitParts[0].matches(regexPattern.get(0))
		// && alphaParts[0].matches(regexPattern.get(1))
		// && digitParts[1].matches(regexPattern.get(2))
		// && alphaParts[1].matches(regexPattern.get(3))
		// && alphaParts[2].matches(regexPattern.get(4));
		// }
		//
		// }
	}

	/**
	 * Get the distance in miles from the center of the city from the given
	 * address.
	 * 
	 * @param address
	 *            the address
	 * @return the distance
	 */
	public static int getDistanceFromCityCenter(String address) {
		if (isAddressValid(address)) {
			String[] digitParts = address.split("\\D");
			return Integer.parseInt(digitParts[0]);
		} else {
			return Integer.MIN_VALUE;
		}
	}

}
