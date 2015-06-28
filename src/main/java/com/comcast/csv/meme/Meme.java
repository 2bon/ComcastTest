package com.comcast.csv.meme;

import java.util.Comparator;

/**
 * Simple class used by various tests.
 */
public class Meme implements Comparable<Meme> {

	private String name;
	private int year;
	private String[] tags;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	// Way1 = Meme implements Comparable
	public int compareTo(Meme m2) {
		int ret = this.year - m2.getYear();
		return ret;
	}

	public int compareTo(Meme m2, boolean ascending) {
		if (ascending) {
			return compareTo(m2);
		} else {
			return -compareTo(m2);
		}
	}

	// Way2 = implements a new Comparator
	public static Comparator<Meme> MemeYearComparator = new Comparator<Meme>() {
		public int compare(Meme m1, Meme m2) {
			int ret = m1.getYear() - m2.getYear();
			return ret;
		}

		public int compare(Meme m1, Meme m2, boolean ascending) {
			if (ascending) {
				return compare(m1, m2);
			} else {
				return -compare(m1, m2);
			}
		}
	};
}
