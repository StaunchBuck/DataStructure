package src.leetcode.home.tech.problem;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void main(String[] args) {
		System.out.println(new GenerateParanthesis().generateParenthesis(3));
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("",0,0,n,result);
        return result;
    }
    
    public void generate(String temp,int open,int close,int n,List<String> result){
        if(open == close && open == n) { 
            result.add(temp);
            return;
        }
        
        if(open<n){
            generate(temp+"(",open+1,close,n,result);
        }
        if(close<open){
            generate(temp+")",open,close+1,n,result);
        }
    }
}
