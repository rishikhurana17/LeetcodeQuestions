package LeetcodePrograms;

public class WordNode2 {
    String word;
    int numSteps;
    WordNode2 pre;
 
    public WordNode2(String word, int numSteps, WordNode2 pre){
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
}
