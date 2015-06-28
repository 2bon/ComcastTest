package com.comcast.csv.interview.problems;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * Using absolute coordinates for EVERYTHING, implement the following methods to
 * position the inner rectangle relative to the outer rectangle.
 */
public class PojoAlgProblem {

	/**
	 * Put the inner rectangle so that it's bottom right corner aligns with the
	 * bottom right corner of the outer rectangle.
	 * 
	 * @param inner
	 *            the inner rectangle to position
	 * @param outer
	 *            the outer rectangle to use as a reference
	 */
	public void bottomRight(Rectangle inner, Rectangle outer) {

		double HeightDiff = outer.getHeight() - inner.getHeight();// HeightDiff>=0
		int newY = 0;
		if (outer.getMaxY() >= 0) {
			newY = (int) (outer.getMaxY() - HeightDiff);
		} else {
			newY = (int) (outer.getMaxY() + HeightDiff);
		}
		double widthDiff = outer.getWidth() - inner.getWidth();// widthDiff>=0
		int newX = 0;
		if (outer.getMaxX() >= 0) {
			newX = (int) (outer.getMaxX() - widthDiff);
		} else {
			newX = (int) (outer.getMaxX() + widthDiff);
		}
		inner.setLocation(newX, newY);
	}

	/**
	 * Put the inner rectangle so that it is centered vertically and
	 * horizontally
	 * 
	 * @param inner
	 *            the inner rectangle to position
	 * @param outer
	 *            the outer rectangle to use as a reference
	 */
	public void middleCenter(Rectangle inner, Rectangle outer) {

		double widthDiff = outer.getWidth() - inner.getWidth();// widthDiff>=0
		int newX = 0;
		if (outer.getMaxX() >= 0) {
			newX = (int) (outer.getMaxX() - widthDiff / 2);
		} else {
			newX = (int) (outer.getMaxX() + widthDiff);
		}
		double HeightDiff = outer.getHeight() - inner.getHeight();// HeightDiff>=0
		int newY = 0;
		if (outer.getMaxY() >= 0) {
			newY = (int) (outer.getMaxY() - HeightDiff / 2);
		} else {
			newY = (int) (outer.getMaxY() + HeightDiff);
		}
		inner.setLocation(newX, newY);
	}
}
