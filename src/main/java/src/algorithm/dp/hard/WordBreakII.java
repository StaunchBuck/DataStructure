package src.algorithm.dp.hard;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        WordBreakII o = new WordBreakII();
        System.out.println(o.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Map<Integer,List<List<String>>> dp = new HashMap<>();
        for(List<String> subList: determine(0,s,wordDict,dp)){
            res.add(String.join(" ",subList));
        }
        return res;
    }

    public List<List<String>> determine(int pos,String s,List<String> wordDict,Map<Integer,List<List<String>>> dp){
        if(dp.containsKey(pos)){
            return dp.get(pos);
        }
        List<List<String>> currList = new ArrayList<>();
        for(String word:wordDict){
            List<List<String>> tempList = new ArrayList<>();
            if(s.startsWith(word,pos)){
                if(pos+word.length() == s.length()){
                    List<String> l = new ArrayList<>(List.of(word));
                    tempList.add(l);
                }else{
                    for(List<String> subList:determine(pos+word.length(),s,wordDict,dp)){
                        List<String> copy = new ArrayList<>(subList);
                        copy.add(0,word);
                        tempList.add(copy);
                    }
                }
                currList.addAll(tempList);
            }
        }
        dp.put(pos,currList);
        return dp.get(pos);
    }
}