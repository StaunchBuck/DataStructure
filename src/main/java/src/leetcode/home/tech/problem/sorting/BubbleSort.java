package src.leetcode.home.tech.problem.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BubbleSort {

    public static void main(String[] args) {
       Integer[] array = new Integer[]{4,8,3,7,0,2,5,3};
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                if(array[j]<array[i]){
                    array[i] = array[i] + array[j];
                    array[j] = array[i]-array[j];
                    array[i] = array[i] - array[j];
                }
            }
        }
        List.of(array).forEach(System.out::println);
    }
}
