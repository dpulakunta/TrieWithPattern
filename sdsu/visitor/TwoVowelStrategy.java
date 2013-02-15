package com.adv.sdsu.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class TwoVowelStrategy implements Strategy {

	private String[] elements;

	@Override
	public boolean findWords(String currentWord) {

		int count = 0;
		int index = 0;

		if (currentWord.contains("a"))
			count++;
		if (currentWord.contains("e"))
			count++;
		if (currentWord.contains("i"))
			count++;
		if (currentWord.contains("o"))
			count++;
		if (currentWord.contains("u"))
			count++;
		if (count >= 3)
			return true;

		return false;
	}
}