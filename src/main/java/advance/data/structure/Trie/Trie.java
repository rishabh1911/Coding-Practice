package advance.data.structure.trie;

/**
 * A Trie node. It has 2 members.<br> 
 *  1. <code>trieNodes:</code> links to tries nodes which append it.<br>
 *  2. <code>isCompleted:</code> denotes a word completes at this node in trie or not.
 *  <br><br>
 *  It in itself doesn't contain any character but the link itself gives character info. 
 *  The below implementation is for a-z words only
 * @author Rishabh Agarwal
 */
class TrieNode {
	
	public static int NUMBER_OF_ALPHABETS = 26;
	
	public final TrieNode[] trieNodes = new TrieNode[NUMBER_OF_ALPHABETS];
	
	private boolean isTerminatingCharacter;
	
	public TrieNode next(char c) {
		if( c <'a' || c>'z')
			throw new IllegalArgumentException();
		return trieNodes[ c-'a' ];
	}
	
	public TrieNode addNextNode(char c,TrieNode childrenNode) {
		if( c <'a' || c>'z')
			throw new IllegalArgumentException();
		return this.trieNodes[ c-'a' ] = childrenNode;
	}

	public boolean isTerminatingCharacter() {
		return isTerminatingCharacter;
	}

	public void setTerminatingCharacter(boolean isTerminatingCharacter) {
		this.isTerminatingCharacter = isTerminatingCharacter;
	}
	
	
}

/**
 * This is a <code>Trie</code> data structure which has a trie node. 
 * The <code>root</code> is entirely empty. but used as reference to reach other nodes.
 * @author  Rishabh Agarwal
 */
public class Trie {
	
	final TrieNode root;
	
	Trie() {
		this.root = new TrieNode();
	}
	
	/**
	 * Checks if the given word is present in string or not.
	 * @param word to be checked if present in trie
	 */
	public boolean isWordPresent(String word) {
		boolean isPresent = true;
		TrieNode current = root;
		for(int i=0; i<word.length() ;i++) {
			current = current.next( word.charAt(i) );
			if(current == null) {
				isPresent = false;
				return isPresent;
			}
		}
		return current.isTerminatingCharacter();
	}
	
	public void addWord(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length() ;i++) {
			if(current.next( word.charAt(i) ) == null) {
				current.addNextNode( word.charAt(i), new TrieNode());
			}
			current = current.next(word.charAt(i));
		}
		current.setTerminatingCharacter(true);
	}
	
	/**
	 * We can do that if a node has no children ahead, we can remove that.<br>
	 * In that case useless nodes will not be present and Trie can be used for Prefix search also.<br>
	 * This will reduce space used and prefix search will be faster but will make code complicated<br>
	 * 
	 * Better option for prefix search if we go ahead with this implementation then, after going to last node of prefix we can check 
	 * id this node or any other subnodes from this is terminating node.
	 * @param word
	 */
	public void removeWord(String word) {
		TrieNode current  = root;
		for(int i=0; i<word.length(); i++) {
			current = current.next( word.charAt(i) );
			if(current == null) // word is not present.
				return;
		}
		current.setTerminatingCharacter(false);
	}
	
	public void updateWord(String oldWord, String newWord) {
		removeWord(oldWord);
		addWord(newWord);
	}
}

