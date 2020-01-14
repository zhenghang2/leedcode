package problem1;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

  private TreeNode root;

  private static final String ALL = ".";
  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new TreeNode();
    root.wordEnd = false;
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TreeNode node = root;
    char[] ch = word.toCharArray();
    for (int i=0; i<ch.length; i++) {
      Character c = new Character(ch[i]);
      if (!node.childdren.containsKey(c)) {
        node.childdren.put(c,new TreeNode());
      }
      node = node.childdren.get(c);
    }
    node.wordEnd = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return searchHelper(word,root);
  }

  public boolean searchHelper(String word, TreeNode root1) {
    char[] ch = word.toCharArray();
    TreeNode node = root1;
    for (int i=0; i<ch.length; i++) {
      if (ch[i] == '.') {
        for (Character c : node.childdren.keySet()) {
          if (searchHelper(word.substring(i+1),node.childdren.get(c)))
            return true;
        }
        return false;
      } else {
        Character c = new Character(ch[i]);
        if (!node.childdren.containsKey(c)) {
          return false;
        }
        node = node.childdren.get(c);
      }
    }
    return node.wordEnd;
  }

  public class TreeNode {
    Map<Character, TreeNode> childdren;
    boolean wordEnd;

    public TreeNode() {
      childdren = new HashMap<Character,TreeNode>();
      wordEnd = false;
    }
  }

  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
    wd.addWord("apple");
    wd.addWord("app");
    System.out.println(wd.search("..s"));
  }
}
