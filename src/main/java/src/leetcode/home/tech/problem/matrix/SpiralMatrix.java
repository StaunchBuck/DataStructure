package src.leetcode.home.tech.problem.matrix;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix
public class SpiralMatrix{

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        int row_start = 0;
        int row_end = matrix.length-1;
        int col_start = 0;
        int col_end = matrix[0].length-1;

        while(row_start<=row_end && col_start<=col_end){

            //left-> right
            if(row_start<=row_end){
                for(int i=col_start;i<=col_end;i++){
                    res.add(matrix[row_start][i]);
                }
                row_start +=1;
                // print(res);
            }

            //top -> bottom
            if(col_start<=col_end){
                for(int i=row_start;i<=row_end;i++){
                    res.add(matrix[i][col_end]);
                }
                col_end -=1;
                // print(res);
            }


            //right -> left
            if(row_start<=row_end){
                for(int i=col_end;i>=col_start;i--){
                    res.add(matrix[row_end][i]);
                }
                row_end -=1;
                // print(res);

            }

            //bottom -> top
            if(col_start<=col_end){
                for(int i=row_end;i>=row_start;i--){
                    res.add(matrix[i][col_start]);
                }
                col_start +=1;
                // print(res);
            }
        }
        return res;
    }

    public void print(List<Integer> res){
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
        System.out.println("");
    }
}