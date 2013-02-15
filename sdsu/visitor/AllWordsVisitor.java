package com.adv.sdsu.visitor;

public class AllWordsVisitor extends Visitor {

	@Override
	void visitWordNode(WordNode w) {
		elementsInTheTrie.push(w);
		wordsInTrie.add(buildWord());
		for (int i = 0; i < 26; i++) {
			Node newNode = w.getChildAt(i);
			newNode.accept(this);
		}
		elementsInTheTrie.pop();
	}

}
