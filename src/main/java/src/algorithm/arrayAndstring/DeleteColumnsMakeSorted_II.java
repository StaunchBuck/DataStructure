package src.algorithm.arrayAndstring;


public class DeleteColumnsMakeSorted_II {

    public static void main(String[] args) {
        DeleteColumnsMakeSorted_II obj = new DeleteColumnsMakeSorted_II();
        String[] strs = {"acfk","bgcl","bdcv","cnlv"};
        System.out.println(obj.minDeletionSize(strs));
    }
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int len = strs.length;
        int res = 0;
        boolean[] mem = new boolean[len];
        for(int index=0;index<n;index++){
            boolean isRemoved = false;
            for(int row=0;row<len-1;row++){
                if(!mem[row]){
                    if(strs[row].charAt(index) > strs[row+1].charAt(index)){
                        isRemoved = true;
                        break;
                    }
                }
            }
            if(isRemoved){
                res++;
                continue;
            }

            for(int i= 0;i<len-1;i++){
                if(!mem[i]){
                    if(strs[i].charAt(index) < strs[i+1].charAt(index))
                        mem[i] = true;
                }
            }
        }
        return res;
    }
}