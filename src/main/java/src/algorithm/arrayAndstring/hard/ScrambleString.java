package src.algorithm.arrayAndstring.hard;

public class ScrambleString {

    public static void main(String[] args) {
        ScrambleString s = new ScrambleString();
        System.out.println(s.isScramble("great","rgate"));
    }

    public boolean isScramble(String s1, String s2) {
        return calculate(s1,0,s1.length()-1,s2);
    }

    boolean calculate(String s1,int i,int j,String s2){
        System.out.println(s1 +" and "+i+" and "+j);
        if(i==j){
            return s1.charAt(0) == s2.charAt(i) ? true : false;
        }
        if(s1.equals(s2.substring(i,j+1)))
            return true;

        for(int k=0;k<s1.length()-1;k++){
            int len1 = k+1;
            int len2 = s1.length() - len1;

            //without swap
            boolean withoutLeft = calculate(s1.substring(0,k+1),i,i+len1-1,s2);
            boolean withoutRight = calculate(s1.substring(k+1,s1.length()),i+len1,j,s2);
            if(withoutLeft && withoutRight)
                return true;
            //with swap
            boolean withLeft = calculate(s1.substring(k+1,s1.length()),i,i+len2-1,s2);
            boolean withRight = calculate(s1.substring(0,k+1),i+len2,j,s2);
            if(withLeft && withRight)
                return true;
        }
        return false;
    }
}