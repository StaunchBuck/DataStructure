package src.algorithm.arrayAndstring.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression {

    public static void main(String[] args) {
        ParsingABooleanExpression p = new ParsingABooleanExpression();
        System.out.println(p.parseBoolExpr("|(f,f,f,t)")); //|(&(t,f,t),!(t))
    }
    public boolean parseBoolExpr(String s) {

        int len = s.length();
        Stack<Character> stack = new Stack<>();
        int pos = 0;
        while(pos<len){
            if(s.charAt(pos) != ')'){
                stack.push(s.charAt(pos));
                pos++;
            }else {
                pos++;
                List<Boolean> list = new ArrayList<>();
                while(stack.peek() != '('){
                    if(stack.peek() != ','){
                        list.add(evalBool(stack.pop()));
                    }else
                        stack.pop();
                }
                stack.pop(); // remove '('
                char operand = stack.pop(); //get operand
                boolean ans = performCal(list,operand);
                stack.push(ans ? 't' : 'f');
            }
        }
        return evalBool(stack.pop());
    }

    public boolean evalBool(char c){
        if(c == 'f')
            return false;
        if(c == 't')
            return true;
        return false;
    }

    public boolean performCal(List<Boolean> list,char c){
        if(c == '|')
            return list.stream().reduce(false, (a, b) -> a || b);
        else if(c == '&')
            return list.stream().reduce(true, (a, b) -> a && b);
        else if(c == '!'){
            return !list.get(0);
        }
        return false;
    }
}