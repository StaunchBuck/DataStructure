package src.leetcode.home.tech.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak {
    public Set<String> startLetterSet = new HashSet<>();
    public Set<String> wordSet = new HashSet<>();
    public boolean found = false;
    public Set<Integer> blackListPos = new HashSet<>();
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(new WordBreak().wordBreak("applepenapple",list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        found = false;
        blackListPos = new HashSet<>();
        startLetterSet = wordDict.stream().map(word -> word.substring(0,1)).collect(Collectors.toSet());
        wordSet = new HashSet<>(wordDict);
        calculate(s,0);
        return found;
    }

    private void calculate(String s, int pos){
        if(pos==s.length()){
            found = true;
            return;
        }
        if(blackListPos.contains(pos) || !startLetterSet.contains(s.substring(pos,pos+1))){
            return;
        }else{
            for(int i = pos;i<s.length();i++){
                String sub = s.substring(pos,i+1);
                if(wordSet.contains(sub)){
                    calculate(s,i+1);
                    if(found){
                        break;
                    }
                }
            }
            if(!found)
                blackListPos.add(pos);
        }
    }
}
