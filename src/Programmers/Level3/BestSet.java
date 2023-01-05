package Programmers.Level3;

public class BestSet {
	
    public int[] solution(int n, int s) {
    	
        if(s < n) {
        	int[] none = {-1};
        	return none;
        }
        
    	int[] answer = new int[n];
        
        int quot = s / n;
        int remain = s % n;
               
        for(int i = n-1; i >= 0; i--) {
        	int one = remain-- > 0 ? 1 : 0;
        	answer[i] = quot + one;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		BestSet bestSet = new BestSet();
		
		int n = 3;
		int s = 9;
		
		int[] result = bestSet.solution(n, s);
		
		System.out.println("======== result ========");
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
	} 
	
	
}
