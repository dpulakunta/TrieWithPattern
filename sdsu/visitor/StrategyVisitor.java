/* ClassName : StrategyVisitor
 * 
 * Created by: Dharmendhar Pulakunta
 * Red ID: 816324464
 * 
 * Class variables: 
 * algoToFind 
 * 
 * Most of the functionality is in the base class we are providing
 * only the functionality required for this visitor 
 */
package com.adv.sdsu.visitor;

public class StrategyVisitor extends Visitor {
	private Strategy algoToFind;

	public Strategy getAlgoToFind() {
		return algoToFind;
	}

	public void setAlgoToFind(Strategy algoToFind) {
		this.algoToFind = algoToFind;
	}

	public StrategyVisitor(Strategy findWord) {
		algoToFind = findWord;
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
	void visitWordNode(WordNode n) {
		elementsInTheTrie.push(n);
		//Very Imp strategy pattern to find different algorithm
		if (algoToFind.findWords(buildWord()))
			wordsInTrie.add(buildWord());

		for (int i = 0; i < 26; i++) {
			Node newNode = n.getChildAt(i);
			newNode.accept(this);
		}
		elementsInTheTrie.pop();

	}

}
