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

	public StringParsingProblem() {

		// * 1. Number of miles from the center of the city
		regexPattern.add("\\d");
		// * 2. Primary direction from the city as a single lower-case letter
		regexPattern.add(null);
		// * 3. Street number
		regexPattern.add("\\d");
		// * 4. Street name (always a single word)
		regexPattern.add(null);
		// * 5. An abbreviation for either a Street or Avenue with a period
		regexPattern.add("(St|Ave).");
	}

	/**
	 * Returns true if the address is valid, otherwise false.
	 * 
	 * @param address
	 *            the address to validate
	 * @return true if the address is valid
	 */

	public boolean isAddressValid(String address) {
		String addressNew = address.replace(" ", "");
		if (addressNew.matches("\\W|_"))// if addressNew has non-word character
										// or _:
		{
			return false;// now addressNew only have : [a-zA-Z0-9]
		}
		String[] alphaParts = addressNew.split("( |\\d)");
		String[] digitParts = addressNew.split("\\D");
		if ((alphaParts.length != 3) || (digitParts.length != 2)) {
			return false;
		} else {
			return digitParts[0].matches(regexPattern.get(0))
					&& alphaParts[0].matches(regexPattern.get(1))
					&& digitParts[1].matches(regexPattern.get(2))
					&& alphaParts[1].matches(regexPattern.get(3))
					&& alphaParts[2].matches(regexPattern.get(4));

		}
	}

	/**
	 * Get the distance in miles from the center of the city from the given
	 * address.
	 * 
	 * @param address
	 *            the address
	 * @return the distance
	 */
	public int getDistanceFromCityCenter(String address) {
		if (isAddressValid(address)) {
			String[] digitParts = address.split("\\D");
			return Integer.parseInt(digitParts[0]);
		} else {
			return Integer.MIN_VALUE;
		}
	}
}
