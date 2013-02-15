package com.adv.sdsu.visitor;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class TestTrie extends TestCase {
	Trie myTestTrie = new Trie();

	@Test
	@Before
	public void testAdd() {
		myTestTrie.add("dog");
		myTestTrie.add("dodge");
		myTestTrie.add("cat");
		myTestTrie.add("catering");
	}

	// @Test
	// public void testContains() {
	// assertEquals(true, myTestTrie.contains("dog"));
	// assertEquals(false, myTestTrie.contains("dogs"));
	// }
	// @Test
	// public void testToString() {
	// //System.out.println("testing"+myTestTrie.toString());
	// assertEquals("[dog, dodge, cat, catering]", myTestTrie.toString());
	// }
	@Test
	public void testIterator() {

	}

	@Test
	public void testFindck() {

	}
}
