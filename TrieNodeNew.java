package LeetcodePrograms;

import java.util.HashMap;

/**
 * Created by rkhurana on 3/3/19.
 */
public class TrieNodeNew {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNodeNew() {
        children = new HashMap<>();
        isWord = false;
    }

}
