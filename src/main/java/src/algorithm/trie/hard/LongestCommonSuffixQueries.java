package src.algorithm.trie.hard;
//https://leetcode.com/problems/longest-common-suffix-queries/description/?envType=daily-question&envId=2026-05-28

//import src.algorithm.trie.Trie;

import java.util.Arrays;

public class LongestCommonSuffixQueries {
    public static void main(String[] args) {
        LongestCommonSuffixQueries lcsq = new LongestCommonSuffixQueries();
        String[] words = {"a","b"};
        String[] queries = {"a","b"};
        System.out.println(Arrays.toString(lcsq.stringIndices(words, queries)));
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        //initialize
        Trie node = new Trie();
        int[] res = new int[wordsQuery.length];
        int minLen = Integer.MAX_VALUE;
        int minLenIndex = 0;

        //load Trie
        for(int i=0;i<wordsContainer.length;i++){
            if(wordsContainer[i].length()<minLen){
                minLen = wordsContainer[i].length();
                minLenIndex = i;
            }
            node.add(wordsContainer[i],i);
        }

        //check Trie
        for(int i=0;i<wordsQuery.length;i++){
            String qWord = wordsQuery[i];
            int lastLetter = qWord.charAt(qWord.length()-1) - 'a';
            if(node.children[lastLetter] == null){
                res[i] = minLenIndex;
            }else
                res[i] = node.getSuffix(qWord);
        }
        return res;
    }
}

class Trie {
    Trie[] children = new Trie[26];
    int minLen = Integer.MAX_VALUE;
    int minLenIndex = 0;

    void add(String word,int idx){
        Trie node = this;
        int len = word.length();
        for(int i=word.length()-1;i>=0;i--){
            int letter = word.charAt(i) - 'a';
            if(node.children[letter] == null){
                node.children[letter] = new Trie();
                node.children[letter].minLen = len;
                node.children[letter].minLenIndex = idx;
            }
            node = node.children[letter];
            if(node.minLen>len){
                node.minLen = len;
                node.minLenIndex = idx;
            }
        }
    }

    int getSuffix(String word){
        Trie node = this;
        for(int i=word.length()-1;i>=0;i--){
            int letter = word.charAt(i) - 'a';
            if(node.children[letter] == null)
                break;
            node = node.children[letter];
        }
        return node.minLenIndex;
    }
}
