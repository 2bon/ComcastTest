package com.comcast.csv.interview.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.comcast.csv.meme.Meme;

/**
 * Implement the specified interface.
 */
public class CollectionsProblemImpl implements CollectionsProblem {

	public void sort(Collection<Meme> memes, boolean ascending) {
		List<Meme> memesArrayList = new ArrayList<Meme>(memes);
		// Way1 = Meme implements Comparable
		Collections.sort(memesArrayList);
		// Way2 = implements a new Comparator
		Arrays.sort((Meme[]) memes.toArray(), Meme.MemeYearComparator);

		if (ascending) {
		} else {
			Collections.reverse(memesArrayList);
		}
		memes = memesArrayList;
		showInfos(memes);
	}

	public void addTag(Collection<Meme> memes, String tag) {
		for (Meme tempMeme : memes) {
			String[] oldTags = tempMeme.getTags();
			if (oldTags.length > 0) {
				List<String> newTags = new ArrayList<String>(
						Arrays.asList(oldTags));// copy old tags
				newTags.add(tag);
				tempMeme.setTags((String[]) newTags.toArray());
			} else {

			}
		}

	}

	public static void showInfos(Collection<Meme> memes) {
		int i = 0;
		for (Meme tempMeme : memes) {
			System.out.println("Memes " + ++i + " : " + tempMeme.getName()
					+ ", Year : " + tempMeme.getYear());
		}

	}

	public static void main(String args[]) {
		Collection<Meme> Ms = new ArrayList<Meme>();
	}
}
