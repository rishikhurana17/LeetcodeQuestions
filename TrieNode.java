package leetcode;
import java.util.*;

/**
 * Created by rkhurana on 7/21/18.
 */
public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }
}
