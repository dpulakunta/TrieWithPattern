package com.adv.sdsu.visitor;

public class TraverseVisitor extends Visitor {
	String word= new String();
	@Override
	void visitNullNode(NullNode n) {
		return;
		
	}

	@Override
	void visitNonWordNode(NonWordNode n) {
		word = word + n.letter;
		
	}

	@Override
	void visitWordNode(WordNode w) {
		word = word + w.letter;
		
	}

}
