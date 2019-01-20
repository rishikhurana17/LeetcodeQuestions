/**
 * Created by rkhurana on 12/12/18.
 */

package LeetcodePrograms;
// Q1 > to print the count of all the

import java.util.*;


class TrieAutocomplete {

    static class Autocomplete {

        class Node {
            public Map<Character, Node> children = new HashMap<>();
            public Map<Integer,String> wordTreeMap = new TreeMap<>();
        }

        Node root = new Node();

        public void addWord(String word,int count) {
            Node p = root;
            for (char c : word.toCharArray()) {
                if (!p.children.containsKey(c)) {
                    p.children.put(c, new Node());
                }
                p = p.children.get(c);
                p.wordTreeMap.put(count, word);

            }
        }

        public List<String> search(String query) {
            Node p = root;
            for (char c : query.toCharArray()) {
                if (!p.children.containsKey(c)) {
                    return Collections.emptyList();
                }
                p = p.children.get(c);
            }

            List<String> words = new ArrayList<String>();

            words.addAll(p.wordTreeMap.values());
            //Collections.sort(words, Collections.reverseOrder()); //this doesnt work
            Collections.reverse(words);
            return words;
        }

        public void printAllHits(Node root, String prefix) {
            if(root == null)
                return;
            for(char c : root.children.keySet()) {
                System.out.println(prefix + c + " => "+ root.children.get(c).wordTreeMap.size());
                printAllHits(root.children.get(c), "" + prefix + c);
            }
        }

    }

    public static void main(String[] args) {
        Autocomplete a = new Autocomplete();
        a.addWord("app", 10);
        a.addWord("apple", 1000);
        a.addWord("ant", 100);
        a.addWord("ape", 1000000);
        a.addWord("apple2", 1000000000);
        a.addWord("alpha", 1);
        a.addWord("badger", 1);

        System.out.println("Search for query a in descending order is " + a.search("a"));  //[apple2, ape, apple,ant,app,alpha]

        System.out.println("All Hits print");
        // "z" -> no hits
        // "a" -> 6 hits
        // "b" -> 1 hits
        // "an" -> 1
        // "ap" -> 4

        a.printAllHits(a.root, "");


        String query = "a";

        System.out.println("QUERY:\t" + query);
        System.out.print("RESULT:\t");
        for (String x : a.search(query)) {
            System.out.print(x + " ");
        }
        System.out.println();
    }


}