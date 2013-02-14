package com.adv.sdsu.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class THWordStrategy implements Strategy {
	private String[] elements = new String[100];

	@Override
	public boolean findWords(String currentWord) {
		if(currentWord.contains("th"))
			return true;
		return false;
	}
}
