package src.algorithm.bitmasking;

import java.util.ArrayList;
import java.util.List;

public class BitMaskSubsetSum {


    public static void main(String[] args) {

        List<String> answer = new ArrayList<>();
        String s = "abc";
        int n = s.length();

        for(int mask=0;mask<(1<<n);mask++){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                if(((1<<i) & mask) > 0 ){
                    sb.append(s.charAt(i));
                }
            }
            answer.add(sb.toString());
        }
        answer.forEach(System.out::println);
    }
}
