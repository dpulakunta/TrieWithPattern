package com.adv.sdsu.visitor;

public class PatternVisitor extends Visitor {
	private String searchPattern = new String();
	
	public String getSearchPattern() {
		return searchPattern;
	}

	public void setSearchPattern(String searchPattern) {
		this.searchPattern = searchPattern;
	}

	@Override
	void visitNullNode(NullNode n) {


	}

	@Override
	void visitNonWordNode(NonWordNode n) {
		elementsInTheTrie.push(n);
		for(int i=0;i<26;i++){
			Node newNode =  n.getChildAt(i);
			newNode.accept(this);
		}
		elementsInTheTrie.pop();
	}

	@Override
	void visitWordNode(WordNode w) {
		elementsInTheTrie.push(w);
		String wordToStore = buildWord();
		if(wordToStore.contains(searchPattern))	
			wordsInTrie.add(wordToStore);
		for(int i=0;i<26;i++){
			Node newNode =  w.getChildAt(i);
			newNode.accept(this);
		}
		elementsInTheTrie.pop();
	}
	

}
