package Programmers.Level2;

public class KakaoKDecimal {
    public static int solution(int n, int k) {
        int answer = -1;
        
        String kNumber = KNumber(n, k); // k 진법변환
        
        String[] splitNum = kNumber.split("0");
        int decimalCount = decimalCount(splitNum); // 소수 개수 체크
        
        return decimalCount;
    }
    
    public static String KNumber(int n, int k) { // k 진법변환
    	String result = "";
    	int quotient = n;
    	int remainde = quotient;
    	
    	if(k==10) return Integer.toString(n);
    	
    	while(quotient > 0) {
    		remainde = quotient % k;
    		quotient /= k;
    		result = remainde + result;    		
    	}
    	
    	return result;
    }
    
    
    public static int decimalCount(String[] splitNum) { // 소수 개수 체크
    	int decimalCount = 0;
    	
    	for(int i = 0; i < splitNum.length; i++) {
    		if(splitNum[i].equals("") || splitNum[i].equals("1")) continue;
    		boolean decimalCheck = isPrime(Long.parseLong(splitNum[i])); // 소수 판별

    		if(!decimalCheck) continue;
    		decimalCount++;
    	}
    	return decimalCount;
    }
    
    public static boolean isPrime(Long decimalCheck) { // 소수 판별

    	for (int i = 2; i<=(int)Math.sqrt(decimalCheck); i++) {
    		if (decimalCheck % i == 0) {
    			return false;
    	    }
    	}
    	return true;
    }
    

    public static void main(String[] args) {
    	int n = 1000000;
    	int k = 3;
    	int result = solution(n, k);
    	System.out.println(result);
	}
    
    /*
     * 	n	k	result
		437674	3	3
		110011	10	2
     */
}
