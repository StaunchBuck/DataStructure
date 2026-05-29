package src;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class RoughConcepts {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        List<Task> list = new ArrayList<Task>();
        list.add(new Task(-5,5,0));
        list.add(new Task(-1,2,1));
        list.add(new Task(2,10,2));

        list.sort(Comparator.comparingInt((Task task) -> task.profit)
                .thenComparing(p -> p.t1));
        list.stream().forEach( task -> {
            System.out.println(task.profit + " "+task.t1+" "+task.index);
        });

        System.out.println(StringUtils.rightPad("1234567",9,'0'));

    }


}

@AllArgsConstructor
class Task{
    public int profit;
    public int t1;
    public int index;
}