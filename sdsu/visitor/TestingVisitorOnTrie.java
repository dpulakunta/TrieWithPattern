package com.adv.sdsu.visitor;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import com.adv.sdsu.Trie;

public class TestingVisitorOnTrie {
	Trie myTestTrie =  new Trie();
	
	@Test
	public void test() {
		assertEquals(true, myTestTrie.add("hi"));
		assertEquals(true, myTestTrie.add("hey"));
		assertEquals(true, myTestTrie.add("hello"));
		assertEquals(true, myTestTrie.add("catering"));
		assertEquals(true, myTestTrie.add("attack"));
		assertEquals(false,myTestTrie.add(""));

		assertEquals(false, myTestTrie.contains("dog"));
		assertEquals(true, myTestTrie.contains("hi"));
		
		assertEquals("[attack, catering, hello, hey, hi]", myTestTrie.toString());
		
		//Testing using iterator for words containing CK
		Iterator trieIterator = myTestTrie.iterator();
		String wordWithCK = new String();
		while(trieIterator.hasNext())
		{
			String newWord = (String) trieIterator.next();
			if(newWord.contains("ck"))
				wordWithCK= newWord;
		}
		assertEquals("attack",wordWithCK);
	}
}
