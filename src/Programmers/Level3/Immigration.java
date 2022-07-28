package Programmers.Level3;

import java.util.Arrays;

public class Immigration {
	
	public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long first = times[0];
        long last = (long)times[times.length-1]*(long)n;
    	
        while(first <= last) {
        	
        	long mid = ( first + last ) / 2;
        	long sum = 0;
        	for(int time : times) {
        		sum += mid / time;
        		if(sum > n) break;
        	}
        	
        	if( sum >= n) {
        		last = mid - 1;
        	}else{
        		first = mid + 1;
        	}
        	
        	
        	
        }
        
        return first;
    }
	
	
	public static void main(String[] args) {
		Immigration imm = new Immigration();
		int n = 6;
		int[] times = {7, 10};
		long result = imm.solution(n, times);  // [1, 3, 1000]  6명 -> 3명 , [3,3,2, 3, 5]   2명 ,    [ ] is.indexof(2) = 1                
		System.out.println(result);
	}
}
