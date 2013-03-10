/* ClassName : PatternVisitor
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 *
 * 
 * Class variables: 
 * searchPattern 
 * 
 * Most of the functionality is in the base class we are providing
 * only the functionality required for this visitor 
 */
package com.adv.sdsu.visitor;

public class PatternVisitor extends Visitor {
	private String searchPattern=new String();
	public PatternVisitor() {
		
	}
	public  PatternVisitor(String string) {
		searchPattern = string;
	}
	
	public String getSearchPattern() {
		return searchPattern;
	}

	public void setSearchPattern(String searchPattern) {
		this.searchPattern = searchPattern;
	}
	/* Function name: visitWordNode
	 * 
	 * Input: WordNode
	 * 
	 * Output: none
	 * 
	 * We add the node into the stack we build the word as the  
	 * visitor has reached the word. Build the word using the nodes on
	 * the stack, find the child for the current node and call the recursion
	 */
	@Override
	void visitWordNode(WordNode w) {
		//Push the currentNode into the node
		elementsInTheTrie.push(w);
		//build the word from the elements on the stack
		String wordToStore = buildWord();
		
		//if there is pattern match add to arrayList
		if (wordToStore.contains(searchPattern))
			wordsInTrie.add(wordToStore);
		
		for (int i = 0; i < 26; i++) {
			//on each of the child we are calling recursion by 
			//calling visitor's accept method
			Node newNode = w.getChildAt(i);
			newNode.accept(this);
		}
		//we are poping the element after creating the word and 
		//recursion is complete
		elementsInTheTrie.pop();
	}

}
