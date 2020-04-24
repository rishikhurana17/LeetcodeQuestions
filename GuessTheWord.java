package LeetcodePrograms;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Rishi Khurana
 */
public class GuessTheWord {
    class Master{

        public int guess(final String w) {
            return -1;
        }
    }

    public void findSecretWord(List<String> wordList , Master master){
        int i=0;
        while( i < 10){
            String w = random_word(wordList);
            int matched_count = master.guess(w);
            wordList = remove_candidate(w,matched_count , wordList);
        }
    }

    private List<String> remove_candidate( String w,  int matched_count, final List<String> wordList) {
        List<String> newWordList = new ArrayList<>();
        for(String word : wordList){
            int matched = 0;
            for(int i=0 ; i < 6 ; i++){
                if(word.charAt(i)== w.charAt(i)){
                    matched+=1;
                }
            }
            if(matched == matched_count || (matched ==0 && matched_count==-1)){
                newWordList.add(word);
            }
        }
        return newWordList;
    }

    private String random_word(final List<String> wordList) {
        return null;

    }
}
