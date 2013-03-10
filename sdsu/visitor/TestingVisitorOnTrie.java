package com.adv.sdsu.visitor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;


public class TestingVisitorOnTrie {
	Trie myTestTrie =  new Trie();
	PatternVisitor testMyPattern = new PatternVisitor("ck");
	Strategy twoVowelStrategy = new TwoVowelStrategy();
	Strategy thStrategy = new THWordStrategy();
	StrategyVisitor findWords = new StrategyVisitor(twoVowelStrategy);

	
	@Test
	public void test() {
		
		assertEquals(true, myTestTrie.add("hi"));
		assertEquals(true, myTestTrie.add("hey"));
		assertEquals(true, myTestTrie.add("hello"));
		assertEquals(true, myTestTrie.add("catering"));
		assertEquals(true, myTestTrie.add("attack"));
		assertEquals(true, myTestTrie.add("they"));
		assertEquals(false,myTestTrie.add(""));
		
		String wordsOnTrie = myTestTrie.toString();
		//assertEquals("[attack, catering, hello, hey, hi, they]",wordsOnTrie);

		//assertEquals(false, myTestTrie.contains("dog"));
		//assertEquals(true, myTestTrie.contains("attack"));
		
		//Test case for CK
		myTestTrie.accept(testMyPattern);
		ArrayList<String> wordsOnArrayList = testMyPattern.getWordsInTrie();
		String word = wordsOnArrayList.get(0).toString();
		//assertEquals("attack", word);
		
		//Test case strategy1
		myTestTrie.accept(findWords);
		wordsOnArrayList = findWords.getWordsInTrie();
		word = wordsOnArrayList.get(0);
		//assertEquals("catering", word);
		
		//Test case strategy2
		findWords = new StrategyVisitor(thStrategy);
		myTestTrie.accept(findWords);
		wordsOnArrayList = findWords.getWordsInTrie();
		word = wordsOnArrayList.get(0);
		//assertEquals("they", word);
		
	}
}
