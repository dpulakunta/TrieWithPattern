package com.adv.sdsu.visitor;

import java.util.ArrayList;
import java.util.Stack;

public class AllWordsVisitor extends Visitor {



	@Override
	void visitWordNode(WordNode w) {
		elementsInTheTrie.push(w);
		wordsInTrie.add(buildWord());
		for(int i=0;i<26;i++){
			Node newNode =  w.getChildAt(i);
			newNode.accept(this);
		}
		elementsInTheTrie.pop();
	}

}
