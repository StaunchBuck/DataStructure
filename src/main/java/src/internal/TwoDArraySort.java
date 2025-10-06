package src.internal;

import java.util.Arrays;
import java.util.List;

public class TwoDArraySort {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2},
                {1,1},
                {3,2},
                {3,3}
        };
        Arrays.sort(matrix,(val1,val2) ->{
            if(val1[0] == val2[0])
                return Integer.compare(val1[1],val2[1]);
            return Integer.compare(val1[0],val2[0]);
        });
        List.of(matrix).forEach(val -> {
            System.out.println(val[0]+" "+val[1]);
        });
    }
}
