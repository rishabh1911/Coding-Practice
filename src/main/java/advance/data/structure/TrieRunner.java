package advance.data.structure;

import java.util.ArrayList;

public class TrieRunner {

	public static void main(String[] args) {
	
		ArrayList<String> dictionary = new ArrayList<>();
		dictionary.add("apple");
		dictionary.add("banana");
		dictionary.add("app");
		dictionary.add("mango");
		dictionary.add("application");
		
		Trie trie = new Trie();
		
		dictionary.stream().forEach( word -> trie.addWord(word));
		
		System.out.println(  trie.isWordPresent(dictionary.get(0)));
		System.out.println(  trie.isWordPresent(dictionary.get(1)));
		System.out.println(  trie.isWordPresent(dictionary.get(2)));
		System.out.println(  trie.isWordPresent(dictionary.get(3)));
		System.out.println(  trie.isWordPresent(dictionary.get(4)));
		
		System.out.println("------------------------");
		System.out.println(  trie.isWordPresent("papaya"));
		System.out.println(  trie.isWordPresent("ap"));

	}

}
