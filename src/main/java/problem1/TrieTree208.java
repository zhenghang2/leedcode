package problem1;

import java.util.HashMap;
import java.util.Map;

public class TrieTree208 {
  private TrieNode root;

  /** Initialize your data structure here. */
  public TrieTree208() {
    root = new TrieNode();
    root.wordEnd = false;
  }
  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode node = root;
    char[] ch = word.toCharArray();
    for (int i = 0; i<ch.length; i++) {
      Character c = new Character(ch[i]);
      if (!node.childdren.containsKey(c)) {
        node.childdren.put(c,new TrieNode());
//        node.wordEnd = false;
      }
      node = node.childdren.get(c);
    }
    node.wordEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode node = root;
    char[] ch = word.toCharArray();
    boolean found = true;
    for (int i = 0; i<ch.length; i++) {
      Character c = new Character(ch[i]);
      if (!node.childdren.containsKey(c)) {
        return false;
      }
      node = node.childdren.get(c);
    }
    return found && node.wordEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode node = root;
    boolean found = true;
    char[] ch = prefix.toCharArray();
    int i = 0;
    for (i=0; i<ch.length; i++) {
      Character c = new Character(ch[i]);
      if (!node.childdren.containsKey(c)) {
        return false;
      }
      node = node.childdren.get(c);
    }
    return found;
  }

  public class TrieNode {
    Map<Character,TrieNode> childdren;
    boolean wordEnd;

    public TrieNode() {
      childdren = new HashMap<Character, TrieNode>();
      wordEnd = false;
    }
  }

  public static void main(String[] args) {
    TrieTree208 tree = new TrieTree208();
    tree.insert("apple");
//    tree.insert("app");
    System.out.println(tree.search("apple"));
    System.out.println(tree.search("app"));
    System.out.println(tree.startsWith("app"));
  }
}
