/* ClassName : TestingIteratorTrie
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Reason: 
 * JUnit test to test the functionality
 * 
 * 
 * Class variables: 
 * myTestTrie : which is a Trie object used to test
 * add
 * contains
 * toString
 * FindWordsWithCK
 * 
 */
package com.adv.sdsu;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class TestingIteratorTrie {
	Trie myTestTrie =  new Trie();
	@Test
	public void test() {
		assertEquals(true, myTestTrie.add("dog"));
		assertEquals(true, myTestTrie.add("dodge"));
		assertEquals(true, myTestTrie.add("cat"));
		assertEquals(true, myTestTrie.add("catering"));
		assertEquals(true, myTestTrie.add("attack"));
		assertEquals(false,myTestTrie.add(""));

		assertEquals(true, myTestTrie.contains("dog"));
		assertEquals(false, myTestTrie.contains("cogs"));
		
		assertEquals("[attack, cat, catering, dodge, dog]", myTestTrie.toString());
		
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
