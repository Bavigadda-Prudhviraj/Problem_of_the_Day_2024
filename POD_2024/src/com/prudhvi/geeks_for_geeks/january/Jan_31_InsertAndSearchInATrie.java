package com.prudhvi.geeks_for_geeks.january;

public class Jan_31_InsertAndSearchInATrie {
	/**
	 * Inserts a word into the Trie.
	 *
	 * @param root The root of the Trie.
	 * @param key  The word to be inserted.
	 */
	public static void insert(TrieNode root, String key) {
		for (int i = 0; i < key.length(); i++) {
			// Check if the current character's child node is null, create a new node if null.
			if (root.children[key.charAt(i) - 'a'] == null) 
				root.children[key.charAt(i) - 'a'] = new TrieNode();
			
			// Move to the child node.
			root = root.children[key.charAt(i) - 'a'];
		}
		// Mark the last node as the end of the inserted word.
		root.isEndOfWord = true;
	}

	/**
	 * Searches for a word in the Trie.
	 *
	 * @param root The root of the Trie.
	 * @param key  The word to be searched.
	 * @return True if the word is found, false otherwise.
	 */
	public static boolean search(TrieNode root, String key) {
		for (int i = 0; i < key.length(); i++) {
			// Check if the current character's child node is null, indicating the word is not present.
			if (root.children[key.charAt(i) - 'a'] == null) 
				return false;
			
			// Move to the child node.
			root = root.children[key.charAt(i) - 'a'];
		}
		// Check if the last node marks the end of a word.
		return root.isEndOfWord;
	}

}
/**
 * TrieNode class represents a node in the Trie data structure.
 */
class TrieNode {
    static final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    /**
     * Initializes a TrieNode.
     */
    TrieNode() {
        isEndOfWord = false;
        // Initialize children array with null values.
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }
}




