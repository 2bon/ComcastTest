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
		int newY = (int) (outer.getY() - HeightDiff);// upper-left
														// ,getY()=getMaxY()
		double widthDiff = outer.getWidth() - inner.getWidth();// widthDiff>=0
		int newX = (int) (outer.getX() + widthDiff);// upper-left
													// ,getX()=getMinX()
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

		double HeightDiff = outer.getHeight() - inner.getHeight();// HeightDiff>=0
		int newY = (int) (outer.getY() - HeightDiff / 2);// getY()=getMaxY()
		double widthDiff = outer.getWidth() - inner.getWidth();// widthDiff>=0
		int newX = (int) (outer.getX() + widthDiff / 2);// getX()=getMinX()
		inner.setLocation(newX, newY);
	}
}
