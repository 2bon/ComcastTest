package com.comcast.csv.interview.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.comcast.csv.meme.Meme;

/**
 * Using all forms of loops and recursions to iterate over a {@link List} of
 * {@link Meme}s and log it's name and year. Format of the log message isn't
 * important.
 * 
 */
public class LoopProblem {
	public static void showInfo(Meme m) {
		if (m != null) {
			System.out.println("Meme " + " : " + m.getName() + ", Year : "
					+ m.getYear());
		} else {
		}
	}

	public static void forLoops(List<Meme> memes) {
		System.out.println("for");
		for (Meme m : memes) {
			showInfo(m);
		}
		for (int i = 0; i < memes.size(); i++) {
			showInfo(memes.get(i));
		}
		for (Iterator iterator = memes.iterator(); iterator.hasNext();) {
			Meme m = (Meme) iterator.next();
			showInfo(m);
		}
	}

	public static void whileLoops(List<Meme> memes) {
		System.out.println("while");
		Iterator<Meme> it = memes.iterator();
		while (it.hasNext()) {
			Meme m = it.next();
			showInfo(m);
		}

		int i = memes.size();
		while (i > 0) {
			i--;
			showInfo(memes.get(i));
		}

		Vector<Meme> mVector = new Vector<Meme>(memes);
		Enumeration<Meme> e = mVector.elements();
		while (e.hasMoreElements()) {
			Meme m = e.nextElement();
			showInfo(m);
		}
	}

	public static void doWhileLoops(List<Meme> memes) {
		System.out.println("doWHile");
		Iterator<Meme> it = memes.iterator();
		if (it.hasNext()) {
			do {
				Meme m = it.next();
				showInfo(m);
			} while (it.hasNext());
		} else {

		}

		int i = memes.size();
		if (i > 0) {
			do {
				i--;
				showInfo(memes.get(i));
			} while (i > 0);

		} else {

		}

		Vector<Meme> mVector = new Vector<Meme>(memes);
		Enumeration<Meme> e = mVector.elements();
		if (e.hasMoreElements()) {
			do {
				Meme m = e.nextElement();
				showInfo(m);
			} while (e.hasMoreElements());

		}
	}

	public static void main(String args[]) {
		List<Meme> Ms = new ArrayList<Meme>();
		for (int i = 1; i < 10; i++) {
			Meme m = new Meme();
			m.setName("m" + i);
			m.setYear((int) (Math.random() * 99));
			Ms.add(m);
		}
		new LoopProblem().forLoops(Ms);
		new LoopProblem().whileLoops(Ms);
		new LoopProblem().doWhileLoops(Ms);
	}
}
