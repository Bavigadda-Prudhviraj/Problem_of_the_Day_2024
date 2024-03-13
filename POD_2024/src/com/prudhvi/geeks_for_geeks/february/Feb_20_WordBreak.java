package com.prudhvi.geeks_for_geeks.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Feb_20_WordBreak {

	public static void main(String[] args) {
		String s = "applepenapple";
		List<String> dictionary = new ArrayList<>(Arrays.asList("apple","pen"));
		System.out.println(wordBreak(s, dictionary));;

	}
	public static boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for(String str : wordDict)
            root.insert(root, str);
        return helper(s,root);
        
    }
	public static boolean helper(String str, Trie root) {
		if (str.length() == 0) {
			return true;
		}
		Trie current = root;
		for (int i = 0; i < str.length(); i++) {
			if(current.child[str.charAt(i) - 'a']== null)
					return false;
			current = current.child[str.charAt(i) - 'a'];
			if (current.isEnd && helper(str.substring(i + 1), root)) {
				return true;
			}
			

		}
		return false;
	}
//	public static boolean wordBreak(String A, ArrayList<String> B ){
//		Trie root = new Trie();
//        for(String str : B)
//            root.insert(root, str);
//        return helper(0, A,root);
//    }
//
//	public static boolean helper(int index, String str, Trie root) {
//		if (str.length() == 0) {
//			return true;
//		}
//		Trie current = root;
//		for (int i = 0; i < str.length(); i++) {
//			if(current.child[str.charAt(i) - 'a']== null)
//					return false;
//			current = current.child[str.charAt(i) - 'a'];
//			if (current.child[str.charAt(i) - 'a'].isEnd && helper(i + 1, str.substring(i + 1), root)) {
//				return true;
//			}
//			
//
//		}
//		return false;
//	}
	

}
class Trie{
	Trie[] child;
	boolean isEnd;
	int letterFrequency;
	public Trie() {
		child = new Trie[26];
		isEnd = false;
		letterFrequency = 0;
	}
	public void insert(Trie root, String str) {
		Trie current = root;
		for(int i = 0; i < str.length(); i++) {
			if(current.child[str.charAt(i)-'a'] == null){
				current.child[str.charAt(i)-'a'] = new Trie();
			}
			current = current.child[str.charAt(i)-'a'];
		}
		current.isEnd = true;
	}
	public static boolean isWordExist(Trie root, String word) {
		Trie temp=root;
		for(int i=0;i<word.length();i++) {
			int charIndex=word.charAt(i)-'a';
			if(temp.child[charIndex]==null) {
				return false;
			}
			temp=temp.child[charIndex];
		}
		return temp.isEnd;
	}

}
