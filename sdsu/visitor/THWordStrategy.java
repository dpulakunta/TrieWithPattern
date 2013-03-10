package com.adv.sdsu.visitor;

public class THWordStrategy implements Strategy {
	private String elements = new String();

	@Override
	public boolean findWords(String currentWord) {
		elements = currentWord;
		if (elements.contains("th"))
			return true;
		return false;
	}
}
