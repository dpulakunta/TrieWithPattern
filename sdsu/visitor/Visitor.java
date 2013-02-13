package com.adv.sdsu.visitor;

public abstract class Visitor {
	abstract void visitNullNode(NullNode n);
	abstract void visitNonWordNode(NonWordNode n);
	abstract void visitWordNode(WordNode w);
}
