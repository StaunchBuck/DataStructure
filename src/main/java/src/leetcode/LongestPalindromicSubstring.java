package src.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.print(new LongestPalindromicSubstring().longestPalindrome("aaaaa"));
    }

    public String longestPalindrome(String s) {
        int max = 1;
        String maxPal = s.substring(0,1);
        char[] arr = s.toCharArray();
        int end = arr.length-1;
        for(int i = 0;i<=end;i++){
            int oddStart = i-1;
            int oddEnd = i+1;
            int evenStart = i-1;
            int evenEnd = i+2;
            boolean oddTrue = true;
            boolean evenTrue = i<end && arr[i] == arr[i+1];
            if(evenTrue && max<2){
                max = 2;
                maxPal = s.substring(i,i+2);
            }
            while(oddTrue || evenTrue){
                if(oddTrue){
                    if(oddStart>=0 && oddEnd<arr.length && arr[oddStart] == arr[oddEnd]){
                        if(max<oddEnd-oddStart+1){
                            max = oddEnd-oddStart+1;
                            maxPal = s.substring(oddStart,oddEnd+1);
                        }
                        oddStart--;
                        oddEnd++;
                    }else{
                        oddTrue = false;
                    }
                }
                if(evenTrue){
                    if(evenStart>=0 && evenEnd<arr.length && arr[evenStart] == arr[evenEnd]){
                        if(max<evenEnd-evenStart+1){
                            max = evenEnd-evenStart+1;
                            maxPal = s.substring(evenStart,evenEnd+1);
                        }
                        evenStart--;
                        evenEnd++;
                    }else{
                        evenTrue = false;
                    }
                }
            }
        }
        return maxPal;
    }
}
