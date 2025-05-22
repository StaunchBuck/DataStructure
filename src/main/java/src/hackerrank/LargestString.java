package src.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestString {

	public static void main(String[] args) {
		 System.out.println(new LargestString().largest("acxaab",3));
		
	}
	
	public String largest(String s,Integer k) {
		
		Map<String,Integer> map = new HashMap<>();
		for(Character c:s.toCharArray()) {
			if(map.containsKey(c.toString()))
				map.put(c.toString(), map.get(c.toString())+1);
			else
				map.put(c.toString(), 1);	
		}
		
		List<String> list = map.keySet().stream().collect(Collectors.toList());
		list.sort((a,b) -> a.compareTo(b) <=0? 1:-1);
		
		StringBuilder res = new StringBuilder();
		
		while(list.size() > 0){
			if(map.get(list.get(0)) <= k){
				for(int i=0;i<map.get(list.get(0));i++)
					res.append(list.get(0));
				map.remove(list.get(0));
				list.remove(0);
			}
			else {
				for(int i=0;i<k;i++)
					res.append(list.get(0));
				map.put(list.get(0), map.get(list.get(0))-k);
				if(list.size() == 1) {
					break;
				}else {
					res.append(list.get(1));
					map.put(list.get(1), map.get(list.get(1))-1);
					if(map.get(list.get(1)) == 0) {
						map.remove(list.get(1));
						list.remove(1);
					}
				}
			}	
		}
		
		return res.toString();
		
	}

}
