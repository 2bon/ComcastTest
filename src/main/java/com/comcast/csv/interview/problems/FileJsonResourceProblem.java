package com.comcast.csv.interview.problems;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.comcast.csv.meme.Meme;
import com.comcast.csv.meme.YoureDoingItWrongException;

/**
 * Read a list of {@link Meme}s from a JSON source file that might be on the
 * classpath or file system.
 */
public class FileJsonResourceProblem {

	/**
	 * Read a list of memes from a JSON file stored on the filesystem
	 * 
	 * @param file
	 *            the file to read
	 * @return the list of memes read
	 */
	public List<Meme> readFromFile(File file) throws YoureDoingItWrongException {
		List<Meme> memes = new ArrayList<Meme>();
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(file));

			JSONArray jArray = (JSONArray) obj;

			// loop array
			if (jArray != null) {
				for (int i = 0; i < jArray.size(); i++) {
					Meme meme = (Meme) jArray.get(i);
					if (meme == null) {
						throw new YoureDoingItWrongException(
								"Load Meme fails,  meme == null ");
					} else {
						memes.add(meme);

					}
				}
			}
		} catch (FileNotFoundException e) {
			throw new YoureDoingItWrongException("Load Meme fails, ", e);
		} catch (IOException e) {
			throw new YoureDoingItWrongException("Load Meme fails, ", e);
		} catch (ParseException e) {
			throw new YoureDoingItWrongException("Load Meme fails, ", e);
		}
		return memes;

	}

	/**
	 * Read a list of memes from a JSON file stored on the classpath
	 * 
	 * @param path
	 *            the path to the resource
	 * @return the list of memes read
	 */
	public List<Meme> readFromClasspath(String path)
			throws YoureDoingItWrongException {
		File file = new File(path);
		return readFromFile(file);
	}

}
