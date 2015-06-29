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
	 * 
	 * @param inner
	 *            the inner rectangle to position
	 * @param outer
	 *            the outer rectangle to use as a reference
	 */
	public static void showInfo(Rectangle inner, Rectangle outer) {

		System.out.println("  inner.getX()=" + inner.getX() + "  inner.getY()="
				+ inner.getY());
		System.out.println("  outer.getX()=" + outer.getX() + "  outer.getY()="
				+ outer.getY());
		System.out.println("  inner.getCenterX()=" + inner.getCenterX()
				+ "  inner.getCenterY()=" + inner.getCenterY());
		System.out.println("  outer.getCenterX()=" + outer.getCenterX()
				+ "  outer.getCenterY()=" + outer.getCenterY());

	}

	public static void bottomRight(Rectangle inner, Rectangle outer) {

		double HeightDiff = outer.getHeight() - inner.getHeight();// HeightDiff>=0
		int newY = (int) (outer.getY() + HeightDiff);// upper-left
														// ,getY()=getMinY()
		double widthDiff = outer.getWidth() - inner.getWidth();// widthDiff>=0
		int newX = (int) (outer.getX() + widthDiff);// upper-left
													// ,getX()=getMinX()
		inner.setLocation(newX, newY);
		showInfo(inner, outer);
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
	public static void middleCenter(Rectangle inner, Rectangle outer) {

		double HeightDiff = outer.getHeight() - inner.getHeight();// HeightDiff>=0
		int newY = (int) (outer.getY() + HeightDiff / 2);// getY()=getMinY()
		double widthDiff = outer.getWidth() - inner.getWidth();// widthDiff>=0
		int newX = (int) (outer.getX() + widthDiff / 2);// getX()=getMinX()
		inner.setLocation(newX, newY);
		showInfo(inner, outer);
	}

	public static void main(String[] args) {
		Rectangle inner = new Rectangle(2, 4);
		Rectangle outer = new Rectangle(6, 8, 16, 18);
		bottomRight(inner, outer);
		middleCenter(inner, outer);

	}
}
